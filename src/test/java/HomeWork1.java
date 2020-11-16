import org.junit.jupiter.api.Test;

import static java.lang.Math.sqrt;

public class HomeWork1 {
    @Test
    public void homeWorks() {

        System.out.println("\nHOMEWORK Nr. 1" +
                "\n12/11/2020");
        //Kredīta summa 39000,00, procenti 8%, Kopā jāatgriež 421202,00)//

        System.out.println("Kopēja mājas cena 39000.00 eur");
        System.out.println("Procenta summa 8%");
        double q = 39000.00 * 1.08;
        System.out.println("Atmaksa kopā ar procentiem " + q + " eur");

        System.out.println("\nHOMEWORK Nr. 2, version nr.1"); {
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
        System.out.println("\nHOMEWORK Nr. 2, version nr.2");
        {
         /* За основу взяла предыдущий метод на подсчет букв
        - погуглила про Иф и дописала на остальное, чисто для себя :). */

            String str = "Tekstā - 6 vārdi, 42 burti, 7 cipari, 11 atstarpes, 6 pieturzīmes.";
            int count = 0;
            int digit = 0;
            int space = 0;
            int other = 0;

            System.out.println("String: " + str);
            for (int i = 0; i < str.length(); i++) {
                if (Character.isLetter(str.charAt(i))) {
                    count++;
                } else if (Character.isDigit(str.charAt(i))) {
                    digit++;
                } else if (Character.isSpaceChar(str.charAt(i))) {
                    space++;
                } else {
                    other++;
                }
            }
            System.out.println("Letters: " + count + "\nDigits: " + digit + "\nSpaces: " + space
                    + "\nPunctuation: " + other);
        }
        // Uzdevums ar zvaigznīti

        System.out.println("\nHOMEWORK Nr. 2, * - Count words in String");
        {
            String str = "Cik tekstā vārdu?";
            String[] words = str.split("\\s");

            int wordCount = 0;
            int i, wordsSize = words.length, strSize = str.length();
            for (i = 0; i < wordsSize; ++i)
                if (words[i] != null && !"".equals(words[i]))
                    ++wordCount;

            System.out.println("Cik tekstā vādu? \nTekstā " + wordCount + " vārdi.");
        }

        System.out.println("\nHOMEWORK Nr. 3, *** - Distance");
        {
            // Mājas = x1, y1;
            // Skola = x2, y2;
            double result = attalums(0.9919, 0.4275, 0.9919, 0.4280);
            System.out.println("Attālums no mājām līdz ielas galam " + result + " km.");
        }
    }
        private double attalums(double x1, double x2, double y1, double y2) {
        double ab = sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
        return ab;
    }
        }



