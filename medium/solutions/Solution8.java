import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();

        for (int i = 0; i < t; i++) {
            int l = in.nextInt();
            int[] arr = new int[l];
            for (int j = 0; j < arr.length; j++) {
                arr[j] = in.nextInt();
            }
            int val = minimumBribes(arr);
            if (val == -1) {
                System.out.println("Too chaotic");
            }
            else{
                System.out.println(val);
            }
        }

    }


    public static int minimumBribes(int[] q) {
        int minBribes = 0;
        for (int i = q.length-1; i >= 0; i--) {
            if(q[i]-(i+1)>2){
                return -1;
            }
            for (int j = Math.max(0, q[i]-2); j < i; j++) {
                if(q[j]>q[i])minBribes++;
            }
        }
        return minBribes;
    }
}
