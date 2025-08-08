package name.lorenzani.andrea.hackerrank.deliveroo.bigfactorials;

import java.math.BigInteger;

public class Result {

    public static void extraLongFactorials(int n) {
        BigInteger result = BigInteger.ONE;
        for(;n>1; n--) {
            result = result.multiply(BigInteger.valueOf(n));
        }
        System.out.println(result.toString());
    }

}
