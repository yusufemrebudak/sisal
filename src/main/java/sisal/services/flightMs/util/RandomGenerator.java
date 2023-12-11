package sisal.services.flightMs.util;


import java.util.Objects;
import java.util.Random;

public class RandomGenerator {

    public static String generate()
    {
        Random r=new Random();
        return String.valueOf(r.nextInt());
    }



}
