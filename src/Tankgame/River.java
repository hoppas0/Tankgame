package Tankgame;

public class River {
    private int X;
    private int Y;
    private int Width;
    private int Height;
    public River(int x, int y, int width, int height){
        X=x;
        Y=y;
        Width=width;
        Height=height;
    }

    public void setX(int x) {
        X = x;
    }

    public void setY(int y) {
        Y = y;
    }

    public void setWidth(int width) {
        this.Width = width;
    }

    public void setHeight(int height) {
        this.Height = height;
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
