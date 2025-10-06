import java.util.Scanner;

public class Choinka {
    public static void main(String[]args){
        Scanner stars  = new Scanner(System.in);
        int stars_number =  stars.nextInt();
        for (int i = 0; i < stars_number;i++){
           for( int j = 0;j<stars_number-i-1;j++){
                System.out.println(" ");
           }

            for(int j = 0;j< 2*j+1;j++ ){
                System.out.println("*");
            }
        System.out.println();

        }
    }
}