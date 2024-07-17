package setup;

public interface Implementation {

    void swap(State[] arr, int i, int j);

    void highlightSwap(State[] arr, int i, int j);

    void compareAndHighlight(State[] arr, int i, int j);

    void setComparingRange(State[] arr, int start, int end);

    void resetColors(State[] arr);

}