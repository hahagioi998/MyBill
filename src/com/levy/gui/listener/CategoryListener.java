package com.levy.gui.listener;

import com.levy.bean.Category;
import com.levy.gui.panel.*;
import com.levy.service.CategoryService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description：CategoryPanel的监听器
 * @author：LevyXie
 * @create：2022-02-05 17:01
 */
public class CategoryListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        CategoryPanel category = CategoryPanel.instance;
        JButton b = (JButton) e.getSource();
        CategoryService cgs = new CategoryService();

        if(category.bAdd == b){
            String name = JOptionPane.showInputDialog(null);
            if(name == null){
                return;
            }
            if(name.length() == 0){
                JOptionPane.showMessageDialog(category, "分类名不能为空！");
            }else{
                cgs.add(name);
            }
        }

        if(category.bEdit == b){
            Category selectedCategory = category.getSelectedCategory();

            int id = selectedCategory.getId();
            String name = JOptionPane.showInputDialog("修改分类名称:",selectedCategory.getName());
            if(name == null){
                return;
            }
            if(name.length() == 0){
                JOptionPane.showMessageDialog(category, "分类名不能为空！");
                return;
            }
            cgs.update(id,name);
        }

        if(category.bDelete == b){
            Category selectedCategory = category.getSelectedCategory();
            if(selectedCategory.getRecordNumber() != 0){
                JOptionPane.showMessageDialog(category, "该分类下有消费记录，不能删除！");
                return;
            }

            int flag = JOptionPane.showConfirmDialog(category, "确认删除分类:" + selectedCategory.getName());
            if(flag != JOptionPane.OK_OPTION){
                return;
            }else {
                int id = selectedCategory.getId();
                cgs.delete(id);
            }
        }
        category.updateData();
    }
}
