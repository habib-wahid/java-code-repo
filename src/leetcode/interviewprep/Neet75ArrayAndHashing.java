package leetcode.interviewprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Set;

public class Neet75ArrayAndHashing {

    public int instanceValue = 0;

    public static class Pair {
        int x;
        int y;

        public Pair(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static boolean solution1(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (target == matrix[0][0])
            return true;

        if (target < matrix[0][0])
            return false;

        int sr = 0, er = m - 1;

        while (sr <= er) {
            int mid = (sr + er) / 2;

            if (target >= matrix[mid][0] && target <= matrix[mid][n - 1]) {
                int left = 0, right = n - 1;

                while (left <= right) {

                    if (left == right) {
                        if (target == matrix[mid][left]) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                    int mi = (left + right) / 2;
                    if (target == matrix[mid][mi]) {
                        return true;
                    } else if (target < matrix[mid][mi]) {
                        right = mi - 1;
                    } else {
                        left = mi + 1;
                    }
                }
                return false;
            } else if (target < matrix[mid][0]) {
                er = mid - 1;
            } else {
                sr = mid + 1;
            }
        }

        return false;

    }

    public static boolean isSolution(String s, String t) {
        if (s.equals(t))
            return true;

        int[] arr1 = new int[26];
        int[] arr2 = new int[26];

        for (int i = 0; i < s.length(); i++) {
            arr1[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < t.length(); i++) {
            arr2[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i])
                return false;
        }

        return true;
    }

    private static List<List<String>> groupAnagram(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();

        for (String str : strs) {

            if (str.isEmpty()) {
                if (map.containsKey("")) {
                    map.get("").add(str);
                } else {
                    List<String> list = new ArrayList<>();
                    list.add(str);
                    map.put("", list);
                }

                continue;
            }

            int[] count = new int[26];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < 26; i++) {
                char ch = (char) ('a' + i);
                sb.append(ch + count[i]);
            }

            if (map.containsKey(sb.toString())) {
                map.get(sb.toString()).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(sb.toString(), list);
            }
        }

        return new ArrayList<>(map.values());
    }

    public static int[] soluton(int[] nums, int k) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        List<List<Integer>> lst = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            lst.add(new ArrayList<>());
        }

        map.forEach((key, value) -> {
            lst.get(value).add(key);
        });

        int[] res = new int[k];
        int index = 0;

        for (int i = len - 1; i >= 0; i--) {
            for (int j = 0; j < lst.get(i).size(); j++) {
                if (index == k) {
                    return res;
                }
                res[index++] = lst.get(i).get(j);
            }
        }

        return res;
    }

    public static String solutionEn(List<String> strs) {
        if (strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strs.size(); i++) {
            int len = strs.get(i).length();
            sb.append(len + ":" + strs.get(i));
        }

        return sb.toString();

    }

    public static List<String> solutionDn(String str) {
        if (str.isEmpty()) {
            return new ArrayList<>();
        }
        ;

        List<String> res = new ArrayList<>();
        int i = 0;
        int j = 0;

        // 5:hello

        while (j < str.length()) {
            if (str.charAt(j) == ':') {
                int wordLen = Integer.parseInt(str.substring(i, j));
                res.add(str.substring(j + 1, j + 1 + wordLen));
                i = j + 1 + wordLen;
                j = i;
            } else {
                j++;
            }
        }

        return res;
    }

    public static List<List<Integer>> soluitons(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < len - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1])
                continue;

            int j = i + 1;
            int k = len - 1;

            while (j < k) {
                int sum = nums[i] + nums[j] + nums[k];

                if (sum == 0) {
                    res.add(List.of(nums[i], nums[j], nums[k]));
                    j++;
                    k--;
                } else if (sum < 0) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return res;
    }

    public static boolean solution(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();

        if (len1 > len2)
            return false;

        int[] arr = new int[26];
        int[] arr1 = new int[26];

        for (int i = 0; i < len1; i++) {
            arr[s1.charAt(i) - 'a']++;
        }

        StringBuilder sb = new StringBuilder(s2.substring(0, len1));

        for (int i = 0; i < sb.length(); i++) {
            arr1[sb.charAt(i) - 'a']++;
        }

        int i = len1 - 1;

        while (i < len2) {
            if (i >= len1) {
                arr1[sb.charAt(0) - 'a']--;
                sb.deleteCharAt(0);
                sb.append(s2.charAt(i));
                arr1[s2.charAt(i) - 'a']++;

            }

            int j = 0;
            while (j < 26) {
                if (arr[j] != arr1[j]) {
                    break;
                }
                j++;
            }

            if (j == 26)
                return true;

            i++;
        }

        return false;

    }

    private static String minWindow(String s, String t) {
        String os = s;
        s = s.toLowerCase();
        t = t.toLowerCase();

        int sLen = s.length();
        int tLen = t.length();

        if (sLen < tLen)
            return "";

        int[] tArr = new int[26];
        int[] sArr = new int[26];

        for (int i = 0; i < tLen; i++) {
            tArr[t.charAt(i) - 'a']++;
        }

        int i = 0;
        int j = 0;
        int min = Integer.MAX_VALUE;
        int left = 0;
        int right = s.length() + 1;
        String res = s;

        while (i <= j && j < sLen) {

            System.out.println("j i " + j + " " + i);

            sArr[s.charAt(j) - 'a']++;

            boolean flag = true;

            for (int k = 0; k < 26; k++) {
                if (sArr[k] < tArr[k]) {
                    flag = false;
                    break;
                }
            }

            if (flag) {
                min = Math.min(min, j - i + 1);
                if (min < right - left + 1) {
                    left = i;
                    right = j;
                }

                boolean check = true;
                while (check) {

                    sArr[s.charAt(i) - 'a']--;
                    i++;

                    System.out.println("i j " + i + " " + j);

                    for (int k = 0; k < 26; k++) {
                        if (sArr[k] < tArr[k]) {
                            check = false;
                            break;
                        }
                    }

                    System.out.println("hello");
                    if (!check)
                        break;

                    min = Math.min(min, j - i + 1);

                    if (min < right - left + 1) {
                        left = i;
                        right = j;
                    }

                }

                System.out.println("hello again " + i);

            }

            j++;
        }

        if (right == s.length() + 1)
            return "";
        return os.substring(left, right + 1);

    }

    static class Pair1 {
        int x;
        int y;
        public Pair1(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static void main() {

        System.out.println(Math.ceilDiv(5, 2));
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        int len = strs.length;
        if (strs[0].equals("eat0") || strs[0].equals("tea0") || strs[0].equals("ate0")) {

        }
        Deque<Integer> dq = new ArrayDeque<>();
        String s = "ADOBECODEBANC";
        String t = "ABC";

       // System.out.println("HRE " + minWindow(s, t));

        String st = "56";

        class Pair {
            int x;
            int y;

            Pair(int x, int y) {
                this.x = x;
                this.y = y;
            }
        }


        Pair[] p = {new Pair(4,2), new Pair(3,4)};
        Arrays.sort(p, Comparator.comparingInt(p1 -> p1.x));
        System.out.println(p[0].x);

      //  System.out.println(Integer.parseInt(st) + 20);

        // System.out.println(solution("abc", "lecabee"));

        // zxyyzz

        // k = 3

        // A -> 4 B -> 3

        // AAABA BB BBBBBBBBB

    }
}
