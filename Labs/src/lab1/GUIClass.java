package lab1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;

public class GUIClass extends JFrame {
    private JButton actionButtonCreateAverage;
    private JButton actionButtonCreateMaximin;
    private List<ObjectClass> elements;
    private List<ObjectClass> centres;
    private int classesCount = 7;
    private int elementsCount = 14000;

    public GUIClass() {
        super("Lab 1");
        setBounds(100, 100, 800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initElements();

        actionButtonCreateAverage = new JButton("Average");
        actionButtonCreateAverage.setBounds(50,100,95,30);

        actionButtonCreateMaximin = new JButton("Maximin");
        actionButtonCreateMaximin.setBounds(50,100,95,30);

        actionButtonCreateAverage.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        JPanel panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Random rnd = new Random(3);
                int pointWidth = 3;
                int pointHeight = 3;

                for (int i = 0; i < elementsCount; i++) {
                    if (!elements.get(i).isCenter()) {
                        if (elements.get(i).getColor() == 0)
                            g.setColor(Color.WHITE);
                        else if (elements.get(i).getColor() == 1)
                            g.setColor(Color.RED);
                        else if (elements.get(i).getColor() == 2)
                            g.setColor(Color.BLUE);
                        else if (elements.get(i).getColor() == 3)
                            g.setColor(Color.YELLOW);
                        else if (elements.get(i).getColor() == 4)
                            g.setColor(Color.GREEN);
                        else if (elements.get(i).getColor() == 5)
                            g.setColor(Color.PINK);
                        else if (elements.get(i).getColor() == 6)
                            g.setColor(Color.MAGENTA);
                        else if (elements.get(i).getColor() == 7)
                            g.setColor(Color.ORANGE);
                        pointWidth = 3;
                        pointHeight = 3;
                    }
                    else {
                        if (elements.get(i).getColor() == 1)
                            g.setColor(Color.RED);
                        else if (elements.get(i).getColor() == 2)
                            g.setColor(Color.BLUE);
                        else if (elements.get(i).getColor() == 3)
                            g.setColor(Color.YELLOW);
                        else if (elements.get(i).getColor() == 4)
                            g.setColor(Color.GREEN);
                        else if (elements.get(i).getColor() == 5)
                            g.setColor(Color.PINK);
                        else if (elements.get(i).getColor() == 6)
                            g.setColor(Color.MAGENTA);
                        else if (elements.get(i).getColor() == 7)
                            g.setColor(Color.ORANGE);
                        pointWidth = 10;
                        pointHeight = 10;
                    }
                    g.fillOval(elements.get(i).getX(), elements.get(i).getY(), pointWidth, pointHeight);
                }
            }
        };

        JPanel actionPanel = new JPanel();

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
                    rnd.nextInt(0, 500), rnd.nextInt(0, 500), 0, false));
        }

        List<ObjectClass> previous = new ArrayList<>();

        for (int j = 0; j < classesCount; j++) {
            ObjectClass tempElement = elements.get(rnd.nextInt(0, 14000));
            if (!previous.contains(tempElement)) {
                tempElement.setCenter(true);
                tempElement.setColor(j + 1);
                previous.add(tempElement);
            }
        }

        centres = (ArrayList<ObjectClass>) ((ArrayList<ObjectClass>) previous).clone();

    }

    private void averageKMethod() {

        float minDistance = 10000.0F;
        int cluster = 0;

        for (int i = 0; i < elementsCount; i++) {
            for (int j = 0; j < classesCount; j++) {
                float distance = (float) Math.sqrt((Math.pow(elements.get(i).getX() - centres.get(j).getX(), 2)) +
                        Math.pow(elements.get(i).getY() - centres.get(j).getY(), 2));
                if (minDistance > distance) {
                    minDistance = distance;
                    cluster = j + 1;
                }
            }
            elements.get(i).setColor(cluster);
        }
    }

    private void maximinMethod() {

    }

    private void repaint(Graphics g) {
        g.fillRect(0, 0, 500, 500);
        for (int i = 0; i < elementsCount; i++) {
            // TODO
        }
    }

}
