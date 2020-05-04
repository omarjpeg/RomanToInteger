package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String mystring = scanner.nextLine();

        System.out.println(romanToInt(mystring));

    }

    public static int romanToInt(String s) {
        String helper = "Z";
        helper = helper.concat(s);
        char currentChar;
        char prevChar = 'O';
        int totaltothispoint = 0;
        if (helper.length() < 2) {
            return romanequiv(s.charAt(0));
        }
        for (int i = helper.length(); i > 0; i--) {
            currentChar = helper.charAt(i - 1);
            if (currentChar == 'Z') {
                break;
            }
            prevChar = helper.charAt(i - 2);
            if (currentChar == 'V' && prevChar == 'I') {
                totaltothispoint = +4;
                i--;
                continue;
            }
            if (currentChar == 'X' && prevChar == 'I') {
                totaltothispoint = +9;
                i--;
                continue;
            }
            if (currentChar == 'L' && prevChar == 'X') {
                totaltothispoint += 40;
                i--;
                continue;
            }
            if (currentChar == 'C' && prevChar == 'X') {
                totaltothispoint += 90;
                i--;
                continue;
            }
            if (currentChar == 'D' && prevChar == 'C') {
                totaltothispoint += 400;
                i--;
                continue;
            }
            if (currentChar == 'M' && prevChar == 'C') {
                totaltothispoint += 900;
                i--;

            } else {
                totaltothispoint += romanequiv(currentChar);

            }
            if (prevChar == 'Z') {
                break;
            }

        }
        return totaltothispoint;
    }


    private static int romanequiv(char s) {

        switch (s) {
            case 'M':
                return 1000;
            case 'D':
                return 500;
            case 'C':
                return 100;
            case 'L':
                return 50;
            case 'X':
                return 10;
            case 'V':
                return 5;
            case 'I':
                return 1;
        }
        return 0;
    }
}