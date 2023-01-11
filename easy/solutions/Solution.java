import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }
        int solution[] = arrayLeftRotation(a,k);

        //ToString
        for (int i = 0; i < solution.length; i++) {
            System.out.print(solution[i]+" ");
        }
    }

    public static int[] arrayLeftRotation(int in[], int rotation){
        int solution[] = new int[in.length];
        int parted[] = Arrays.copyOfRange(in, 0,rotation);
        int other[] = Arrays.copyOfRange(in, rotation,in.length);
        solution = Arrays.copyOf(other, other.length + parted.length);
        System.arraycopy(parted, 0, solution, other.length, parted.length);
        return solution;
    }

}
