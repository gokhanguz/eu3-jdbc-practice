package Review;

import org.testng.annotations.Test;

public class Priority {

    //it determines with test will be run first

    @Test(priority = 3)
    public void test1(){

    }

    @Test(priority = 1)
    public void test2(){

    }

    @Test(priority = 2)
    public void test3(){

    }
}
