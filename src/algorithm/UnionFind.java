package algorithm;

public class UnionFind {
    int n;
    int[] parent;

    UnionFind(int n) {
        this.n = n;
        parent = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
        }
    }

    public int find(int u) {
        if (parent[u] != u) {
            parent[u] = find(parent[u]);
        }

        return parent[u];
    }

    public void union(int u, int v) {
        int rootU = find(u);
        int rootV = find(v);

        parent[rootV] = rootU;

    }

    public static void main(String[] args) {
        UnionFind uf = new UnionFind(5);
        uf.union(1, 2);
        uf.union(3,4);
        uf.union(3,2);

        System.out.println(uf.find(4));

        if (uf.find(1) == uf.find(2))
            System.out.println("Same parent");

        if (uf.find(1) != uf.find(3))
            System.out.println("Different parent");


    }
}
