package com.levy.gui.panel;

import com.levy.bean.Category;
import com.levy.gui.listener.CategoryListener;
import com.levy.gui.model.CategoryTableModel;
import com.levy.service.CategoryService;
import com.levy.util.ColorUtil;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @description：分类面板
 * @author：LevyXie
 * @create：2022-02-04 17:52
 */
public class CategoryPanel extends WorkingPanel {
    public static CategoryPanel instance = new CategoryPanel();

    public JButton bAdd = new JButton("新增");
    public JButton bEdit = new JButton("编辑");
    public JButton bDelete = new JButton("删除");

    public CategoryTableModel ctm = new CategoryTableModel();
    public JTable table = new JTable(ctm);
    public JScrollPane center = new JScrollPane(table);

    public CategoryPanel() {
        GUIUtil.setColor(ColorUtil.blueColor, bAdd,bDelete,bEdit);
        this.setLayout(new BorderLayout());
        this.add(center,BorderLayout.CENTER);
        this.add(south(),BorderLayout.SOUTH);

        addListener();
    }
    public JPanel south() {
        JPanel south = new JPanel();
        south.add(bAdd);
        south.add(bEdit);
        south.add(bDelete);
        return south;
    }

    public Category getSelectedCategory() {
        int index = table.getSelectedRow();
        return ctm.cs.get(index);
    }


    public void addListener(){
        CategoryListener listener = new CategoryListener();
        bAdd.addActionListener(listener);
        bEdit.addActionListener(listener);
        bDelete.addActionListener(listener);
    }

    public void updateData() {
        ctm.cs = new CategoryService().list();
        table.updateUI();
        table.getSelectionModel().setSelectionInterval(0, 0);

        if(0 == ctm.cs.size()){
            bEdit.setEnabled(false);
            bDelete.setEnabled(false);
        }
        else{
            bEdit.setEnabled(true);
            bDelete.setEnabled(true);
        }

    }

    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }
}
