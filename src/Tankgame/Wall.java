package Tankgame;

public class Wall {
    private int X;
    private int Y;
    private int Width;
    private int Height;

    boolean islive = true;

    public Wall(int x, int y, int width, int height) {
        X = x;
        Y = y;
        Width = width;
        Height = height;
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
