package frames;

import setup.State;

import javax.swing.*;
import java.awt.*;

public class MyPanel extends JPanel {
    private State[] states;

    public MyPanel() {
        setBackground(Color.BLACK);
    }

    public void setStates(State[] states) {
        this.states = states;
        repaint();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        if (states == null)
            return;

        int width = getWidth();
        int height = getHeight();
        int barWidth = width / states.length;

        for (int i = 0; i < states.length; i++) {
            int barHeight = (int) ((double) states[i].getValue() / states.length * height);
            int x = i * barWidth;
            int y = height - barHeight;

            if (states[i].isComaparing()) {
                g.setColor(Color.RED);
            } else if (states[i].isSorted()) {
                g.setColor(Color.GREEN);
            } else {
                g.setColor(Color.WHITE);
            }

            g.fillRect(x, y, barWidth - 1, barHeight);

        }

    }

}
