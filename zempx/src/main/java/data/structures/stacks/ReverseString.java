package com.ms.data.structures.stacks;

public class ReverseString {


    public String reverse(String input, int idx, StringBuilder output) {
        if (idx == input.length() - 1) {
            return output.append(input.charAt(idx)).toString();
        }
        reverse(input, idx + 1, output);
        output.append(input.charAt(idx));
        return output.toString();
    }

    public String reverse(String input) {
        StringBuilder sb = new StringBuilder(input);
        return reverseHelper(sb, 0, input.length() - 1).toString();
    }

    private StringBuilder reverseHelper(StringBuilder sb, int si, int ei) {
        if (si >= ei) {
            return sb;
        }
        char tempChar = sb.charAt(si);
        sb.setCharAt(si, sb.charAt(ei));
        sb.setCharAt(ei, tempChar);
        return reverseHelper(sb, si + 1, ei - 1);
    }
}
