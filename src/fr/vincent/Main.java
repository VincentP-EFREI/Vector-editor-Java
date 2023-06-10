package fr.vincent;

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
                        case 'C' -> screen_area.add_shape_to_area(CLI.setSquare());
                        case 'D' -> screen_area.add_shape_to_area(CLI.setRectangle());
                        case 'E' -> screen_area.add_shape_to_area(CLI.setCircle());
                        case 'F' -> screen_area.add_shape_to_area(CLI.setPolygon());
                    }
                }
                case 'B' -> {
                    for(Shape shape : screen_area.shapes){
                        shape.print(false);
                    }
                    if(screen_area.shapes.size() == 0)
                        System.out.println("The list is empty.");
                    scanner.next();
                }
                case 'C' -> {
                    for(Shape shape : screen_area.shapes){
                        shape.print(true);
                    }
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
    }
}