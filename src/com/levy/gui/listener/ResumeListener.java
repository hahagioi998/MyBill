package com.levy.gui.listener;

import com.levy.gui.panel.ResumePanel;
import com.levy.service.ConfigService;
import com.levy.util.MysqlUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @description：ResumePanel的监听器
 * @author：LevyXie
 * @create：2022-02-06 14:21
 */
public class ResumeListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ResumePanel rp = new ResumePanel();
        ConfigService cs = new ConfigService();
        String sqlPath = cs.get(ConfigService.SQL_PATH).getValue();
        if(sqlPath.length() == 0){
            JOptionPane.showMessageDialog(rp, "恢复前请事先配置mysql的路径");
        }

        String name = JOptionPane.showInputDialog("请输入备份文件名");
        if(name == null){
            return;
        }
        String data = cs.get(ConfigService.DUMP_PATH).getValue() + "\\" + name + ".sql";
        File dataFile = new File(data);
        if (!dataFile.exists()) {
            JOptionPane.showMessageDialog(rp, "备份不存在，请核实备份名是否有误");
        } else {
            MysqlUtil.resume(cs.get(ConfigService.SQL_PATH).getValue(),data);
            JOptionPane.showMessageDialog(rp, "数据恢复成功！");
        }

    }
}
