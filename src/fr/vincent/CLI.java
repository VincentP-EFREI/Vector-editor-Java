package fr.vincent;

import java.util.ArrayList;
import java.util.InputMismatchException;

public final class CLI {

    private CLI(){}

    public static char boundedChoice(String showStr, char limMin, char limMax, boolean caseSensitif){
        String val = "\n";
        boolean error;
        do {
            cls();
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

    private static int valAffectation(String toPrintString, String toAskString){
        int val = 0;
        boolean error;
        do {
            error = false;
            try {
                cls();
                System.out.print(toPrintString);
                System.out.print(toAskString);
                val = Main.scanner.nextInt();
            } catch (InputMismatchException e) {
                Main.scanner.nextLine();
                error = true;
            }
        }while (error);
        return val;
    }

    public static Point setPoint()
    {
        int x = 0, y = 0;

        String toPrintString = "You need to give x and y.\n";
        String toAskString = "x : ";
        x = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "x : " + x + "\n";
        toAskString = "y : ";
        y = valAffectation(toPrintString, toAskString);

        return new Point(x,y);
    }

    public static Line setLine()
    {
        int x1 = 0, x2 = 0, y1 = 0, y2 =0;

        String toPrintString = "You need to give x1, y1, x2 and y2.\n";
        String toAskString = "x1 : ";
        x1 = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "x1 : " + x1 + "\n";
        toAskString = "y1 : ";
        y1 = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "y1 : " + y1 + "\n";
        toAskString = "x2 : ";
        x2 = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "x2 : " + x2 + "\n";
        toAskString = "y2 : ";
        y2 = valAffectation(toPrintString, toAskString);

        return new Line(new Point(x1, y1), new Point(x2, y2));
    }

    public static Square setSquare()
    {
        int x = 0, y = 0, length = 0;

        String toPrintString = "You need to give x, y and length.\n";
        String toAskString = "x : ";
        x = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "x : " + x + "\n";
        toAskString = "y : ";
        y = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "y : " + y + "\n";
        toAskString = "length : ";
        length = valAffectation(toPrintString, toAskString);

        return new Square(new Point(x, y), length);
    }

    public static Rectangle setRectangle()
    {
        int x = 0, y = 0, length = 0, width = 0;

        String toPrintString = "You need to give x, y, length and width.\n";
        String toAskString = "x : ";
        x = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "x : " + x + "\n";
        toAskString = "y : ";
        y = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "y : " + y + "\n";
        toAskString = "length : ";
        length = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "length : " + length + "\n";
        toAskString = "width : ";
        width = valAffectation(toPrintString, toAskString);

        return new Rectangle(new Point(x, y), length, width);
    }

    public static Circle setCircle()
    {
        int x = 0, y = 0, radius = 0;

        String toPrintString = "You need to give x, y, length and width.\n";
        String toAskString = "x : ";
        x = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "x : " + x + "\n";
        toAskString = "y : ";
        y = valAffectation(toPrintString, toAskString);

        toPrintString = toPrintString + "y : " + y + "\n";
        toAskString = "radius : ";
        radius = valAffectation(toPrintString, toAskString);

        return new Circle(new Point(x, y), radius);
    }

    public static Polygon setPolygon()
    {
        ArrayList<Point> pointList = new ArrayList<>();
        int x = 0, y = 0, n = 0;

        String toPrintString = "You need to give the number of point.\n";
        String toAskString = "number of point : ";
        n = valAffectation(toPrintString, toAskString);

        toPrintString = "";
        for(int i = 0; i < 2 * n; i += 2){

            toPrintString = toPrintString + "You need to give the x"+(i / 2 + 1)+" and y"+(i / 2 + 1)+".\n";
            toAskString = "x"+(i / 2 + 1)+" : ";
            x = valAffectation(toPrintString, toAskString);

            toPrintString = toPrintString + "x"+ (i / 2 + 1) + " : " + x + "\n";
            toAskString = "y"+(i / 2 + 1)+" : ";
            y = valAffectation(toPrintString, toAskString);

            toPrintString = toPrintString + "y"+ (i / 2 + 1) + " : " + y + "\n";
            pointList.add(new Point(x, y));
        }

        return new Polygon(pointList);
    }

    public static void cls()
    {
        try {
            new ProcessBuilder("cmd","/c","cls").inheritIO().start().waitFor();
        }
        catch(Exception E) {
            System.out.println(E);
        }
    }


}
