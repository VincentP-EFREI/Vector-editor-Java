package fr.vincent;

import javax.print.DocFlavor;
import java.io.*;
import java.util.*;

public final class CLI {

    private CLI(){}

    public static char boundedChoice(String showStr, char limMin, char limMax, boolean caseSensitif, String optText){
        String val;
        char firstChar = '\\';
        do {
//            cls();
            System.out.println("Full");
            System.out.println(optText.isEmpty());
            System.out.printf("Enter a character between %c and %c: ", limMin, limMax);
            val = Main.scanner.nextLine();
            if(!val.isEmpty())
                firstChar = val.charAt(0);

        }while( val.isEmpty() || (caseSensitif && (firstChar < limMin || firstChar > limMax)) ||
                (!caseSensitif && ((firstChar < Character.toLowerCase(limMin) || firstChar > Character.toLowerCase(limMax)) &&
                        (firstChar < Character.toUpperCase(limMin) || firstChar > Character.toUpperCase(limMax)))
                )
        );
        return firstChar;
    }

    public static int valAffectation(String toPrintString, String toAskString){
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

    public static String printMenu(String filename, int paragraphNumber){
        InputStream inputStream = CLI.class.getResourceAsStream(filename);
        assert inputStream != null;
        Scanner scanner = new Scanner(inputStream);
        ArrayList<String> returnString = new ArrayList<>();
        int n = 0;
        String workString;

        while(scanner.hasNextLine()){
            workString = scanner.nextLine();
            System.out.print(workString);
            if (workString.charAt(workString.length()-1) == ';' || returnString.size() == 0){
                returnString.add(workString);
            }
        }
        return returnString.get(paragraphNumber);
    }

    public static String textFileReader(String filepath, String paragraphName){

        String outputString = new String();

        try (InputStream input = new FileInputStream(filepath)) {

            Properties prop = new Properties();
            prop.load(input);
            outputString = prop.getProperty(paragraphName);

//            try (OutputStream output = new FileOutputStream(filepath)) {
//
//                prop.store(output, null);
//                output.close();
//            } catch (IOException ex) {
//                ex.printStackTrace();
//            }
            System.out.println(outputString);

        } catch (IOException io) {
            io.printStackTrace();
        }

        return outputString;
    }

}
