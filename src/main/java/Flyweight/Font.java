package Flyweight;

public class Font {
    private String name;

    public Font(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Font: " + name;
    }
}
