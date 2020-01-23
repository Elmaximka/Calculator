import java.util.Scanner;

public class RomanCalc {
    public static void main(String[] args) {
        System.out.println(("Введите выражение"));
        Scanner sc = new Scanner(System.in);
        String a = sc.nextLine();
        a = a.toUpperCase();
        a = a.replaceAll(" ", "");
        String b, c, q;
        int r;
        if (a.contains("+")) {
            r = a.indexOf('+');
            b = a.substring(0, r);
            c = a.substring(r, r + 1);
            q = a.substring(r + 1);
        } else if (a.contains("/")) {
            r = a.indexOf('/');
            b = a.substring(0, r);
            c = a.substring(r, r + 1);
            q = a.substring(r + 1);
        } else if (a.contains("-")) {
            r = a.indexOf('-');
            b = a.substring(0, r);
            c = a.substring(r, r + 1);
            q = a.substring(r + 1);
        } else if (a.contains("*")) {
            r = a.indexOf('*');
            b = a.substring(0, r);
            c = a.substring(r, r + 1);
            q = a.substring(r + 1);
        } else throw new NullPointerException("Не то пальто");
        String[] romanNumerals = {" ", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
        String go;
        StringBuilder go1 = new StringBuilder();
        for (int i = 0; i < romanNumerals.length; i++) {
            go = romanNumerals[i];
            if (b.contentEquals(go)) {
                go1.append(i);
            }
            if (q.contentEquals(go)) {
                go1.append(i);
            }
        }
        go = go1.toString();
        int qq, qq1;
        if (go.contains("1010")) {
            qq = Integer.parseInt(go.substring(0, 2));
            qq1 = Integer.parseInt(go.substring(2));
        } else {
            qq = Integer.parseInt(go.substring(0, 1));
            qq1 = Integer.parseInt(go.substring(1));
        }
        int result;
        switch (c) {
            case "+":
                result = qq + qq1;
                break;
            case "-":
                result = qq - qq1;
                break;
            case "*":
                result = qq * qq1;
                break;
            case "/":
                result = qq / qq1;
                break;
            default:
                throw new NullPointerException("Неверная операция");
        }
        System.out.println(result);

    }

}
