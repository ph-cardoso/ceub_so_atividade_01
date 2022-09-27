package utils;

import java.util.ArrayList;
import java.util.List;

public abstract class Utils {
    public static List<String> getStrings(String text, int n) {
        List<String> results = new ArrayList<>();
        int length = text.length();

        for (int i = 0; i < length; i += n) {
            results.add(text.substring(i, Math.min(length, i + n)));
        }

        return results;
    }
}
