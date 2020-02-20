package Lesson05;
public class MainClass {
    public static void main(String[] args) {
        //когда гонка создается она получает дорогу, потом тунель, и еще дорогу
        try {
            Race race = new Race(new Road(60), new Tunnel(), new Road(40));
            Car.cdl.await();
            System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Гонка началась!!!");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
