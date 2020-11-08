package com.hai.leecode.string;

public class AddStrings {

    public String addStrings(String num1, String num2) {
        if (num1 == null || num2 == null) {
            return "";
        }
        StringBuilder  sb = new StringBuilder();
        int i = num1.length() - 1, j = num2.length() - 1, flag = 0;
        while (j >= 0 && i >= 0) {
            int sum = (num1.charAt(i--) - '0') + (num2.charAt(j--) - '0') + flag;
            flag = sum / 10;
            sb.append(sum % 10 );
        }
        while (j >= 0) {
            int sum = (num2.charAt(j--) - '0' + flag);
            sb.append(sum % 10 );
            flag = sum / 10;
        }
        while (i >= 0) {
            int sum = (num1.charAt(i--) - '0' + flag);
            sb.append(sum % 10);
            flag = sum / 10;
        }
        if (flag == 1) {
            sb.append('1');
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args) {
        String num1 = "0";
        String num2 = "0";
        AddStrings instance = new AddStrings();
        String result = instance.addStrings(num1,num2);
        System.out.println("输出的结果为: " + result);

    }

}
