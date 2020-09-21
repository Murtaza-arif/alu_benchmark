import java.util.concurrent.ThreadLocalRandom;
import java.util.function.BinaryOperator;

public class ALU {
    private static long test(String desc, BinaryOperator<Integer> op, Integer a, Integer b) {

        long start = System.nanoTime();
        op.apply(a, b);
        long end = System.nanoTime();
        long elapsed = end - start;

        System.out.println(desc + " " + elapsed + " ns");

        return elapsed;
    }

    public static void main(String[] arg) {
        Integer A = 483902;
        Integer B = 42347;
        StringBuilder line1 = new StringBuilder();
        StringBuilder line2 = new StringBuilder();

        test("", (Integer a, Integer b) -> {
            return a + b;
        }, A, B);

        test("Subtraction (Integer)", (Integer a, Integer b) -> {
            return a - b;
        }, A, B);
        test("Addition (Integer)", (Integer a, Integer b) -> {
            return a + b;
        }, A, B);

        test("Multiplication (Integer)", (Integer a, Integer b) -> {
            return a * b;
        }, A, B);
        test("Division (Integer)", (Integer a, Integer b) -> {
            return a / b;
        }, A, B);

//        for (int i = 0; i < 100; i++) {
//            Integer A1 = ThreadLocalRandom.current().nextInt();
//            Integer B1 = ThreadLocalRandom.current().nextInt();
//            long time = test("Addition (double)", (Integer a, Integer b) -> {
//                return a + b;
//            }, A1, B1);
//            line1.append(time).append(" ");
//        }
        for (int i = 1; i < 100; i++) {
            Integer A1 = ThreadLocalRandom.current().nextInt();
            Integer B1 = ThreadLocalRandom.current().nextInt();
            long time = test("Division (double)", (Integer a, Integer b) -> a / b, A, B);
            line2.append(time).append(" ");
        }
        System.out.println(line1);
        System.out.println(line2);

    }
}
