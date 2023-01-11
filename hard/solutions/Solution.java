import java.io.*;
import java.math.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;

public class Solution {

    static ArrayList<Double> resp = new ArrayList<>();
    static double [] orderedValues;
    static int items=0;

    static void addValueInOrderedArray(double value){
        if(items<orderedValues.length){
            int j = Arrays.binarySearch(orderedValues, 0, items, value);
            if (j < 0) {
                // this is a new value to insert (not a duplicate).
                j = - j - 1;
            }
            System.arraycopy(orderedValues, j, orderedValues, j+1, items - j);
            orderedValues[j] = value;
            items++;
        }
    }

    static void verifyMedianBasedOnItems(){
        if(items==1){resp.add(orderedValues[0]);}
        else{
            if(items%2==0){
                int i1 = (items/2)-1;
                int i2 = i1+1;
                BigDecimal bd = new BigDecimal(Double.toString((orderedValues[i1]+orderedValues[i2])/2));
                bd = bd.setScale(1, RoundingMode.HALF_UP);
                resp.add(bd.doubleValue());
            }
            else{
                resp.add(orderedValues[items/2]);
            }
        }
    }


    static double[] runningMedian(int[] a) {
        orderedValues = new double[a.length];
        Arrays.fill(orderedValues, 100001);
        for (int i = 0; i < a.length; i++) {
            addValueInOrderedArray(a[i]);
            verifyMedianBasedOnItems();
        }
        return resp.stream().mapToDouble(Double::doubleValue).toArray();
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int aCount = Integer.parseInt(scanner.nextLine().trim());

        int[] a = new int[aCount];

        for (int aItr = 0; aItr < aCount; aItr++) {
            int aItem = Integer.parseInt(scanner.nextLine().trim());
            a[aItr] = aItem;
        }

        double[] result = runningMedian(a);

        for (int resultItr = 0; resultItr < result.length; resultItr++) {
            bufferedWriter.write(String.valueOf(result[resultItr]));

            if (resultItr != result.length - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();
    }
}
