package streams;

import Domain.Dish;

import java.util.List;
import java.util.OptionalInt;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MenuStreamProcessor {
    List<Dish> specialMenu;

    public void filter() {
        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300).toList();
        System.out.println(filteredMenu);

        if (specialMenu.stream().anyMatch(Dish::isVegetarian))
            System.out.println("The menu is (somewhat) vegetarian friendly!!");

        if (specialMenu.stream().allMatch(dish -> dish.getCalories() < 1000))
            System.out.println("The menu is less than 1000 cals.");

        if (specialMenu.stream().noneMatch(dish -> dish.getCalories() > 1000))
            System.out.println("The menu is not more than 1000 cals.");
    }

    public void slice() {
        List<Dish> slicedMenu1
                = specialMenu.stream()
                .takeWhile(dish -> dish.getCalories() < 320).toList();
        System.out.println(slicedMenu1);

        List<Dish> slicedMenu = specialMenu.stream()
                .dropWhile(dish -> dish.getCalories() < 320).toList();
        System.out.println(slicedMenu);

        List<Dish> dishes = specialMenu.stream()
                .filter(d -> d.getCalories() > 300)
                .skip(2)
                .toList();
        System.out.println(dishes);

        IntStream intStream = specialMenu.stream().mapToInt(Dish::getCalories);
        Stream<Integer> stream = intStream.boxed();
    }

    public int findSumCalories(List<Dish> dishes){
        return dishes.stream()
                .mapToInt(Dish::getCalories)
                .sum();
    }

    public OptionalInt findMaxCalories(List<Dish> dishes){
      return dishes.stream()
              .mapToInt(Dish::getCalories)
              .max();
//            max.orElse(1);
    }


}
