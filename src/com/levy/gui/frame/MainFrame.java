package com.levy.gui.frame;

import com.levy.gui.panel.MainPanel;
import com.levy.gui.panel.SpendPanel;
import com.levy.util.CenterPanel;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description：搭建项目窗体组件
 * @author：LevyXie
 * @create：2022-02-03 21:55
 */
public class MainFrame extends JFrame{
    public static MainFrame instance = new MainFrame();
    public MainFrame() {
        this.setTitle("一本糊涂账");
        this.setSize(500, 500);
        this.setResizable(false);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.setContentPane(MainPanel.instance);
    }

}
