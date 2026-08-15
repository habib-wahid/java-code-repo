package algorithm;

public class UnionFind {
    int n;
    int[] parent;

    UnionFind(int n) {
        this.n = n;
        this.parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }


    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]);
        }

        return parent[x];
    }


    boolean union(int x, int y) {
        int parX = find(x);
        int parY = find(y);

        if (parX == parY) {
            return true;
        }
        parent[parX] = parY;
        return false;
    }



    static void main(String[] args) {

        // 0 1
        // 1 2
        // 2 3
        // 4 5
        // 6 7
        // 3 7
        System.out.println("Initial state:");
        UnionFind uf = new UnionFind(8);
        System.out.println(uf.find(0));
        System.out.println(uf.find(1));
        System.out.println(uf.find(2));
        System.out.println(uf.find(3));
        System.out.println(uf.find(4));
        System.out.println(uf.find(5));
        System.out.println(uf.find(6));
        System.out.println(uf.find(7));
        System.out.println("After unions:");
        System.out.println(uf.union(0, 1));
        System.out.println(uf.union(1, 2));
        System.out.println(uf.union(2, 3));
        System.out.println(uf.union(4, 5));
        System.out.println(uf.union(6, 7));
        System.out.println(uf.union(3, 7));
        System.out.println(uf.union(1, 3));


    }
}
