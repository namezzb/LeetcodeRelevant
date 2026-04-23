package org.example.daily;
public class Extra_ValidParentheses_20260423_02 {
    public boolean isValid(String s) {
        var st = new java.util.ArrayDeque<Character>();
        for (char c : s.toCharArray()) {
            if (c == '(') st.push(')');
            else if (c == '{') st.push('}');
            else if (c == '[') st.push(']');
            else if (st.isEmpty() || st.pop() != c) return false;
        }
        return st.isEmpty();
    }
}