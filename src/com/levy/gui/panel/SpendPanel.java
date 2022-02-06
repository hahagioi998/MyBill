package com.levy.gui.panel;

import com.levy.service.SpendPage;
import com.levy.util.CircleProgressBar;
import com.levy.util.ColorUtil;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @description：消费展示面板
 * @author：LevyXie
 * @create：2022-02-03 22:43
 */
public class SpendPanel extends WorkingPanel {
    //单例模式，余同
    public static SpendPanel instance = new SpendPanel();

    public SpendPage page = new SpendPage();

    public JLabel lMonthSpend = new JLabel("本月消费");
    public JLabel lTodaySpend = new JLabel("今日消费");
    public JLabel lAvgSpendPerDay = new JLabel("日均消费");
    public JLabel lMonthLeft = new JLabel("本月剩余");
    public JLabel lAvailablePerDay = new JLabel("日均可用");
    public JLabel lDayLeft = new JLabel("距离月末");

    public JLabel vMonthSpend = new JLabel();
    public JLabel vTodaySpend = new JLabel();
    public JLabel vAvgSpendPerDay = new JLabel();
    public JLabel vMonthLeft = new JLabel();
    public JLabel vAvailablePerDay = new JLabel();
    public JLabel vDayLeft = new JLabel();

    CircleProgressBar bar;

    public SpendPanel() {
        bar = new CircleProgressBar();
        bar.setBackgroundColor(ColorUtil.blueColor);
        GUIUtil.setColor(ColorUtil.grayColor,lAvailablePerDay,lAvgSpendPerDay,lMonthSpend,lTodaySpend,lDayLeft
        ,lMonthLeft,vAvgSpendPerDay,vAvailablePerDay,vDayLeft,vMonthLeft);
        GUIUtil.setColor(ColorUtil.blueColor,vMonthSpend,vTodaySpend );
        vMonthSpend.setFont(new Font("微软雅黑", Font.BOLD, 23));
        vTodaySpend.setFont(new Font("微软雅黑", Font.BOLD, 23));

        setPage();

        this.setLayout(new BorderLayout());
        this.add(south(),BorderLayout.SOUTH);
        this.add(center(),BorderLayout.CENTER);
    }

    private void setPage() {
        vMonthSpend.setText("￥" + page.monthSpend);
        vTodaySpend.setText("￥" + page.todaySpend);
        vAvgSpendPerDay.setText("￥" + page.avgSpendPerDay);
        vMonthLeft.setText(page.monthLeft);
        vAvailablePerDay.setText(page.availablePerDay);
        vDayLeft.setText(page.dayLeft + "天");
    }

    private JPanel center() {
        JPanel center = new JPanel();
        center.setLayout(new BorderLayout());
        center.add(west(),BorderLayout.WEST);
        center.add(bar,BorderLayout.CENTER);
        return center;
    }

    private JPanel west() {
        JPanel west = new JPanel();
        west.setLayout(new GridLayout(4, 1));
        west.add(lMonthSpend);
        west.add(vMonthSpend);
        west.add(lTodaySpend);
        west.add(vTodaySpend);
        return west;
    }

    public JPanel south(){
        JPanel south = new JPanel(new GridLayout(2, 4));
        south.add(lAvgSpendPerDay);
        south.add(lMonthLeft);
        south.add(lAvailablePerDay);
        south.add(lDayLeft);
        south.add(vAvgSpendPerDay);
        south.add(vMonthLeft);
        south.add(vAvailablePerDay);
        south.add(vDayLeft);

        return south;
    }


    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }

    @Override
    public void updateData() {
        page = new SpendPage();
        setPage();
        bar.setProgress(page.usagePercentage);
        bar.setForegroundColor(ColorUtil.getByPercentage(page.usagePercentage));
        if(page.overSpendFlag){
            GUIUtil.setColor(ColorUtil.warningColor, vMonthSpend,vTodaySpend,vMonthLeft,vAvailablePerDay);
        }else{
            GUIUtil.setColor(ColorUtil.grayColor,vMonthLeft,vAvailablePerDay);
            GUIUtil.setColor(ColorUtil.blueColor,vMonthSpend,vTodaySpend);
        }
    }

    @Override
    public void addListener() {

    }
}
