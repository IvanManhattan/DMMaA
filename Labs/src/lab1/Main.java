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
    private int x = 0;
    private int y = 0;
    private float avX = 0;
    private float avY = 0;

    private int count = 0;
    public void clearDis(){
        this.x=0;
        this.y=0;
        this.count=0;
    }
    public void addEl(ObjectClass o){
        this.x+=o.getX();
        this.y+=o.getY();
        this.count++;
    }
    public void calcAv(){
        this.avX=(float) (this.x/this.count);
        this.avY=(float) (this.y/this.count);
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




    public ObjectClass(int x, int y, int color, boolean isCenter) {
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