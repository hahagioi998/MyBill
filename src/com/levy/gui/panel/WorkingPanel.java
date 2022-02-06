package com.levy.gui.panel;

import javax.swing.*;

/**
 * @description：工作面板的抽象类，抽象了updateData()和addListener()的方法
 * @author：LevyXie
 * @create：2022-02-05 19:01
 */
public abstract class WorkingPanel extends JPanel {
    public abstract void updateData();
    public abstract void addListener();
}
