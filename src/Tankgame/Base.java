package Tankgame;

import java.awt.*;

/**
 * 基地，被敌人攻击则游戏失败
 */
public class Base {
    private int X;
    private int Y;
    private Image mimage;
    private int Width;
    private int Height;

    boolean islive = true;

    public Base(Image image,int x, int y, int width, int height) {
        mimage=image;
        X = x;
        Y = y;
        Width = width;
        Height = height;
    }
    public Base(int x, int y, int width, int height) {
        mimage=Toolkit.getDefaultToolkit().getImage("images/base.png");
        X = x;
        Y = y;
        Width = width;
        Height = height;
    }
    public Image getImage(){
        return mimage;
    }
    public int getX() {
        return X;
    }

    public int getY() {
        return Y;
    }

    public int getWidth() {
        return Width;
    }

    public int getHeight() {
        return Height;
    }
}
