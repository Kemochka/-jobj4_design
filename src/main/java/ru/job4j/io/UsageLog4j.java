package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {
    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Kris";
        int age = 25;
        float f = 1.7F;
        double d = 60.0D;
        byte b = 8;
        boolean bln = true;
        char c = 'W';
        long l = 4567890;
        short s = 10;
        LOG.debug("User info name : {}, age : {}, f : {}, d : {}, b : {}, bln : {}, c : {}, l : {}, s : {}", name, age, f, d, b, bln, c, l, s);
    }
}
