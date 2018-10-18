package uow.codetest.tab.design.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class IterableUtil {

    /**
     * transfer
     * @param iter
     * @param <E>
     * @return
     */
    public static <E> Collection<E> makeCollection(Iterable<E> iter) {
        Collection<E> list = new ArrayList<E>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }

    public static <E> List<E> makeList(Iterable<E> iter) {
        List<E> list = new ArrayList<E>();
        for (E item : iter) {
            list.add(item);
        }
        return list;
    }
}
