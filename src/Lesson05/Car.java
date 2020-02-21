package Lesson05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;

public class Car implements Runnable {
    private  static int count = 0;
    private static int CARS_COUNT;
    static {
        CARS_COUNT = 0;
    }
    private Race race;
    private int speed;
    private String name;
    public static CyclicBarrier cb;
    public static CountDownLatch cdl = new CountDownLatch(4);//счетчик
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }

    public Car(Race race, int speed,CyclicBarrier cb) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
        this.cb = cb;
    }
    @Override
    public void run() {//запускается каждая машина
            try {
                System.out.println(this.name + " готовится");
                Thread.sleep(500 + (int) (Math.random() * 800));
                System.out.println(this.name + " готов");
                cb.await();
                cb.await();
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }


            //cdl.countDown();              //когда машина выполнила подготову => готова к старту- тут делает щелчок
        for (int i = 0; i < race.getStages().size(); i++) {//авто получает отрезок дороги и выполняет
            race.getStages().get(i).go(this);
        }
        count++;
        if (count == 1){
            System.out.println(this.getName() + " WIN!!!");
        }
        try {
            cb.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }


    }

}
