package uow.codetest.tab.design.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import uow.codetest.tab.design.service.UserService;
import uow.codetest.tab.design.utils.face.ImgUtil;

/**
 * Login Controller
 *
 * @author 	Tab Tu
 * @update	Nov.21 2017
 * @version	1.2
 */

@Controller
public class TestView {

    @Autowired
    private UserService userserv;

    /**
     * compare the similarity between two person
     *
     * @param f1 first file
     * @param f2 second file
     * @return the similarity
     */
    @RequestMapping(value = "/compare", method = RequestMethod.POST)
    @ResponseBody
    public String whoami(@RequestParam("pic1") MultipartFile f1,
                         @RequestParam("pic2") MultipartFile f2) {
        try {
            double result = ImgUtil.compare(f1.getBytes(), f2.getBytes());
            return result + "";
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    @RequestMapping(value = "/helchk", method = RequestMethod.POST)
    @ResponseBody
    public String checkhealth(@RequestParam("pic") MultipartFile pic) {
        try {
            String result = ImgUtil.addperson(pic.getBytes());
            return result;
        } catch (Exception e) {
            return e.getMessage();
        }
    }
}