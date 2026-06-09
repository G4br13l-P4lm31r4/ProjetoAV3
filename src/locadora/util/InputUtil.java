package locadora.util;

import java.util.Scanner;

public class InputUtil {

    public static int lerInt(Scanner sc) {
        try {
            return Integer.parseInt(sc.nextLine().trim());
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static double lerDouble(Scanner sc) {
        try {
            return Double.parseDouble(sc.nextLine().trim().replace(",", "."));
        } catch (NumberFormatException e) {
            return 0.0;
        }
    }
}
