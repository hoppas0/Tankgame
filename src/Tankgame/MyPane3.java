package Tankgame;

import java.util.Random;
@SuppressWarnings("all")
public class MyPane3 extends MyPane{
    int positionx[]={70*1,70*11,70*1,70*11};
    int positiony[]={70*6,70*6,70*11,70*11};
    public MyPane3(){
        hero = new Hero(5+(70*6),5+70*11);//初始化自己的坦克
        hero.setEnemyTanks(enemyTanks);
        hero.setWalls(walls);
        hero.setSteels(steels);
        hero.setRivers(rivers);
        hero.setProps(props);
        hero.setSpeed(5);
        for (int i = 1; i < enemyTankSize+1; i++) {     //初始化敌人的坦克
            EnemyTank enemyTank = new EnemyTank(5+(i*140),0);
            //将 enemyTanks 设置给 enemyTank
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setWalls(walls);
            enemyTank.setSteels(steels);
            enemyTank.setRivers(rivers);
            Random ran = new Random();
            int ranum =ran.nextInt(100);
            enemyTank.setDirect(ranum%4);
            enemyTank.setSpeed(4);
            new Thread(enemyTank).start();
            Shot shot1 = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot1);
            new Thread(shot1).start();
            enemyTanks.add(enemyTank);
        }
        for(int i=0;i<4;i++){
            EnemyTank enemyTank = new EnemyTank(positionx[i],positiony[i]);
            //将 enemyTanks 设置给 enemyTank
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setWalls(walls);
            enemyTank.setSteels(steels);
            enemyTank.setRivers(rivers);
            enemyTank.setDirect(2);
            enemyTank.setSpeed(4);
            new Thread(enemyTank).start();
            Shot shot1 = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot1);
            new Thread(shot1).start();
            enemyTanks.add(enemyTank);
        }

        bases.add(new Base(70*6,70*6,70,70));
        //bases.add(new Base(baseimage,70*6,70*3,70,70));
        props.add(new Prop(70*6,70*2,70,70));

        for(int i=5;i<=7;i++){
            walls.add(new Wall(70*i,70*5,70,70));
            walls.add(new Wall(70*i,70*6,70,70));
            if(i==6){
                walls.removeElementAt(4);
            }
            walls.add(new Wall(70*i,70*7,70,70));
        }


        steels.add(new Steel(70*6,70*3,70,70));

        steels.add(new Steel(70*3,70*3,70,70));
        steels.add(new Steel(70*2,70*3,70,70));
        steels.add(new Steel(70*3,70*4,70,70));

        steels.add(new Steel(70*9,70*3,70,70));
        steels.add(new Steel(70*10,70*3,70,70));
        steels.add(new Steel(70*9,70*4,70,70));

        steels.add(new Steel(70*3,70*8,70,70));
        steels.add(new Steel(70*2,70*9,70,70));
        steels.add(new Steel(70*3,70*9,70,70));

        steels.add(new Steel(70*9,70*8,70,70));
        steels.add(new Steel(70*10,70*9,70,70));
        steels.add(new Steel(70*9,70*9,70,70));

        for(int i=4;i<=8;i++){
            rivers.add(new River(70*i,70*9,70,70));
        }
        props.add(new Prop(70*6,70*10,70,70,2));
    }
}