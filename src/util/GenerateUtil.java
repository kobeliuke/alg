package util;

import java.util.Random;

public class GenerateUtil {

    private static String[] strForm = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n",
                                "o","p","q","r","s","t","u","v","w","x","y","z"};

    public static Integer[] genRanNumArr(int size, int bound) {
        Integer[] arr = new Integer[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            arr[i] = random.nextInt(bound);
        }
        return arr;
    }

    public static String[] genRanStrArr(int size){
        String[] str = new String[size];
        Random random = new Random();
        for (int i = 0; i < size; i++) {
            str[i] = strForm[random.nextInt(26)];
        }

        return str;

    }

    public static Integer[] genNearlyOrderArr(int size,int changeTimes){
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = i;
        }
        for (int i = 0; i < changeTimes; i++) {
            Random ran = new Random();
            int xpos = ran.nextInt(size);
            int ypos = ran.nextInt(size);

            int temp = arr[xpos];
            arr[xpos] = arr[ypos];
            arr[ypos] = temp;
        }

        return arr;
    }

}
