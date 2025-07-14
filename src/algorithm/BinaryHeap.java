package algorithm;

import java.util.ArrayList;

public class BinaryHeap {

    void heapify(ArrayList<Integer> hT, int i) {
        int size = hT.size();
        int largest = i;
        int leftIndex = 2 * i + 1;
        int rightIndex = 2 * i + 2;

        if (leftIndex < size && hT.get(leftIndex) > hT.get(largest)) {
            largest = leftIndex;
        }

        if (rightIndex < size && hT.get(rightIndex) > hT.get(leftIndex)) {
            largest = rightIndex;
        }

        if (largest != i) {
            int temp = hT.get(i);
            hT.set(i, hT.get(largest));
            hT.set(largest, temp);
        }
    }

    void insert (ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        if (size == 0) {
            hT.add(newNum);
        } else {
            hT.add(newNum);
            for (int i = hT.size()/2 - 1; i >=0; i--) {
                heapify(hT, i);
            }
        }
    }

    void delete(ArrayList<Integer> hT, int newNum) {
        int size = hT.size();
        int j = 0;

        for (int i = 0; i < size; i++) {
            if (hT.get(i) == newNum) {
                j = i;
                break;
            }
        }

        hT.set(j, hT.get(size - 1));
        hT.remove(size - 1);

        for (int i = hT.size()/2 - 1; i>= 0; i--) {
            heapify(hT, i);
        }
    }


    public static void main(String[] args) {
        BinaryHeap bh = new BinaryHeap();
        ArrayList<Integer> hT = new ArrayList<>();
        bh.insert(hT, 1);
        bh.insert(hT, 2);
        bh.insert(hT, 3);
        bh.insert(hT, 4);

        for (int i = 0; i < hT.size(); i++) {
            System.out.println(hT.get(i));
        }

        bh.delete(hT, 4);

        for (int i = 0; i < hT.size(); i++) {
            System.out.println(hT.get(i));
        }
    }
}
