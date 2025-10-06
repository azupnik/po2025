import java.util.Random;
import java.util.HashSet;

public class Lotto{
    public void losuj(){
        HashSet<Integer> numbers = new HashSet<Integer>();
        for(int i = 0;i<6;i++){
            Random rand = new Random();
            int n =rand.nextInt(49);
            n +=1;
            while(numbers.contains(n)){
                n +=rand.nextInt(49);
                n +=1;
            }
            numbers.add(n);
            System.out.println(n);
        }
    }

    public static void main(String[]args){
        Lotto lotto = new Lotto();
        lotto.losuj();
    }
}