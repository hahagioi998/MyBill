package com.levy.gui.panel;

import com.levy.bean.Config;
import com.levy.dao.ConfigDao;
import com.levy.gui.listener.ConfigListener;
import com.levy.service.ConfigService;
import com.levy.util.ColorUtil;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @description：设置面板
 * @author：LevyXie
 * @create：2022-02-04 18:09
 */
public class ConfigPanel extends WorkingPanel {
    public static ConfigPanel instance = new ConfigPanel();

    public JLabel lBudget = new JLabel("本月预算（￥）");
    public JLabel lMySql = new JLabel("MySql安装目录");
    public JLabel lDump = new JLabel("MySql备份目录");

    public JTextField vBudget = new JTextField();
    public JTextField vMysql = new JTextField();
    public JTextField vDump = new JTextField();

    public JButton bUpdate = new JButton("更新");

    public ConfigPanel() {
        this.setLayout(new BorderLayout());
        this.add(center(),BorderLayout.CENTER);
        this.add(south(),BorderLayout.SOUTH);
        GUIUtil.setColor(ColorUtil.grayColor, lBudget,lMySql,lDump);
        GUIUtil.setColor(ColorUtil.blueColor, bUpdate);

        addListener();
    }

    @Override
    public void updateData() {
        ConfigDao configDao = new ConfigDao();
        Config cBudget = configDao.getByKey(ConfigService.BUDGET);
        Config cPath = configDao.getByKey(ConfigService.SQL_PATH);
        Config cDump = configDao.getByKey(ConfigService.DUMP_PATH);
        vBudget.setText(cBudget.getValue());
        vMysql.setText(cPath.getValue());
        vDump.setText(cDump.getValue());
        vBudget.grabFocus();
    }

    public void addListener() {
        ConfigListener listener = new ConfigListener();
        bUpdate.addActionListener(listener);
    }

    private JPanel south() {
        JPanel south = new JPanel();
        south.add(bUpdate);
        return south;
    }

    private JPanel center() {
        int gap = 25;
        JPanel center = new JPanel(new GridLayout(6,1,gap,gap));
        center.add(lBudget);
        center.add(vBudget);
        center.add(lMySql);
        center.add(vMysql);
        center.add(lDump);
        center.add(vDump);
        return center;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }
}
