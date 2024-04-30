package Flyweight;


import java.util.HashMap;
import java.util.Map;

public class ColorFactory {
    private Map<String, Color> colors = new HashMap<>();


    public Color getColor(String name){
        String key = name.toLowerCase();

        if(colors.containsKey(key)) {
            return colors.get(key);
        }
        else {
            Color newColor = new Color(name);
            colors.put(key, newColor);
            return newColor;
        }
    }
}
