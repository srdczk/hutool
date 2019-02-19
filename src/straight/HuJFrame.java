package straight;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;

/**
 * @Auther: srd-czk
 * @Date: 2019/2/19
 * @Description: straight
 * @version: 1.0
 */
public class HuJFrame extends JFrame{

    public void launch()
    {

//        setBounds(500, 200, 400, 500);
        setLayout(new BorderLayout());
        setSize(500, 500);
        JLabel jLabel = new JLabel();
        add(jLabel, BorderLayout.CENTER);
        JToolBar jToolBar = new JToolBar();
        jToolBar.add(new JButton("消费一览"));
        jToolBar.add(new JButton("记一笔"));
        jToolBar.add(new JButton("消费分类"));
        jToolBar.add(new JButton("月消费报表"));
        jToolBar.add(new JButton("设置"));
        jToolBar.add(new JButton("备份"));
        jToolBar.add(new JButton("恢复"));
        JButton jButton = new JButton("呵呵");
        jButton.addActionListener((event) -> jLabel.setText("你妈死了"));
        jToolBar.add(jButton);
        add(jToolBar, BorderLayout.NORTH);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args)
    {
        new HuJFrame().launch();
//        String s = "hdfkdf.sjdk.sdjiks";
//        String[] strings = s.split("\\.");
//        for(String c : strings)
//        {
//            System.out.println(c);
//        }
    }
}
