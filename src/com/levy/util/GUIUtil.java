package com.levy.util;

import javax.swing.*;
import java.awt.*;
import java.io.File;

/**
 * @description：GUI常用的工具包
 * @author：LevyXie
 * @create：2022-02-04 10:59
 */
public class GUIUtil {
    /**
     * Description:  返回真则非空，返回假则为空
     * Param:        [jt, input]
     * Return:       boolean
    **/
    public static boolean checkEmpty(JTextField jt,String input){
        String text = jt.getText().trim();
        if(0 == text.length()){
            JOptionPane.showMessageDialog(null, input + "不能为空");
            jt.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean checkNumber(JTextField jt,String input){
        if(!checkEmpty(jt, input)){
            return false;
        }
        String text = jt.getText().trim();
        try {
            Integer.parseInt(text);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, input + "需要为数字");
            jt.grabFocus();
            return false;
        }
        return true;
    }

    public static boolean checkZero(JTextField jt,String input){
        if(!checkEmpty(jt, input)){
            return false;
        }
        String text = jt.getText().trim();
        if("0".equals(text)){
            JOptionPane.showMessageDialog(null, input + "不能为0");
            jt.grabFocus();
            return false;
        }
        return true;
    }

    public static void setColor(Color color,JComponent... cs){
        for(JComponent c : cs){
            c.setForeground(color);
        }
    }

    public static void setImageIcon(JButton b,String fileName,String tip){
        ImageIcon imageIcon = new ImageIcon(new File(fileName).getAbsolutePath());
        b.setIcon(imageIcon);
        b.setPreferredSize(new Dimension(61,81));
        b.setToolTipText(tip);
        b.setVerticalTextPosition(JButton.BOTTOM);
        b.setHorizontalTextPosition(JButton.CENTER);
        b.setText(tip);
    }

    public static void useLNF() {
        try {
            UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * Description:  面板不能直接显示，以下方法简单搭建了JFrame,供调用显示panel 
     * Param:        [p, stretch]
     * Return:       void
    **/
    public static void showPanel(JPanel p,double stretch){
        JFrame frame = new JFrame("一本糊涂账");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CenterPanel centerPanel = new CenterPanel(stretch);
        frame.setContentPane(centerPanel);

        centerPanel.show(p);
    }

    public static void showPanel(JPanel p){
        showPanel(p,0.85);
    }


}
