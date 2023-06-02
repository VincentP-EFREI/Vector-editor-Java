package fr.vincent;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public final class CLI {

    private CLI(){}

    public static char boundedChoice(String showStr, char limMin, char limMax, boolean caseSensitif){
        String val = "\n";
        boolean error;
        do {

            System.out.print("Enter a character: ");
            val = Main.scanner.next();

        }while( (caseSensitif && (val.charAt(0) < limMin || val.charAt(0) > limMax)) ||
                (!caseSensitif && ((val.charAt(0) < Character.toLowerCase(limMin) || val.charAt(0) > Character.toLowerCase(limMax)) &&
                        (val.charAt(0) < Character.toUpperCase(limMin) || val.charAt(0) > Character.toUpperCase(limMax)))
                )
        );
        System.out.println("Return "+val.charAt(0));
        return val.charAt(0);
    }

    public static Point setPoint(){
        int x = 0, y = 0;
        boolean error;
        do {
            error = false;
            try {
                System.out.println("You need to give x and y.");
                System.out.print("x : ");
                x = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                error = true;
            }
        }while (error);
        do {
            error = false;
            try {
                System.out.println("You need to give x and y.");
                System.out.printf("x : %d\n", x);
                System.out.print("y : ");
                y = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                error = true;
            }
        }while (error);
        return new Point(x,y);
    }

    public static Line setLine(){
        int x1 = 0, x2 = 0, y1 = 0, y2 =0;
        boolean error;
        do {
            error = false;
            try {
                System.out.println("You need to give x1, y1, x2 and y2.");
                System.out.print("x1 : ");
                x1 = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                error = true;
            }
        }while (error);
        do {
            error = false;
            try {
                System.out.println("You need to give x1, y1, x2 and y2.");
                System.out.printf("x1 : %d\n", x1);
                System.out.print("y1 : ");
                y1 = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                error = true;
            }
        }while (error);
        do {
            error = false;
            try {
                System.out.println("You need to give x1, y1, x2 and y2.");
                System.out.printf("x1 : %d\n", x1);
                System.out.printf("y1 : %d\n", y1);
                System.out.print("x2 : ");
                x2 = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                error = true;
            }
        }while (error);
        do {
            error = false;
            try {
                System.out.println("You need to give x1, y1, x2 and y2.");
                System.out.printf("x1 : %d\n", x1);
                System.out.printf("y1 : %d\n", y1);
                System.out.printf("x2 : %d\n", x2);
                System.out.print("y2 : ");
                y2 = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                error = true;
            }
        }while (error);
        return new Line(new Point(x1, y1), new Point(x2, y2));
    }

}
