import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.IntConsumer;

public class TaskFizzBuzz {

    private int n;
    private final AtomicInteger currentValue = new AtomicInteger(1);

    public  TaskFizzBuzz(int n) {
        this.n = n;
    }

    public void fizz(Runnable printFizz) throws InterruptedException{
        while (currentValue.get() <= n) {
            if (currentValue.get()%3 ==0 && currentValue.get()%5 != 0) {
                if (currentValue.get() > n) {
                    break;
                }
                printFizz.run();
                currentValue.getAndIncrement();
            }
        }
    }


    public void buzz(Runnable printBuzz) throws InterruptedException{
        while (currentValue.get() <= n) {
            if (currentValue.get()%5 ==0 && currentValue.get()%3 != 0) {
                if (currentValue.get() > n) {
                    break;
                }
                printBuzz.run();
                currentValue.getAndIncrement();
            }
        }
    }

    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException{
        while (currentValue.get() <= n) {
            if (currentValue.get()%3 ==0 && currentValue.get()%5 == 0) {
                if (currentValue.get() > n) {
                    break;
                }
                printFizzBuzz.run();
                currentValue.getAndIncrement();
            }
        }
    }



    public void number (IntConsumer printNumber) throws InterruptedException{
        while (currentValue.get() <= n) {
            if (currentValue.get()%3 !=0 && currentValue.get()%5 != 0) {
                if (currentValue.get() > n) {
                    break;
                }
                printNumber.accept(currentValue.get());
                currentValue.getAndIncrement();
            }
        }
    }

}
