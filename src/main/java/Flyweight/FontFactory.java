package Flyweight;

import java.util.HashMap;
import java.util.Map;

public class FontFactory {
    private Map<String, Font> fonts = new HashMap<>();


    public Font getFont(String name){
        String key = name.toLowerCase();

        if(fonts.containsKey(key)) {
            return fonts.get(key);
        }
        else {
            Font newFont = new Font(name);
            fonts.put(key, newFont);
            return newFont;
        }
    }
}
