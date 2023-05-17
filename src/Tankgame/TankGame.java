package Tankgame;

import javax.swing.*;

public class TankGame extends JFrame {
    public TankGame(){
        MyPane1 mp1 =new MyPane1();    //第一关
        MyPane2 mp2 =new MyPane2();    //第二关
        MyPane3 mp3 =new MyPane3();    //第三关

        //设置第一关的游戏结束监听器
        mp1.setGameEndListener(new GameEndListener() {
            @Override
            public void gameOver() {
                //切换到第二关
                TankGame.this.remove(mp1);
                TankGame.this.add(mp2);
                Thread thread2 = new Thread(mp2);
                thread2.start();
                TankGame.this.addKeyListener(mp2);
                TankGame.this.setVisible(true);
            }
            public void goHome(){
                new HomePage();
                dispose();
            }
        });

        //设置第二关的游戏结束监听器
        mp2.setGameEndListener(new GameEndListener() {
            @Override
            public void gameOver() {
                //切换到第三关
                TankGame.this.remove(mp2);
                TankGame.this.add(mp3);
                Thread thread3 = new Thread(mp3);
                thread3.start();
                TankGame.this.addKeyListener(mp3);
                TankGame.this.setVisible(true);
            }

            @Override
            public void goHome() {
                new HomePage();
                dispose();
            }
        });
        //设置第三关的游戏结束监听器
        mp3.setGameEndListener(new GameEndListener() {
            @Override
            public void gameOver() {
                //切换到第三关
                TankGame.this.remove(mp3);
                TankGame.this.add(mp1);
                Thread thread4 = new Thread(mp1);
                thread4.start();
                TankGame.this.addKeyListener(mp1);
                TankGame.this.setVisible(true);
            }

            @Override
            public void goHome() {
                new HomePage();
                dispose();
            }
        });

        //添加第一关的游戏绘图区域
        this.add(mp1);
        Thread thread1 = new Thread(mp1);
        thread1.start();

        //设置窗口大小、监听器和关闭操作
        this.setSize(950, 950);
        this.addKeyListener(mp1);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);

    }
}
