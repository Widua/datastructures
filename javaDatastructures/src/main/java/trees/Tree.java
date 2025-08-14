package trees;

public interface Tree {

    int height();
    int size();
    void insert(Integer value);
    void delete(Integer value);
    boolean find(Integer value);
    boolean bfsFind(Integer value);
    String asString(TraversalMode mode);
    boolean compare(BTNode a, BTNode b);

}
