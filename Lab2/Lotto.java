import java.util.Random;
import java.util.ArrayList;

public class Lotto{
    public ArrayList<Integer> userInput =  new ArrayList<Integer>();
    public ArrayList<Integer> appNumbers =  new ArrayList<Integer>();
    public Lotto(ArrayList<Integer> userInputa){
        userInput = userInputa;
    }
    public void  losuj(){
        appNumbers.clear();
        for(int i = 0;i<6;i++){
            Random rand = new Random();
            int n =rand.nextInt(49);
            n +=1;
            while(appNumbers.contains(n)){
                n +=rand.nextInt(49);
                n +=1;
            }
            appNumbers.add(n);
        }
    }


    public int compareStringArray( ArrayList<Integer> a,  ArrayList<Integer> b){
        a.retainAll(b);
        return a.size();
    }

    public long all6(){
            long startTime = System.currentTimeMillis();
            int liczbaWykonan=0;
            while(compareStringArray(userInput,appNumbers)!=6){
                losuj();
                System.out.println(appNumbers);
                liczbaWykonan++;
            }
            long endTime = System.currentTimeMillis();
            return (startTime - endTime);
        }

    public void programInit(){
        losuj();
        System.out.println(userInput);
        System.out.println(appNumbers);
        compareStringArray(userInput,appNumbers);
        all6();

    }

    public static void main(String[]args){
        ArrayList<Integer> userInput = new ArrayList<Integer>();
        for(String val : args){
            userInput.add(Integer.parseInt(val));
        }
        Lotto lotto = new Lotto(userInput);
        lotto.programInit();
    }
}