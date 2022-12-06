/*
 * Specifically for the integration of 1/x^2. Meant for general use with code tweaking, not a 
 * finished product, but certainly a working one. Enjoy.
 * 
 * Author: Nick Cui
 */

import java.lang.Math;
//import java.util.Scanner;

public class approxIntegrals {
    // TO ADJUST BOUNDS CHANGE HERE
    final static int bound1 = 1;
    final static int bound2 = 2;


    // TO ADJUST N VALUES CHANGE HERE
    final static int n1 = 5;
    final static int n2 = 10;
    final static int n3 = 20;

    static double compute(double x){
        // TO CHANGE THE FUNCTION CHANGE HERE.
        return 1.0/Math.pow(x, 2);
    }

    static double compute(double x, double y){
        return (compute(x) + compute(y));
    }

    static double trap(int n, int bound1, int bound2){
        double sum = compute(bound1, bound2);
        double dx = (bound2 - bound1)/(double)n;
        for (int i = 1; i < n; i++){
            sum += 2 * (compute((dx * i) + bound1));
        }
        return sum * dx / 2;
    }

    static double midpoint(int n, int bound1, int bound2){
        double sum = 0;
        double dx = (bound2 - bound1)/(double)n;
        double x;
        for (int i = 1; i <= n; i++){
            x = ((dx * (i - 1) + bound1) + (dx * i + bound1))/2;
            sum += compute(x);
        }
        return sum * dx;
    }

    static double simpsons(int n, int bound1, int bound2){
        if (n % 2 == 1) return 0;
        double sum = compute(bound1, bound2);
        double dx = (bound2 - bound1)/(double)n;
        for (int i = 1; i < n; i++){
            sum += (compute((dx * i) + bound1)) * (i % 2==0?2:4);
        }
        return sum * dx / 3;
    }

    public static void main(String[] args) {
        System.out.println("Trapezoid approximations:");
        System.out.println(trap(n1, 1, 2));
        System.out.println(trap(n2, 1, 2));
        System.out.println(trap(n3, 1, 2));
        System.out.println("Midpoint approximations:");
        System.out.println(midpoint(n1, 1, 2));
        System.out.println(midpoint(n2, 1, 2));
        System.out.println(midpoint(n3, 1, 2));
        System.out.println("Simpsons approximations:");
        System.out.println(simpsons(n1, 1, 2));
        System.out.println(simpsons(n2, 1, 2));
        System.out.println(simpsons(n3, 1, 2));
    }
}
