package Tankgame;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//


import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

public abstract class GameObject {
    Image img;
    int x;
    int y;
    int width;
    int height;
    int speed;
    //Direction direction;
    MyPane1 gamePanel;

    public GameObject() {
    }

    public GameObject(Image img, int x, int y, MyPane1 gamePanel) {
        this.img = img;
        this.x = x;
        this.y = y;
        this.gamePanel = gamePanel;
    }

    public Image getImg() {
        return this.img;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getX() {
        return this.x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return this.y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getWidth() {
        return this.width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return this.height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public double getSpeed() {
        return (double)this.speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public MyPane1 getGamePanel() {
        return this.gamePanel;
    }

    public void setGamePanel(MyPane1 gamepanel) {
        this.gamePanel = this.gamePanel;
    }

    public abstract void paintSelf(Graphics var1);

    public abstract Rectangle getRec();
}

