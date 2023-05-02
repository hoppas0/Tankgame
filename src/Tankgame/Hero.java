package Tankgame;

import java.util.Vector;

//自己的坦克
public class Hero extends Tank {
    Shot shot = null;
    public Hero(int x, int y) {
        super(x, y);
    }
    Vector<Shot> shots = new Vector<>();
    Vector<EnemyTank> enemyTanks = new Vector<>();

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void shotEnemyTank(){
        switch (getDirect()){
            case 0:
                shot = new Shot(getX() +20,getY(),0);
                break;
            case 1:
                shot = new Shot(getX() +60 , getY() + 20,1);
                break;
            case 2:
                shot = new Shot(getX() +20,getY() + 60,2);
                break;
            case 3:
                shot = new Shot(getX(),getY() + 20,3);
                break;
        }
        shots.add(shot);
        new Thread(shot).start();
    }
    public boolean isTouchEnemyTank(){
        switch (this.getDirect()){
            case 0:
                for(int i = 0; i<enemyTanks.size();i++){
                    EnemyTank enemyTank = enemyTanks.get(i);
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

}
