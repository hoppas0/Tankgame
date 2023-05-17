package Tankgame;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class HomePage extends JFrame {
    private JButton startButton;
    private JButton exitButton;
    private JLabel imgLabel;

    public HomePage() {
        super("TankGame");

        // 设置窗口大小和位置
        setSize(1235, 794);
        setLocationRelativeTo(null);

        // 设置窗口关闭操作
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 设置背景图片
        ImageIcon img = new ImageIcon("images/home3.png"); // 这是背景图片
        imgLabel = new JLabel(img); // 将背景图放在标签里。
        setContentPane(imgLabel); // 将背景标签设置为窗口的内容面板
        imgLabel.setLayout(new FlowLayout()); // 设置标签的布局方式为流式布局

        // 创建按钮面板
        JPanel buttonPanel = new JPanel();
        buttonPanel.setOpaque(false); // 设置为透明
        buttonPanel.setLayout(new BoxLayout(buttonPanel, BoxLayout.Y_AXIS)); // 设置垂直流式布局
        buttonPanel.add(Box.createVerticalStrut(425)); // 添加垂直间距
        buttonPanel.setBorder(BorderFactory.createEmptyBorder(0, 100, 0, 0)); // 设置空白边框

        // 创建开始游戏按钮
        startButton = new JButton("Play");
        startButton.setFont(new Font("Arial", Font.PLAIN, 24)); // 设置字体大小
        startButton.setPreferredSize(new Dimension(300, 80)); // 设置按钮大小
        startButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 跳转到游戏界面
                new TankGame();
                dispose();
            }
        });
        buttonPanel.add(startButton);
        buttonPanel.add(Box.createVerticalStrut(20));

        // 创建退出游戏按钮
        exitButton = new JButton("Exit ");
        exitButton.setFont(new Font("Arial", Font.PLAIN, 24)); // 设置字体大小
        exitButton.setPreferredSize(new Dimension(200, 80)); // 设置按钮大小
        exitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // 退出游戏
                System.exit(0);
            }
        });
        buttonPanel.add(exitButton);
        buttonPanel.setBackground(Color.black);

        // 添加按钮面板到背景标签
        imgLabel.add(buttonPanel);

        // 显示窗口
        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePage();
    }
}
