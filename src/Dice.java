import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 * Created by benjamin on 10/3/16.
 */
public class Dice {
    private Random rand;

    public Dice(){
        this.rand = new Random();
    }

    public int d20(){
        return roll(20);
    }

    public int roll(int sides){
        return rand.nextInt(sides) + 1;
    }
    public int roll(int num, int sides){
        int val = 0;
        for( int ii = 0; ii < num; ii++){
            val += roll(sides);
        }
        return val;
    }
    public int roll(int num, int sides, int best){
        int[] rolls = new int[num];
        for( int ii = 0; ii < num; ii++){
            rolls[ii] = roll(sides);
        }
        Arrays.sort(rolls);
//        System.out.println(Arrays.toString(rolls));
        int val = 0;
        for( int ii = 1; ii <= best; ii++){
            val += rolls[num - ii];
        }
        return val;
    }

}
