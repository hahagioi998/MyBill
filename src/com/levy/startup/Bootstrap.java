package com.levy.startup;

import com.levy.gui.frame.MainFrame;
import com.levy.gui.panel.MainPanel;
import com.levy.gui.panel.SpendPanel;
import com.levy.util.GUIUtil;

import javax.swing.*;

/**
 * @description：启动类
 * @author：LevyXie
 * @create：2022-02-05 12:07
 */
public class Bootstrap {
    public static void main(String[] args) throws Exception {
        GUIUtil.useLNF();
        SwingUtilities.invokeAndWait(new Runnable() {
            @Override
            public void run() {
                MainFrame.instance.setVisible(true);
                MainPanel.instance.workingPanel.show(SpendPanel.instance);
            }
        });
    }
}
