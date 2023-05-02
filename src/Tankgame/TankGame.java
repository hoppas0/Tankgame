package Tankgame;

import javax.swing.*;

public class TankGame extends JFrame {

    MyPane mp = null;
    public static void main(String[] args) {
        TankGame tankGame = new TankGame();
    }
    public TankGame(){
        mp =new MyPane();
        this.add(mp);//把游戏绘图区域加进去
        Thread thread = new Thread(mp);
        thread.start();
        this.setSize(1000,750);
        this.addKeyListener(mp);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
