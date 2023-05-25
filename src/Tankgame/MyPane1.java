package Tankgame;

@SuppressWarnings("all")
public class MyPane1 extends MyPane{
    public MyPane1(){
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
            enemyTank.setDirect(2);
            new Thread(enemyTank).start();
            Shot shot = new Shot(enemyTank.getX() + 20, enemyTank.getY() + 60, enemyTank.getDirect());
            enemyTank.shots.add(shot);
            new Thread(shot).start();
            enemyTanks.add(enemyTank);
        }
        for(int i = 0;i<10;i++){     //初始化所有的墙
            if(i==4 || i==6)continue;
            if(i == 5){
                walls.add(new Wall(70*2,70*(i+1),70,70));
                walls.add(new Wall(70*3,70*(i+1),70,70));
                walls.add(new Wall(70*5,70*(i+1),70,70));
                walls.add(new Wall(70*7,70*(i+1),70,70));
                walls.add(new Wall(70*9,70*(i+1),70,70));
                walls.add(new Wall(70*10,70*(i+1),70,70));
            }
            walls.add(new Wall(70*1,70*(i+1),70,70));
            walls.add(new Wall(70*3,70*(i+1),70,70));
            walls.add(new Wall(70*5,70*(i+1),70,70));
            walls.add(new Wall(70*7,70*(i+1),70,70));
            walls.add(new Wall(70*9,70*(i+1),70,70));
            walls.add(new Wall(70*11,70*(i+1),70,70));
        }
        for(int i =0;i<3;i++){      //初始化所有的钢板
            steels.add(new Steel(70*6,70*3,70,70));
            steels.add(new Steel(0,70*6,70,70));
            steels.add(new Steel(70*12,70*6,70,70));
            steels.add(new Steel(70*6,70*8,70,70));
        }
        props.add(new Prop(70*6,70*9,70,70,2));
    }
}
