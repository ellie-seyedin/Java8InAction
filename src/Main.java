import streams.Dish;
import streams.Type;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toList;

public class Main {
    public static void main(String[] args) {
        List<Dish> specialMenu = Arrays.asList(
                new Dish("seasonal fruit", true, 120, Type.OTHER),
                new Dish("prawns", false, 300, Type.FISH),
                new Dish("rice", true, 350, Type.OTHER),
                new Dish("chicken", false, 400, Type.MEAT),
                new Dish("french fries", true, 530, Type.OTHER));

        List<Dish> filteredMenu = specialMenu.stream()
                .filter(dish -> dish.getCalories() > 300).toList();
        System.out.println(filteredMenu);

        if (specialMenu.stream().anyMatch(Dish::isVegetarian))
            System.out.println("The menu is (somewhat) vegetarian friendly!!");

        if (specialMenu.stream().allMatch(dish -> dish.getCalories() < 1000))
            System.out.println("The menu is less than 1000 cals.");

        if (specialMenu.stream().noneMatch(dish -> dish.getCalories() > 1000))
            System.out.println("The menu is not more than 1000 cals.");

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

        List<Dish> dishes1 = specialMenu
                .stream()
                .filter(dish -> dish.getCalories() > 300)
                .limit(3).toList();
        System.out.println(dishes1);

        specialMenu.stream()
                .filter(dish -> dish.getType() == Type.MEAT).limit(2).forEach(System.out::println);

        List<String> dishNames = specialMenu.stream()
                .filter(Dish::isVegetarian)
                .map(Dish::getName).toList();
        System.out.println(dishNames);

        List<String> words = Arrays.asList("Modern", "Java", "In", "Action");
        List<Integer> wordLengths = words.stream()
                .map(String::length)
                .toList();
        System.out.println(wordLengths);

        List<Integer> dishNameLengths = specialMenu.stream()
                .map(Dish::getName)
                .map(String::length)
                .toList();
        System.out.println(dishNameLengths);

        //flatmap
        List<String> uniqueCharacters = words.stream()
                .map(word -> word.split(""))
                .flatMap(Arrays::stream)
                .distinct()
                .toList();
        System.out.println(uniqueCharacters);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareNumber = numbers.stream()
                .map(n -> n * n)
                .toList();
        System.out.println(squareNumber);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3);
        List<Integer> numbers2 = Arrays.asList(3, 4);

        //Could two maps to iterate on the two lists and generate the pairs
        List<int[]> allPairs = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .map(j -> new int[]{i, j}))
                .toList();
        for (int[] pair : allPairs) {
            System.out.println(Arrays.toString(pair));
        }

        //check if the sum is divisible by 3
        List<int[]> divisible = numbers1.stream()
                .flatMap(i -> numbers2.stream()
                        .filter(j -> (i + j) % 3 == 0)
                        .map(j -> new int[]{i, j})).toList();
        for (int[] i : divisible) {
            System.out.println(Arrays.toString(i));
        }

        //The stream pipeline will be optimized behind the scene
        //Optional is a container class to represent the existence or absence of value
        //instead of returning null, which is an error prone
        Optional<Dish> dish = specialMenu.stream()
                .filter(Dish::isVegetarian)
                .findAny();
        System.out.println("dish = " + dish);
        //or
        specialMenu.stream()
                .filter(Dish::isVegetarian)
                .findAny()
                .ifPresent(d -> System.out.println(d.getName()));

        List<Integer> someNumbers = Arrays.asList(1, 2, 6, 3, 4, 5, 9);
        Optional<Integer> squareDivisibleByThree = someNumbers.stream()
                .map(n -> n * n)
                .filter(n -> n % 3 == 0)
                .findFirst();
        System.out.println(squareDivisibleByThree);
        //using Reducing
        int sum = someNumbers.stream().reduce(0, Integer::sum);
        int multiply = someNumbers.stream().reduce(1,(a,b)->a*b);
        System.out.println("sum: " + sum);
        System.out.println("multiply: " + multiply);
        //or
        Optional<Integer> sum1 =  someNumbers.stream().reduce(Integer::sum);
        System.out.println(sum1);
        Optional<Integer> max = someNumbers.stream().reduce(Integer::max);
        System.out.println(max);
        Optional<Integer> min = someNumbers.stream().reduce(Integer::min);
        System.out.println(min);

      long countOfDishes = specialMenu.size();
        System.out.println(countOfDishes);
        someNumbers.parallelStream().reduce(Integer::sum);

    }
}