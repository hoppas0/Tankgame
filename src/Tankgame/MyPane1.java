package Tankgame;
//绘图区域

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
@SuppressWarnings("all")
public class MyPane1 extends MyPane implements KeyListener ,Runnable{
    public MyPane1(){
        hero = new Hero(5+(70*6),5+70*11);//初始化自己的坦克
        hero.setEnemyTanks(enemyTanks);
        hero.setWalls(walls);
        hero.setSteels(steels);
        hero.setRivers(rivers);
        hero.setSpeed(5);
        for (int i = 1; i < enemyTankSize+1; i++) {     //初始化敌人的坦克
            EnemyTank enemyTank = new EnemyTank(5+(i*140),0);
            //将 enemyTanks 设置给 enemyTank
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setWalls(walls);
            enemyTank.setSteels(steels);
            enemyTank.setRivers(rivers);
            enemyTank.setDirect(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        for(int i = 0;i<10;i++){     //初始化所有的墙
            if(i==4 || i==6)continue;
            if(i == 5){
                Wall wall0 = new Wall(70*2,70*(i+1),70,70);
                walls.add(wall0);
                Wall wall1 = new Wall(70*3,70*(i+1),70,70);
                walls.add(wall1);
                Wall wall2 = new Wall(70*5,70*(i+1),70,70);
                walls.add(wall2);
                Wall wall3 = new Wall(70*7,70*(i+1),70,70);
                walls.add(wall3);
                Wall wall4 = new Wall(70*9,70*(i+1),70,70);
                walls.add(wall4);
                Wall wall5 = new Wall(70*10,70*(i+1),70,70);
                walls.add(wall5);
            }
            Wall wall0 = new Wall(70*1,70*(i+1),70,70);
            walls.add(wall0);
            Wall wall1 = new Wall(70*3,70*(i+1),70,70);
            walls.add(wall1);
            Wall wall2 = new Wall(70*5,70*(i+1),70,70);
            walls.add(wall2);
            Wall wall3 = new Wall(70*7,70*(i+1),70,70);
            walls.add(wall3);
            Wall wall4 = new Wall(70*9,70*(i+1),70,70);
            walls.add(wall4);
            Wall wall5 = new Wall(70*11,70*(i+1),70,70);
            walls.add(wall5);
        }
        for(int i =0;i<3;i++){      //初始化所有的钢板
            Steel steel0 = new Steel(70*6,70*3,70,70);
            steels.add(steel0);
            Steel steel1 = new Steel(0,70*6,70,70);
            steels.add(steel1);
            Steel steel2 = new Steel(70*12,70*6,70,70);
            steels.add(steel2);
            Steel steel3 = new Steel(70*6,70*8,70,70);
            steels.add(steel3);
        }
        props.add(new Prop(70*6,70*9,70,70));
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,910,910);//填充矩形，默认黑色,把70*70看作一个基本的单元，所以长和宽要设置成能够整除70的数,910*910能放13*13个单元
        if(hero.islive==false){         //如果玩家死亡
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            Font font = new Font("Serif", Font.PLAIN, 56);
            g.setFont(font);
            g.setColor(Color.red);
            g.drawString("DEFEAT",70*4,70*4);
            return;
        }
        if(enemyTanks.size()==0){       //如果敌人全部被消灭
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            gameOver();
        }
        drawWalls(walls,g);         //画出所有墙
        drawSteels(steels,g);       //画出所有钢板
        drawProps(props,g);        //画出所有道具
        drawHero(hero,g);           //画出玩家
        drawEnemyTanks(enemyTanks,g);//画出所有敌人
        drawBombs(bombs,g);         //画出爆炸效果
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(hero.islive == false)return;
        if (e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            if (hero.getY() > 0 && !hero.isTouchEnemyTank() && !hero.isTouchBuilding()) {
                hero.moveUp();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            if (hero.getX()+60 < 70*13 && !hero.isTouchEnemyTank() && !hero.isTouchBuilding()) {
                hero.moveRight();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            if (hero.getY() + 60 < 70*13 && !hero.isTouchEnemyTank() && !hero.isTouchBuilding()) {
                hero.moveDown();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            if (hero.getX() > 0 && !hero.isTouchEnemyTank() && !hero.isTouchBuilding()) {
                hero.moveLeft();
            }
        }
        if (e.getKeyCode() == KeyEvent.VK_J){
            hero.shotEnemyTank();
        }
        this.repaint();
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank(bombs,hero,enemyTanks);     //不停的检查是否打中了
            hitHero(bombs,hero,enemyTanks);
            hitSteel(steels,hero,enemyTanks);
            hitWall(walls,hero,enemyTanks);
            getprop(props,bombs,hero,enemyTanks);
            this.repaint();
            if(hero.islive==false) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                goHome();
                return;
            }
        }
    }
}
