
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class MyFirstTest {
    private String name = ("Veikalā ATLAIDES!");

    @Test
    public void firstTest() {

        System.out.println("Hello, corona!");
        System.out.println(name);
        int sum = sumTwoDigits (34,45);
        System.out.println("Sarkans džemperis maksā " + sum);
        System.out.println("Zaļš džemperis maksā " + sumTwoDigits(25,19));
        System.out.println("Dzeltens džemperis maksā");
    }


    private int sumTwoDigits(int a, int b) {

        System.out.println("-15% atlaide");
        int c = a + b;
        return c;
    }

}