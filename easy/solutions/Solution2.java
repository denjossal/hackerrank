import java.util.*;

public class Solution2 {

    public static void main(String[] args) {
        HashMap<String, Integer> both = new HashMap<>();
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        String magazineWord = magazineWord = in.next();
        both.put(magazineWord, 1);
        Integer value = null;
        Integer valueWord = null;
        boolean noteOk = false;

        for (int magazine_i = 1; magazine_i < m; magazine_i++) {
            magazineWord = in.next();
            if (both.containsKey(magazineWord)) {
                value = both.get(magazineWord);
                value = value+1;
                both.replace(magazineWord, value);
            } else {
                both.put(magazineWord, 1);
            }

        }

        String noteWord = "";
        for (int ransom_i = 0; ransom_i < n; ransom_i++) {
            noteWord = magazineWord = in.next();

            if (both.containsKey(noteWord)) {
                valueWord = both.get(noteWord);
                if (valueWord > 0) {
                    valueWord = valueWord-1;
                    both.replace(magazineWord,valueWord);
                    noteOk = true;
                } else {
                    noteOk = false;
                    break;
                }
            } else {
                noteOk = false;
                break;
            }
        }

        if (noteOk) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
