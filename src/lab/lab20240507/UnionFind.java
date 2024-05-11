package lab.lab20240507;

public class UnionFind {
    protected Node[] a;

    public UnionFind(Node[] iarray) {
        a = iarray;
    }

    protected int find(int i) {
        if (i != a[i].getParent())
            a[i].setParent(find(a[i].getParent()));
        return a[i].getParent();
    }

    public void union(int i, int j) {
        int iroot = find(i);
        int jroot = find(j);
        if(iroot == jroot)
            return; // 루트 노드가 동일하면 더이상의 수행없이 그대로 리턴

        // size가 큰 루트 노드가 승자가 된다.
        if(a[iroot].getSize() > a[jroot].getSize())
            a[jroot].setParent(iroot); // iroot가 승자
        else if (a[iroot].getSize() < a[jroot].getSize())
            a[iroot].setParent(jroot); // jroot가 승자
        else {
            a[jroot].setParent(iroot); // 둘 중에 하나 임의로 승자
            int t = a[iroot].getSize() + 1;
            a[iroot].setSize(t); // iroot의 size 1 증가
        }
    }

    public void printsets() {
        boolean[] visited = new boolean[a.length]; // 방문 여부 표시

        for (int i = 0; i < a.length; i++) {
            if (!visited[i]) {
                int root = find(i); // 출력 기준 루트 노드 선정

                // 현재 노드의 루트 노드가 root인 집합 출력
                for (int j = 0; j < a.length; j++) {
                    if (find(j) == root) {
                        System.out.print(j + " ");
                        visited[j] = true; // 출력한 노드는 true로 만들어 이후에 다시 출력이 되지 않도록
                    }
                }
                System.out.println();
            }
        }
    }
}
