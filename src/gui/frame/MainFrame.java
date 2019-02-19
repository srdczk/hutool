package gui.frame;

import debugger.HuFrame;

import javax.swing.*;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: gui.frame
 * @version: 1.0
 */
public class MainFrame extends JFrame{
    public static void main(String[] args)
    {
        HuFrame huFrame = HuFrame.huFrame;
        huFrame.jButton.addActionListener(e -> huFrame.jButton1.setText("魅惑"));
    }
}
