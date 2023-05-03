package Tankgame;

import javax.swing.*;

public class TankGame extends JFrame {
    /*
    运行这个文件开始游戏
    输入法切换成英文输入法
    WASD控制坦克移动，J发射炮弹
     */

    MyPane mp = null;
    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }
    public TankGame(){
        mp =new MyPane();
        this.add(mp);//把游戏绘图区域加进去
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(950,950);     //把70*70看作一个基本的单元，所以长和宽要设置成能够整除70的数,910*910能放13*13个单元
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
