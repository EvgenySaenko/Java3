package Lesson05;

import java.util.concurrent.Semaphore;

public class Tunnel extends Stage {
    private Semaphore sm;
    public Tunnel() {
        this.sm = new Semaphore(Race.CARS_COUNT/2);
        this.length = 80;
        this.description = "Тоннель " + length + " метров";
    }
    @Override
    public void go(Car c) {
        try {
            try {
                //сюда заходит если не получается захватить, если получилось идет ниже блока if
                if (!sm.tryAcquire()){//пытается захватить семафор, если не получается
                    System.out.println(c.getName() + " готовится к этапу(ждет): " + description);//печатает это
                    sm.acquire();                                                               //и потом захватывает
                }
                System.out.println(c.getName() + " начал этап: " + description);
                Thread.sleep(length / c.getSpeed() * 1000);
                System.out.println(c.getName() + " закончил этап: " + description);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                sm.release();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
