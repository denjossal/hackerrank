import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author CapAdmin
 */
public class Solution1 {

    public static int fuctionalOperations(char arr1[], char arr2[]) {
        int operations = 0;
        boolean array1[] = new boolean[arr1.length];
        boolean array2[] = new boolean[arr2.length];
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                if (arr1[i] == arr2[j] && !array2[j] && !array1[i]) {
                    array1[i]=true;
                    array2[j]=true;
                    break;
                }
            }
        }

        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr1.length; j++) {
                if (arr2[i] == arr1[j] && !array1[j] && !array2[i]) {
                    array2[i]=true;
                    array1[j]=true;
                    break;
                }
            }

        }

        for (int i = 0; i < array1.length; i++) {
            if(!array1[i])operations++;
        }

        for (int i = 0; i < array2.length; i++) {
            if(!array2[i])operations++;
        }
        return operations;
    }

    public static int numberNeeded(String first, String second) {
        int operations = 0;
        char arr1[] = first.toCharArray();
        char arr2[] = second.toCharArray();
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        if (arr1.length < arr2.length) {
            operations = fuctionalOperations(arr1, arr2);
        } else {
            operations = fuctionalOperations(arr2, arr1);
        }
        return operations;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String a = in.next();
        String b = in.next();
        System.out.println(numberNeeded(a, b));
    }

}
