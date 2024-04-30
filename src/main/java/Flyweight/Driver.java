package Flyweight;

public class Driver {
    public static void main(String[] args) {

        System.out.println("Testing output to new document: ./doc1.txt");
        System.out.println("Checking if document exists:...");

        DocumentManager manager = new DocumentManager();
        manager.openDocument("./doc1.txt");

        System.out.println("Writing to document...\n==");

        manager.writeToDocument('H', "Ariel", "Red", 12);
        manager.writeToDocument('e', "Ariel", "Red", 12);
        manager.writeToDocument('l', "Ariel", "Red", 12);
        manager.writeToDocument('l', "Ariel", "Red", 12);
        manager.writeToDocument('o', "Ariel", "Red", 12);
        manager.writeToDocument('W', "Calibri", "Blue", 14);
        manager.writeToDocument('o', "Calibri", "Blue", 14);
        manager.writeToDocument('r', "Calibri", "Blue", 14);
        manager.writeToDocument('l', "Calibri", "Black", 14);
        manager.writeToDocument('d', "Calibri", "Black", 14);
        manager.writeToDocument('C', "Verdana", "Red", 16);
        manager.writeToDocument('S', "Verdana", "Red", 16);
        manager.writeToDocument('5', "Ariel", "Red", 14);
        manager.writeToDocument('8', "Calibri", "Blue", 14);
        manager.writeToDocument('0', "Verdana", "Black", 14);
        manager.writeToDocument('0', "Calibri", "Black", 12);

        System.out.println("\n\nNow reading document: ");

        manager.readDocument();

        System.out.println("\n==> End Driver");
    }
}