package com.levy.gui.listener;

import com.levy.bean.Category;
import com.levy.gui.panel.RecordPanel;
import com.levy.service.RecordService;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * @description：RecordPanel的监听器
 * @author：LevyXie
 * @create：2022-02-05 23:21
 */
public class RecordListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        RecordPanel rp = RecordPanel.instance;
        RecordService rs = new RecordService();

        Object sCategory = rp.vCategory.getSelectedItem();
        if(!GUIUtil.checkEmpty(rp.vSpend, "花费金额")){
            return;
        }
        if(!(sCategory instanceof Category)) {
            JOptionPane.showMessageDialog(rp, "请选择分类！");
            return;
        }

        String sSpend = rp.vSpend.getText();
        String note = rp.vNote.getText();
        Date date = rp.vDate.getDate();

        double spend = Double.parseDouble(sSpend);

        Category category = (Category) sCategory;
        rs.add(spend,category.getId(),note,date);

        JOptionPane.showMessageDialog(rp, "消费记录添加成功！");
        rp.updateData();
    }
}
