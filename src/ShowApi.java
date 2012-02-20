
import java.net.MalformedURLException;


public class ShowApi {

    /**
     *  
     */
    public static void main(String[] args) throws MalformedURLException {
        MainApi api = new MainApi();
        api.imageStartPaths();
        api.setDisplay();
        api.content(900, 700, true);
        


    }
}