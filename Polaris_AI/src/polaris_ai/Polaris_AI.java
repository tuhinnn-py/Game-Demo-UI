package polaris_ai;

import java.net.MalformedURLException;
import java.net.URL;

public class Polaris_AI 
{
    static Polaris_AI_Frame ui_frame;
    static URL media_url;
    static URL left_url;
    static URL right_url;

    public static void main(String args[])
    {
        media_url= null;
        left_url = null;
        right_url = null;
        
        try
        {
            media_url = new URL("file:\\C:\\Users\\hp\\Desktop\\Polaris_AI\\src\\polaris_ai\\Media.avi");
            left_url = new URL("file:\\C:\\Users\\hp\\Desktop\\Polaris_AI\\src\\polaris_ai\\Left_Media.avi");
            right_url = new URL("file:\\C:\\Users\\hp\\Desktop\\Polaris_AI\\src\\polaris_ai\\Right_Media.avi");
        }
        catch(MalformedURLException e)
        {
            System.err.println("MEDIA COULD NOT BE LOADED!");
        }
        
        if(media_url != null)
            ui_frame = new Polaris_AI_Frame(media_url, left_url, right_url);
    }
}
