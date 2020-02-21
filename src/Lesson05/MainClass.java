package Lesson05;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class MainClass {
    public static void main(String[] args) {

        //когда гонка создается она получает дорогу, потом тунель, и еще дорогу
        Race race = new Race(new Road(60), new Tunnel(), new Road(40));

    }
}
