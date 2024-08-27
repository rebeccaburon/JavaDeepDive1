package app.Uge1.Generics;

public class MainForGenericMethods {
    public static void main(String[] args) {

        shout("4,5");
        shout(43);


        anotherShout("lets", "do", "this");


    }
    // before the return type, you but the generic type, so it indicates that it is a generic method
    // thingToShout can take any kind of parameter
    // if you wanna return any type, you change void to T and then add a return
    private static <T> void shout (T thingToShout ) {
        System.out.println(thingToShout + "!!!!!");
        //return thingToShout;
    }

    //if we would wanna have more types, simplye add it in the <> and in the parameters

    private static <T,V,L> void anotherShout (T shout, V shouting, L yelling){
        System.out.println(shout + "2"+ shouting + yelling);
    }

}
