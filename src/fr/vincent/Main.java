package fr.vincent;

import fr.vincent.CLI;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        boolean run = true;
        Area screen_area = new Area(45,45);

        while(run){

            char choice;
            choice = CLI.boundedChoice("Your choice : ", 'A', 'F', false);

            switch (Character.toUpperCase(choice)) {
                case 'A' -> {

                    choice = CLI.boundedChoice("Your choice : ", 'A', 'F', false);
                    switch (Character.toUpperCase(choice)) {
                        case 'A' -> screen_area.add_shape_to_area(CLI.setPoint());
                        case 'B' -> screen_area.add_shape_to_area(CLI.setLine());
                        case 'C' -> {
                        }
                        case 'D' -> {
                        }
                        case 'E' -> {
                        }
                        case 'F' -> {
                        }
                    }
                }
                case 'B' -> {
                }
                case 'C' -> {
                }
                case 'D' -> {
                }
                case 'E' -> {
                }
                case 'F' -> run = false;
                default -> {
                    break;
                }
            }
        }

        scanner.close();

        /*
        Area arre = new Area(45,45);

        Point point = new Point(2,2);
        point.print_point();
        System.out.println(point.shape_type);
        arre.add_shape_to_area(point);

        Point p1 = new Point(4,2);
        Point p2 = new Point(25,9);
        Line line = new Line(p1, p2);
        line.print();
        System.out.println(line.shape_type);
        arre.add_shape_to_area(line);


        Point p_square = new Point(2,9);
        Square square = new Square(p_square, 5);
        square.print();
        System.out.println(square.shape_type);
        arre.add_shape_to_area(square);


        Point p_rectangle = new Point(2,19);
        Rectangle rectangle = new Rectangle(p_rectangle, 3, 6);
        rectangle.print();
        System.out.println(rectangle.shape_type);
        arre.add_shape_to_area(rectangle);


        Point p_circle = new Point(20,20);
        Circle circle = new Circle(p_circle, 10);
        circle.print();
        System.out.println(circle.shape_type);
        arre.add_shape_to_area(circle);


        ArrayList<Point> p_polygon = new ArrayList<>();
        p_polygon.add(new Point(1, 43));
        p_polygon.add(new Point(4, 43));
        p_polygon.add(new Point(10, 41));
        Polygon polygon = new Polygon(p_polygon);
        polygon.print();
        System.out.println(polygon.shape_type);
        arre.add_shape_to_area(polygon);

        for (int i = 0; i< arre.nb_shape; i++){
            System.out.println(arre.shapes.get(i).pixel_arr.size());
        }

        arre.draw_area();
        arre.print_area();
        */

    }
}