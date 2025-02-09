package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class RandomisedSet {

    List<Integer> list;
    HashMap<Integer, Integer> map;
    public RandomisedSet() {
        list = new ArrayList<>();
        map = new HashMap<>();
    }

    public boolean insert(int val) {
        if (map.containsKey(val)) {
            return false;
        }

        list.add(val);
        map.put(val, list.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (map.containsKey(val)) {
            int index = map.get(val);
            int temp = list.getLast();
            list.set(index, temp);
            list.removeLast();
            map.put(temp, index);
            map.remove(val);
            return true;
        }

        return false;
    }

    public int getRandom() {
        return list.get((int) (Math.random() * list.size()));
    }

    public static void main(String[] args) {
        RandomisedSet randomisedSet = new RandomisedSet();
        System.out.println(randomisedSet.insert(0));
        System.out.println(randomisedSet.insert(1));
        System.out.println(randomisedSet.remove(0));
        System.out.println(randomisedSet.insert(2));
        System.out.println(randomisedSet.remove(1));
        System.out.println(randomisedSet.getRandom());


    }
}
