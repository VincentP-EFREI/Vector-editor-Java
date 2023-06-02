package fr.vincent;

import java.util.ArrayList;

class Pixel {
    int x, y;

    Pixel(int x, int y){
        this.x = x;
        this.y = y;
    }
}
    ///fr.vincent.Main Class///
public abstract class Shape {
    int id;
    String shape_type;
    ArrayList<Pixel> pixel_arr = new ArrayList<Pixel>();

    abstract void print();

    abstract void create_shape_to_pixel();

    Pixel create_pixel(int x, int y){
        return new Pixel(x, y);
    }
}

class Point extends Shape{
    int x, y, nb_pixels;

    public Point(int x, int y){
        this.x = x;
        this.y = y;
        this.shape_type = "POINT";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    @Override
    void print() {
        print_point();
    }

    void print_point(){
        System.out.printf("POINT %d %d\n", this.x, this.y);
    }

    @Override
    void create_shape_to_pixel(){
        this.pixel_arr.add(create_pixel(this.x, this.y));
        this.nb_pixels = pixel_arr.size();
    }
}

class Line extends Shape{
    Point p1, p2;
    int nb_pixels;

    Line(Point p1, Point p2){
        this.p1 = p1;
        this.p2 = p2;
        this.shape_type = "LINE";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    @Override
    void print() {
        print_line();
    }

    void print_line(){
        System.out.printf("LINE %d %d %d %d\n", p1.x, p1.y, p2.x, p2.y);
    }

    @Override
    void create_shape_to_pixel() {
        int dx = Math.abs(p2.x - p1.x);
        int dy = Math.abs(p2.y - p1.y);
        int sx = (p1.x < p2.x) ? 1 : -1;
        int sy = (p1.y < p2.y) ? 1 : -1;
        int err = dx - dy;

        int x = p1.x;
        int y = p1.y;

        while (true) {
            pixel_arr.add(new Pixel(x, y));

            if (x == p2.x && y == p2.y)
                break;

            int e2 = 2 * err;
            if (e2 > -dy) {
                err -= dy;
                x += sx;
            }
            if (e2 < dx) {
                err += dx;
                y += sy;
            }
        }
        nb_pixels = pixel_arr.size();
    }
}

class Square extends Shape{
    Point p;
    int length, nb_pixels;

    Square(Point p, int length){
        this.p = p;
        this.length = length;
        this.shape_type = "SQUARE";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    @Override
    void print() {
        print_square();
    }

    void print_square(){
        System.out.printf("SQUARE %d %d %d\n", p.x, p.y, length);
    }

    @Override
    void create_shape_to_pixel(){
        int length = this.length;
        int x = this.p.x;
        int y = this.p.y;

        this.pixel_arr.add(create_pixel(x, y));

        for(int i = 0; i<length-1; i++){
            this.pixel_arr.add(create_pixel(x+i+1, y));
            this.pixel_arr.add(create_pixel(x+i+1, y+length-1));
            this.pixel_arr.add(create_pixel(x, y+i+1));
            this.pixel_arr.add(create_pixel(x+length-1, y+i+1));
        }
        this.pixel_arr.remove(this.pixel_arr.size()-1);
        this.nb_pixels = this.pixel_arr.size();
    }
}

class Rectangle extends Shape{
    Point p;
    int length, width, nb_pixels;

    Rectangle(Point p){
        this(p, 1, 1);
        this.shape_type = "RECTANGLE";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    Rectangle(int length, int width){
        this(new Point(0,0), length, width);
        this.shape_type = "RECTANGLE";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    Rectangle(Point p, int length, int width){
        this.p = p;
        this.length = length;
        this.width = width;
        this.shape_type = "RECTANGLE";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    @Override
    void print() {
        print_rectangle();
    }

    void print_rectangle(){
        System.out.printf("RECTANGLE %d %d %d %d\n", p.x, p.y, length, length);
    }

    @Override
    void create_shape_to_pixel(){
        int length = this.length;
        int width = this.width;
        int x = this.p.x;
        int y = this.p.y;

        this.pixel_arr.add(create_pixel(x, y));

        for(int i = 0; i<length-1; i++){
            this.pixel_arr.add(create_pixel(x+i+1, y));
            this.pixel_arr.add(create_pixel(x+i+1, y+width-1));
        }
        for(int i = 0; i<width-1; i++){
            this.pixel_arr.add(create_pixel(x, y+i+1));
            this.pixel_arr.add(create_pixel(x+length-1, y+i+1));
        }
        this.pixel_arr.remove(this.pixel_arr.size()-1);
        this.nb_pixels = this.pixel_arr.size();
    }
}

class Circle extends Shape{
    Point p;
    int radius, nb_pixels;

    Circle(int radius){
        this(new Point(0,0), radius);
        this.shape_type = "fr.vincent.Circle";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    Circle(Point p){
        this(p, 1);
        this.shape_type = "CIRCLE";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    Circle(Point p, int radius){
        this.p = p;
        this.radius = radius;
        this.shape_type = "CIRCLE";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    @Override
    void print() {
        print_circle();
    }

    void print_circle(){
        System.out.printf("CIRCLE %d %d %d\n", p.x, p.y, radius);
    }

    @Override
    void create_shape_to_pixel(){
        int radius = this.radius;
        int x = this.p.x;
        int y = this.p.y;


        int alpha = 0;
        int beta = radius;
        int delta = radius-1;

        while (beta>=alpha){
            this.pixel_arr.add(create_pixel(x + alpha, y + beta));
            this.pixel_arr.add(create_pixel(x + beta, y + alpha));
            this.pixel_arr.add(create_pixel(x - alpha, y + beta));
            this.pixel_arr.add(create_pixel(x - beta, y + alpha));
            this.pixel_arr.add(create_pixel(x + alpha, y - beta));
            this.pixel_arr.add(create_pixel(x + beta, y - alpha));
            this.pixel_arr.add(create_pixel(x - alpha, y - beta));
            this.pixel_arr.add(create_pixel(x - beta, y - alpha));
            if(delta >= 2*alpha){
                delta -= 2*alpha+1;
                alpha++;
            }
            else if(delta < 2 * (radius-beta)){
                delta += 2*beta-1;
                beta--;
            }
            else{
                delta += 2 * (beta-alpha-1);
                beta--;
                alpha++;
            }
        }
        this.nb_pixels = this.pixel_arr.size();
    }
}

class Polygon extends Shape{
    int nb_pixels;
    ArrayList<Line> line_arr = new ArrayList<Line>();
    ArrayList<Point> PointList;


    Polygon(ArrayList<Point> PointList){
        this.PointList = PointList;
        this.shape_type = "POLYGON";
        this.nb_pixels = 0;
        create_shape_to_pixel();
    }

    @Override
    void print() {
        print_polygon();
    }

    void print_polygon(){
        System.out.print("POLYGON ");
        for (Point point : PointList)
            System.out.printf("%d %d ", point.x, point.y);
        System.out.println();
    }

    @Override
    void create_shape_to_pixel(){
        int nb_point = PointList.size();
        for(int g = 0; g<nb_point-1; g++){
            this.line_arr.add(new Line(PointList.get(g), PointList.get(g+1)));
            this.pixel_arr.addAll(this.line_arr.get(g).pixel_arr);
        }
        this.nb_pixels = this.pixel_arr.size();
    }
}
