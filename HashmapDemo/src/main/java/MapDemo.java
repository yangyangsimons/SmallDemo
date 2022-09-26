import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapDemo {
    public static void main(String[] args) {
        Map<Integer, String> map = new HashMap<>();
        map.put(1, "lynn");
        map.put(2, "simons");
        System.out.println("this is the value of key 1: " + map.get(1));
        System.out.println("this is the value of key 2: " + map.get(2));

        String deleteValue = map.remove(1);

        Set<Integer> key = map.keySet();
        Collection<String> values = map.values();
        Set<Map.Entry<Integer, String>> entry = map.entrySet();
    }
}
