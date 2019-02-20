package gui.frame;

import debugger.HuFrame;
import gui.panel.*;
import util.GUIUtil;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: gui.frame
 * @version: 1.0
 */
public class MainFrame extends JFrame{
    static {
        GUIUtil.userLNF();
        GUIUtil.initGlobalFont();
    }

    public static MainFrame mainFrame = new MainFrame();
    public MainPanel mainPanel = MainPanel.mainPanel;
//    public
    public SpendPanel spendPanel = SpendPanel.spendPanel;
//    public
    public RecordPanel recordPanel = RecordPanel.recordPanel;

    public CategoryPanel categoryPanel = CategoryPanel.categoryPanel;

    public ReportPanel reportPanel = ReportPanel.reportPanel;

    public ConfigPanel configPanel = ConfigPanel.configPanel;

    public BackupPanel backupPanel = BackupPanel.backupPanel;

    public RecoverPanel recoverPanel = RecoverPanel.recoverPanel;

    private MainFrame()
    {
        setSize(500, 500);
        setLocationRelativeTo(null);
        setContentPane(mainPanel);
//        mainPanel.xfyl.addActionListener(e -> System.out.println("jwe"));
        mainPanel.xfyl.addActionListener(e -> {mainPanel.centerPanel.show(spendPanel); int width = this.getWidth(); if(width < 500) {resize(++width, 500);}  else resize(--width, 500);});
        mainPanel.jyb.addActionListener(e -> {mainPanel.centerPanel.show(recordPanel); int width = this.getWidth(); if(width < 500) {resize(++width, 500);}  else resize(--width, 500);});
        mainPanel.xffl.addActionListener(e -> {mainPanel.centerPanel.show(categoryPanel); int width = this.getWidth(); if(width < 500) {resize(++width, 500);}  else resize(--width, 500);});
        mainPanel.yxfbb.addActionListener(e -> {mainPanel.centerPanel.show(reportPanel); int width = this.getWidth(); if(width < 500) {resize(++width, 500);}  else resize(--width, 500);});
        mainPanel.sz.addActionListener(e -> {mainPanel.centerPanel.show(configPanel); int width = this.getWidth(); if(width < 500) {resize(++width, 500);}  else resize(--width, 500);});
        mainPanel.bf.addActionListener(e -> {mainPanel.centerPanel.show(backupPanel); int width = this.getWidth(); if(width < 500) {resize(++width, 500);}  else resize(--width, 500);});
        mainPanel.hf.addActionListener(e -> {mainPanel.centerPanel.show(recoverPanel); int width = this.getWidth(); if(width < 500) {resize(++width, 500);}  else resize(--width, 500);});
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args)
    {
        MainFrame mainFrame = MainFrame.mainFrame;
    }
}
