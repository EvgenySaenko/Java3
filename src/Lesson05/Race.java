package Lesson05;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;


public class Race {
    private ArrayList<Stage> stages;
    public static final int CARS_COUNT = 4;
    public Car[] cars = new Car[CARS_COUNT];
    public CyclicBarrier cb = new CyclicBarrier(CARS_COUNT + 1);
    public ArrayList<Stage> getStages() {
        return stages; }

    public Race(Stage... stages) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        this.stages = new ArrayList<>(Arrays.asList(stages));//когда конка создается получает 3 отрезка пути
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10),cb);//машина создается и получает
                                                                            // гонку(3 отрезка пути) и рандом скорость
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();//каждая машина стартует в своем потоке
        }
        try {
            //Car.cdl.await();//все собираются на линии страта и едут
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
            cb.await();
            cb.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка закончилась!!!");
        } catch (BrokenBarrierException | InterruptedException e) {
            e.printStackTrace();
        }

    }
}