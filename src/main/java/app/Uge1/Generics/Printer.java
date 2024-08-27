package app.Uge1.Generics;

// Type parameter = <>.
// It can be called what ever you want.
// It is offent just a T, standing for type.
// The T is reprecenting what ever that "Printer" is holding/printing

public class Printer <T>{
    T thingToPrint;

    public Printer(T thingToPrint){
        this.thingToPrint = thingToPrint;
    }
    public void print(){
        System.out.println(thingToPrint);
    }
}

/**This can også be a printer for, fx any type of animal, we here use extends
  public class Printer <T extends Animal>{
  T thingToPrint;
 *
 *  Any method that are definde in the Animal class, is avalible to us, in thingToPrint variable
 *  thingToPrint.eat();
 * This is called bouned generic. This can be used for inheritance and interfaces
 *
 * If you wanna expand the bouned generic, you just add a &: public class Printer <T extends Animal & Serializable>
 *     OBS - you can only have one class, and that has to stand firs, then after you can add on Interfaces.
 */
