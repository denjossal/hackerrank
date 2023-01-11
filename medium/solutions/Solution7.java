import java.util.Comparator;

class Solution7 implements Comparator {

    @Override
    public int compare(Object o1, Object o2) {
        Player player1 = ((Player) o1);
        Player player2 = ((Player) o2);
        if (player1.score == player2.score) {
            //System.out.println(player1.name + ".."+player2.name);
            int compare = player1.name.compareToIgnoreCase(player2.name);
            if(compare<0){
                //System.out.println("menor-------------"+player1.name);

                return -1;
            }
            else{
                if(compare>0){
                    //System.out.println("menor------------"+player2.name);
                    return 1;
                }
                else{
                    return player2.score - player1.score;
                }
            }
        } else {
            return player2.score - player1.score;
        }
    }

}

