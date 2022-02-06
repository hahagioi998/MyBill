package com.levy.gui.listener;

import com.levy.gui.panel.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @description：工具条的监听器
 * @author：LevyXie
 * @create：2022-02-05 12:23
 */
public class ToolbarListener implements ActionListener {
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton b = (JButton) e.getSource();
        MainPanel main = MainPanel.instance;
        if(main.bSpend == b){
            main.workingPanel.show(SpendPanel.instance);
        }
        if(main.bConfig == b){
            main.workingPanel.show(ConfigPanel.instance);
        }
        if(main.bCategory == b){
            main.workingPanel.show(CategoryPanel.instance);
        }
        if(main.bDump == b){
            main.workingPanel.show(DumpPanel.instance);
        }
        if(main.bResume == b){
            main.workingPanel.show(ResumePanel.instance);
        }
        if(main.bRecord == b){
            main.workingPanel.show(RecordPanel.instance);
        }
        if(main.bReport == b){
            main.workingPanel.show(ReportPanel.instance);
        }

    }
}
