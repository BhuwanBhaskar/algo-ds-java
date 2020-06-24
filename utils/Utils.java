package utils;

public class Utils {
    /**
     * Print array
     * @param a
     */
    public static void prettyPrintArr(int[] a) {
        System.out.println("");
        System.out.print("{ ");

        for(int i = 0; i < a.length; i += 1) {
            String terminator = (i == a.length - 1) ? "" : ", ";
            System.out.print(a[i] + terminator);
        }

        System.out.print(" }");
        System.out.println("");
    }

    public static void printArray(int[] a) {
        for(int i = 0; i < a.length; i += 1) {
            System.out.print(a[i] + " ");
        }
        System.out.println("");
    }
}