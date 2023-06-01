import java.util.ArrayList;
import java.util.Collections;

public class Area {
    int width; // Number of pixels in width or number of columns (y-axis)
    int height; // Number of pixels in height or number of lines (x axis)
    ArrayList<ArrayList<Boolean>> mat; // pixel size matrix (width * height)
    ArrayList<Shape> shapes= new ArrayList<Shape>(); // array of shapes
    int nb_shape; // number of shapes in the shapes array (logical size)

    Area(int width, int height){
        this.width = width;
        this.height = height;
        this.nb_shape = 0;
        mat = new ArrayList<ArrayList<Boolean>>();
        for (int i = 0; i < height; i++) {
            ArrayList<Boolean> row = new ArrayList<Boolean>(Collections.nCopies(width, false));
            mat.add(row);
        }
    }

    void clear_area(){
        for(int i = 0; i<mat.size(); i++){
            for(int j = 0; j<mat.get(0).size(); j++){
                mat.get(i).set(j, false);   /// parkour the whole array mat and put 0
            }
        }
    }

    void add_shape_to_area(Point add_shape){
        this.shapes.add(add_shape);
        this.shapes.get(this.shapes.size()-1).pixel_arr.addAll(add_shape.pixel_arr);
        this.nb_shape = this.shapes.size();
    }

    void add_shape_to_area(Line add_shape){
        this.shapes.add(add_shape);
//        this.shapes.get(this.shapes.size()-1).pixel_arr.containsAll(add_shape.pixel_arr);
        this.nb_shape = this.shapes.size();
    }

    void add_shape_to_area(Square add_shape){
        this.shapes.add(add_shape);
//        this.shapes.get(this.shapes.size()-1).pixel_arr.containsAll(add_shape.pixel_arr);
        this.nb_shape = this.shapes.size();
    }

    void add_shape_to_area(Rectangle add_shape){
        this.shapes.add(add_shape);
//        this.shapes.get(this.shapes.size()-1).pixel_arr.containsAll(add_shape.pixel_arr);
        this.nb_shape = this.shapes.size();
    }

    void add_shape_to_area(Circle add_shape){
        this.shapes.add(add_shape);
//        this.shapes.get(this.shapes.size()-1).pixel_arr.containsAll(add_shape.pixel_arr);
        this.nb_shape = this.shapes.size();
    }

    void add_shape_to_area(Polygon add_shape){
        this.shapes.add(add_shape);
//        this.shapes.get(this.shapes.size()-1).pixel_arr.containsAll(add_shape.pixel_arr);
        this.nb_shape = this.shapes.size();
    }

    void draw_area(){
        int nb_pixels = 0;
        ArrayList<Pixel> arr;
        for(int i = 0; i<this.nb_shape; i++) {
            arr = this.shapes.get(i).pixel_arr;
            for (int j = 0; j < arr.size(); j++) {
                if (-1 < arr.get(j).x && arr.get(j).x < this.width && -1 < arr.get(j).y && arr.get(j).y < this.height) {
                    int px = arr.get(j).x;
                    int py = arr.get(j).y;
                    this.mat.get(py).set(px, true);
                }
            }
        }
    }

    void print_area(){
        System.out.printf("Row : %d | Col : %d\n", this.height, this.width);
        System.out.println("The array elements are:");
        for (int i = 0; i < this.height; i++) {
            for (int j = 0; j < this.width; j++) {
                if(this.mat.get(i).get(j))
                    System.out.print("* ");
                else
                    System.out.print("- ");
            }
            System.out.println();
        }
    }

}
