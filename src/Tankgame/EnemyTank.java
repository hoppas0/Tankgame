package Tankgame;

import java.util.Vector;

public class EnemyTank extends Tank implements Runnable{
    boolean islive = true;
    Vector<Shot> shots = new Vector<>();
    //可以得到敌人坦克的vertor
    Vector<EnemyTank> enemyTanks = new Vector<>();
    public EnemyTank(int x, int y) {
        super(x, y);
    }
    //提供一个方法，将MyPanel的成员Vector<EnemyTank> enemyTankes 设置到 EnemyTank的成员enemyTanks
    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    //编写方法，判断该坦克是否和其他坦克发生碰撞
    public boolean isTouchEnemyTank(){
        switch (this.getDirect()){
            case 0:
                for(int i = 0; i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比
                    if(this == enemyTank)continue;
                    //若敌方坦克的方向是上下
                    if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                        //若左上角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +60){
                            return true;
                        }
                        //若右上角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX()+40 >= enemyTank.getX()
                                && this.getX()+40 <= enemyTank.getX() +40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +60){
                            return true;
                        }
                    }
                    //若敌方坦克的方向是左右
                    if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +40){
                            return true;
                        }
                        if(this.getX()+40 >= enemyTank.getX()
                                && this.getX()+40 <= enemyTank.getX() +60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +40){
                            return true;
                        }
                    }
                }
                break;
            case 1:
                for(int i = 0; i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比
                    if(this == enemyTank)continue;
                    //若敌方坦克的方向是上下
                    if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                        //若右上角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX()+60 >= enemyTank.getX()
                                && this.getX()+60 <= enemyTank.getX() +40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +60){
                            return true;
                        }
                        //若右下角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX()+60 >= enemyTank.getX()
                                && this.getX()+60 <= enemyTank.getX() +40
                                && this.getY()+40 >= enemyTank.getY()
                                && this.getY()+40 <= enemyTank.getY() +60){
                            return true;
                        }
                    }
                    //若敌方坦克的方向是左右
                    if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                        if(this.getX()+60 >= enemyTank.getX()
                                && this.getX()+60 <= enemyTank.getX() +60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +40){
                            return true;
                        }
                        if(this.getX()+60 >= enemyTank.getX()
                                && this.getX()+60 <= enemyTank.getX() +60
                                && this.getY()+40 >= enemyTank.getY()
                                && this.getY()+40 <= enemyTank.getY() +40){
                            return true;
                        }
                    }
                }
                break;
            case 2:
                for(int i = 0; i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比
                    if(this == enemyTank)continue;
                    //若敌方坦克的方向是上下
                    if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                        //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +40
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY()+60 <= enemyTank.getY() +60){
                            return true;
                        }
                        //若右下角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX()+40 >= enemyTank.getX()
                                && this.getX()+40 <= enemyTank.getX() +40
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY()+60 <= enemyTank.getY() +60){
                            return true;
                        }
                    }
                    //若敌方坦克的方向是左右
                    if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +60
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY()+60 <= enemyTank.getY() +40){
                            return true;
                        }
                        if(this.getX()+40 >= enemyTank.getX()
                                && this.getX()+40 <= enemyTank.getX() +60
                                && this.getY()+60 >= enemyTank.getY()
                                && this.getY()+60 <= enemyTank.getY() +40){
                            return true;
                        }
                    }
                }
                break;
            case 3:
                for(int i = 0; i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
                    //不和自己比
                    if(this == enemyTank)continue;
                    //若敌方坦克的方向是上下
                    if(enemyTank.getDirect()==0||enemyTank.getDirect()==2){
                        //若左上角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +40
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +60){
                            return true;
                        }
                        //若左下角点位于其他坦克区域内，则证明已经发生了碰撞
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +40
                                && this.getY()+40 >= enemyTank.getY()
                                && this.getY()+40 <= enemyTank.getY() +60){
                            return true;
                        }
                    }
                    //若敌方坦克的方向是左右
                    if(enemyTank.getDirect()==1||enemyTank.getDirect()==3){
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +60
                                && this.getY() >= enemyTank.getY()
                                && this.getY() <= enemyTank.getY() +40){
                            return true;
                        }
                        if(this.getX() >= enemyTank.getX()
                                && this.getX() <= enemyTank.getX() +60
                                && this.getY()+40 >= enemyTank.getY()
                                && this.getY()+40 <= enemyTank.getY() +40){
                            return true;
                        }
                    }
                }
                break;
        }
        return false;
    }
    @Override
    public void run() {
        do {
            if (islive && shots.size() < 1) {
                Shot s = switch (getDirect()) {
                    case 0 -> new Shot(getX() + 20, getY(), getDirect());
                    case 1 -> new Shot(getX() + 60, getY() + 20, getDirect());
                    case 2 -> new Shot(getX() + 20, getY() + 60, getDirect());
                    case 3 -> new Shot(getX() + 20, getY() + 20, getDirect());
                    default -> null;
                };
                shots.add(s);
                new Thread(s).start();
            }

            switch (getDirect()) {
                case 0:
                    for (int i = 0; i < 30; i++) {      //沿着这个方向走30步
                        if(this.getSpeed()==1){
                            try {
                                Thread.sleep(10000);
                                setSpeed(2);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (getY() > 0 && !isTouchEnemyTank() && !isTouchBuilding()) {
                            moveUp();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 1:
                    for (int i = 0; i < 30; i++) {
                        if(this.getSpeed()==1){
                            try {
                                Thread.sleep(10000);
                                setSpeed(2);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (getX() + 60 < 70*13 && !isTouchEnemyTank() && !isTouchBuilding()) {
                            moveRight();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 2:
                    for (int i = 0; i < 50; i++) {          //为了让敌方坦克更靠近我方坦克，所以让它向下走的更多一些
                        if(this.getSpeed()==1){
                            try {
                                Thread.sleep(10000);
                                setSpeed(2);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (getY() + 60 < 70*13 && !isTouchEnemyTank() && !isTouchBuilding()) {
                            moveDown();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
                case 3:
                    for (int i = 0; i < 30; i++) {
                        if(this.getSpeed()==1){
                            try {
                                Thread.sleep(10000);
                                setSpeed(2);
                            } catch (InterruptedException e) {
                                throw new RuntimeException(e);
                            }
                        }
                        if (getX() > 0 && !isTouchEnemyTank() && !isTouchBuilding()) {
                            moveLeft();
                        }
                        try {
                            Thread.sleep(50);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    break;
            }

            setDirect((int) (Math.random() * 4));
        } while (islive);
    }
}
