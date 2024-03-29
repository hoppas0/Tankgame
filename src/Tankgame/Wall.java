package Tankgame;

import java.awt.*;

public class Wall {
    private int X;
    private int Y;
    private Image mimage;;
    private int Width;
    private int Height;

    boolean islive = true;

    public Wall(Image image,int x, int y, int width, int height) {
        mimage=image;
        X = x;
        Y = y;
        Width = width;
        Height = height;
    }
    public Wall(int x, int y, int width, int height) {
        mimage=Toolkit.getDefaultToolkit().getImage("images/walls.gif");;
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
