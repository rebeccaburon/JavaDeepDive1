package app.Uge1.LambdaExpression;

public class Main {
    /*  public static void main(String[] args) {
          Cat cat  = new Cat();
          printingThing(cat);

      }
  */

    /***
     * Denne verison er hvordan man i Lambda bruge implementaion af et interface letter.
     * I stedet for at indsætte et bestemt objekt som indeholder en implementation, indsættes
     * den selve implementationen.
     */
    public static void main(String[] args) {
        printingThing(
                () -> {
                    System.out.println("Meow");
                });

        /***
         * Her et en forkortet version af Lambda
         */

        printingThing(() ->
                System.out.println("Meow"));
    }

    // den tager hvilket som helst objekt som implementere interface Printing
    static void printingThing(Printing things) {
        things.print();
    }
}