package com.levy.gui.panel;

import com.levy.gui.listener.ResumeListener;
import com.levy.util.ColorUtil;
import com.levy.util.GUIUtil;

import javax.swing.*;

/**
 * @description：恢复面板
 * @author：LevyXie
 * @create：2022-02-04 18:09
 */
public class ResumePanel extends WorkingPanel{
    public static ResumePanel instance = new ResumePanel();
    public JButton bResume = new JButton("恢复");
    public ResumePanel() {
        JPanel jPanel = new JPanel();
        jPanel.add(bResume);
        this.add(jPanel);
        GUIUtil.setColor(ColorUtil.blueColor, bResume);

        addListener();
    }


    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }

    @Override
    public void updateData() {

    }

    @Override
    public void addListener() {
        ResumeListener listener = new ResumeListener();
        bResume.addActionListener(listener);
    }
}
