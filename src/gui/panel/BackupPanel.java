package gui.panel;

import util.GUIUtil;

import javax.swing.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.panel
 * @version: 1.0
 */
public class BackupPanel extends JPanel {
    static {
        GUIUtil.initGlobalFont();
        GUIUtil.userLNF();
    }
    public static BackupPanel backupPanel = new BackupPanel();

    public JButton bf = new JButton("备份");

    private BackupPanel()
    {
        add(bf);
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(BackupPanel.backupPanel);
    }
}
