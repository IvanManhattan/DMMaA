package lab1;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class GUIClass extends JFrame {
    private JButton actionButtonCreateAverage;
    private JButton actionButtonCreateMaximin;
    private List<ObjectClass> elements;
    private List<ObjectClass> centres;
    private List<AvDistance> distances;

    private int centresMaximinCount;
    private List<ObjectClass> centresMaximinList;

    private int classesCount = 7;
    private int elementsCount = 14000;
    private boolean isRepaint = false;
    private boolean isMaximinMethod = false;

    public GUIClass() {
        super("Lab 1");
        setBounds(100, 100, 500, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        initElements();

        JPanel actionPanel = new JPanel();

        JPanel panel = new JPanel() {

            @Override
            public void paintComponent(Graphics g) {
                super.paintComponent(g);
                Random rnd = new Random(3);
                int pointWidth = 3;
                int pointHeight = 3;

                if (!isRepaint) {
                    for (int i = 0; i < elementsCount; i++) {
                        pointWidth = 3;
                        pointHeight = 3;

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

                        g.fillOval(elements.get(i).getX(), elements.get(i).getY(), pointWidth, pointHeight);
                    }
                    if (!isMaximinMethod) {
                        for (int i = 0; i < classesCount; i++) {

                            pointWidth = 10;
                            pointHeight = 10;

                            if (centres.get(i).getColor() == 0)
                                g.setColor(Color.WHITE);
                            else if (centres.get(i).getColor() == 1)
                                g.setColor(Color.RED);
                            else if (centres.get(i).getColor() == 2)
                                g.setColor(Color.BLUE);
                            else if (centres.get(i).getColor() == 3)
                                g.setColor(Color.YELLOW);
                            else if (centres.get(i).getColor() == 4)
                                g.setColor(Color.GREEN);
                            else if (centres.get(i).getColor() == 5)
                                g.setColor(Color.PINK);
                            else if (centres.get(i).getColor() == 6)
                                g.setColor(Color.MAGENTA);
                            else if (centres.get(i).getColor() == 7)
                                g.setColor(Color.ORANGE);

                            g.fillOval(centres.get(i).getX(), centres.get(i).getY(), pointWidth, pointHeight);
                        }
                    }
                    else {
                        for (int i = 0; i < centresMaximinCount; i++) {

                            pointWidth = 10;
                            pointHeight = 10;

                            if (centresMaximinList.get(i).getColor() == 0)
                                g.setColor(Color.WHITE);
                            else if (centresMaximinList.get(i).getColor() == 1)
                                g.setColor(Color.RED);
                            else if (centresMaximinList.get(i).getColor() == 2)
                                g.setColor(Color.BLUE);
                            else if (centresMaximinList.get(i).getColor() == 3)
                                g.setColor(Color.YELLOW);
                            else if (centresMaximinList.get(i).getColor() == 4)
                                g.setColor(Color.GREEN);
                            else if (centresMaximinList.get(i).getColor() == 5)
                                g.setColor(Color.PINK);
                            else if (centresMaximinList.get(i).getColor() == 6)
                                g.setColor(Color.MAGENTA);
                            else if (centresMaximinList.get(i).getColor() == 7)
                                g.setColor(Color.ORANGE);

                            g.fillOval(centres.get(i).getX(), centres.get(i).getY(), pointWidth, pointHeight);
                        }
                    }
                }
                else {
                    g.setColor(Color.WHITE);
                    g.fillRect(0, 0, 500, 500);
                }

            }
        };

        actionButtonCreateAverage = new JButton("Average");
        actionButtonCreateAverage.setBounds(50,100,95,30);

        actionButtonCreateMaximin = new JButton("Maximin");
        actionButtonCreateMaximin.setBounds(50,100,95,30);

        actionButtonCreateAverage.addActionListener( e-> {
            isMaximinMethod = false;
            isRepaint = true;
            panel.repaint();
            averageKMethod();
            isRepaint = false;
            panel.repaint();
        });

        actionButtonCreateMaximin.addActionListener( e-> {
            isMaximinMethod = true;
            isRepaint = true;
            panel.repaint();
            maximinMethod();
            isRepaint = false;
            panel.repaint();
        });

        this.add(panel, BorderLayout.CENTER);
        this.add(actionPanel, BorderLayout.SOUTH);
        actionPanel.add(actionButtonCreateAverage);
        actionPanel.add(actionButtonCreateMaximin);

        this.setVisible(true);
        this.setResizable(false);
    }

    private void initElements() {

        centres = new ArrayList<>();
        elements = new ArrayList<>();
        Random rnd = new Random();

        for (int i = 0; i < elementsCount; i++) {
            elements.add(new ObjectClass(
                    rnd.nextInt(0, 500), rnd.nextInt(0, 500), 0));
        }

/*
        for (int l = 0; l < 50; l++) {
            for (int j = 0; j < 50; j++) {
                elements.add(new ObjectClass(l*10, j*10, 0));
            }
        }
  */
        // List<ObjectClass> previous = new ArrayList<>();

        // Инициализируем центры - каждый центр имеет свой цвет, затем
        // элементам будут присваиваться цвета в зависимости от центра
        for (int j = 0; j < classesCount; j++) {
            ObjectClass tempElement = elements.get(rnd.nextInt(0, elementsCount));
            if (!centres.contains(tempElement)) {
                tempElement.setColor(j + 1);
                centres.add(tempElement);
            }
        }

        // centres = (ArrayList<ObjectClass>) ((ArrayList<ObjectClass>) previous).clone();

    }

    private void averageKMethod() {

        float minDistance = 10000.0F;
        int cluster;
        distances = new ArrayList<>();

        for (int i = 0; i < classesCount; i++) {
            distances.add(new AvDistance());
        }

        for (int i = 0; i < elementsCount; i++) {
            cluster = 0;
            minDistance = 100000.0F;
            for (int j = 0; j < classesCount; j++) {
                float distance = (float) Math.sqrt((Math.pow(elements.get(i).getX() - centres.get(j).getX(), 2)) + Math.pow(elements.get(i).getY() - centres.get(j).getY(), 2));
                if (minDistance > distance) {
                    minDistance = distance;
                    cluster = j;
                }
            }
            elements.get(i).setColor(cluster + 1);
        }

        for (int i = 0; i < classesCount; i++) {
            distances.get(i).clearDis();
        }
        for (int i = 0; i < elementsCount; i++) {
            distances.get(elements.get(i).getColor()-1).addEl(elements.get(i).getX(),elements.get(i).getY());
        }
        for (int i = 0; i < classesCount; i++) {
            distances.get(i).calcAv();
        }
        System.out.println("Av: " + distances.get(0).getAvX() + " " + distances.get(0).getAvY());

        System.out.println("Av: " + distances.get(1).getAvX() + " " + distances.get(1).getAvY());

        for (int i = 0; i < elementsCount; i++) {
            if (Math.sqrt((Math.pow(elements.get(i).getX() - distances.get(elements.get(i).getColor()-1).getAvX(), 2)) + Math.pow(elements.get(i).getY() - distances.get((elements.get(i).getColor()-1)).getAvY(), 2)) < Math.sqrt((Math.pow(centres.get((elements.get(i).getColor()-1)).getX() - distances.get((elements.get(i).getColor()-1)).getAvX(), 2)) + Math.pow(centres.get((elements.get(i).getColor()-1)).getY() - distances.get((elements.get(i).getColor()-1)).getAvY(), 2)) ) {
                centres.get((elements.get(i).getColor()-1)).setX(elements.get(i).getX());
                centres.get((elements.get(i).getColor()-1)).setY(elements.get(i).getY());
                System.out.print("X:");
                System.out.println(centres.get((elements.get(i).getColor()-1)).getX());
                System.out.print("Y:");
                System.out.println(centres.get((elements.get(i).getColor()-1)).getY());

            }
        }


    }

        /*
        for (int i = 0; i < elementsCount; i++) {
            for(int j = 0; j < classesCount; j++){
                float distance = (float) Math.sqrt((Math.pow(elements.get(i).getX() - distances.get(j).getAvX(), 2)) +
                        Math.pow(elements.get(i).getY() - distances.get(j).getAvY(), 2));
                if ((float) Math.sqrt((Math.pow(centres.get(i).getX() - distances.get(j).getAvX(), 2)) +
                        Math.pow(centres.get(i).getY() - distances.get(j).getAvY(), 2)) > distance) {

                    centres.get(j).setX(elements.get(i).getX());
                    centres.get(j).setY(elements.get(i).getY());



                }
            }
        }

         */




    private void maximinMethod() {
        ObjectClass firstObject = elements.get(0);
        float maxDistance = 1.F;
        int indexMax = 0;
        boolean isCycle = true;

        // Выбирается любой из объектов, например, первый в списке объектов
        centresMaximinList = new ArrayList<>();
        List<ObjectClass> centresMaximinListPotential = new ArrayList<>();

        centresMaximinList.add(firstObject);
        centresMaximinCount++;


        /*
         * Определяются расстояния от объекта 1 до всех остальных объектов:
         * Определяется объект, наиболее удаленный от 1,
        */
        for (int i = 1; i < elementsCount; i++) {
            float distance = (float) Math.sqrt(Math.pow(elements.get(i).getX() - firstObject.getX(), 2) + Math.pow(elements.get(i).getY() - firstObject.getY(), 2));
            if (distance > maxDistance) {
                maxDistance = distance;
                indexMax = i;
            }
        }

        // Этот объект становится прототипом второго кластера. Количество кластеров принимается равным двум: K=2
        centresMaximinCount++;
        centresMaximinList.add(elements.get(indexMax));

        /*
         * Определяется пороговое расстояние. Оно принимается равным
         * половине расстояния между прототипами 1 и 2.
         * Эта величина будет использоваться для проверки условия окончания алгоритма.
         */
        float thresholdDistance = ((float) Math.sqrt((Math.pow(centresMaximinList.get(0).getX() - centresMaximinList.get(1).getX(), 2)) +
                Math.pow(centresMaximinList.get(0).getY() - centresMaximinList.get(1).getY(), 2))) / 2.F;

        while (isCycle) {

            List<ObjectClass> newCenters = new ArrayList<>();

            /*
             * Находятся расстояния от каждого из анализируемых объектов до каждого
             * из имеющихся объектов-прототипов. Выполняется отнесение каждого объекта к
             * ближайшему кластеру, т.е. кластеру, для которого расстояние между этим объектом
             * и прототипом кластера минимально.
             */
            for (int j = 0; j < elementsCount; j++) {
                int cluster = 0;
                float minDistance = 10000.0F;
                for (int k = 0; k < centresMaximinCount; k++) {
                    float distance = (float) Math.sqrt(Math.pow(elements.get(j).getX() - centresMaximinList.get(k).getX(), 2) +
                            Math.pow(elements.get(j).getY() - centresMaximinList.get(k).getY(), 2));
                    if (minDistance > distance) {
                        minDistance = distance;
                        cluster = k + 1;
                    }
                }
                elements.get(j).setColor(cluster + 1);
            }

            /*
             * В каждом кластере определяется объект, наиболее удаленный от
             * прототипа своего кластера.
             */
            for (int b = 0; b < centresMaximinCount; b++) {
                maxDistance = 0.F;
                indexMax = 0;
                for (int c = 1; c < elementsCount; c++) {
                    if (elements.get(c).getColor() - 1 == b) {
                        float distance = (float) Math.sqrt(Math.pow(elements.get(c).getX() - centresMaximinList.get(b).getX(), 2) + Math.pow(elements.get(c).getY() - centresMaximinList.get(b).getY(), 2));
                        if (distance > maxDistance) {
                            maxDistance = distance;
                            indexMax = c;
                        }
                    }
                }
                centresMaximinListPotential.add(elements.get(indexMax));
            }

            /*
             * Сравниваем. Если для ВСЕХ расстояний между потенциальным центром
             * и уже имеющимся центром будет меньше порогового, то алгоритм завершен,
             * иначе добавляем того, у кого больше, к существующим и заново проходимся в while
             */
            for (int d = 0; d < centresMaximinCount; d++) {
                if ((float) Math.sqrt(Math.pow(centresMaximinList.get(d).getX() - centresMaximinListPotential.get(d).getX(), 2)
                        + Math.pow(centresMaximinList.get(d).getY() - centresMaximinListPotential.get(d).getY(), 2)) > thresholdDistance) {
                    newCenters.add(centresMaximinListPotential.get(d));
                }
            }

            if (newCenters.size() == 0) {
                isCycle = false;
            }
            else {
                centresMaximinList.addAll(centresMaximinCount - 1, newCenters);
                centresMaximinCount += newCenters.size();
            }

            /*
             * Находится новое пороговое расстояние.
             * Оно определяется как половина среднего арифметического всех расстояний между прототипами
             */
            thresholdDistance = 0.F;

            for (int i = 0; i < centresMaximinCount; i++) {
                for (int j = 0; j < centresMaximinCount; j++) {
                    float distance = (float) Math.sqrt(Math.pow(elements.get(i).getX() - centresMaximinList.get(j).getX(), 2) + Math.pow(elements.get(i).getY() - centresMaximinList.get(j).getY(), 2));
                    thresholdDistance += distance;
                }
            }

            thresholdDistance = thresholdDistance / (factorial(centresMaximinCount) * 2);
        }
    }

    private int factorial(int x) {
        int factor = 1;
        for (int i = 1; i < x; i++) {
            factor *= i;
        }

        return factor;
    }

}