package degiuaki_so3.bai2;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class SymbolTable {
    private Map<String, Integer> table;

    public SymbolTable() {
        table = new LinkedHashMap<>();
    }

    public void addPair(String key) {
        if (table.containsKey(key)) {
            table.put(key, table.get(key) + 1);
        } else {
            table.put(key, 1);
        }
    }

    public int getFrequency(String key) {
        return table.get(key);
    }

    public void disPlay() {
        for (Map.Entry<String, Integer> entry : table.entrySet()) {
            System.out.print("(" + entry.getKey() + ": " + entry.getValue() + ")" + "; ");
        }
    }
}
