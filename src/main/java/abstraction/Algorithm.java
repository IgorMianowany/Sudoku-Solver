package abstraction;

public interface Algorithm {

    boolean solve();
    void print();
    void print(int[][] board);
    void print(int row, int column);

    int getIterations();
}
