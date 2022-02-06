package com.levy.gui.panel;

import com.levy.service.ReportService;
import com.levy.util.ChartUtil;
import com.levy.util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @description：报表面板
 * @author：LevyXie
 * @create：2022-02-04 18:09
 */
public class ReportPanel extends JPanel {
    public static ReportPanel instance = new ReportPanel();

    private ReportService rs = new ReportService();

    private JLabel label = new JLabel();
    private Image img = ChartUtil.getImage(rs.getSpendByMonth(),400, 300);
    private Icon icon = new ImageIcon(img);

    public ReportPanel() {
        label.setIcon(icon);
        this.add(label);
    }

    public static void main(String[] args) {
        GUIUtil.showPanel(instance);
    }
}
