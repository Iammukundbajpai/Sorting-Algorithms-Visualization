package setup;

import frames.MyPanel;
import sorting.Sorting;

import java.util.Random;
import java.util.random.*;

public class Sorter implements Implementation {
    private State[] states;
    private MyPanel panel;
    private static final int DELAY = 10;

    public Sorter(int size, MyPanel panel) {
        this.panel = panel;
        states = new State[size];
        resetArray();

    }

    public void resetArray() {
        Random random = new Random();
        for (int i = 0; i < states.length; i++) {
            states[i] = new State(random.nextInt(states.length) + 1);
        }
        panel.setStates(states);
    }

    public void sort(Sorting algorithm) {
        resetColors(states);
        algorithm.sort(states, this);
        for (State state : states) {
            state.setSorted(true);
        }
        panel.setStates(states);
    }

    public State[] getStates() {
        return states;
    }

    @Override
    public void swap(State[] arr, int i, int j) {
        State temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        updatePanel();
    }

    @Override
    public void highlightSwap(State[] arr, int i, int j) {
        arr[i].setComparing(true);
        arr[j].setComparing(true);
        updatePanel();
        swap(arr, i, j);
        arr[i].setComparing(false);
        arr[j].setComparing(false);
    }

    @Override
    public void compareAndHighlight(State[] arr, int i, int j) {
        arr[i].setComparing(true);
        arr[j].setComparing(true);
        updatePanel();
        arr[i].setComparing(false);
        arr[j].setComparing(false);
    }

    @Override
    public void setComparingRange(State[] arr, int start, int end) {
        for (int i = start; i <= end; i++) {
            arr[i].setComparing(true);
        }
        updatePanel();
        for (int i = start; i <= end; i++) {
            arr[i].setComparing(false);
        }
    }

    @Override
    public void resetColors(State[] arr) {
        for (State state : arr) {
            state.setComparing(false);
            state.setSorted(false);
        }
        updatePanel();
    }

    private void updatePanel() {
        panel.setStates(states);
        try {
            Thread.sleep(DELAY);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
