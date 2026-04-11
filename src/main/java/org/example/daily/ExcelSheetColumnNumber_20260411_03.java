package org.example.daily;
public class ExcelSheetColumnNumber_20260411_03 {
    public int titleToNumber(String s) {
        int r = 0;
        for (char c : s.toCharArray()) r = r * 26 + (c - 'A' + 1);
        return r;
    }
}