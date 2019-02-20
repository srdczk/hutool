package gui.panel;

import util.ChartUtil;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

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
    private ReportPanel()
    {
        setLayout(new BorderLayout());
        Image i = ChartUtil.getImage(400, 300);
        ImageIcon icon = new ImageIcon(i);
        label.setIcon(icon);
        add(label);
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(ReportPanel.reportPanel);
    }
}
