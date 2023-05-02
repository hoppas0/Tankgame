package Tankgame;

public class Tank {
    private int X;
    private int Y;
    private int direct;
    private int speed = 1;
    boolean islive = true;

    public void moveUp(){
        Y -=speed;
    }
    public void moveRight(){
        X +=speed;
    }
    public void moveDown(){
        Y +=speed;
    }
    public void moveLeft(){
        X -=speed;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getDirect() {
        return direct;
    }

    public void setDirect(int direct) {
        this.direct = direct;
    }

    public Tank(int x, int y) {
        X = x;
        Y = y;
    }

    public int getX() {
        return X;
    }

    public void setX(int x) {
        X = x;
    }

    public int getY() {
        return Y;
    }

    public void setY(int y) {
        Y = y;
    }
}
