package Tankgame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Random;
import java.util.Vector;
@SuppressWarnings("all")
public class MyPane extends JPanel implements KeyListener,Runnable {
    private GameEndListener gameEndListener;
    Hero hero = null;
    Vector<EnemyTank> enemyTanks = new Vector<>();
    Vector<Bomb> bombs = new Vector<>();
    Vector<Wall> walls = new Vector<>();
    Vector<Steel> steels = new Vector<>();
    Vector<River> rivers = new Vector<>();
    Vector<Base> bases = new Vector<>();
    Vector<Prop> props = new Vector<>();
    int enemyTankSize = 5;
    Image image1=Toolkit.getDefaultToolkit().getImage("images/b1.gif");
    Image image2 = Toolkit.getDefaultToolkit().getImage("images/b2.gif");
    Image image3 = Toolkit.getDefaultToolkit().getImage("images/b3.gif");
    public MyPane(){
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
            if(Thread.currentThread().getName() != "stage-3"){
                Font font = new Font("Serif", Font.PLAIN, 56);
                g.setFont(font);
                g.setColor(Color.red);
                g.drawString("VICTORY",70*4,70*4);
            }
            return;
        }
        //画出基地
        if(bases.size()!=0){
            Base base=bases.get(0);
            drawBase(base.getImage(),base.getX(),base.getY(),base.getWidth(),base.getHeight(),g);
        }
        drawWalls(g);
        drawSteels(g);
        drawRivers(g);
        drawProps(g);
        drawHero(g);
        drawEnemyTanks(g);
        drawBombs(g);
    }
    public void drawBase(Image image,int X, int Y, int width, int height, Graphics g){
        g.drawImage(image,X,Y,width,height,null);
    }
    public void drawProp(Image image,int X, int Y, int width, int height, Graphics g){
        g.drawImage(image,X,Y,width,height,null);
    }
    public void drawProps(Graphics g){
        if(props.size()==0)return;
        for (int i=0;i<props.size();i++){
            Prop prop=props.get(i);
            if(prop.islive){
                drawProp(prop.getImage(),prop.getX(),prop.getY(),prop.getWidth(),prop.getHeight(),g);
            }else{
                props.remove(prop);
            }
        }

    }
    public void drawWall(Image image,int X, int Y, int width, int height, Graphics g){
        g.drawImage(image,X,Y,width,height,null);
    }
    public void drawWalls(Graphics g){
        if(walls.size()==0)return;
        for(int i = 0;i<walls.size();i++){      //画出所有的墙
            Wall wall = walls.get(i);
            if(wall.islive) {
                drawWall(wall.getImage(),wall.getX(), wall.getY(), wall.getWidth(), wall.getHeight(), g);
            }else {
                walls.remove(wall);
            }
        }
    }
    public void drawSteel(Image image,int X, int Y, int width, int height, Graphics g){
        g.drawImage(image,X,Y,width,height,null);
    }
    public void drawSteels(Graphics g){
        if(steels.size()==0)return;
        for(int i = 0;i<steels.size();i++){     //画出所有的钢板
            Steel steel=steels.get(i);
            drawSteel(steel.getImage(),steel.getX(),steel.getY(),steel.getWidth(),steel.getHeight(),g);
        }
    }
    public void drawRiver(Image image,int X,int Y,int width,int height,Graphics g){
        g.drawImage(image,X,Y,width,height,null);
    }
    public void drawRivers(Graphics g){
        if(rivers.size()==0)return;
        for(int i=0;i<rivers.size();i++){       //画出所有的河
            River river = rivers.get(i);
            drawRiver(river.getImage(),river.getX(),river.getY(),river.getWidth(),river.getHeight(),g);
        }
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
    public void drawHero(Graphics g){
        if (hero != null && hero.islive) {      //画出玩家
            drawTank(hero.getX(), hero.getY(), g, hero.getDirect(), 0);
        }
        for (int i = 0; i < hero.shots.size(); i++) {       //画出玩家的炮弹
            Shot shot = hero.shots.get(i);
            if (shot != null && shot.islive == true){
                g.draw3DRect(shot.x,shot.y, 2,2,false);
            }else{
                hero.shots.remove(shot);        //这里会把死掉的炮弹移除掉
            }
        }
    }
    public void drawEnemyTanks(Graphics g){
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
    public void drawBombs(Graphics g){
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
    }
    public void hitEnemyTank(){
        for(int i =0;i<hero.shots.size();i++) {
            Shot shot = hero.shots.get(i);
            if (shot.islive) {
                for (int j = 0; j < enemyTanks.size(); j++) {
                    EnemyTank enemyTank = enemyTanks.get(j);
                    hitTank(bombs,shot, enemyTank,enemyTanks);
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
                    hitTank(bombs,shot,hero,enemyTanks);
                }
            }
        }
    }
    public void hitTank(Vector<Bomb> bombs,Shot s,Tank enemyTank,Vector<EnemyTank> enemyTanks){
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
    public void hitbase(){
        for(int ba=0;ba<bases.size();ba++){
            Base base = bases.get(ba);
            for(int i=0;i<enemyTanks.size();i++){       //若是敌人打基地
                EnemyTank enemyTank = enemyTanks.get(i);
                for (int j = 0; j < enemyTank.shots.size(); j++) {
                    Shot s = enemyTank.shots.get(j);
                    if (s.x >= base.getX() && s.x <= base.getX() + base.getWidth()
                            && s.y >= base.getY() && s.y <= base.getY() + base.getHeight()) {
                        hero.islive=false;
                    }
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
    public void getprop(){
        if(props.size()>0){
            Prop prop=hero.isTouchProp();
            if(prop != null){
                if(prop.getType()==1){          //1是手榴弹
                    int n=enemyTanks.size();
                    for(int i=0;i<n-1;i++){
                        EnemyTank enemyTank=enemyTanks.get(0);
                        enemyTank.islive=false;
                        enemyTanks.remove(enemyTank);
                        Bomb bomb =new Bomb(enemyTank.getX(),enemyTank.getY());
                        bombs.add(bomb);
                    }
                }
                if(prop.getType()==2){          //2是时钟
                    for(int i=0;i<enemyTanks.size();i++){
                        EnemyTank enemyTank=enemyTanks.get(i);
                        enemyTank.setSpeed(1);
                        for(int j=0;j<enemyTank.shots.size();j++){
                            Shot shot=enemyTank.shots.get(j);
                            shot.speed=1;
                        }
                    }
                }
                prop.islive = false;
            }
//            for(int k=0;k<props.size();k++){
//                Prop prop=props.get(k);
//                if (hero.getX() >= prop.getX() && hero.getX() <= prop.getX() + prop.getWidth()
//                        && hero.getY() >= prop.getY() && hero.getY()<= prop.getY() + prop.getHeight()) {
//                    if(prop.getType()==1){          //1是手榴弹
//                        int n=enemyTanks.size();
//                        for(int i=0;i<n-1;i++){
//                            EnemyTank enemyTank=enemyTanks.get(0);
//                            enemyTank.islive=false;
//                            enemyTanks.remove(enemyTank);
//                            Bomb bomb =new Bomb(enemyTank.getX(),enemyTank.getY());
//                            bombs.add(bomb);
//                        }
//                    }
//                    if(prop.getType()==2){          //2是时钟
//                        for(int i=0;i<enemyTanks.size();i++){
//                            EnemyTank enemyTank=enemyTanks.get(i);
//                            enemyTank.setSpeed(1);
//                            for(int j=0;j<enemyTank.shots.size();j++){
//                                Shot shot=enemyTank.shots.get(j);
//                                shot.speed=1;
//                            }
//                        }
//                    }
//                    prop.islive = false;
//                }
//            }
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
                Thread.sleep(25);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            hitEnemyTank();     //不停的检查是否打中了
            hitHero();
            hitSteel();
            hitWall();
            hitbase();
            getprop();
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
            if(hero.islive==true && enemyTanks.size()==0){
                if (Thread.currentThread().getName()=="stage-3") {
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    goHome();
                }else {
                    gameOver();
                }
                return;
            }
        }
    }
    public void gameOver() {
        //如果游戏结束了，调用接口的gameOver()方法
        gameEndListener.gameOver();
    }
    //回到开始页面
    public void goHome() {
        gameEndListener.goHome();
    }
    //添加一个设置gameEndListener的方法
    public void setGameEndListener(GameEndListener listener) {
        this.gameEndListener = listener;
    }
}