package org.example.daily;
import java.util.Map;
import java.util.HashMap;
public class WordPattern_20260423_03 {
    public boolean wordPattern(String p, String s) {
        String[] w = s.split(" ");
        if (p.length() != w.length) return false;
        var m = new HashMap<Character, String>();
        for (int i = 0; i < p.length(); i++) {
            char c = p.charAt(i);
            if (m.containsKey(c)) { if (!m.get(c).equals(w[i])) return false; }
            else { if (m.containsValue(w[i])) return false; m.put(c, w[i]); }
        }
        return true;
    }
}