package com.levy.util;

import com.levy.gui.panel.WorkingPanel;

import javax.swing.*;
import java.awt.*;

/**
 * @description：面板居中的工具类
 * @author：LevyXie
 * @create：2022-02-04 10:34
 */
public class CenterPanel extends JPanel {

    private double rate;
    private JComponent c;
    private boolean stretch;

    public CenterPanel(double rate, boolean stretch) {
        this.setLayout(null);
        this.rate = rate;
        this.stretch = stretch;
    }

    public CenterPanel(double rate) {
        this(rate,true);
    }

    public void repaint(){
        if(null != c){
            Dimension containerSize = this.getSize();
            Dimension componentSize = this.getPreferredSize();
            if(stretch){
                c.setSize((int)(containerSize.width * rate),(int)(containerSize.height*rate));
            }else {
                c.setSize(componentSize);
            }
            c.setLocation(containerSize.width/2 - c.getWidth()/2,containerSize.height/2 - c.getHeight()/2);
        }
        super.repaint();
    }
    /**
     * Description:  传入JComponent对象,利用CenterPanel的画板将其居中显示 
     * Param:        [p]
     * Return:       void
    **/
    public void show(JComponent p){
        this.c = p;
        Component[] cs = getComponents();
        for(Component c : cs){
            remove(c);
        }
        add(p);
        if(p instanceof WorkingPanel){
            ((WorkingPanel) p).updateData();
        }
        this.updateUI();
    }
    //main方法中实际上是该方法的测试信息
    public static void main(String[] args) {
        JFrame frame = new JFrame("test for centerPanel");
        frame.setSize(500, 500);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        CenterPanel centerPanel = new CenterPanel(0.5);
        frame.setContentPane(centerPanel);

        JButton b = new JButton("test");
        centerPanel.show(b);
    }

}
