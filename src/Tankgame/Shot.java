package Tankgame;

public class Shot implements Runnable{
    int x;
    int y;
    int direct;
    int speed = 10;
    boolean islive = true;

    public Shot(int x, int y, int dirct) {
        this.x = x;
        this.y = y;
        this.direct = dirct;
    }

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(50);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            switch (direct){
                case 0:
                    y -= speed;
                    break;
                case 1:
                    x += speed;
                    break;
                case 2:
                    y += speed;
                    break;
                case 3:
                    x -= speed;
                    break;
            }
            if (!(x >= 0 && x <= 1000  && y >= 0 && y<=1000 && islive)){
                islive = false;
                break;
            }
        }
    }
}
