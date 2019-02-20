package startup;

import gui.frame.MainFrame;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/20
 * @Description: startup
 * @version: 1.0
 */
public class Bootstrap {
    public MainFrame mainFrame = MainFrame.mainFrame;

    public static void main(String[] args)
    {

        new Bootstrap();
    }
}
