package Lesson2;

import java.util.*;
import java.util.stream.Collectors;

public class Test1 {
    public static void main(String[] args) {
        int[] arr1 = new int[10];
        List<Integer> list1 = new ArrayList<>();

        fillArray(arr1);
        fillList(list1);

        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));

        // метод map() - маппировать данные
        arr1 = Arrays.stream(arr1).map(a -> a * 2).toArray(); // все элементы массива умножаются на 2
        list1 = list1.stream().map(a -> a * 2).collect(Collectors.toList());

        arr1 = Arrays.stream(arr1).map(a -> 3).toArray(); // все элементы массива будут тройки
        arr1 = Arrays.stream(arr1).map(a -> a + 1).toArray(); // все элементы массива четверки (3+1)
        System.out.println(list1);
        System.out.println(Arrays.toString(arr1));

        // метод filter() - отфильтровать нужные данные
        int[] arr2 = new int[10];
        List<Integer> list2 = new ArrayList<>();

        fillArray(arr2);
        fillList(list2);

        arr2 = Arrays.stream(arr2).filter(a -> a % 2 == 0).toArray(); // все четные элементы, то есть указанные в условии
        list2 = list2.stream().filter(a -> a % 2 == 0).collect(Collectors.toList());

        System.out.println(Arrays.toString(arr2));
        System.out.println(list2);

        // метод - аналог цикла for
        Arrays.stream(arr2).forEach(a -> System.out.println(a));
        list2.stream().forEach(a -> System.out.println(a));

        // метод - reduce - уменьшение набора данных (листа, массива) до одного элемента (суммой, произведением итд)
        int[] arr3 = new int[10];
        List<Integer> list3 = new ArrayList<>();

        fillList(list3);
        fillArray(arr3);

        // работа reduce - два аргумента - аккумулятор и текущее значение.
        // [1,2,3] вызываем на нем reduce, 1шаг (аккумулятор 1 (первый элемент) и текущее значение 1), итерацию начинаем со второго
        // 2 шаг (аккумулятор 1 и текущее значение 2) сумма ==3
        // 3 шаг (аккумулятор 3 и текущее значение 3) сумма ==6, аккум =6 - возврат этого значения

        // если не указываем начальное значение acc, итерация начинается со второго элемента, укзыаем - с первого итерируемся...
        int sum1 = Arrays.stream(arr3).reduce((acc, b) -> acc + b).getAsInt(); // сумма всех элементов
        int sum2 = list3.stream().reduce((acc, b) -> acc * b).get(); // произведение всех элементов

        System.out.println(sum1);
        System.out.println(sum2);

        //можно делать последовательный вызов методов:
        int[] arr4 = new int[10];
        fillArray(arr4);

        // хотим оставить в массиве нечетные только. И умножим их на два. Для чего фильтр, потом мэп:
        int[] newArray = Arrays.stream(arr4).filter(a -> a % 2 != 0).map(a -> a * 2).toArray();
        System.out.println(Arrays.toString(newArray));

        // методы можно вызывать на любых коллекциях:
        Set<Integer> set = new HashSet<>();
        set.add(1);
        set.add(2);
        set.add(5);

        System.out.println(set);
        set = set.stream().map(a -> a * 3).collect(Collectors.toSet());
        System.out.println(set);

    }

    private static void fillList(List<Integer> list) { // проход и вывод каждого элемента цикла
        for (int i = 0; i < 10; i++) {
            list.add(i + 1);
        }

    }

    private static void fillArray(int[] arr) {
        for (int i = 0; i < 10; i++) {
            arr[i] = i + 1;
        }
    }
}
