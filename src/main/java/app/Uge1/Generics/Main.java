package app.Uge1.Generics;

public class Main {
    public static void main(String[] args) {
        // The value T is now a Integer
        Printer <Integer> printerInteger = new Printer<>(24);
        printerInteger.print();

        //You can now change value without change the original class and it's methods.
        Printer<String> printerString = new Printer<>("Hej");
        printerString.print();

        // With Javas collections framework, you use generics all the time with ArrayList <Something>:


        /** If we wanted to print animals, we would have to change the values Interger, String, ect
         * to what animals, fx a cat, dog ect.
         *
         */

    }

}

