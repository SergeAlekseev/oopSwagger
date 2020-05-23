package oop.service;

import org.springframework.stereotype.Service;

@Service
public class OOPService {

    public static String light(double time) {
        return String.valueOf(time * 330.0);
    }

    public static String roll(String s, String result) {
        if (!s.isEmpty()) {
            result += s.charAt(s.length() - 1);
            s = s.substring(0, s.length() - 1);
            result = roll(s, result);
        }
        return result;
    }

    public static String topSpeder(String[] names, int[] times) {
        int min = times[0];
        int i = 1;
        String nm;
        for (; i < times.length; i++) {
            if (times[i] < min) {
                min = times[i];
            }
        }
        nm = names[0];
        return (nm + " - " + min);
    }



    public static boolean isPalindrome(String text) {
        return text.replaceAll("\\W", "")
                .equalsIgnoreCase(new StringBuilder(text.replaceAll("\\W", ""))
                        .reverse().toString());
    }

    public static int[] day(int day) {
        int[] time = new int[3];
        time[0] = day * 24;
        time[1] = time[0] * 60;
        time[2] = time[1] * 60;
        return time;
    }
}
