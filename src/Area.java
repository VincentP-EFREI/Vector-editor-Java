import java.util.ArrayList;
import java.util.Collections;

public class Area {
    int width; // Number of pixels in width or number of columns (y-axis)
    int height; // Number of pixels in height or number of lines (x-axis)
    ArrayList<ArrayList<Boolean>> mat; // pixel size matrix (width * height)
    ArrayList<Shape> shapes; // array of shapes
    int nb_shape; // number of shapes in the shapes array (logical size)

    Area(int width, int height){
        this.width = width;
        this.height = height;
        this.nb_shape = 0;
        this.shapes = new ArrayList<Shape>();
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
        add_shape.create_shape_to_pixel();
        this.shapes.add(add_shape);
        System.out.println("add : "+add_shape.shape_type);
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
