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
    Vector<Steel> steels = new Vector<>();
    Vector<River> rivers = new Vector<>();
    int enemyTankSize = 5;

    Image image1 ;
    Image image2 ;
    Image image3 ;
    public MyPane(){
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
                continue;
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
        for(int i=0;i<0;i++){
            River river = new River(70,70,70,70);
            rivers.add(river);
        }


//        image1 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("D:\\IDEA\\IDEA FOLDER\\Tankgame\\out\\production\\Tankgame\\b1.gif"));
//        image2 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("D:\\IDEA\\IDEA FOLDER\\Tankgame\\out\\production\\Tankgame\\b2.gif"));
//        image3 = Toolkit.getDefaultToolkit().getImage(Panel.class.getResource("D:\\IDEA\\IDEA FOLDER\\Tankgame\\out\\production\\Tankgame\\b3.gif"));
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
            Font font = new Font("Serif", Font.PLAIN, 56);
            g.setFont(font);
            g.setColor(Color.red);
            g.drawString("VICTORY",70*4,70*4);
            return;
        }
        for(int i = 0;i<walls.size();i++){      //画出所有的墙
            Wall wall = walls.get(i);
            if(wall.islive) {
                drawWall(wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight(), g);
            }else {
                walls.remove(wall);
            }
        }
        for(int i = 0;i<steels.size();i++){     //画出所有的钢板
            Steel steel=steels.get(i);
            drawSteel(steel.getX(),steel.getY(),steel.getWidth(),steel.getHeight(),g);
        }
        for(int i=0;i<rivers.size();i++){       //画出所有的河
            River river = rivers.get(i);
            drawRiver(river.getX(),river.getY(),river.getWidth(),river.getHeight(),g);
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
    }

    public void hitSteel(){
        for(int stl=0;stl<steels.size();stl++){
            Steel steel = steels.get(stl);
            for(int i=0;i<enemyTanks.size();i++){       //若是敌人打钢板
                EnemyTank enemyTank = enemyTanks.get(i);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot s = enemyTank.shots.get(j);
                    if (s.x >= steel.getX() && s.x <= steel.getX() + steel.getWidth()
                            && s.y >= steel.getY() && s.y <= steel.getY() + steel.getHeight()) {
                        s.islive = false;
                    }
                }
            }
            for(int i =0;i<hero.shots.size();i++) {     //若是玩家打钢板
                Shot s = hero.shots.get(i);
                if (s.islive) {
                    if (s.x >= steel.getX() && s.x <= steel.getX() + steel.getWidth()
                            && s.y >= steel.getY() && s.y <= steel.getY() + steel.getHeight()) {
                        s.islive = false;
                    }
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
                    if (s.x >= wall.getX() && s.x <= wall.getX() + wall.getWidth()
                            && s.y >= wall.getY() && s.y <= wall.getY() + wall.getHeight()) {
                        s.islive = false;
                        wall.islive = false;
                    }
                }
            }
            for(int i =0;i<hero.shots.size();i++) {     //若是玩家打墙
                Shot s = hero.shots.get(i);
                if (s.islive) {
                    if (s.x >= wall.getX() && s.x <= wall.getX() + wall.getWidth()
                            && s.y >= wall.getY() && s.y <= wall.getY() + wall.getHeight()) {
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
            this.repaint();
            hitEnemyTank();     //不停的检查是否打中了
            hitHero();
            hitSteel();
            hitWall();
//            if(hero.islive==false) {
//                return;
//            }
        }
    }
}
