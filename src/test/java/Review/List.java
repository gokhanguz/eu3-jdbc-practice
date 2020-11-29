package Review;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class List {
    public static void main(String[] args) {

        /*Array size fixed
        array accept primitive and object
        array can make multiple/2D array
        array size str.lenght;
       */
        int [] num={1,2,3};
        String [] str={"Ali","sami"};
        System.out.println(num.toString());
        int [] [] nums={{1,2,3},{5,6,7}};

        Arrays.sort(num);

        System.out.println(nums[0][0]);//1
        System.out.println(nums[1][2]);//7

        /* arraylist size not fixed
        accept only object
        str.size;
         */

        ArrayList<Integer> str1=new ArrayList<>();
        str1.add(0,1);
        str1.add(1,5);
        str1.add(2,6);
        str1.add(3,20);
        System.out.println(str1.toString());

        ArrayList<Integer> str2=new ArrayList<>(Arrays.asList(1,2,3));

        int [] num1={1,2,3};

        ArrayList<Integer> str3=new ArrayList(Arrays.asList(num1));
        System.out.println(str1.get(2));

        str1.remove(2);
        str1.removeAll(Arrays.asList(1,3));
        System.out.println(str1.equals(5));
        Collections.sort(str3);
    }
}
