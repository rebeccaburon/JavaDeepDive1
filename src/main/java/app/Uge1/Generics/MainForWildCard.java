package app.Uge1.Generics;

import java.util.ArrayList;
import java.util.List;

public class MainForWildCard {
    public static void main(String[] args) {

        List<Integer> intList = new ArrayList<>();
        intList.add(3);
        printList(intList);

        List<String> StringList = new ArrayList<>();
        StringList.add("hej");
        printList(StringList);

        List<Double> doubleList = new ArrayList<>();
        doubleList.add(3.4);
        printList(doubleList);
    }
    //The ? is a wild card, as a type parameter while using generics when you don't know what that generic type is
    // going to be
    private static void printList(List<?> myList){
        System.out.println(myList);

        // It is also possible to extend from a class, in the class.
        /**
         *  private static void printList(List<? extends Animal> myList){
         *         System.out.println(myList);
         */
    }
}
