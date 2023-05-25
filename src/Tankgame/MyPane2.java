package Tankgame;

import java.util.Random;
@SuppressWarnings("all")
public class MyPane2 extends MyPane{
    public MyPane2(){
        hero = new Hero(10+(70*6),5+70*10);//初始化自己的坦克
        hero.setEnemyTanks(enemyTanks);
        hero.setWalls(walls);
        hero.setSteels(steels);
        hero.setRivers(rivers);
        hero.setProps(props);
        hero.setSpeed(5);
        for (int i = 1; i < enemyTankSize+1; i++) {     //初始化敌人的坦克
            EnemyTank enemyTank = new EnemyTank(20,70*(i*2));
            //将 enemyTanks 设置给 enemyTank
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setWalls(walls);
            enemyTank.setSteels(steels);
            enemyTank.setRivers(rivers);
            Random r = new Random();
            int rnum =r.nextInt(100);
            enemyTank.setDirect(rnum%4);
            enemyTank.setSpeed(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        for (int i = 1; i < enemyTankSize+1; i++) {     //初始化敌人的坦克
            EnemyTank enemyTank = new EnemyTank(70*12+20,70*(i*2));
            //将 enemyTanks 设置给 enemyTank
            enemyTank.setEnemyTanks(enemyTanks);
            enemyTank.setWalls(walls);
            enemyTank.setSteels(steels);
            enemyTank.setRivers(rivers);
            Random r = new Random();
            int rnum =r.nextInt(100);
            enemyTank.setDirect(rnum%4);
            enemyTank.setSpeed(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        bases.add(new Base(70*6,70*12,70,70));

        walls.add(new Wall(70*5,70*12,70,70));
        walls.add(new Wall(70*7,70*12,70,70));
        walls.add(new Wall(70*5,70*11,70,70));
        walls.add(new Wall(70*6,70*11,70,70));
        walls.add(new Wall(70*7,70*11,70,70));

        walls.add(new Wall(70*1,70*2,70,70));
        walls.add(new Wall(70*2,70*2,70,70));
        walls.add(new Wall(70*3,70*2,70,70));
        walls.add(new Wall(70*3,70*3,70,70));
        walls.add(new Wall(70*3,70*4,70,70));
        walls.add(new Wall(70*2,70*4,70,70));
        walls.add(new Wall(70*1,70*4,70,70));

        walls.add(new Wall(70*1,70*8,70,70));
        walls.add(new Wall(70*2,70*8,70,70));
        walls.add(new Wall(70*3,70*8,70,70));
        walls.add(new Wall(70*3,70*9,70,70));
        walls.add(new Wall(70*3,70*10,70,70));
        walls.add(new Wall(70*2,70*10,70,70));
        walls.add(new Wall(70*1,70*10,70,70));

        walls.add(new Wall(70*11,70*2,70,70));
        walls.add(new Wall(70*10,70*2,70,70));
        walls.add(new Wall(70*9,70*2,70,70));
        walls.add(new Wall(70*9,70*3,70,70));
        walls.add(new Wall(70*9,70*4,70,70));
        walls.add(new Wall(70*10,70*4,70,70));
        walls.add(new Wall(70*11,70*4,70,70));

        walls.add(new Wall(70*11,70*8,70,70));
        walls.add(new Wall(70*10,70*8,70,70));
        walls.add(new Wall(70*9,70*8,70,70));
        walls.add(new Wall(70*9,70*9,70,70));
        walls.add(new Wall(70*9,70*10,70,70));
        walls.add(new Wall(70*10,70*10,70,70));
        walls.add(new Wall(70*11,70*10,70,70));
        for(int i =0;i<3;i++){      //初始化所有的钢板
            Steel steel0 = new Steel(70*6,70*3,70,70);
            steels.add(steel0);
            Steel steel1 = new Steel(70*5,70*6,70,70);
            steels.add(steel1);
            Steel steel2 = new Steel(70*7,70*6,70,70);
            steels.add(steel2);
            Steel steel3 = new Steel(70*6,70*8,70,70);
            steels.add(steel3);
        }
        steels.add(new Steel(70*5,70*8,70,70));
        steels.add(new Steel(70*7,70*8,70,70));

        rivers.add(new River(70*1,70*6,70,70));
        rivers.add(new River(70*2,70*6,70,70));
        rivers.add(new River(70*3,70*6,70,70));

        rivers.add(new River(70*9,70*6,70,70));
        rivers.add(new River(70*10,70*6,70,70));
        rivers.add(new River(70*11,70*6,70,70));

        props.add(new Prop(70*6,70*9,70,70));
    }
}