package frames;

import sorting.*;

import javax.swing.*;
import java.awt.*;

import static javax.swing.WindowConstants.DISPOSE_ON_CLOSE;

@Author(name = "Mukund Bajpai", date = "July 05 2023")
public class Visualiser {
    public static String length;
    private JFrame frame;

    private Visualiser() {
        JPanel panel;
        JButton q, w, e, t;
        frame = new JFrame();
        frame.setSize(510, 390);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);

        q = new JButton("Bubble");
        w = new JButton("Selection");
        e = new JButton("Insertion");
        t = new JButton("Merge");

        q.setBounds(100, 50, 100, 50);
        w.setBounds(100, 150, 100, 50);
        e.setBounds(300, 50, 100, 50);
        t.setBounds(300, 150, 100, 50);

        q.addActionListener(v -> {
            Sorting.count = 0;
            MyPanel p = new MyPanel();
            Sorting.values = Sorting.returnArray();
            BubbleSort sorter = new BubbleSort(Sorting.values);
            p.setSorter(sorter);
            frame = returnFrame(p);
            sorter.sort();
        });

        w.addActionListener(v -> {
            Sorting.count = 0;
            MyPanel p = new MyPanel();
            Sorting.values = Sorting.returnArray();
            SelectionSort sorter = new SelectionSort(Sorting.values);
            p.setSorter(sorter);
            frame = returnFrame(p);
            sorter.sort();
        });

        e.addActionListener(v -> {
            Sorting.count = 0;
            MyPanel p = new MyPanel();
            Sorting.values = Sorting.returnArray();
            InsertionSort sorter = new InsertionSort(Sorting.values);
            p.setSorter(sorter);
            frame = returnFrame(p);
            sorter.sort();
        });

        t.addActionListener(v -> {
            Sorting.count = 0;
            MyPanel p = new MyPanel();
            Sorting.values = Sorting.returnArray();
            MergeSort sorter = new MergeSort(Sorting.values);
            p.setSorter(sorter);
            frame = returnFrame(p);
            sorter.sort();
        });

        panel.add(q);
        panel.add(w);
        panel.add(e);
        panel.add(t);
        panel.setBackground(new Color(33, 97, 140));
        frame.add(panel);
        frame.setVisible(true);
        JOptionPane.showMessageDialog(frame, "Mukund Bajpai created this sorting visualization application..\n");
        length = JOptionPane.showInputDialog(frame, "Enter number of array elements[1 - 700].\nDefault elements are 270");
        try {
            while (Integer.parseInt(length) > 700 || Integer.parseInt(length) < 0) {
                JOptionPane.showMessageDialog(frame, "Please choose the number in the given limit!");
                length = JOptionPane.showInputDialog(frame, "Enter number of array elements[1 - 700].\nDefault elements are 270");
            }
        } catch (NumberFormatException p) {
            p.getStackTrace();
        }
    }

    public static void main(String... s) {
        new Visualiser();
    }

    private JFrame returnFrame(JPanel panel) {
        JFrame frame = new JFrame("Sorting");
        frame.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());
        frame.add(panel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        return frame;
    }
}