package org.example.daily;
public class AddBinary_20260415_06 {
    public String addBinary(String a, String b) {
        var sb = new StringBuilder();
        int i = a.length() - 1, j = b.length() - 1, c = 0;
        while (i >= 0 || j >= 0 || c > 0) {
            int s = c + (i >= 0 ? a.charAt(i--) - '0' : 0) + (j >= 0 ? b.charAt(j--) - '0' : 0);
            sb.append(s % 2); c = s / 2;
        }
        return sb.reverse().toString();
    }
}