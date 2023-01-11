import java.util.Scanner;
import java.util.SortedSet;
import java.util.TreeSet;

public class Solution {

    public static void main(String[] args) {
        SortedSet set = new TreeSet();
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int a0 = 0; a0 < n; a0++){
            String op = in.next();
            String contact = in.next();
            if(op.equals("add"))set.add(contact);
            else{
                String letter = contact.substring(contact.length()-1, contact.length());
                int charValue = letter.charAt(0);
                SortedSet a = set.subSet(contact, contact.substring(0,contact.length()-1)+String.valueOf((char)(charValue+1)));
                System.out.println(a.size());
            }
        }
    }
}

