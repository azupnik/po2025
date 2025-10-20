public class CodingBat {
    public static void main(String[] args) {
        CodingBat cb = new CodingBat();
    }

    public boolean sleepIn(boolean weekday, boolean vacation) {
        if(vacation && weekday){
            return true;
        }
        if(weekday){
            return false;
        }
        if(vacation && !weekday){
            return true;
        }
        return true;
    }

    public boolean monkeyTrouble(boolean aSmile, boolean bSmile) {
        if ((aSmile && bSmile) || (!aSmile && !bSmile)) {
            return true;
        }
        return false;
    }

    public String helloName(String name) {
        return "Hello" + " " + name + "!";
    }

    public int countEvens(int[] nums) {
        int even = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
                even +=1;
            }
        }
        return even;
    }

}
