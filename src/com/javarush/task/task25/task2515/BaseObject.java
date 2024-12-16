package com.javarush.task.task25.task2515;

public abstract class BaseObject {
    protected double x;
    protected double y;
    protected double radius;
    private boolean isAlive;

    public BaseObject(double x, double y, double redius) {
        this.x = x;
        this.y = y;
        this.radius = redius;
        this.isAlive = true;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public double getRadius() {
        return radius;
    }

    public void setRadius(double redius) {
        this.radius = redius;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public void draw(Canvas canvas){

    }

    public void move(){

    }

    public void die(){
        isAlive = false;
    }

    public boolean isIntersect(BaseObject o){
        double dx = x - o.x;
        double dy = y - o.y;
        double distance = Math.sqrt(dx * dx + dy * dy);
        double distance2 = Math.max(radius, o.radius);
        return distance <= distance2;
    }

    public void checkBorders(double minx, double maxx, double miny, double maxy) {
        if (x < minx) x = minx;
        if (x > maxx) x = maxx;
        if (y < miny) y = miny;
        if (y > maxy) y = maxy;
    }
}
