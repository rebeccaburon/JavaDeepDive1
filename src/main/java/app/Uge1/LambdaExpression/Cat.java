package app.Uge1.LambdaExpression;


public class Cat implements Printing {

    private String names;
    private int age;

    @Override
    public void print() {
        System.out.println("Meow");
    }

    /***
     * Denne verison er hvordan man i Lambda bruge implementaion af et interface letter.
     *
     */

}
