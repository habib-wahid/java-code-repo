package leetcode.interviewprep;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
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

    static void main() {
        List<String> sts = new ArrayList<>();
        sts.add("");
        System.out.println(solutionDn(solutionEn(sts)));

        String st = "kabsa";
        char[] chs = st.toCharArray();
        Arrays.sort(chs);
        System.out.println("Sorted String " + new String(chs));
    }
}
