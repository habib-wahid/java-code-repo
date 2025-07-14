package leetcode;

import java.util.Arrays;

public class Urlify {

    public static String urlify(char[] chars) {
        int length = chars.length;
        System.out.println(length);
        int j = length-1;
        for (int i = 0; i < length; i++) {
           if (chars[i] == ' ') {
               chars[j] = '%';
           }
        }




        return Arrays.toString(chars);
    }

    public static void main(String[] args) {

        String s = "a#c";
        int val = s.charAt(1);
        System.out.println(val);
        char[] chars = new char[10];
        chars[0] = 'I';
        chars[1] = ' ';
        chars[2] = 'P';
        chars[3] = 'R';
        chars[4] = 'O';
        chars[5] = 'G';
        chars[6] = 'R';
        chars[7] = 'L';
       // System.out.println(chars[9] == '\u0000');
      //  urlify(chars);
    }
}
