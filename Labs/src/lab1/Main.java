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
    public void addEl(int x1, int y1){
        this.x+=x1;
        this.y+=y1;
        this.count++;
    }
    public void calcAv(){
        this.avX= ((float)this.x/this.count);
        this.avY=((float)this.y/this.count);
    }
    public float getAvX(){
        return this.avX;
    }
    public float getAvY(){
        return this.avY;
    }
    public int getCount(){
        return this.count;
    }

}
class ObjectClass {
    private int x;
    private int y;
    private int color;




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
class MaxDis{
    private float dis;
    private int id;

    public MaxDis() {
        this.dis = 0;
        this.id = 0;
    }

    public void setId(int i){
        this.id=i;
    }
    public void setDis(float d){
        this.dis=d;
    }
    public int getId(){
        return this.id;
    }

    public float getDis(){
        return this.dis;
    }

    public  void clearDis(){
        this.id=0;
        this.dis=0;
    }
}