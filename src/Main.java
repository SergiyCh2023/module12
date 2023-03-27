/*
Завдання 1

Напишіть програму, яка кожну секунду відображає на екрані дані про час, що минув від моменту запуску програми.

Другий потік цієї ж програми кожні 5 секунд виводить повідомлення Минуло 5 секунд.
 */

public class Main {

    private static volatile boolean isSecondLeft = false;

    public static void main(String[] args) {
        long timeStartProgram = System.currentTimeMillis();

        new Thread(()->{

            while (true) {

                try {
                    Thread.sleep(1000);
                    isSecondLeft = true;
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
                System.out.println("час, що минув від моменту запуску програми: " + ((System.currentTimeMillis() - timeStartProgram)/1000) + " секунд тому");
            }
        }).start();




        new Thread(()->{
            try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            while (true) {
                try{
                    for (int i = 0; i < 5; i++) {
                        Thread.sleep(1000);
                        if (isSecondLeft) isSecondLeft = false;
                    }
                    System.out.println("Минуло 5 секунд");


                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }).start();




    }


}
