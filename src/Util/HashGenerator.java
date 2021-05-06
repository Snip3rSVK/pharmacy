package Util;

public class HashGenerator {
    private HashGenerator() {}

    // generate hash from string, returns number in range 0 - m
    public static Integer generateFromString(String str, Integer m) {
        Integer hash = 0;

        for (Integer i = 0, x = 1; i < str.length(); ++i, x *= 31) {
            Integer charCode = str.charAt(i) - '0';

            hash = hash * x + charCode;
        }

        // modulo can be negative in Java so this is to ensure positive number is returned
        return (hash % m + m) % m;
    }
}
