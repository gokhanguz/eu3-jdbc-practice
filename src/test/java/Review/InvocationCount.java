package Review;

import org.testng.annotations.Test;

public class InvocationCount {

    @Test(threadPoolSize = 2,invocationCount = 6,timeOut = 10000)
    public void test(){

        System.out.println("hello");
    }
    //InvacotionCount:How many times testNG this test method
    //threadPoolSize:How many number thread run this test method

}
