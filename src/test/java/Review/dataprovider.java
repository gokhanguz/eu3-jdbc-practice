package Review;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovider {

    //it helps us to write data driven test which same method wiil be run multiple times with different set of data

    /* Data driven test with Junit
    1.Scnerio outline
    2.Excell Sheet(Apachi poi)
    3.From data base(like oracle)

    Data driven test with TestNG
    1.Excell Sheet(apachi poi)
    2.DataProvider

     */

    @Test(dataProvider = "getdata")
    public void setdata(String username,String password){

    }

    @DataProvider
    public Object[][] getdata(){

        Object[][] data=new Object[3][2];

        data[0][0]="user1";

        return  data;

    }
    //@DataProvider(name=getdata)--second way
}
