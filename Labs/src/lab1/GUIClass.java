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
    private List<MaxDis> mDistances;
    private List<ObjectClass> mCentres;

    private int classesCount = 16;
    private int mCountCentres = 0;
    private int elementsCount = 14000;
    private boolean isRepaint = false;
    private boolean isMaxMin = false;


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
                        else if (elements.get(i).getColor() == 8)
                            g.setColor(new Color(195, 49, 49));
                        else if (elements.get(i).getColor() == 9)
                            g.setColor(new Color(30, 50, 151));
                        else if (elements.get(i).getColor() == 10)
                            g.setColor(new Color(30, 143, 151));
                        else if (elements.get(i).getColor() == 11)
                            g.setColor(new Color(0, 255, 34));
                        else if (elements.get(i).getColor() == 12)
                            g.setColor(new Color(239, 0, 255));
                        else if (elements.get(i).getColor() == 13)
                            g.setColor(new Color(39, 27, 117));
                        else if (elements.get(i).getColor() == 14)
                            g.setColor(new Color(255, 191, 65));
                        else if (elements.get(i).getColor() == 15)
                            g.setColor(new Color(176, 100, 0));
                        else if (elements.get(i).getColor() == 16)
                            g.setColor(new Color(33, 208, 220));

                        g.fillOval(elements.get(i).getX(), elements.get(i).getY(), pointWidth, pointHeight);
                    }
                    if(isMaxMin) {
                        for (int i = 0; i < mCountCentres; i++) {

                            pointWidth = 10;
                            pointHeight = 10;

                            if (mCentres.get(i).getColor() == 0)
                                g.setColor(Color.WHITE);
                            else if (mCentres.get(i).getColor() == 1)
                                g.setColor(Color.RED);
                            else if (mCentres.get(i).getColor() == 2)
                                g.setColor(Color.BLUE);
                            else if (mCentres.get(i).getColor() == 3)
                                g.setColor(Color.YELLOW);
                            else if (mCentres.get(i).getColor() == 4)
                                g.setColor(Color.GREEN);
                            else if (mCentres.get(i).getColor() == 5)
                                g.setColor(Color.PINK);
                            else if (mCentres.get(i).getColor() == 6)
                                g.setColor(Color.MAGENTA);
                            else if (mCentres.get(i).getColor() == 7)
                                g.setColor(Color.ORANGE);
                            else if (mCentres.get(i).getColor() == 8)
                                g.setColor(new Color(195, 49, 49));
                            else if (mCentres.get(i).getColor() == 9)
                                g.setColor(new Color(30, 50, 151));
                            else if (mCentres.get(i).getColor() == 10)
                                g.setColor(new Color(30, 143, 151));
                            else if (mCentres.get(i).getColor() == 11)
                                g.setColor(new Color(0, 255, 34));
                            else if (mCentres.get(i).getColor() == 12)
                                g.setColor(new Color(239, 0, 255));
                            else if (mCentres.get(i).getColor() == 13)
                                g.setColor(new Color(39, 27, 117));
                            else if (mCentres.get(i).getColor() == 14)
                                g.setColor(new Color(255, 191, 65));
                            else if (mCentres.get(i).getColor() == 15)
                                g.setColor(new Color(176, 100, 0));
                            else if (mCentres.get(i).getColor() == 16)
                                g.setColor(new Color(33, 208, 220));

                            if(mCentres.get(i).getX()>490){
                                mCentres.get(i).setX(mCentres.get(i).getX()-20);
                            }
                            if(mCentres.get(i).getY()>490){
                                mCentres.get(i).setY(mCentres.get(i).getY()-5);
                            }
                            g.fillOval(mCentres.get(i).getX(), mCentres.get(i).getY(), pointWidth, pointHeight);
                        }
                    } else {
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
                            else if (centres.get(i).getColor() == 8)
                                g.setColor(new Color(195, 49, 49));
                            else if (centres.get(i).getColor() == 9)
                                g.setColor(new Color(30, 50, 151));
                            else if (centres.get(i).getColor() == 10)
                                g.setColor(new Color(30, 143, 151));
                            else if (centres.get(i).getColor() == 11)
                                g.setColor(new Color(0, 255, 34));
                            else if (centres.get(i).getColor() == 12)
                                g.setColor(new Color(239, 0, 255));
                            else if (centres.get(i).getColor() == 13)
                                g.setColor(new Color(39, 27, 117));
                            else if (centres.get(i).getColor() == 14)
                                g.setColor(new Color(255, 191, 65));
                            else if (centres.get(i).getColor() == 15)
                                g.setColor(new Color(176, 100, 0));
                            else if (centres.get(i).getColor() == 16)
                                g.setColor(new Color(33, 208, 220));

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
            isRepaint = true;
            panel.repaint();
            averageKMethod();
            isRepaint = false;
            panel.repaint();
            actionButtonCreateAverage.setEnabled(false);
        });

        actionButtonCreateMaximin.addActionListener( e-> {
            isRepaint = true;
            panel.repaint();
            maximinMethod();
            isRepaint = false;
            isMaxMin = true;
            panel.repaint();
            actionButtonCreateMaximin.setEnabled(false);
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
        int cluster = 0;
        distances = new ArrayList<>();

        for (int i = 0; i < classesCount; i++) {
            distances.add(new AvDistance());
        }
        boolean check = true;

        while (check) {
            check=false;
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
                distances.get(elements.get(i).getColor() - 1).addEl(elements.get(i).getX(), elements.get(i).getY());
            }
            for (int i = 0; i < classesCount; i++) {
                distances.get(i).calcAv();
            }

            for (int i = 0; i < elementsCount; i++) {
                if (Math.sqrt((Math.pow(elements.get(i).getX() - distances.get(elements.get(i).getColor() - 1).getAvX(), 2)) + Math.pow(elements.get(i).getY() - distances.get((elements.get(i).getColor() - 1)).getAvY(), 2)) < Math.sqrt((Math.pow(centres.get((elements.get(i).getColor() - 1)).getX() - distances.get((elements.get(i).getColor() - 1)).getAvX(), 2)) + Math.pow(centres.get((elements.get(i).getColor() - 1)).getY() - distances.get((elements.get(i).getColor() - 1)).getAvY(), 2))) {
                    centres.get((elements.get(i).getColor() - 1)).setX(elements.get(i).getX());
                    centres.get((elements.get(i).getColor() - 1)).setY(elements.get(i).getY());
                    check=true;
                }
            }
        }

    }


    private void maximinMethod() {

        float minDistance = 0f;
        int cluster;
        mCentres = new ArrayList<>();
        mDistances = new ArrayList<>();

        //Первый центр
        mCentres.add(elements.get(0));
        mDistances.add(new MaxDis());
        mCountCentres++;

        //Присваиваем каждой точке цвет
        for (int i = 0; i < elementsCount; i++) {
            cluster = 0;
            minDistance = 100000.0F;
            for (int j = 0; j < mCountCentres; j++) {
                float distance = (float) Math.sqrt((Math.pow(elements.get(i).getX() - mCentres.get(j).getX(), 2)) + Math.pow(elements.get(i).getY() - mCentres.get(j).getY(), 2));
                if (minDistance > distance) {
                    minDistance = distance;
                    cluster = j;
                }
            }
            elements.get(i).setColor(cluster + 1);
        }

        //Находим самую удалённую точку
        for (int i = 0; i < elementsCount; i++) {
            if ((float)Math.sqrt((Math.pow(elements.get(i).getX() - mCentres.get(elements.get(i).getColor()-1).getX(), 2)) + Math.pow(elements.get(i).getY() - mCentres.get(elements.get(i).getColor()-1).getY(), 2)) > mDistances.get(elements.get(i).getColor()-1).getDis()) {
                mDistances.get((elements.get(i).getColor()-1)).setId(i);
                mDistances.get((elements.get(i).getColor()-1)).setDis((float) Math.sqrt((Math.pow(elements.get(i).getX() - mCentres.get(elements.get(i).getColor()-1).getX(), 2)) + Math.pow(elements.get(i).getY() - mCentres.get(elements.get(i).getColor()-1).getY(), 2)));
            }
        }

        //Добавляем второй центр
        mCentres.add(elements.get(mDistances.get(0).getId()));
        mDistances.add(new MaxDis());
        mCountCentres++;

        //Присваиваем каждой точке цвет
        for (int i = 0; i < elementsCount; i++) {
            cluster = 0;
            minDistance = 100000.0F;
            for (int j = 0; j < mCountCentres; j++) {
                float distance = (float) Math.sqrt((Math.pow(elements.get(i).getX() - mCentres.get(j).getX(), 2)) + Math.pow(elements.get(i).getY() - mCentres.get(j).getY(), 2));
                if (minDistance > distance) {
                    minDistance = distance;
                    cluster = j;
                }
            }
            elements.get(i).setColor(cluster + 1);
        }

        //Подготовка к циклу
        for (int i = 0; i < mCountCentres; i++) {
            mDistances.get(i).clearDis();
        }
        float disAv = 0f;

        boolean checkNewCenter = true;

        //Пока есть прототипы новых ядер
        while(checkNewCenter){
            disAv=0f;

            //Поиск половины среднего расстояния
            for (int i = 0; i < mCountCentres; i++) {
                for (int j = 0; j < mCountCentres; j++) {
                    disAv+=(float) Math.sqrt((Math.pow(mCentres.get(j).getX() - mCentres.get(i).getX(), 2)) + Math.pow(mCentres.get(j).getY() - mCentres.get(i).getY(), 2));
                }
            }

            //Вроже как так надо, но не уверен
            disAv=(disAv/factor(mCountCentres))/2;


            //Поиск вероятных прототипов
            for (int i = 0; i < elementsCount; i++) {
                if ((float) Math.sqrt((Math.pow(elements.get(i).getX() - mCentres.get(elements.get(i).getColor() - 1).getX(), 2)) + Math.pow(elements.get(i).getY() - mCentres.get(elements.get(i).getColor() - 1).getY(), 2)) > mDistances.get(elements.get(i).getColor() - 1).getDis()) {
                    mDistances.get((elements.get(i).getColor() - 1)).setId(i);
                    mDistances.get((elements.get(i).getColor() - 1)).setDis((float) Math.sqrt((Math.pow(elements.get(i).getX() - mCentres.get(elements.get(i).getColor() - 1).getX(), 2)) + Math.pow(elements.get(i).getY() - mCentres.get(elements.get(i).getColor() - 1).getY(), 2)));
                }

            }

            int i = 0;
            checkNewCenter=false;

            float maxDis=disAv;
            int maxId=0;

            //Поиск наиболее удалённогоо от центра среди прототипов
            for (int j = 0; j < mCountCentres; j++) {
                if(mDistances.get(j).getDis()>maxDis){
                    checkNewCenter=true;
                    maxId = mDistances.get(j).getId();
                    maxDis=mDistances.get(j).getDis();
                }
            }

            //Если прототип найден, то добвляем его в ядра
            if(checkNewCenter){
                mCentres.add(elements.get(maxId));
                mDistances.add(new MaxDis());
                mCountCentres++;
                mCentres.get(mCountCentres-1).setColor(mCountCentres);
                int num=0;

                //присвиваем цвет точкам
                for (int l = 0; l < elementsCount; l++) {
                    cluster = 0;
                    minDistance = 100000.0F;
                    for (int j = 0; j < mCountCentres; j++) {
                        float distance = (float) Math.sqrt((Math.pow(elements.get(l).getX() - mCentres.get(j).getX(), 2)) + Math.pow(elements.get(l).getY() - mCentres.get(j).getY(), 2));
                        if (minDistance > distance) {
                            minDistance = distance;
                            cluster = j;
                        }
                    }

                    elements.get(l).setColor(cluster+1);
                }


            }

            //Подготовка к следующему циклы
            for (int l = 0; l < mCountCentres; l++) {
                mDistances.get(l).clearDis();
            }
        }
    }

    public int factor(int i){
        int res = 1;
        for (int j = 2; j <= i; j++) {
            res *= i;
        }
        return res;
    }



}