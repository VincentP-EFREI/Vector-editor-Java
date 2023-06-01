import javax.swing.JOptionPane;
import java.util.ArrayList;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        Area arre = new Area(25,25);


        Point point = new Point(5,6);
        point.print_point();
        System.out.println(point.pixel_arr.size());
        arre.add_shape_to_area(point);

        arre.shapes.get(0).print();

        System.out.println(arre.shapes.get(0).pixel_arr.size());

//        Point p1 = new Point(7,8);
//        Point p2 = new Point(9,10);
//        Line line = new Line(p1, p2);
//        line.print();
//        System.out.println(line.shape_type);
//        arre.add_shape_to_area(line);
//
//
//        Point p_square = new Point(11,12);
//        Square square = new Square(p_square, 10);
//        square.print();
//        System.out.println(square.shape_type);
//        arre.add_shape_to_area(square);
//
//
//        Point p_rectangle = new Point(13,14);
//        Rectangle rectangle = new Rectangle(p_rectangle, 10, 10);
//        rectangle.print();
//        System.out.println(rectangle.shape_type);
//        arre.add_shape_to_area(rectangle);
//
//
//        Point p_circle = new Point(15,16);
//        Circle circle = new Circle(p_circle, 10);
//        circle.print();
//        System.out.println(circle.shape_type);
//        arre.add_shape_to_area(circle);
//
//
//        ArrayList<Point> p_polygon = new ArrayList<>();
//        p_polygon.add(new Point(17, 18));
//        p_polygon.add(new Point(19, 20));
//        p_polygon.add(new Point(21, 22));
//        Polygon polygon = new Polygon(p_polygon);
//        polygon.print();
//        System.out.println(polygon.shape_type);
//        arre.add_shape_to_area(polygon);


//        System.out.println(arre.shapes.get(0).pixel_arr.toString());


    }
}