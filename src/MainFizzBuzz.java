import java.util.function.IntConsumer;

public class MainFizzBuzz {

    public static void main(String[] args) {

        TaskFizzBuzz fizzBuzz = new TaskFizzBuzz(22);

        Runnable fizz = ()-> System.out.println("fizz");
        Runnable buzz = ()-> System.out.println("buzz");
        Runnable fizzbuzz = ()-> System.out.println("fizzbuzz");
        IntConsumer number = (n)-> System.out.println(n);

        Thread threadA = new Thread(()-> {
            try{
                fizzBuzz.fizz(fizz);
            }catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
        });

        Thread threadB = new Thread(()-> {
            try{
                fizzBuzz.buzz(buzz);
            }catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
        });

        Thread threadC = new Thread(()-> {
            try{
                fizzBuzz.fizzbuzz(fizzbuzz);
            }catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
        });


        Thread threadD = new Thread(()-> {
            try{
                fizzBuzz.number(number);
            }catch (InterruptedException ex){
                throw new RuntimeException(ex);
            }
        });

        threadA.start();
        threadB.start();
        threadC.start();
        threadD.start();

    }

}
