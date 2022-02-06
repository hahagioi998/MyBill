package com.levy.gui.panel;

import com.levy.bean.Category;
import com.levy.gui.listener.RecordListener;
import com.levy.service.CategoryService;
import com.levy.util.ColorUtil;
import com.levy.util.DateUtil;
import com.levy.util.GUIUtil;
import org.jdesktop.swingx.JXDatePicker;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @description：消费记录面板
 * @author：LevyXie
 * @create：2022-02-04 17:13
 */
public class RecordPanel extends WorkingPanel {
    public static RecordPanel instance = new RecordPanel();
    public JLabel lSpend = new JLabel("花费");
    public JLabel lCategory = new JLabel("分类");
    public JLabel lNote = new JLabel("备注");
    public JLabel lDate = new JLabel("日期");

    public JTextField vSpend = new JTextField();
    public JComboBox vCategory = new JComboBox();
    public JTextField vNote = new JTextField();
    public JXDatePicker vDate = new JXDatePicker(new Date());

    private JButton bSubmit = new JButton("记一笔");


    public RecordPanel() {
        GUIUtil.setColor(ColorUtil.grayColor, lCategory,lDate,lNote,lSpend);
        GUIUtil.setColor(ColorUtil.blueColor, bSubmit);
        this.setLayout(new BorderLayout());
        this.add(center(),BorderLayout.NORTH);
        this.add(north(),BorderLayout.CENTER);

        addListener();
    }

    private JPanel north() {
        JPanel north = new JPanel();
        north.add(bSubmit);
        return north;
    }
    private JPanel center() {
        int gap = 40;

        JPanel center = new JPanel(new GridLayout(4, 2,gap,gap));
        vCategory.addItem("请选择分类");

        center.add(lSpend);
        center.add(vSpend);
        center.add(lCategory);
        center.add(vCategory);
        center.add(lNote);
        center.add(vNote);
        center.add(lDate);
        center.add(vDate);
        return center;
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }

    @Override
    public void updateData() {
        List<Category> cs = new CategoryService().list();
        //由于JComboBox中没有contain方法，从其中取出所有的Category对象,生成List
        ArrayList<Category> boxList = new ArrayList<>();
        int itemCount = vCategory.getItemCount();
        for(int i = 0;i < itemCount;i++){
            if(vCategory.getItemAt(i) instanceof Category){
                boxList.add((Category) vCategory.getItemAt(i));
            }
        }
        //利用List的Contain方法判断，若已包含则不添加
        //需重写hashcode和equals方法，且不应包含recordNumber属性
        for(Category c : cs){
            if(!boxList.contains(c)){
                vCategory.addItem(c);
            }
        }

        vSpend.setText("");
        vCategory.setSelectedIndex(0);
        vNote.setText("");
        vDate.setDate(DateUtil.today());
    }

    @Override
    public void addListener() {
        RecordListener listener = new RecordListener();
        bSubmit.addActionListener(listener);
    }
}
