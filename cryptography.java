import java.util.Scanner;
import java.util.Random;

class cryptography {

    static String process(String text, int password, int mode) {
        
        Random rand = new Random(password);

        char[] chars = text.toCharArray();
        
        for (int i = 0; i < chars.length; i++) {
            int shift = rand.nextInt(10); 

            if (mode == 1) {
                // 暗号化：乱数分だけ足す
                chars[i] = (char)(chars[i] + shift);
            } else {
                // 復号：同じ乱数分だけ引く
                chars[i] = (char)(chars[i] - shift);
            }
        }
        
        return new String(chars);
    }

    public static void main(String[] args) {
        Scanner stdin = new Scanner(System.in);

        System.out.print("[1] 暗号化 (隠す)  [2] 復号 (戻す) : ");
        int select = stdin.nextInt();
        stdin.nextLine();

        System.out.println("メッセージを入力してください:");
        String message = stdin.nextLine();

        System.out.print("パスワード（数字）を決めてください: ");
        int pass = stdin.nextInt();

        // 実行
        if (select == 1) {
            String result = process(message, pass, 1);
            System.out.println("生成された暗号文");
            System.out.println(result);
                    
        } else if (select == 2) {
            String result = process(message, pass, 2);
            System.out.println("解読されたメッセージ");
            System.out.println(result);
        }
    }
}