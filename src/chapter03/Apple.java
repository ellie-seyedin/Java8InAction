package chapter03;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class Apple {
    private int weight = 0;
    private Color color;

    public Apple() {
    }

    public Apple(int weight, Color color) {
        this.weight = weight;
        this.color = color;
    }
    //Create default constructor
//    Supplier<Apple> defaultCon = Apple::new;
//    Apple apple = defaultCon.get();
//
//    BiFunction<Integer, Color, Apple> function = Apple::new;
    List<Integer> weights = Arrays.asList(7, 3, 4, 10);
    public List<Apple> map(List<Integer> list, Function<Integer, Apple> f) {
        List<Apple> result = new ArrayList<>();
        for(Integer i: list) {
            result.add(f.apply(i));
        }
        return result;
    }
    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "weight=" + weight +
                ", color=" + color +
                '}';
    }
}
