package debugger;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.File;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: straight
 * @version: 1.0
 *
 * 调试 -- 创建单例的frame,或显示类
 *
 *
 */
public class HuFrame extends JFrame{

    public JLabel jLabel = new JLabel("");
    public JToolBar jToolBar = new JToolBar();
    public JButton jButton = new JButton("消费一览");
    public JButton jButton1 = new JButton("记一笔");

    static int a;
    static {
        System.out.println(a);
    }



    public static HuFrame huFrame = new HuFrame();

    private HuFrame()
    {
//        setLayout(new BorderLayout());
//        setSize(500, 500);
//        jToolBar.add(jButton);
//        jToolBar.add(jButton1);
//        add(jToolBar, BorderLayout.NORTH);
//        add(jLabel, BorderLayout.CENTER);
//        setLocationRelativeTo(null);
//        setVisible(true);
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public static void main(String[] args)
    {
        File file = new File("C:\\Program Files\\MySQL\\MySQL Server 5.5", "bin/mysql.exe");
        System.out.println(file.exists());
    }
}