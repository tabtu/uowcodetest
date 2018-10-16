package uow.codetest.tab.algorithm;

import java.io.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Code test for University of Waterloo on Oct.15
 * - "Write a program which can count the word frequency with multi-threads."
 * 1, Read file from hardware and analyze content, put into words list. (FileReader)
 * 2, Separate words list into some blocks, can analyze HTML file directly. (RE, StringToken)
 * 3, Create multiple threads to count word frequency. Assume that the maximum number of threads is 100. (ConcurrentHashMap, ExecutorService)
 * 4, Merge all result into a map. (ConcurrentHashMap)
 *
 * -- Written by Tab Tu, (c) 2018 All Rights Reserved
 * -- Updated Oct.15 2018
 */
@SuppressWarnings("unchecked")
public class WordsFrequency {

    /**
     * Anlyze words frequency in a file with multi-threads.
     * Synopsis: WordsFrequency <filename> <number>
     * @param args filename and path {0}, number of thread {1}
     */
    public static void main(String args[]) {
        if (args.length != 2) {
            System.out.println("Warning: illegal method.\neg: AlgorithmTest <file> <number>");
        } else if (Integer.parseInt(args[1]) > 100) {
            System.out.println("error: the maximum thread number is 100.");
        } else {
            File file = new File(args[0]);
            if (!file.exists()) {
                System.out.println("error: File " + args[0] + " does not exist in this folder.");
            } else {
                WordsFrequency tst = new WordsFrequency();
                ConcurrentHashMap map = tst.words_frequency(args[0], Integer.parseInt(args[1]));

                // sorted by key and print.
                Map<String, Integer> treeMap = new TreeMap<String, Integer>(map);
                System.out.println(treeMap);
            }
        }
    }

    /**
     * Build a word frequency sheet.
     *
     * @param filename  target file name and path.
     * @param threadnum the number of threads to be used.
     */
    public ConcurrentHashMap<String, Integer> words_frequency(String filename, int threadnum) {
        try {
            // read file to word list from path.
            String[] tmp = readfile2strings(filename);
            int each = tmp.length / threadnum;
            int parts = tmp.length % threadnum;

            System.out.println("Total words: " + tmp.length + "\n Will seprate to " + threadnum + " blocks(threads) and each size is " + each + " words with " + parts + " more words in the last block.");

            // create a thread pool.
            ExecutorService pool = Executors.newFixedThreadPool(threadnum);
            // create a list of return values.
            List<Future> list = new ArrayList<>();

            // locate the start and the end point in each block, the last one has more bytes.
            for (int j = 0; j < threadnum; j++) {
                int start, end;
                start = each * j;
                if (j == threadnum - 1) {
                    end = each * (j + 1) - 1 + parts;
                } else {
                    end = each * (j + 1) - 1;
                }

                // initalize callable thread.
                Callable c = new MyCallable();
                ((MyCallable) c).set_task("Thread" + j);
                ((MyCallable) c).set_start(start);
                ((MyCallable) c).set_end(end);
                ((MyCallable) c).set_content(tmp);

                // submit mission to thread and return future object.
                Future f = pool.submit(c);
                list.add(f);
            }
            // close thread pool.
            pool.shutdown();

            // merge all result objects to a hashmap.
            ConcurrentHashMap<String, Integer> result = new ConcurrentHashMap<>();
            for (Future f : list) {
                ConcurrentHashMap<String, Integer> map = (ConcurrentHashMap<String, Integer>) f.get();
                result.putAll(map);
            }

            return result;
        } catch (Exception e) {
            return null;
        }
    }

    /**
     * a callable thread to count the word frequency.
     */
    class MyCallable implements Callable<Object> {
        /**
         * task identification.
         */
        private String _task;

        /**
         * start position.
         */
        private int _start;

        /**
         * end position.
         */
        private int _end;

        /**
         * target content.
         */
        private String[] _content;

        public void set_task(String task) {
            this._task = task;
        }

        public void set_start(int start) {
            this._start = start;
        }

        public void set_end(int end) {
            this._end = end;
        }

        public void set_content(String[] content) {
            this._content = content;
        }

        @Override
        public Object call() throws Exception {
            long curtime = System.currentTimeMillis();
            // inner thread, use a thread-safe map to protect data.
            ConcurrentHashMap map = new ConcurrentHashMap();
            for (int i = _start; i < _end; i++) {
                String key = _content[i];
                Integer frequency = (Integer) map.get(key);
                if (frequency == null) {
                    // can not find the word.
                    frequency = 1;
                } else {
                    // read the frequency and add by 1.
                    frequency = new Integer(frequency.intValue() + 1);
                }
                map.put(key, frequency);
            }
            System.out.println("  " + _task + " start at " + _start + " and end at " + _end + ", cost " + (System.currentTimeMillis() - curtime) + "ms.");
            return map;
        }
    }

    /**
     * @param filePath
     * @return words list
     * @throws IOException
     */
    public static String[] readfile2strings(String filePath) throws IOException {
        StringBuffer sb = new StringBuffer();
        InputStream is = new FileInputStream(filePath);
        String line;
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        line = reader.readLine();
        while (line != null) {
            sb.append(line);
            sb.append("\n");
            line = reader.readLine();
        }
        reader.close();
        is.close();

        // analyze content and separate words, suppose all words are made up of letters and numbers.
        String content = sb.toString();
        String regEx = "[^A-Za-z0-9]";
        Pattern p = Pattern.compile(regEx);
        Matcher m = p.matcher(content);
        String tmp = m.replaceAll("\n").trim();
        StringTokenizer st = new StringTokenizer(tmp.toString(), ",.! \n");
        List<String> result = new ArrayList<>();
        while (st.hasMoreTokens()) {
            result.add(st.nextToken());
        }
        return result.toArray(new String[result.size()]);
    }
}