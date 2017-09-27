import java.util.Arrays;

/**
 * Created by benjamin on 10/3/16.
 */
public class Main {
    public static void main(String[] args){
        World world = new World();
        for( int ii = 0; ii < 19; ii++){
            world.addCharacter(new Character("b" + ii,10, 10, 2, 2, 0, 10));
        }
        world.calcInitiatives();
        for( int ii = 0; ii < 19; ii++){
            world.addCharacter(new Character("a" + ii,10, 10, 2, 2, 0, 10));
        }
        world.displayWorld();

//        Dice set = new Dice();
//        int[] data = new int[19];
//        int iters = 1000000000;
//        for( int ii = 0; ii < iters; ii++){
//            data[set.roll(4, 6, 3)] += 1;
//        }
//        double[] processed = new double[19];
//        for( int ii = 0; ii < 19; ii++){
//            processed[ii] = data[ii]/(double)iters;
//            System.out.println(" " + ii + "\t" + data[ii] + "\t" + processed[ii]);
//        }

//        System.out.println(Arrays.toString(processed));

//        for( int ii = 0; ii < 20; ii++){
//            System.out.println(" " + ii + " "  +Character.getMod(ii));
//        }
    }
}
