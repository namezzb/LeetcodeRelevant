package org.example.special;

import org.omg.CORBA.INTERNAL;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

public class ConvertToChinese {
        private static final Map<Integer, String> DIGIT = new HashMap<>();
        private static final String[] UNIT4 = {"", "万", "亿", "万亿"};

        static {
            for (int i = 0; i <= 9; i++)
                DIGIT.put(i, "零一二三四五六七八九".substring(i, i + 1));
        }

        // 把 0~9999 转成中文
        private static String four2Chinese(int n) {
            if (n == 0) return "";
            String[] u = {"", "十", "百", "千"};
            StringBuilder sb = new StringBuilder();
            int pos = 0;
            while (n > 0) {
                int digit = n % 10;
                if (digit != 0) {
                    sb.insert(0, DIGIT.get(digit) + u[pos]);
                } else {
                    if (sb.length() > 0 && !sb.substring(0, 1).equals("零"))
                        sb.insert(0, "零");
                }
                n /= 10;
                pos++;
            }
            // 去掉多余前导零
            while (sb.length() > 1 && sb.charAt(0) == '零')
                sb.deleteCharAt(0);
            return sb.toString();
        }

        public static String toChinese(long n) {
            if (n == 0) return "零";
            int unitIndex = 0;
            StringBuilder res = new StringBuilder();
            while (n > 0) {
                long part = n % 10000;          // 取低 4 位
                if (part != 0) {
                    String partStr = four2Chinese((int) part) + UNIT4[unitIndex];
                    res.insert(0, partStr);
                }
                n /= 10000;
                unitIndex++;
            }
            // 合并连续零
            return res.toString()
                    .replaceAll("零+", "零")
                    .replaceAll("零([万亿])", "$1")
                    .replaceAll("^零|零$", "");
        }

        public static void main(String[] args) {
            System.out.println(toChinese(113));
            System.out.println(toChinese(1003));            // 一千零三
            System.out.println(toChinese(10000));           // 一万
            System.out.println(toChinese(100000000));       // 一亿
            System.out.println(toChinese(1001000000));      // 十亿零一百万
            System.out.println(toChinese(1234567890123L));  // 一万二千三百四十五亿六千七百八十九万零一百二十三
        }
}
