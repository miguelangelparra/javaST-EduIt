package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DummyTest {

    @Test
    public void test1(){

        int a = 10;
        int b = 20;

        int resultado = a+b;

        //Pasa
        Assert.assertEquals(resultado,30);
//No pasa
       // Assert.assertEquals(resultado,25);

    }
}
