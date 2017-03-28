import java.time.LocalDateTime;
import java.util.*;

/**
 * 3/28/2017
 */
public class Main {

    private static final int  MAX_CAPACITY = 50;

    private static Map<String, LocalDateTime> lruCache = new LinkedHashMap<String, LocalDateTime>(MAX_CAPACITY, 0.75f, true){
        @Override
        protected boolean removeEldestEntry(Map.Entry<String, LocalDateTime> eldest) {
            return size() > MAX_CAPACITY;
        }
    };

    public static void main(String[] args) {
        List<String> randomName = new ArrayList<>();

        for (int i = 0; i < 100; i++) {
            randomName.add("Name" + i);
        }

        for (int j = 0; j < 5000; j++) {
            lruCache.put(randomName.get(new Random().nextInt(100)), LocalDateTime.now());
        }

        for (Map.Entry<String, LocalDateTime> entry : lruCache.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

    }
}
