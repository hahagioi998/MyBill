package com.levy.gui.listener;

import com.levy.dao.ConfigDao;
import com.levy.gui.panel.DumpPanel;
import com.levy.service.ConfigService;
import com.levy.util.GUIUtil;
import com.levy.util.MysqlUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description：DumpPanel的监听器
 * @author：LevyXie
 * @create：2022-02-06 14:21
 */
public class DumpListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        DumpPanel dp = new DumpPanel();
        ConfigService cs = new ConfigService();
        String name = JOptionPane.showInputDialog("请输入备份文件名称");
        if(name == null){
            return;
        }
        if(name.length() == 0){
            JOptionPane.showMessageDialog(dp,"备份文件名称不能为空");
            return;
        }
        String data = cs.get(ConfigService.DUMP_PATH).getValue() +"\\" + name + ".sql";
        MysqlUtil.dump(cs.get(ConfigService.SQL_PATH).getValue(),data);
        JOptionPane.showMessageDialog(dp,"数据库已成功备份！\n备份文件位于" + data);
    }
}
