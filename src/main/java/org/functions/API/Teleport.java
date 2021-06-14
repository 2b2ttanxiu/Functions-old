package org.functions.API;

import java.util.Random;

public class Teleport {
    public static void main(String[] args) {
        int max= 10000;
        int min= 1000;
        Random random = new Random();
        int s = random.nextInt(max+1);
        int mis = s - random.nextInt(min+1);
        System.out.println(s);
        System.out.println(mis);
    }
}
