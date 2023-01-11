import java.util.HashMap;
import java.util.Hashtable;
import java.util.Scanner;

public class Solution5 {

    public static Hashtable<Character,Character> hashOpen = new Hashtable<>();



    public static boolean isBalanced(String expression) {
        boolean isBalanced = false;
        //41 91 123 = ( [ {
        //42 93 125 = ) ] }
        char characters[];
        boolean marks[];
        if(expression.length()%2==0){
            characters=expression.toCharArray();
            marks = new boolean[expression.length()];
            int counter = 0;
            boolean manageOrder = true;
            while(counter<characters.length && manageOrder){

                char anyCharacter;
                char lastCharacter = characters[characters.length-1];
                for (int i = 0; i < marks.length && manageOrder; i++) {
                    anyCharacter = characters[i];

                    if((int)anyCharacter != 40 &&
                            (int)anyCharacter != 91 &&
                            (int)anyCharacter != 123 &&
                            (int)anyCharacter != 41 &&
                            (int)anyCharacter != 93 &&
                            (int)anyCharacter != 125){isBalanced = false; break;}
                    else{
                        if(i==0 && (((int)anyCharacter)==41||(int)anyCharacter == 93||(int)anyCharacter == 125)){isBalanced = false; manageOrder=false; break;}
                        else if(i==marks.length-1 && ((int)lastCharacter==40 || (int)lastCharacter == 91 || (int)lastCharacter==123)){isBalanced = false; manageOrder=false; break;}
                        else{
                            if(anyCharacter==')' || anyCharacter=='}' || anyCharacter==']'){
                                marks[i]=true;
                                counter++;
                                for (int j = (i-1); j >= 0; j--) {
                                    if(characters[j]==hashOpen.get(anyCharacter) && !marks[j]){
                                        manageOrder=true;
                                        marks[j]=true;
                                        counter++;
                                        break;
                                    }
                                    else if (marks[j]) {
                                        if (j == 0) {
                                            manageOrder = false;
                                            isBalanced = false;
                                            break;
                                        }
                                    }
                                    else{
                                        manageOrder=false;
                                        isBalanced=false;
                                        break;
                                    }
                                }
                            }
                        }
                    }
                    if(counter==characters.length){
                        if(manageOrder){
                            return true;
                        }
                    }
                }
            }

        }

        else isBalanced = false;

        return isBalanced;
    }

    public static void main(String[] args) {
        hashOpen.put(')', '(');
        hashOpen.put('}', '{');
        hashOpen.put(']', '[');

        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for (int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            System.out.println( (isBalanced(expression)) ? "YES" : "NO" );
        }
    }
}