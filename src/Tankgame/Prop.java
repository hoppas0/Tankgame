package Tankgame;

import java.awt.*;

/**
 * 道具
 * 有手榴弹和时钟两种
 */
public class Prop {
    private int X;
    private int Y;
    private Image mimage;
    private int Width;
    private int Height;
    private int Type;       //1是手榴弹，2是时钟
    boolean islive = true;

    public Prop(Image image,int x, int y, int width, int height,int type) {
        mimage=image;
        X = x;
        Y = y;
        Width = width;
        Height = height;
        Type=type;
    }
    public Prop(int x, int y, int width, int height,int type) {
        if(type==1){
            mimage=Toolkit.getDefaultToolkit().getImage("images/grenade.png");
        }else if(type==2){
            mimage=Toolkit.getDefaultToolkit().getImage("images/timer.png");
        }
        X = x;
        Y = y;
        Width = width;
        Height = height;
        Type=type;
    }
    public Prop(int x, int y, int width, int height) {
        mimage=Toolkit.getDefaultToolkit().getImage("images/grenade.png");
        X = x;
        Y = y;
        Width = width;
        Height = height;
        Type=1;
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
    public int getType() {
        return Type;
    }
}
