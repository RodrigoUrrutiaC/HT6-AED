package mapas; 

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Rodrigo Urrutia 16139
 * @author Kevin Macario 17369
 * @version 5.03.2018
 */

public class MapFactory {

    public Map getMap(int entry){
        switch(entry){
            case 1:
                return new HashMap();
            case 2:
                return new TreeMap();
            case 3:
                return new LinkedHashMap();
        }
        return null;
    }
}