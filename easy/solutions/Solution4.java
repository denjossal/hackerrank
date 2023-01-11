import java.util.Scanner;

public class Solution4 {

    public static int numbersArray[];
    public static void main(String[] args) {
        int numberOfSwap = 0;
        Scanner in = new Scanner(System.in);
        int legthArray = in.nextInt();
        numbersArray = new int[legthArray];
        for (int i = 0; i < legthArray; i++) {
            numbersArray[i] = in.nextInt();
        }
        boolean isOrdered = true;
        while(isOrdered){

            int counter = 0;
            for (int j = 0; j < legthArray-1; j++) {
                // Swap adjacent elements if they are in decreasing order
                if (numbersArray[j] > numbersArray[j + 1]) {
                    swap(j, numbersArray[j], j + 1, numbersArray[j + 1]);
                    numberOfSwap++;
                }
                else{
                    counter++;
                    if(counter==legthArray-1){
                        isOrdered=false;
                    }
                }

            }



        }


        System.out.println("Array is sorted in "+numberOfSwap+" swaps.");
        System.out.println("First Element: "+numbersArray[0]);
        System.out.println("Last Element: "+numbersArray[numbersArray.length-1]);

    }

    public static void swap(int index, int mayor, int indexMinor, int minor){
        numbersArray[index]=minor;
        numbersArray[indexMinor]=mayor;
    }

}