import java.util.Scanner;

public class CalculatorTest {
    public static void main(String[] args) {
        String expression = getExpression();
        String num1 = getNum1(expression);
        String num2 = getNum2(expression);
        String operation = getOperation(expression);
        if(num1.matches("[0-9]") || num1.contains("10")){
            int arabicNum1 = Integer.parseInt(num1);
            int arabicNum2 = Integer.parseInt(num2);
            System.out.println("Результат");
            System.out.println(doResult(arabicNum1, arabicNum2, operation));
        }
        else if(num1.matches("[a-zA-Z]")) {
            String go = getRomanNumerals(num1, num2);
            int romanNum1 = romanNum1(go);
            int romanNum2 = romanNum2(go);
            System.out.println("Результат");
            System.out.println(doResult(romanNum1, romanNum2, operation));
        }
        else throw new NullPointerException("Неподдерживаемые символы");
    }

    public static String getExpression() {
        System.out.println(("Введите выражение"));
        Scanner sc = new Scanner(System.in);
        String newExpression = sc.nextLine();
        newExpression = newExpression.toUpperCase();
        newExpression = newExpression.replaceAll(" ", "");
        return newExpression;
    }

    public static String getNum1(String expression) {
        String firstElement;
        int r;
        if (expression.contains("+")) {
            r = expression.indexOf('+');
            firstElement = expression.substring(0, r);
        } else if (expression.contains("/")) {
            r = expression.indexOf('/');
            firstElement = expression.substring(0, r);
        } else if (expression.contains("-")) {
            r = expression.indexOf('-');
            firstElement = expression.substring(0, r);
        } else if (expression.contains("*")) {
            r = expression.indexOf('*');
            firstElement = expression.substring(0, r);
        } else throw new NullPointerException("Неверный символ");
        return firstElement;
    }

    public static String getNum2(String expression) {
        String lastElement;
        int r;
        if (expression.contains("+")) {
            r = expression.indexOf('+');
            lastElement = expression.substring(r + 1);
        } else if (expression.contains("/")) {
            r = expression.indexOf('/');
            lastElement = expression.substring(r + 1);
        } else if (expression.contains("-")) {
            r = expression.indexOf('-');
            lastElement = expression.substring(r + 1);
        } else if (expression.contains("*")) {
            r = expression.indexOf('*');
            lastElement = expression.substring(r + 1);
        } else throw new NullPointerException("Неверный символ");
        return lastElement;
    }

    public static String getOperation(String expression) {
        String operation;
        int r;
        if (expression.contains("+")) {
            r = expression.indexOf('+');
            operation = expression.substring(r, r + 1);
        } else if (expression.contains("/")) {
            r = expression.indexOf('/');
            operation = expression.substring(r, r + 1);
        } else if (expression.contains("-")) {
            r = expression.indexOf('-');
            operation = expression.substring(r, r + 1);
        } else if (expression.contains("*")) {
            r = expression.indexOf('*');
            operation = expression.substring(r, r + 1);
        } else throw new NullPointerException("Неверная операция");
        return operation;
    }


    public static int doResult(int arabicNum1, int arabicNum2, String operation) {
        int result;
        if (arabicNum1 >= 1 && arabicNum1 <= 10 && arabicNum2 >= 1 && arabicNum2 <= 10) {
            switch (operation) {
                case "+":
                    result = arabicNum1 + arabicNum2;
                    break;
                case "-":
                    result = arabicNum1 - arabicNum2;
                    break;
                case "*":
                    result = arabicNum1 * arabicNum2;
                    break;
                case "/":
                    result = arabicNum1 / arabicNum2;
                    break;
                default:
                    throw new NullPointerException("Неверная операция");
            }
        } else throw new NullPointerException("Такие операции не провожу");
        return result;
    }

    public static String getRomanNumerals(String num1, String num2) {
        String[] romanNumerals = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String go;
        StringBuilder go1 = new StringBuilder();
        for (int i = 0; i < romanNumerals.length; i++) {
            go = romanNumerals[i];
            if (num1.contentEquals(go)) {
                go1.append(i);
            }
            if (num2.contentEquals(go)) {
                go1.append(i);
            }
        }
        go = go1.toString();
        return go;
    }

    public static int romanNum1(String go) {
        int a;
        if (go.contains("1010")) {
            a = Integer.parseInt(go.substring(0, 2));
        } else {
            a = Integer.parseInt(go.substring(0, 1));
        }
        return a;
    }

    public static int romanNum2(String go) {
        int b;
        if (go.contains("1010")) {
            b = Integer.parseInt(go.substring(2));
        } else {
            b = Integer.parseInt(go.substring(1));
        }
        return b;
    }
}
