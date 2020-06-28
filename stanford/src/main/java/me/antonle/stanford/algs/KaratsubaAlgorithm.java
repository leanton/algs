package me.antonle.stanford.algs;

import java.math.BigInteger;

public class KaratsubaAlgorithm {

    public static String multiply(String x, String y) {
        if (x.length() < 6 || y.length() < 6) {
            return String.valueOf(Long.parseLong(x) * Long.parseLong(y));
        }
        final int l = x.length();
        final int m = y.length();
        final int n = Math.min(l, m) / 2;

        final var a = x.substring(0, l - n);
        final var b = x.substring(l - n, l);
        final var c = y.substring(0, m - n);
        final var d = y.substring(m - n, m);
        System.out.println("======= RECURSIVE CALL =======");
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("n = " + n);
        System.out.println("split to:");
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);

        final var ac = multiply(a, c);

        final var aPlusB = (new BigInteger(a).add(new BigInteger(b)).toString());
        final var cPlusD = (new BigInteger(c).add(new BigInteger(d)).toString());
        final var abcd = multiply(aPlusB, cPlusD);

        final var bd = multiply(b, d);

        final BigInteger adPlusBc = new BigInteger(abcd).subtract(new BigInteger(ac)).subtract(new BigInteger(bd));
        final BigInteger first = new BigInteger(ac).multiply((BigInteger.TEN.pow(n * 2)));
        final BigInteger second = adPlusBc.multiply((BigInteger.TEN.pow(n)));
        return first.add(second).add(new BigInteger(bd)).toString();
    }
}
