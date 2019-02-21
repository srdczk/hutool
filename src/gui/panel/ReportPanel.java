package gui.panel;

import pojo.Record;
import service.ReportService;
import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;
import java.util.List;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.panel
 * @version: 1.0
 */
public class ReportPanel extends JPanel {

    static {
        GUIUtil.userLNF();
        GUIUtil.initGlobalFont();
    }
    public JLabel label = new JLabel();
    public static ReportPanel reportPanel = new ReportPanel();

    public void updateData()
    {

        List<Record> rs = new ReportService().listThisMonthRecords();
        Image i = ChartUtil.getImage(rs, 350, 250);
        ImageIcon icon = new ImageIcon(i);
        label.setIcon(icon);
    }

    private ReportPanel()
    {
        setLayout(new BorderLayout());
        Image i = ChartUtil.getImage(400, 300);
        ImageIcon icon = new ImageIcon(i);
        label.setIcon(icon);
        add(label);
        updateData();
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(ReportPanel.reportPanel);
    }
}
