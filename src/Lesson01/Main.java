package Lesson01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    //1. Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
    public static void toSwapArrayIndex(Object[] array, int index1, int index2) {
        Object element = array[index1];//сохраняем значение в массиве на позиции index1
        array[index1] = array[index2];//перезатираем ссылку-говорим в массиве на позиц index1 лежит значение index2
        array[index2] = element;//и теперь в index2 кладем сохраненное ранее значение с index1
    }

    //Написать метод, который преобразует массив в ArrayList;
    public static <T> ArrayList<T> arraysToList(T[] arr) {
        return new ArrayList<>(Arrays.asList(arr));
    }

    public static void main(String[] args) {
        String[] arrStr = {"яблоко", "груша", "черешня"};
        Integer[] numbers = {200, 400, 1000, 500};
        Double[] numbersDouble = {2.22, 3.33, 4.44};

        toSwapArrayIndex(arrStr, 0, 2);
        System.out.println(Arrays.deepToString(arrStr));

        toSwapArrayIndex(numbers, 0, 2);
        System.out.println(Arrays.deepToString(numbers));

        toSwapArrayIndex(numbersDouble, 0, 2);
        System.out.println(Arrays.deepToString(numbersDouble));

        List<String> list = arraysToList(arrStr);
        List<Integer> listINt = arraysToList(numbers);


        System.out.println("массив " + Arrays.deepToString(numbers));
        System.out.println("список" + list);
        System.out.println("список" + listINt);

        Apple ap1 = new Apple();
        Apple ap2 = new Apple();
        Apple ap3 = new Apple();
        System.out.println("вес яблока - " + ap1.getWeight());
        Orange or1 = new Orange();
        Orange or2 = new Orange();
        Orange or3 = new Orange();
        Orange or4 = new Orange();
        Orange or5 = new Orange();
        System.out.println("вес апельсина - " + or1.getWeight());

        Box<Apple> appleBox = new Box<>(ap1, ap2, ap3);
        Box<Apple> appleBox2 = new Box<>(ap1, ap2);
        Box<Orange> orangeBox = new Box<>(or1, or2, or3, or4);
        Box<Orange> orangeBox2 = new Box<>(or1, or2, or3, or4, or5);

        System.out.println("Коробка с яблоками весит: " + appleBox.getWeight());
        System.out.println("Коробка с апельсинами весит: " + orangeBox.getWeight());
        System.out.println(orangeBox.compare(orangeBox2));

        System.out.println("было: " + "Первая коробка весит " + appleBox2.getWeight() +
                " высыпаем в коробку с " + appleBox.getWeight());
        appleBox2.pour(appleBox);
        System.out.println("стало: " + "Первая коробка весит " + appleBox2.getWeight() + " вторая стала весить " + appleBox.getWeight());
        System.out.println("было " + orangeBox.getWeight() + " " + orangeBox2.getWeight());
        orangeBox.pour(orangeBox2);
        System.out.println("стало " + orangeBox.getWeight() + " " + orangeBox2.getWeight());

        orangeBox.add(or1, or2, or3);
        System.out.println(orangeBox.getWeight());

    }
}
