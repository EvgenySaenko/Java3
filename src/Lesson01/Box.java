package Lesson01;

import java.util.ArrayList;
import java.util.Arrays;

//Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта,
// поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
public class Box<T extends Fruit> {

    private ArrayList<T> listBox;//создадим список для хранения фруктов в коробке

    public Box(T... items) {
        this.listBox = new ArrayList<T>(Arrays.asList(items));//добавим в список массив элементов
    }

    //метод высчитывает вес коробки
    public float getWeight() {
        if (listBox.size() == 0) return 0;
        float weight = 0;
        for (int i = 0; i < listBox.size(); i++) {
            weight += listBox.get(i).getWeight();//намучился пока не прописал <T extends Fruit>
        }
        return weight;
    }

    //метод сравнивает текущую коробку с той что дают ему
    public boolean compare(Box<?> anotherBox) {
        return Math.abs(this.getWeight() - anotherBox.getWeight()) < 0.0001;
    }

    //добавляем фрукты в коробку
    public void add(T... items) {
        this.listBox.addAll(Arrays.asList(items));//добавим в нашу коробку список элементов
    }

    //метод пересыпает из текущей коробки в другую
    // (помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами).
    public void pour(Box<T> anotherBox) {
        if (anotherBox==this){
            return;
        }
        for (int i = 0; i < listBox.size(); i++) {
            anotherBox.listBox.add(listBox.get(i));
        }
        listBox.clear();
    }
}
