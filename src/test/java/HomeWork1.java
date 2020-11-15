import org.junit.jupiter.api.Test;

public class HomeWork1 {
    @Test
    public void homeWorks() {


        System.out.println("\nHOMEWORK Nr. 1" +
                "\n12/11/2020");

        //Kredīta summa 39000,00, procenti 8%, Kopā jāatgriež 421202,00)//

        System.out.println("Kopēja mājas cena 39000.00 eur");
        System.out.println("Procenta summa 8%");
        Double q = 39000.00 * 1.08;
        System.out.println("Atmaksa kopā ar procentiem " + q + " eur");


        System.out.println("\nHOMEWORK Nr. 2, version nr.1" +
                "\n12/11/2020");    {

        // Этот метод Copy -> Paste с нета :)//

        String str = "Text";
        int count = 0;
        System.out.println("String: " + str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i)))
            count++;
            }
        System.out.println("Letters: " + count);
        }
        System.out.println("\nHOMEWORK Nr. 2, version nr.1/1" +
                "\n12/11/2020");


         /* За основу взяла предыдущий метод на подсчет букв
        - погуглила про Иф и дописала на остальное, чисто для себя :). */

        String str = "Tekstā - 6 vārdi, 42 burti, 7 cipari, 11 atstarpes, 6 pieturzīmes.";
        int count = 0;
        int digit = 0;
        int space = 0;
        int other = 0;

        System.out.println("String: " + str);
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLetter(str.charAt(i))){
                count++;
            }
            else if (Character.isDigit(str.charAt(i))) {
                digit++;
            }
            else if (Character.isSpaceChar(str.charAt(i))) {
                space++;
            }
            else {
                other++;
            }
        }
        System.out.println("Letters: " + count + "\nDigits: " + digit+ "\nSpaces: " + space
                + "\nPunctuation: " + other);

        // šeit vajag komandu vārdu skaitam






    }
}