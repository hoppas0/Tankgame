package Tankgame;

import java.util.Vector;

public class Tank {
    private int X;
    private int Y;
    private int direct;
    private int speed = 2;
    boolean islive = true;
    Vector<Wall> walls = new Vector<>();
    Vector<Steel> steels = new Vector<>();
    Vector<River> rivers = new Vector<>();

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
    public void setWalls(Vector<Wall> walls) {
        this.walls = walls;
    }

    public void setSteels(Vector<Steel> steels) {
        this.steels = steels;
    }

    public void setRivers(Vector<River> rivers) {
        this.rivers = rivers;
    }
    public boolean isTouchBuilding(){
        switch (this.getDirect()){
            case 0:
                for(int i=0;i<walls.size();i++){        //这里检测是否撞到了墙
                    Wall wall = walls.get(i);
                    //若左上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX() >= wall.getX()
                            && this.getX() <= wall.getX() +wall.getWidth()
                            && this.getY() >= wall.getY()
                            && this.getY() <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                    //若右上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= wall.getX()
                            && this.getX()+40 <= wall.getX() +wall.getWidth()
                            && this.getY() >= wall.getY()
                            && this.getY() <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<steels.size();i++){       //这里检测是否撞到了钢板
                    Steel steel = steels.get(i);
                    //若左上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX() >= steel.getX()
                            && this.getX() <= steel.getX() +steel.getWidth()
                            && this.getY() >= steel.getY()
                            && this.getY() <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                    //若右上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= steel.getX()
                            && this.getX()+40 <= steel.getX() +steel.getWidth()
                            && this.getY() >= steel.getY()
                            && this.getY() <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<rivers.size();i++){       //这里检测是否撞到了河
                    River river = rivers.get(i);
                    //若左上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX() >= river.getX()
                            && this.getX() <= river.getX() +river.getWidth()
                            && this.getY() >= river.getY()
                            && this.getY() <= river.getY() +river.getHeight()){
                        return true;
                    }
                    //若右上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= river.getX()
                            && this.getX()+40 <= river.getX() +river.getWidth()
                            && this.getY() >= river.getY()
                            && this.getY() <= river.getY() +river.getHeight()){
                        return true;
                    }
                }
                break;
            case 1:
                for(int i=0;i<walls.size();i++){
                    Wall wall = walls.get(i);
                    //若左上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= wall.getX()
                            && this.getX()+60 <= wall.getX() +wall.getWidth()
                            && this.getY() >= wall.getY()
                            && this.getY() <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                    //若右下角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= wall.getX()
                            && this.getX()+60 <= wall.getX() +wall.getWidth()
                            && this.getY()+40 >= wall.getY()
                            && this.getY()+40 <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<steels.size();i++){
                    Steel steel = steels.get(i);
                    //若左上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= steel.getX()
                            && this.getX()+60 <= steel.getX() +steel.getWidth()
                            && this.getY() >= steel.getY()
                            && this.getY() <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                    //若右下角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= steel.getX()
                            && this.getX()+60 <= steel.getX() +steel.getWidth()
                            && this.getY()+40 >= steel.getY()
                            && this.getY()+40 <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<rivers.size();i++){
                    River river = rivers.get(i);
                    //若左上角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= river.getX()
                            && this.getX()+60 <= river.getX() +river.getWidth()
                            && this.getY() >= river.getY()
                            && this.getY() <= river.getY() +river.getHeight()){
                        return true;
                    }
                    //若右下角点位于地形方块区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= river.getX()
                            && this.getX()+60 <= river.getX() +river.getWidth()
                            && this.getY()+40 >= river.getY()
                            && this.getY()+40 <= river.getY() +river.getHeight()){
                        return true;
                    }
                }
                break;
            case 2:
                for(int i=0;i<walls.size();i++){
                    Wall wall = walls.get(i);
                    //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= wall.getX()
                            && this.getX() <= wall.getX() +wall.getWidth()
                            && this.getY()+60 >= wall.getY()
                            && this.getY()+60 <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                    //若右下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= wall.getX()
                            && this.getX()+40 <= wall.getX() +wall.getWidth()
                            && this.getY()+60 >= wall.getY()
                            && this.getY()+60 <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<steels.size();i++){
                    Steel steel = steels.get(i);
                    //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= steel.getX()
                            && this.getX() <= steel.getX() +steel.getWidth()
                            && this.getY()+60 >= steel.getY()
                            && this.getY()+60 <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                    //若右下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= steel.getX()
                            && this.getX()+40 <= steel.getX() +steel.getWidth()
                            && this.getY()+60 >= steel.getY()
                            && this.getY()+60 <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<rivers.size();i++){
                    River river = rivers.get(i);
                    //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= river.getX()
                            && this.getX() <= river.getX() +river.getWidth()
                            && this.getY()+60 >= river.getY()
                            && this.getY()+60 <= river.getY() +river.getHeight()){
                        return true;
                    }
                    //若右下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= river.getX()
                            && this.getX()+40 <= river.getX() +river.getWidth()
                            && this.getY()+60 >= river.getY()
                            && this.getY()+60 <= river.getY() +river.getHeight()){
                        return true;
                    }
                }
                break;
            case 3:
                for(int i=0;i<walls.size();i++){
                    Wall wall = walls.get(i);
                    //若左上角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= wall.getX()
                            && this.getX() <= wall.getX() +wall.getWidth()
                            && this.getY() >= wall.getY()
                            && this.getY() <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                    //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= wall.getX()
                            && this.getX() <= wall.getX() +wall.getWidth()
                            && this.getY()+40 >= wall.getY()
                            && this.getY()+40 <= wall.getY() +wall.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<steels.size();i++){
                    Steel steel = steels.get(i);
                    //若左上角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= steel.getX()
                            && this.getX() <= steel.getX() +steel.getWidth()
                            && this.getY() >= steel.getY()
                            && this.getY() <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                    //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= steel.getX()
                            && this.getX() <= steel.getX() +steel.getWidth()
                            && this.getY()+40 >= steel.getY()
                            && this.getY()+40 <= steel.getY() +steel.getHeight()){
                        return true;
                    }
                }
                for(int i=0;i<rivers.size();i++){
                    River river = rivers.get(i);
                    //若左上角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= river.getX()
                            && this.getX() <= river.getX() +river.getWidth()
                            && this.getY() >= river.getY()
                            && this.getY() <= river.getY() +river.getHeight()){
                        return true;
                    }
                    //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                    if(this.getX() >= river.getX()
                            && this.getX() <= river.getX() +river.getWidth()
                            && this.getY()+40 >= river.getY()
                            && this.getY()+40 <= river.getY() +river.getHeight()){
                        return true;
                    }
                }
                break;
        }
        return false;
    }
}
