package fr.vincent;

import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

    public static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws FileNotFoundException {

        boolean run = true;
        Area screen_area = new Area(30,30);

        //PATH to the menu text file
        final String menuPropertiesPath = "resource/menu.properties";

        while(run){

            char choice;
            choice = CLI.boundedChoice("Your choice : ", 'A', 'G', false, CLI.textFileReader(menuPropertiesPath, "main"));

            switch (Character.toUpperCase(choice)) {
                case 'A' -> {
                    choice = CLI.boundedChoice("Your choice : ", 'A', 'G', false, CLI.textFileReader(menuPropertiesPath, "aMenu"));
                    switch (Character.toUpperCase(choice)) {
                        case 'A' -> screen_area.add_shape_to_area(CLI.setPoint());
                        case 'B' -> screen_area.add_shape_to_area(CLI.setLine());
                        case 'C' -> screen_area.add_shape_to_area(CLI.setSquare());
                        case 'D' -> screen_area.add_shape_to_area(CLI.setRectangle());
                        case 'E' -> screen_area.add_shape_to_area(CLI.setCircle());
                        case 'F' -> screen_area.add_shape_to_area(CLI.setPolygon());
                        case 'G' -> {
                            break;
                        }
                    }
                }
                case 'B' -> {
                    CLI.cls();
                    for(Shape shape : screen_area.shapes)
                        shape.print(false);
                    if(screen_area.shapes.size() == 0)
                        System.out.println("The list is empty.");
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
                case 'C' -> {
                    CLI.cls();
                    for(Shape shape : screen_area.shapes)
                        shape.print(true);
                    if(screen_area.shapes.size() == 0) {
                        System.out.println("The list is empty.");
                        System.out.print("Press Enter to continue...");
                        scanner.nextLine();
                    }
                    else {
                        String toPrintString = "You need to give the id of the shape you want to delete, enter 0 if you want to abort.";
                        String toAskString = "\nid : ";
                        int val = CLI.valAffectation(toPrintString, toAskString);
                        boolean notFound = true;
                        int index = 0;
                        do{
                            if (val == 0)
                                break;
                            for (int i = 0; i < screen_area.nb_shape; i++) {
                                if (val == screen_area.shapes.get(i).id) {
                                    notFound = false;
                                    index = i;
                                }
                            }
                            if(!notFound)
                                screen_area.shapes.remove(index);
                        }while (notFound);

                        if(screen_area.shapes.size() == 0) {
                            System.out.println("The list is empty.");
                            System.out.print("Press Enter to continue...");
                            scanner.nextLine();
                        }
                    }
                }
                case 'D' -> {
                    screen_area.draw_area();
                    screen_area.print_area();
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
                case 'E' -> {
                    System.out.println(CLI.textFileReader(menuPropertiesPath, "eMenu"));
                    System.out.print("Press Enter to continue...");
                    scanner.nextLine();
                }
                case 'F' -> {
                    choice = CLI.boundedChoice("Your choice : ", 'A', 'D', false, CLI.textFileReader(menuPropertiesPath, "fMenu"));
                    switch (Character.toUpperCase(choice)) {
                        case 'A' -> {
                            screen_area.height = CLI.valAffectation("What height do you want?\n", "Height :");
                            screen_area.width = CLI.valAffectation("What width do you want?\n", "Width :");
                        }
                        case 'B' -> {
                            break;
                        }
                    }
                }
                case 'G' -> run = false;
                default -> {
                    break;
                }
            }
        }
        scanner.close();
    }
}