package startup;

import gui.frame.MainFrame;
import gui.panel.ConfigPanel;
import service.ConfigService;
import util.GUIUtil;

import javax.swing.*;
import java.io.File;
import java.lang.reflect.InvocationTargetException;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: startup
 * @version: 1.0
 */
public class Bootstrap {
    public MainFrame mainFrame = MainFrame.mainFrame;

    public static void main(String[] args)  {
        MainFrame.mainFrame.setVisible(true);
    }
}
