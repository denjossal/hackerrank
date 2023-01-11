import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;


class Tuple{
    public Tuple(int index, int data){
        this.index = index;
        this.data = data;
    }
    public final int index;
    public final int data;
}

class IntIntComparator implements
        Comparator<Tuple>{

    @Override
    public int compare(Tuple o1, Tuple o2) {
        return ((Integer)o1.data).compareTo((Integer)o2.data);
    }
}

public class Solution3 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int i = 0; i < t; i++){
            int m = in.nextInt();
            int n = in.nextInt();
            ArrayList<Tuple> listTuple = new ArrayList(n);
            Tuple obj = null;
            for(int i_a=0; i_a < n; i_a++){
                obj = new Tuple(i_a+1, in.nextInt());
                listTuple.add(obj);
            }
            Collections.sort(listTuple, new IntIntComparator());
            int minIndex = 0;
            int maxIndex = listTuple.size()-1;
            Tuple minTuple = listTuple.get(minIndex);
            Tuple maxTuple = listTuple.get(maxIndex);
            while(minTuple.data+maxTuple.data!=m){
                if(minTuple.data+maxTuple.data>m){
                    maxTuple=listTuple.get(maxIndex--);
                }
                else{
                    minTuple=listTuple.get(minIndex++);
                }
            }
            System.out.println(Math.min(minTuple.index, maxTuple.index)+ " " +Math.max(minTuple.index, maxTuple.index));
        }
    }

}
