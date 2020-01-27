public class UnionFind {
    private int[] parent;
    private int[] weight;
    private int size;
    private int count;

    public UnionFind(int size) {
        this.size = size;
        this.count = size;
        parent = new int[size];
        weight = new int[size];
        for (int i = 0; i < size; i++) {
            parent[i] = i;
            weight[i] = 1;
        }
    }

    public int find(int element) {
        if (element != parent[element]) parent[element] = find(parent[element]);
        return parent[element];
    }

    public void union(int firstEle, int secondEle) {
        int firstRoot = find(firstEle);
        int secondRoot = find(secondEle);
        if (firstRoot != secondRoot) {
            if (weight[firstRoot] < weight[secondRoot]) {
                int temp = firstRoot; firstRoot = secondRoot; secondRoot = temp;
            }
            parent[secondRoot] = firstRoot;
            weight[firstRoot] += weight[secondRoot];
            count--;
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
