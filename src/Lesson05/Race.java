package Lesson05;

import java.util.ArrayList;
import java.util.Arrays;


public class Race {
    private ArrayList<Stage> stages;
    public static final int CARS_COUNT = 4;
    public Car[] cars = new Car[CARS_COUNT];
    public ArrayList<Stage> getStages() {
        return stages; }

    public Race(Stage... stages) {
        System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Подготовка!!!");
        this.stages = new ArrayList<>(Arrays.asList(stages));//когда конка создается получает 3 отрезка пути
        for (int i = 0; i < cars.length; i++) {
            cars[i] = new Car(this, 20 + (int) (Math.random() * 10));//машина создается и получает
                                                                            // гонку(3 отрезка пути) и рандом скорость
        }
        for (int i = 0; i < cars.length; i++) {
            new Thread(cars[i]).start();//каждая машина стартует в своем потоке
        }

    }
}