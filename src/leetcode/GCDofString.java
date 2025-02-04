package leetcode;

import java.util.ArrayList;

public class GCDofString {

    public static String gcdOfString(String str1, String str2) {
       int len1 = str1.length();
       int len2 = str2.length();
       if (len1 > len2) {
           int tmp = len1;
           len1 = len2;
           len2 = tmp;
       }

       while (len2 % len1 != 0) {
           int a = len2 % len1;
           len2 = len1;
           len1 = a;
       }

       String ans = "";
       for (int i = 0; i < len1; i++) {
           if (str1.charAt(i) == str2.charAt(i)) {
               ans += str1.charAt(i);
           } else {
               ans = "";
               break;
           }
       }

       if (ans.isEmpty())
           return "";


       for (int i = 0; i < str1.length(); i+= ans.length()) {
           if (!str1.startsWith(ans, i)){
               return "";
           }
       }

       for (int i = 0; i < str2.length(); i+= ans.length()) {
           if (!str2.startsWith(ans, i)){
               return "";
           }
       }

       return ans;

    }

    public static void main(String[] args) {
        System.out.println(gcdOfString("ABCABC", "ABC"));

        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
     //   list.remove(Integer.valueOf(1));
        System.out.println(list.size());
    }
}
