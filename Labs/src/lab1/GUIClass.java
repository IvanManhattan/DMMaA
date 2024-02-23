package lab1;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GUIClass extends JFrame {
    private JButton actionButtonCreateAverage;
    private JButton actionButtonCreateMaximin;
    private List<ObjectClass> elements;
    private List<ObjectClass> centres;
    private int classesCount = 5;
    private int elementsCount = 14000;

    public GUIClass() {
        super("Lab 1");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initElements();
        initCentres();

        JPanel panel = new JPanel() {
            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Random rnd = new Random(3);
                for (int i = 0; i < elementsCount; i++) {
                    if (elements.get(i).getColor() == 1)
                        g.setColor(Color.RED);
                    else if (elements.get(i).getColor() == 2)
                        g.setColor(Color.BLUE);
                    else if (elements.get(i).getColor() == 3)
                        g.setColor(Color.GREEN);
                    g.fillOval(elements.get(i).getX(), elements.get(i).getY(), 3, 3);
                }
                for (int i = 0; i < classesCount; i++) {
                    g.setColor(Color.BLACK);
                    g.fillOval(centres.get(i).getX(), centres.get(i).getY(), 10, 10);
                }
            }
        };

        JPanel actionPanel = new JPanel();

        actionButtonCreateAverage = new JButton("Average");
        actionButtonCreateAverage.setBounds(50,100,95,30);

        actionButtonCreateMaximin = new JButton("Maximin");
        actionButtonCreateMaximin.setBounds(50,100,95,30);

        this.add(panel, BorderLayout.CENTER);
        this.add(actionPanel, BorderLayout.SOUTH);
        actionPanel.add(actionButtonCreateAverage);
        actionPanel.add(actionButtonCreateMaximin);

        this.setVisible(true);
        this.setResizable(false);
    }

    private void initElements() {
        elements = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < elementsCount; i++) {
            elements.add(new ObjectClass(
                    rnd.nextInt(0, 500), rnd.nextInt(0, 500), rnd.nextInt(1, 4)));
        }
    }

    private void initCentres() {
        centres = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < classesCount; i++) {
            centres.add(new ObjectClass(
                    rnd.nextInt(0, 500), rnd.nextInt(0, 500), 0));
        }
    }

    private void averageMethod() {

    }

    private void maximinMethod() {

    }

}
