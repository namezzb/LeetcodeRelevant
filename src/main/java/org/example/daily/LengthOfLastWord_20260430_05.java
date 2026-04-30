package org.example.daily;
public class LengthOfLastWord_20260430_05 {
    public int lengthOfLastWord(String s) {
        int len = 0, i = s.length() - 1;
        while (i >= 0 && s.charAt(i) == ' ') i--;
        while (i >= 0 && s.charAt(i) != ' ') { len++; i--; }
        return len;
    }
}