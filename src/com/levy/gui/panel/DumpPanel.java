package com.levy.gui.panel;

import com.levy.gui.listener.DumpListener;
import com.levy.util.ColorUtil;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @description：备份面板
 * @author：LevyXie
 * @create：2022-02-04 18:09
 */
public class DumpPanel extends WorkingPanel{
    public static DumpPanel instance = new DumpPanel();

    private JButton bDump = new JButton("备份");

    public DumpPanel() {
        JPanel jPanel = new JPanel();
        jPanel.add(bDump);
        this.add(jPanel);
        GUIUtil.setColor(ColorUtil.blueColor, bDump);

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
        DumpListener listener = new DumpListener();
        bDump.addActionListener(listener);
    }
}
