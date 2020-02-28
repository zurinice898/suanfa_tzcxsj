package com.ljw;

import java.util.*;

/**
 * Hello world!
 *
 */
public class App 
{
    /**
     * 不含重复串的最长子串 abcdefgh
     * **/
    public static void main( String[] args )
    {
        Scanner in = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while(in.hasNext("[a-zA-Z]+")){
            try {
                String input = in.nextLine();
                inputs.add(input);
            }catch (Exception e){
                break;
            }
        }
        inputs.add(in.nextLine());
        int max = 0;
        String result="";
        for(String s: inputs){
            String temp = getLongest(s.toCharArray());
            if(temp.length() > max){
                max = temp.length();
                result = temp;
            }
        }
        System.out.println(result);
    }

    private static String getLongest(char[] inputChars) {
        if(inputChars == null || inputChars.length == 0){
            return null;
        }
        int max = 0;
        int resultStart = 0;
        int resultEnd = 0;
        int start = 0;
        int end = 1;
        for(int i = 1; i < inputChars.length; i++){
            int index = findIndex(inputChars, start, end, inputChars[i]);
            if(index < 0){
                //不包含
                end++;
                if(end - start > max){
                    resultStart = start;
                    resultEnd = end;
                    max = end - start;
                }
            }else {
                //包含
                start = index+1;
            }
        }

        return getResult(inputChars,  resultStart,  resultEnd);

    }

    private static int findIndex(char[] inputChars, int start, int end, char target) {
        for(int i = start; i < end; i++){
            if(Character.toUpperCase(inputChars[i]) == Character.toUpperCase(target)){
                return i;
            }
        }
        return -1;
    }

    private static String  getResult(char[] temp, int start, int end) {
        char[] result = new char[end - start];
        for(int i = start; i < end ; i++){
            result[i] = temp[i];
        }
        return String.valueOf(result);
    }


}
