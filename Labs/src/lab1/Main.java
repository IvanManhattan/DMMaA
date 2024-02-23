package lab1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        new GUIClass();

    }
}

class ObjectClass {
    int x;
    int y;
    int color;

    public ObjectClass(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getColor() {
        return color;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setColor(int color) {
        this.color = color;
    }
}