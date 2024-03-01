package lab1;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        new GUIClass();

    }
}

class AvDistance{
    public int x = 0;
    public int y = 0;
    public float avX = 0;
    public float avY = 0;

    public int count = 0;
    public void clearDis(){
        x=0;
        y=0;
        count=0;
    }
    public void addEl(int x1, int y1){
        x+=x1;
        y+=y1;
        count++;
    }
    public void calcAv(){
        avX= ((float)x/count);
        avY=((float)y/count);
    }
    public float getAvX(){
        return avX;
    }
    public float getAvY(){
        return avY;
    }
    public int getCount(){
        return this.count;
    }

}
class ObjectClass {
    private int x;
    private int y;
    private int color;
    private int beforeX=0;
    private int beforeY=0;




    public ObjectClass(int x, int y, int color) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.beforeX=0;
        this.beforeY=0;


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