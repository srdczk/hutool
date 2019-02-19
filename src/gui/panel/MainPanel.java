package gui.panel;

import util.CenterPanel;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: gui.panel
 * @version: 1.0
 */
public class MainPanel extends JPanel{
    static {
        GUIUtil.userLNF();
        GUIUtil.initGlobalFont();
    }
    public static MainPanel mainPanel = new MainPanel();
    public JToolBar jToolBar = new JToolBar();
    public JButton xfyl = new JButton();
    public JButton jyb = new JButton();
    public JButton xffl = new JButton();
    public JButton yxfbb = new JButton();
    public JButton sz = new JButton();
    public JButton bf = new JButton();
    public JButton hf = new JButton();
//    public JPanel jPanel = new JPanel();
    public CenterPanel centerPanel = new CenterPanel(1);
//    public JButton getBf() {
    private MainPanel()
    {
        jToolBar.add(xfyl);
        jToolBar.add(jyb);
        jToolBar.add(xffl);
        jToolBar.add(yxfbb);
        jToolBar.add(sz);
        jToolBar.add(bf);
        jToolBar.add(hf);
        GUIUtil.setImageIcon("home.png", xfyl, "消费一览");
        GUIUtil.setImageIcon("record.png", jyb, "记一笔");
        GUIUtil.setImageIcon("category2.png", xffl, "消费分类");
        GUIUtil.setImageIcon("report.png", yxfbb, "月消费报表");
        GUIUtil.setImageIcon("config.png", sz, "设置");
        GUIUtil.setImageIcon("backup.png", bf, "备份");
        GUIUtil.setImageIcon("restore.png", hf, "恢复");
        setLayout(new BorderLayout());
        setVisible(true);
        add(jToolBar, BorderLayout.NORTH);
//        jToolBar.add(xffl);
        add(centerPanel, BorderLayout.CENTER);
    }
    public static void main(String[] args)
    {

        MainPanel mainPanel = MainPanel.mainPanel;
        mainPanel.centerPanel.show(new JLabel(){
            @Override
            public void paint(Graphics g)
            {
                ImageIcon icon = new ImageIcon("d://1.jpg");
                g.drawImage(icon.getImage(), 0, 0, getWidth(), getHeight(), icon.getImageObserver());
            }
        });
        GUIUtil.showPanel(mainPanel);
//        GUIUtil.setImageIcon("home.png", mainPanel.xfyl, "消费一览");
////        mainPanel.jToolBar.add(mainPanel.xfyl);
    }
}
