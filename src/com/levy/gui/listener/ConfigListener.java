package com.levy.gui.listener;

import com.levy.gui.panel.*;
import com.levy.service.ConfigService;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

/**
 * @description：ConfigPanel的监听器
 * @author：LevyXie
 * @create：2022-02-05 15:40
 */
public class ConfigListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        ConfigService cfs = new ConfigService();
        ConfigPanel cfp = ConfigPanel.instance;

        String sBudget = cfp.vBudget.getText();
        String sMysql = cfp.vMysql.getText();
        String sDump = cfp.vDump.getText();

        if(!GUIUtil.checkNumber(cfp.vBudget, "本月预算")){
            return;
        }

        File file = new File(sMysql + "/bin/mysql.exe");
        if(!file.exists()){
            JOptionPane.showMessageDialog(cfp, "MySql路径不正确");
            cfp.vMysql.grabFocus();
            return;
        }

        if(!GUIUtil.checkEmpty(cfp.vDump, "数据备份路径")){
            return;
        }

        File folder = new File(sDump);
        if (!folder.exists() && !folder.isDirectory()) {
            int flag = JOptionPane.showConfirmDialog(cfp, "文件夹不存在，是否创建?");
            if(flag == JOptionPane.OK_OPTION){
                folder.mkdirs();
            }else {
                return;
            }
        }

        cfs.update(ConfigService.BUDGET, sBudget);
        cfs.update(ConfigService.SQL_PATH, sMysql);
        cfs.update(ConfigService.DUMP_PATH,sDump);
        JOptionPane.showMessageDialog(cfp, "设置修改成功");

    }
}
