package util;

import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: util
 * @version: 1.0
 */
public class ColorUtil {
    public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");

    public static Color getByPercent(int per)
    {
        if(per > 100)
            per = 100;
        int r = 51;
        int g = 255;
        int b = 51;
        double rate = per / 100.0;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        return new Color(r, g, b);
    }
}
