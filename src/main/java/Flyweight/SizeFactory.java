package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class SizeFactory {
    private Map<Integer, Size> sizes = new HashMap<>();


    public Size getSize(int sizeNum){

        if(sizes.containsKey(sizeNum)) {
            return sizes.get(sizeNum);
        }
        else {
            Size newSize = new Size(sizeNum);
            sizes.put(sizeNum, newSize);
            return newSize;
        }
    }
}
