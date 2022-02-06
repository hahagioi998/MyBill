package com.levy.gui.panel;

import com.levy.gui.listener.ToolbarListener;
import com.levy.util.CenterPanel;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description：主面板
 * @author：LevyXie
 * @create：2022-02-04 16:08
 */
public class MainPanel extends JPanel {

    public static MainPanel instance = new MainPanel();
    public JToolBar toolBar = new JToolBar();
    public JButton bSpend = new JButton();
    public JButton bRecord = new JButton();
    public JButton bCategory = new JButton();
    public JButton bReport = new JButton();
    public JButton bConfig = new JButton();
    public JButton bDump = new JButton();
    public JButton bResume = new JButton();

    //设置的workingPanel用于显示工作的子面板
    public CenterPanel workingPanel;

    private MainPanel(){
        GUIUtil.setImageIcon(bSpend, "img/home.png", "消费一览");
        GUIUtil.setImageIcon(bRecord, "img/record.png", "记一笔");
        GUIUtil.setImageIcon(bCategory, "img/category1.png", "分类管理");
        GUIUtil.setImageIcon(bReport, "img/report.png", "月消费报表");
        GUIUtil.setImageIcon(bConfig, "img/config.png", "设置");
        GUIUtil.setImageIcon(bDump, "img/dump.png", "数据备份");
        GUIUtil.setImageIcon(bResume, "img/resume.png", "数据恢复");

        toolBar.add(bSpend);
        toolBar.add(bRecord);
        toolBar.add(bCategory);
        toolBar.add(bReport);
        toolBar.add(bConfig);
        toolBar.add(bDump);
        toolBar.add(bResume);
        toolBar.setFloatable(false);

        workingPanel = new CenterPanel(0.85);

        this.setLayout(new BorderLayout());
        this.add(toolBar,BorderLayout.NORTH);
        this.add(workingPanel,BorderLayout.CENTER);

        addListener();
    }

    public void addListener(){
        ToolbarListener listener = new ToolbarListener();
        bSpend.addActionListener(listener);
        bRecord.addActionListener(listener);
        bReport.addActionListener(listener);
        bResume.addActionListener(listener);
        bConfig.addActionListener(listener);
        bCategory.addActionListener(listener);
        bDump.addActionListener(listener);
    }

    //此main方法仅用于测试，余同
    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }

}
