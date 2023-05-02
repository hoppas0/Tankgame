package Tankgame;
//绘图区域

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Vector;
@SuppressWarnings("all")
public class MyPane extends JPanel implements KeyListener ,Runnable{
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    Vector<Wall> walls = new Vector<>();
    int enemyTankSize = 3;
    Steel steel = null;
//    Wall wall = null;
    Image image1 ;
    Image image2 ;
    Image image3 ;
    public MyPane(){
        hero = new Hero(500,500);//初始化自己的坦克
        hero.setEnemyTanks(enemyTanks);
        hero.setSpeed(10);
        for (int i = 1; i < enemyTankSize+1; i++) {
            EnemyTank enemyTank = new EnemyTank(100*i,0);
            //将 enemyTanks 设置给 enemyTank
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setDirect(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        steel = new Steel(0,250,180,60);
        for(int i = 0;i<3;i++){
            Wall wall = new Wall(240+(i*60),250,60,60);
            walls.add(wall);
        }

//        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("D:\\IDEA\\IDEA FOLDER\\Tankgame\\out\\production\\Tankgame\\b1.gif"));
//        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("D:\\IDEA\\IDEA FOLDER\\Tankgame\\out\\production\\Tankgame\\b2.gif"));
//        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("D:\\IDEA\\IDEA FOLDER\\Tankgame\\out\\production\\Tankgame\\b3.gif"));
    }


    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.fillRect(0,0,1000,750);//填充矩形，默认黑色        在我的电脑上高度是713才和窗口一样大
        drawSteel(steel.getX(), steel.getY(), steel.getWidth(), steel.getHeight(),g);
        drawRiver(180,250,60,60,g);
        for(int i = 0;i<walls.size();i++){
            Wall wall = walls.get(i);
            if(wall.islive) {
                drawWall(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight(), g);
            }else {
                walls.remove(wall);
            }
        }

        if (hero != null && hero.islive) {
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }
//        if (hero.shot != null && hero.shot.islive == true ){
//            g.fill3DRect(hero.shot.x,hero.shot.y,2,2,false);
//        }
        for (int i = 0; i < hero.shots.size(); i++) {
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.islive == true){
                g.draw3DRect(shot.x,shot.y, 2,2,false);
            }else{
                hero.shots.remove(shot);        //这里会把死掉的炮弹移除掉
            }
        }


        //画出爆炸效果
        for (int i = 0; i < bombs.size(); i++) {
            Bomb bomb = bombs.get(i);
            if (bomb.life > 6){
                g.drawImage(image1,bomb.x,bomb.y,60,60,this);
            }else if (bomb.life > 3){
                g.drawImage(image2,bomb.x,bomb.y,60,60,this);
            }else{
                g.drawImage(image3,bomb.x,bomb.y,60,60,this);
            }
            bomb.lifeDown();
            if (bomb.life == 0){
                bombs.remove(bomb);
            }
        }
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            if (enemyTank.islive) {
                drawTank(enemyTank.getX(),enemyTank.getY(),g,enemyTank.getDirect(),1);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot shot = enemyTank.shots.get(j);
                    if (shot.islive){
                        g.draw3DRect(shot.x,shot.y,2,2,false);
                    }else{
                        enemyTank.shots.remove(shot);
                    }
                }
            }
        }
    }

    public void drawWall(int X, int Y, int width, int height, Graphics g){
        g.setColor(Color.RED);
        g.fill3DRect(X, Y,width,height,false);
    }
    public void drawSteel(int X, int Y, int width, int height, Graphics g){
        g.setColor(Color.WHITE);
        g.fill3DRect(X, Y,width,height,false);
    }

    public void drawRiver(int X,int Y,int width,int height,Graphics g){
        g.setColor(Color.BLUE);
        g.fill3DRect(X, Y,width,height,false);
    }

    public void drawTank(int X,int Y,Graphics g,int direct,int type){

        switch (type){
            case 0:
                g.setColor(Color.CYAN);
                break;
            case 1:
                g.setColor(Color.yellow);
                break;
        }
        switch(direct){
            case 0://向上
                g.fill3DRect(X, Y,10,60,false);
                g.fill3DRect(X+30, Y,10,60,false);
                g.fill3DRect(X+10, Y+10,20,40,false);
                g.fillOval(X+10,Y+20,20,20);
                g.drawLine(X+20,Y+30,X+20,Y);
                break;
            case 1://向右
                g.fill3DRect(X, Y,60,10,false);
                g.fill3DRect(X, Y+30,60,10,false);
                g.fill3DRect(X+10, Y+10,40,20,false);
                g.fillOval(X+20,Y+10,20,20);
                g.drawLine(X+30,Y+20,X+60,Y+20);
                break;
            case 2://向下
                g.fill3DRect(X, Y,10,60,false);
                g.fill3DRect(X+30, Y,10,60,false);
                g.fill3DRect(X+10, Y+10,20,40,false);
                g.fillOval(X+10,Y+20,20,20);
                g.drawLine(X+20,Y+30,X+20,Y+60);
                break;
            case 3://向左
                g.fill3DRect(X, Y,60,10,false);
                g.fill3DRect(X, Y+30,60,10,false);
                g.fill3DRect(X+10, Y+10,40,20,false);
                g.fillOval(X+20,Y+10,20,20);
                g.drawLine(X+30,Y+20,X,Y+20);
                break;
            default:
                System.out.println("暂时没有处理 ");
        }
    }
    public void hitEnemyTank(){
        for(int i =0;i<hero.shots.size();i++) {
            Shot shot = hero.shots.get(i);
            if (shot.islive) {
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(shot, enemyTank);
                }
            }
        }
    }
    public void hitHero(){
        for (int i = 0; i < enemyTanks.size(); i++) {
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot shot = enemyTank.shots.get(j);
                if (hero.islive && shot.islive){
                    hitTank(shot,hero);
                }
            }
        }
        if (hero.islive == false){
            System.out.println("game over");
        }
    }

    public void hitSteel(){
        Steel steel1 = steel;
        for(int i=0;i<enemyTanks.size();i++){       //若是敌人打钢板
            EnemyTank enemyTank = enemyTanks.get(i);
            for (int j = 0; j < enemyTank.shots.size(); j++) {
                Shot s = enemyTank.shots.get(j);
                if (s.x > steel1.getX() && s.x < steel1.getX() + steel1.getWidth()
                        && s.y > steel1.getY() && s.y < steel1.getY() + steel1.getHeight()) {
                    s.islive = false;
                }
            }
        }
        for(int i =0;i<hero.shots.size();i++) {     //若是玩家打钢板
            Shot s = hero.shots.get(i);
            if (s.islive) {
                if (s.x > steel1.getX() && s.x < steel1.getX() + steel1.getWidth()
                        && s.y > steel1.getY() && s.y < steel1.getY() + steel1.getHeight()) {
                    s.islive = false;
                }
            }
        }
    }
    public void hitWall(){
        for(int w = 0;w<walls.size();w++){
            Wall wall = walls.get(w);
            for(int i=0;i<enemyTanks.size();i++){       //若是敌人打墙
                EnemyTank enemyTank = enemyTanks.get(i);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot s = enemyTank.shots.get(j);
                    if (s.x > wall.getX() && s.x < wall.getX() + wall.getWidth()
                            && s.y > wall.getY() && s.y < wall.getY() + wall.getHeight()) {
                        s.islive = false;
                        wall.islive = false;
                    }
                }
            }
            for(int i =0;i<hero.shots.size();i++) {     //若是玩家打墙
                Shot s = hero.shots.get(i);
                if (s.islive) {
                    if (s.x > wall.getX() && s.x < wall.getX() + wall.getWidth()
                            && s.y > wall.getY() && s.y < wall.getY() + wall.getHeight()) {
                        s.islive = false;
                        wall.islive = false;
                    }
                }
            }
        }
    }
    public void hitTank(Shot s,Tank enemyTank){
        switch (enemyTank.getDirect()){
            case 0:
            case 2:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() +40
                && s.y > enemyTank.getY() && s.y < enemyTank.getY() +60){
                    s.islive = false;
                    enemyTank.islive = false;
                    enemyTanks.remove(enemyTank);
                    Bomb bomb =new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
            case 1:
            case 3:
                if (s.x > enemyTank.getX() && s.x < enemyTank.getX() +60
                    && s.y > enemyTank.getY() && s.y < enemyTank.getY() +40){
                    s.islive = false;
                    enemyTank.islive = false;
                    enemyTanks.remove(enemyTank);
                    Bomb bomb =new Bomb(enemyTank.getX(),enemyTank.getY());
                    bombs.add(bomb);
                }
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(hero.islive == false)return;
        if (e.getKeyCode() == KeyEvent.VK_W){
            hero.setDirect(0);
            if (hero.getY() > 0 && !hero.isTouchEnemyTank()) {
                hero.moveUp();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_D){
            hero.setDirect(1);
            if (hero.getX()+60 <1000 && !hero.isTouchEnemyTank()) {
                hero.moveRight();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_S){
            hero.setDirect(2);
            if (hero.getY() + 100 < 750 && !hero.isTouchEnemyTank()) {
                hero.moveDown();
            }
        }else if (e.getKeyCode() == KeyEvent.VK_A){
            hero.setDirect(3);
            if (hero.getX() > 0 && !hero.isTouchEnemyTank()) {
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
            this.repaint();
            hitEnemyTank();     //不停的检查是否打中了
            hitHero();
            hitSteel();
            hitWall();
            if(hero.islive==false) {
                return;
            }
        }
    }
}
