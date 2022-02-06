package com.levy.util;

import java.awt.*;

/**
 * @description：颜色设置的工具类
 * @author：LevyXie
 * @create：2022-02-04 15:03
 */
public class ColorUtil {

    public static Color blueColor = Color.decode("#3399FF");
    public static Color grayColor = Color.decode("#999999");
    public static Color backgroundColor = Color.decode("#eeeeee");
    public static Color warningColor = Color.decode("#FF3333");

    /**
     * Description:  根据百分比，返回颜色，用于表征不同程度的占比 
     * Param:        [per]
     * Return:       java.awt.Color
    **/
    public static Color getByPercentage(int per){
        int r = 51;
        int g = 255;
        int b = 51;
        
        if(per > 100) per = 100;
        float rate = per / 100f;
        r = (int) ((255 - 51) * rate + 51);
        g = 255 - r + 51;
        Color color = new Color(r, g, b);
        return color;
    }
}
