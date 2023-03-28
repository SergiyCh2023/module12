import java.util.concurrent.ArrayBlockingQueue;
        import java.util.concurrent.BlockingQueue;

public class FizzBuzzTask {

    static int n = 37;
    static String numbersString;
    static BlockingQueue<String> queue;
    static boolean checkNumber = false;

    static void fizz(int num) {
        if (num % 3 == 0 && num % 5 != 0) {
            numbersString = "fizz";
            checkNumber = true;
        }
    }


    static void buzz(int num) {
        if (num % 5 == 0 && num % 3 != 0) {
            numbersString = "buzz";
            checkNumber = true;
        }
    }

    static void fizzbuzz(int num) {
        if (num % 3 == 0 && num % 5 == 0) {
            numbersString = "fizzbuzz";
            checkNumber = true;
        }
    }


    static void number(int num) {
        if (!checkNumber) numbersString = num + "";
        checkNumber = false;

    }


    public static void main(String[] args) throws InterruptedException {
        queue = new ArrayBlockingQueue<>(n);

        for (int i = 1; i <= n; i++) {
            final int FINAL_I = i;

            Thread a = new Thread(() -> fizz(FINAL_I));
            Thread b = new Thread(() -> buzz(FINAL_I));
            Thread c = new Thread(() -> fizzbuzz(FINAL_I));
            Thread d = new Thread(() -> number(FINAL_I));

            a.start();
            b.start();
            c.start();
            d.start();

            a.join();
            b.join();
            c.join();
            d.join();

            queue.put(numbersString);

        }

        System.out.println(queue.toString());


    }
}

