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
    public static CyclicBarrier cb = new CyclicBarrier(4);
    public static CountDownLatch cdl = new CountDownLatch(4);//счетчик
    public String getName() {
        return name;
    }
    public int getSpeed() {
        return speed;
    }
    public Car(Race race, int speed) {
        this.race = race;
        this.speed = speed;
        CARS_COUNT++;
        this.name = "Участник #" + CARS_COUNT;
    }
    @Override
    public void run() {//запускается каждая машина
        try {
            System.out.println(this.name + " готовится");
            Thread.sleep(500 + (int)(Math.random() * 800));
            System.out.println(this.name + " готов");
            cdl.countDown();              //когда машина выполнила подготову => готова к старту- тут делает щелчок
        } catch (Exception e) {           //а в майне мы слушаем как только 4 щелчка - кидаем "гонка началась"
            e.printStackTrace();
        }finally {
            try {
                cb.await();//все собираются на линии страта и едут
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
        for (int i = 0; i < race.getStages().size(); i++) {//авто получает отрезок дороги и выполняет
            race.getStages().get(i).go(this);
        }
            if (race.getStages().get(2).getDescription().equals("Дорога " + 40 + " метров")) {
                count++;
            }

            if (count == 1){
                System.out.println(this.getName() + " WIN!!!");
            }

        System.out.println(this.getName() +" "+ count + " место");

    }

}
