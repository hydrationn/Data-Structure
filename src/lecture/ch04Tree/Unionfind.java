package lecture.ch04Tree;

public class Unionfind {
    protected UFNode[] a;
    public Unionfind(UFNode[] iarray) {
        a = iarray;
    }
    // i가 속한 집합의 루트를 순환 호출로 찾고 최종적으로 경로상의 각 원소의 부모를 루트로 만든다.
    protected int find(int i) { // 경로 압축
        if(i != a[i].getParent())
            a[i].setParent(find(a[i].getParent())); // 리턴하며 경로상의 각 노드의 부모가 루트가 되도록 만든다.
        return a[i].getParent();
    }
    public void union(int i, int j) { // Union 연산
        int iroot = find(i);
        int jroot = find(j);
        if(iroot == jroot)
            return; // 루트 노드가 동일하면 더이상의 수행없이 그대로 리턴
        // rank가 높은 루트 노드가 승자가 된다.
        if(a[iroot].getRank() > a[jroot].getRank())
            a[jroot].setParent(iroot); // iroot가 승자
        else if (a[iroot].getRank() < a[jroot].getRank())
            a[iroot].setParent(jroot); // jroot가 승자
        else {
            a[jroot].setParent(iroot); // 둘 중아 하나 임의로 승자
            int t = a[iroot].getRank() + 1;
            a[iroot].setRank(t); // iroot의 rank 1 증가
        }
    }
}
