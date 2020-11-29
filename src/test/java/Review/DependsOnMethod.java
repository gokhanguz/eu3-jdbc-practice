package Review;

import org.testng.annotations.Test;

public class DependsOnMethod {


    @Test(dependsOnMethods ={"test3"} )//test3 is run after test1 run
    public void test1(){

    }

    @Test(enabled = false)//not run
    public void test2(){

    }

    @Test()
    public void test3(){

    }
}
