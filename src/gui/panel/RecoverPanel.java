package gui.panel;

import util.GUIUtil;

import javax.swing.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: gui.panel
 * @version: 1.0
 */
public class RecoverPanel extends JPanel {
    static {
        GUIUtil.initGlobalFont();
        GUIUtil.userLNF();
    }
    public static RecoverPanel recoverPanel = new RecoverPanel();

    public JButton hf = new JButton("恢复");
    private RecoverPanel()
    {
        add(hf);
    }
    public static void main(String[] args)
    {
        GUIUtil.showPanel(RecoverPanel.recoverPanel);
    }
}
