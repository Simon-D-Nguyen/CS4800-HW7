package Flyweight;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.ArrayList;

public class DocumentManager {
    private File document;
    private ArrayList<String> plaintext;
    FontFactory fonts;
    ColorFactory colors;
    SizeFactory sizes;


    private Font fontCheck(String fontName){
        return fonts.getFont(fontName);
    }

    private Color colorCheck(String colorName){
        return colors.getColor(colorName);
    }

    private Size sizeCheck(int sizeNum){
        return sizes.getSize(sizeNum);
    }



    private void printCharDetails(String data) {
        String[] characteristics = data.split(",");

        plaintext.add(characteristics[0]);

        System.out.print(characteristics[0] + " => ");
        System.out.print(fontCheck(characteristics[1]) + ", ");
        System.out.print(colorCheck(characteristics[2]) + ", ");
        System.out.print(sizeCheck(Integer.parseInt(characteristics[3])) + " ");
        System.out.println();
    }


    private String printPlaintext() {
        System.out.println(">>> Plaintext:");
        plaintext.forEach(System.out::print);
        System.out.println();

        return plaintext.toString();
    }



    public DocumentManager(){
        this.document = null;
        this.plaintext = new ArrayList<>();
        fonts = new FontFactory();
        colors = new ColorFactory();
        sizes = new SizeFactory();
    }


    public void openDocument(String documentPath){
        plaintext.clear();
        document = new File(documentPath);

        try {
            if (document.createNewFile()) {
                System.out.println("Document created: " + document.getName() );
            }
            else {
                System.out.println("Document already exists:");
            }
        }
        catch (IOException e) {
            System.out.println("An error occurred");
            e.printStackTrace();
        }
    }


    public void writeToDocument(Character character,
                                String fontName,
                                String colorName,
                                int size) {
        try {
            FileWriter docWriter = new FileWriter(document, true);
            BufferedWriter appendWriter = new BufferedWriter(docWriter);

            appendWriter.write(character + "," +
                    fontCheck(fontName).getName() + "," +
                    colorCheck(colorName).getName() + "," +
                    sizeCheck(size).getNum());
            appendWriter.newLine();

            appendWriter.close();
        }
        catch (Exception e){
            System.out.println("An error occured.");
            e.printStackTrace();
        }
    }


    public void readDocument(){
        try {
            Scanner reader = new Scanner(document);

            while(reader.hasNextLine()){
                String data = reader.nextLine();
                printCharDetails(data);
            }
            reader.close();

            printPlaintext();

        }
        catch (Exception e){
            System.out.println("An error occured.");
        }
    }
}
