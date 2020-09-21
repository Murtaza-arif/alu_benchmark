import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.IntStream;

public class MyBenchmark {
    public static void main(String[] args) {

        StringBuilder xaxis = new StringBuilder();
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();

//        for (int y = 1; y <= 100; y++) {

            int size = 1000*1;
            xaxis.append(size).append(" ");
            int[] anArray = new int[size];

            Random rand = new Random();
            for (int i = 0; i < anArray.length; i++) {

                anArray[i] = rand.nextInt();
            }

            long sequentialElapsedTime = 0;
            for (int i = 0; i < 10; i++) {
                long startTime = System.nanoTime();
                int r = anArray[i];
                long stopTime = System.nanoTime();
                sequentialElapsedTime += stopTime - startTime;
            }

            line1.append(sequentialElapsedTime).append(" ");

            long line2O = 0;
//            for (int i = 0; i < 10; i++) {
//                int random = ThreadLocalRandom.current().nextInt(0, size);
//                long rastartTime = System.nanoTime();
//                int r = anArray[random];
//                long rastopTime = System.nanoTime();
//                line2O += rastopTime - rastartTime;
//            }

            line2.append(line2O).append(" ");

//        }

        System.out.println(xaxis);
        System.out.println(line1);
        System.out.println(line2);

    }



}
