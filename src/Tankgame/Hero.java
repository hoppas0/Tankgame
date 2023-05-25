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
    Vector<Prop> props = new Vector<>();

    public void setEnemyTanks(Vector<EnemyTank> enemyTanks) {
        this.enemyTanks = enemyTanks;
    }

    public void setProps(Vector<Prop> props) {
        this.props = props;
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
    public Prop isTouchProp(){
        switch (this.getDirect()){
            case 0:
                for(int i=0;i<props.size();i++){        //这里检测是否撞到了道具
                    Prop prop = props.get(i);
                    //若左上角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX() >= prop.getX()
                            && this.getX() <= prop.getX() +prop.getWidth()
                            && this.getY() >= prop.getY()
                            && this.getY() <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                    //若右上角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= prop.getX()
                            && this.getX()+40 <= prop.getX() +prop.getWidth()
                            && this.getY() >= prop.getY()
                            && this.getY() <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                }
                break;
            case 1:
                for(int i=0;i<props.size();i++){
                    Prop prop = props.get(i);
                    //若左上角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= prop.getX()
                            && this.getX()+60 <= prop.getX() +prop.getWidth()
                            && this.getY() >= prop.getY()
                            && this.getY() <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                    //若右下角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX()+60 >= prop.getX()
                            && this.getX()+60 <= prop.getX() +prop.getWidth()
                            && this.getY()+40 >= prop.getY()
                            && this.getY()+40 <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                }
                break;
            case 2:
                for(int i=0;i<props.size();i++){
                    Prop prop = props.get(i);
                    //若左下角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX() >= prop.getX()
                            && this.getX() <= prop.getX() +prop.getWidth()
                            && this.getY()+60 >= prop.getY()
                            && this.getY()+60 <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                    //若右下角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX()+40 >= prop.getX()
                            && this.getX()+40 <= prop.getX() +prop.getWidth()
                            && this.getY()+60 >= prop.getY()
                            && this.getY()+60 <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                }
                break;
            case 3:
                for(int i=0;i<props.size();i++){
                    Prop prop = props.get(i);
                    //若左上角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX() >= prop.getX()
                            && this.getX() <= prop.getX() +prop.getWidth()
                            && this.getY() >= prop.getY()
                            && this.getY() <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                    //若左下角点位于道具区域内，则证明已经发生了碰撞
                    if(this.getX() >= prop.getX()
                            && this.getX() <= prop.getX() +prop.getWidth()
                            && this.getY()+40 >= prop.getY()
                            && this.getY()+40 <= prop.getY() +prop.getHeight()){
                        return prop;
                    }
                }
                break;
        }
        return null;
    }
}
