package setup;

public class State {
    private int value;
    private boolean comparing;
    private boolean sorted;

    public State(int value) {
        this.value = value;
        this.comparing = false;
        this.sorted = false;
    }

    public int getValue() {
        return value;
    }

    public boolean isComaparing() {
        return comparing;
    }

    public void setComparing(boolean comparing) {
        this.comparing = comparing;
    }

    public boolean isSorted() {
        return sorted;
    }

    public void setSorted(boolean sorted) {
        this.sorted = sorted;
    }

}
