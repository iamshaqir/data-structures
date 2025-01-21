package org.mshaq.ds.playground;

public class ReverseString {


    public static String reverse(String data) {
        StringBuilder sb = new StringBuilder(data);
        int si = 0;
        int ei = sb.length() - 1;
        while (si < ei) {
            char temp = sb.charAt(si);
            sb.setCharAt(si, sb.charAt(ei));
            sb.setCharAt(ei, temp);
            si++;
            ei--;
        }
        return sb.toString();
    }

    public static void reverseRec(StringBuilder sb, int si, int ei) {
        if (si > ei) {
            return;
        }
        char temp = sb.charAt(si);
        sb.setCharAt(si, sb.charAt(ei));
        sb.setCharAt(ei, temp);
        reverseRec(sb, si++, ei--);
    }
}
