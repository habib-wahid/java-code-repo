package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class RandomizedSet {

    private Set<Integer> set;
    private List<Integer> list;
    public RandomizedSet() {
        set = new HashSet<>();
        list = new ArrayList<>();
    }

    public boolean insert(int val) {
        if (set.contains(val))
            return false;
        set.add(val);
        list.add(val);
        return true;
    }

    public boolean remove(int val) {
        if (!set.contains(val))
            return false;
        set.remove(val);
        list.remove(Integer.valueOf(val));
        return true;
    }
}
