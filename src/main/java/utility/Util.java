package utility;

import java.io.File;
import java.security.SecureRandom;
import java.util.Random;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Util {
    public static boolean between(int x, int min, int max){ //Number is between values inclusively
        return x>=min && x<=max;
    }

    public static int getRandomInt(int min, int max) { //Inclusively
        Random rand = new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

    public static String getRandomAlphanumeric(int length) {
        char[] characterSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789".toCharArray();
        Random random = new SecureRandom();
        char[] result = new char[length];
        for (int i = 0; i < result.length; i++) {
            // picks a random index out of character set > random character
            int randomCharIndex = random.nextInt(characterSet.length);
            result[i] = characterSet[randomCharIndex];
        }
        return new String(result);
    }

    public static String getRandomSetElement(Set<String> set) {
        int size = set.size();
        int item = new Random().nextInt(size);
        int i = 0;
        for (String obj : set) {
            if (i == item)
                return obj;
            i++;
        }
        return null;
    }

    //Function for getting an array of all files from directory
    public static File[] getFiles(String directory) {
        File folder = new File(directory);
        return folder.listFiles();
    }

    public static String regExpression(String data, String regExpression, int group) {
        Pattern pattern = Pattern.compile(regExpression);
        Matcher matcher = pattern.matcher(data);
        if (matcher.find()) {
            data = matcher.group(group);
        }
        return data;
    }
}
