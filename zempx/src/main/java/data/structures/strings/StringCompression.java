package data.structures.strings;

public class StringCompression {


    // chars = ["aset","aset","b","b","c","c","c"]
    public static int compress(char[] a) {

        int count = 1;
        int length = 0;
        for (int i = 1; i < a.length; i++) {
            if (a[i] == a[i - 1]) {
                count++;
            } else {
                if (count <= 1) {
                    continue;
                }
                a[length++] = a[i - 1];
                String countStr = String.valueOf(count);
                for (int j = 0; j < countStr.length(); j++) {
                    a[length++] = countStr.charAt(j);
                }
            }
        }
        return length;
    }
}
