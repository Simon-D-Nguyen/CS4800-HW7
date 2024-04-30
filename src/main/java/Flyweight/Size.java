package Flyweight;

public class Size {
    private int num;

    public Size (int size){
        this.num = size;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Size: " + num;
    }
}
