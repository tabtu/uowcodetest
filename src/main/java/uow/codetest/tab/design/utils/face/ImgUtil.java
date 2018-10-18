package uow.codetest.tab.design.utils.face;

import org.json.JSONObject;
import uow.codetest.tab.design.utils.youtu.APIs;
import uow.codetest.tab.design.utils.youtu.Func;

import java.util.ArrayList;

/**
 * Compare Images
 * @Author Tab Tu
 * @Created Oct.27 2017
 * @Updated Nov.15 2017
 * @Description Include Detect Faces and So On.
 */
public class ImgUtil {

    /**
     * Youtu face API
     * @return the similarity fo these two pictures.
     */
    public static double compare(byte[] source, byte[] target) {
        double result = 0;
        uow.codetest.tab.design.utils.youtu.Func faceYoutu = new uow.codetest.tab.design.utils.youtu.Func(APIs.APP_ID, APIs.SECRET_ID, APIs.SECRET_KEY, uow.codetest.tab.design.utils.youtu.Func.API_YOUTU_END_POINT, APIs.USER_ID);
        try {
            JSONObject response = faceYoutu.FaceCompare(source, target);
            result = (double) response.get("similarity");
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return result;
    }

    public static String addperson(byte[] source) {
        uow.codetest.tab.design.utils.youtu.Func faceYoutu = new uow.codetest.tab.design.utils.youtu.Func(APIs.APP_ID, APIs.SECRET_ID, APIs.SECRET_KEY, uow.codetest.tab.design.utils.youtu.Func.API_YOUTU_END_POINT, APIs.USER_ID);
        try {
            JSONObject response = faceYoutu.NewPerson(source, "1", new ArrayList<String>());
            return response.toString();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "error";
        }
    }

    public static String getinformation(String pid) {
        uow.codetest.tab.design.utils.youtu.Func faceYoutu = new uow.codetest.tab.design.utils.youtu.Func(APIs.APP_ID, APIs.SECRET_ID, APIs.SECRET_KEY, uow.codetest.tab.design.utils.youtu.Func.API_YOUTU_END_POINT, APIs.USER_ID);
        try {
            JSONObject response = faceYoutu.GetInfo("1");
            return response.toString();
        } catch (Exception e) {
            return "error";
        }
    }
}
