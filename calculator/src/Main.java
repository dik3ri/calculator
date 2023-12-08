import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Калькулятор");
        Scanner scanner = new Scanner(System.in);

        while(true){
            boolean isRoman = false;
            int a,b,arabian,res = 0;
            String resArbian = "";
            System.out.print("\nВведите выражение (арабские или римские): ");
            String expression = scanner.nextLine();
            expression  = expression.trim().replace(" ","");



            // Проверка на знак
            String sign = toCheckSign(expression);
            if(sign == null) {
                System.out.println("Вы ввели неверный знак.");
                continue;
            }

            // Сколько ввел операндов пользователь

            String [] expressionArr = expression.split("[+\\-*/]");

            if(expressionArr.length > 2) {
                System.out.println("Должно быть два операнда");
                continue;
            }


            //если оба числа римские
            if (Roman.isRoman(expressionArr[0]) && Roman.isRoman(expressionArr[1])) {
                //конвертируем оба числа в арабские для вычесления действия
                a = Roman.convertToArabian(expressionArr[0]);
                b = Roman.convertToArabian(expressionArr[1]);
                isRoman = true;
            } else if (!Roman.isRoman(expressionArr[0]) && !Roman.isRoman(expressionArr[1])) {
                a = Integer.parseInt(expressionArr[0]);
                b = Integer.parseInt(expressionArr[1]);
                isRoman = false;
            }
            //если одни число римское, а другое - арабское
            else {
                System.out.println("Все числа должны быть в одном формате");
                continue;
            }




            if(isRoman == false){

                switch (sign){
                    case "+":
                        res = a + b;
                        System.out.println("Ответ: "+res);
                        break;
                    case "-":
                        res = a - b;
                        System.out.println("Ответ: "+res);
                        break;
                    case "*":
                        res = a * b;
                        System.out.println("Ответ: "+res);
                        break;
                    case "/":
                        res = a / b;
                        System.out.println("Ответ: "+res);
                        break;
                    default:
                        System.out.println("Ошибка");
                }
            }
            if (isRoman == true) {
                if (a > 10 || b > 10) {
                System.out.println("Числа должны быть от I до X");

                } else {
                    switch (sign){
                        case "+":
                            res = a + b;
                            break;
                        case "-":
                            res = a - b;
                            break;
                        case "*":
                            res = a * b;
                            break;
                        case "/":
                            res = a / b;
                            break;
                    }
                    if (isRoman) {
                        //если римское число получилось меньше либо равно нулю, генерируем ошибку
                        if (res <= 0) {
                            System.out.println("Римское число должно быть больше нуля");
                        } else {
                            //конвертируем результат операции из арабского в римское
                            arabian = res;
                            resArbian = Roman.convertToRoman(arabian);
                            //Конвертируем арабское число в тип String
                            System.out.println("Ответ: " + resArbian);
                        }
                    }
                }

            }

        }
    }

    public static String toCheckSign(String expression) {

        if(expression.contains("+")){
            return "+";
        } else if(expression.contains("-")){
            return "-";
        } else if(expression.contains("*")){
            return "*";
        } else if(expression.contains("/")){
            return "/";
        } else {
            return null;
        }
    }

}

class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI",
            "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV",
            "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI",
            "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII",
            "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII",
            "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV",
            "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
            "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII",
            "XCVIII", "XCIX", "C"};


    public static boolean isRoman(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int convertToArabian(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arabian) {
        return romanArray[arabian];
    }

}