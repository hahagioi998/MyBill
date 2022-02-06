package com.levy.service;

import com.levy.bean.Record;
import com.levy.util.DateUtil;

import java.util.List;

/**
 * @description：服务层
 * @author：LevyXie
 * @create：2022-02-06 10:25
 */
public class SpendPage {
    public String monthSpend;
    public String todaySpend;
    public String avgSpendPerDay;
    public String monthLeft;
    public String availablePerDay;
    public int dayLeft;

    public SpendService ss = new SpendService();
    public ConfigService cs = new ConfigService();
    public boolean overSpendFlag = false;
    public double left;
    public int usagePercentage;

    public SpendPage() {
        setMonthSpend();
        setTodaySpend();
        setMonthLeft();
        setDayLeft();
        setAvgSpendPerDay();
        setAvailablePerDay();
        setUsagePercentage();
    }

    public void setMonthSpend() {
        double sum = 0;
        List<Record> records = ss.getThisMonth();
        for(Record record : records){
            sum += record.getSpend();
        }
        monthSpend = String.format("%.1f", sum);
    }

    public void setTodaySpend() {
        double sum = 0;
        List<Record> records = ss.getToday();
        for(Record record : records){
            sum += record.getSpend();
        }
        todaySpend = String.format("%.1f", sum);
    }

    public void setAvgSpendPerDay() {
        double v = Double.parseDouble(monthSpend) / DateUtil.thisMonthTotalDay();
        avgSpendPerDay = String.format("%.2f", v);
    }

    public void setMonthLeft() {
        left = Double.parseDouble(cs.get(ConfigService.BUDGET).getValue()) - Double.parseDouble(monthSpend);
        if(left >= 0) {
            monthLeft = "￥" + left;
        }else{
            monthLeft = "已超支";
            overSpendFlag = true;
        }
    }

    public void setAvailablePerDay() {
        if(overSpendFlag){
            availablePerDay = "已超支";
        }else{
            availablePerDay = String.format("%.2f", left / dayLeft);
        }
    }

    public void setDayLeft() {
        dayLeft = DateUtil.thisMonthLeftDay();
    }

    private void setUsagePercentage() {
        usagePercentage = (int)(100 * (Double.parseDouble(monthSpend)) / Double.parseDouble(cs.get(ConfigService.BUDGET).getValue()));
    }
}
