package java_algo.ch04;

/*
 * 逆ポーランド記法電卓
 * 演算子が最後
 * ex) 12 4 /
 * 	   5 7 2 + *    <- 5 * (7 + 2)
 */
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PushbackReader;
import java.io.StringReader;
import java.util.EmptyStackException;

public class Calculator
{
    private final MyStack stack;        

    /**
     * 逆ポーランド記法電卓を生成
     */
    public Calculator()
    {
        stack = new MyStack();          
    }

    /*
     * 逆ポーランド記法の数式の値を計算
     *
     *  @param  exp     逆ポーランド記法の数式を表す文字列
     *  @return         数式の値
     */
    public long compute(String exp) throws IOException
    {
        // スタックをクリア
        stack.clear();

        // 文字列expを１文字ずつ読み込むためのリーダーを用意
        // PushbackReaderクラスを利用して、読みすぎた文字をunreadで戻せる
        // 文字列の末尾に、式の終わりを示すセミコンロをつけていることを注意
        PushbackReader input =
                new PushbackReader(new StringReader(exp + ";"));

        // セミコンロに出会うまで、１文字読み込んで繰り返す
        int c;                  // 読み込んだ文字
        while ((c = input.read()) != ';') {
            char ch = (char)c;

            if (Character.isDigit(ch)) {        
                // 読み込んだ文字が数字であった
                // 数字が続く限り読み込んで、それを十進数として解釈
                // long値に変換。得られた値をスタックに積む
                long num = 0;
                while (Character.isDigit(ch)) {
                    num = 10 * num + (ch  - '0');
                    c = input.read();
                    ch = (char)c;
                }
                input.unread(c);    // 1文字読みすぎているので、それを戻す
                stack.push(num);
            } else {
                long a, b;      // 作業用変数
                switch (ch) {
                case '+':       // +  加算
                    b = (Long)stack.pop();
                    a = (Long)stack.pop();
                    stack.push(a + b);
                    break;
                case '-':       // -  減算
                    b = (Long)stack.pop();
                    a = (Long)stack.pop();
                    stack.push(a - b);
                    break;
                case '*':       // *  乗算
                    b = (Long)stack.pop(); 
                    a = (Long)stack.pop();
                    stack.push(a * b);
                    break;
                case '/':       // /  除算
                    b = (Long)stack.pop(); a = (Long)stack.pop();
                    stack.push(a / b);
                    break;
                case ' ':       // 空白文字。何もしないで読み飛ばす
                case '\t':
                case '\r':
                    break;
                default:        // それ以外の文字ならエラー
                    throw new IllegalArgumentException(
                                   "不正な文字" + ch + "がありました");
                }
            }
        }

        //   計算結果をスタックから取り出して返す
        if (! stack.isEmpty()) {
            return (Long)stack.pop();
        } else {
            // スタックが空の場合、式がなかったので例外をスロー
            throw new IllegalArgumentException("式がありません");
        }
    }

    /*
     * 逆ポーランド記法のメインプログラム
     * 標準入力から読み込んだ式を評価して結果を表示
     */
    public static void main(String args[]) throws IOException
    {
        // 標準入力から１行ずつ読むために、リーダーを用意
        BufferedReader input =
            new BufferedReader(new InputStreamReader(System.in));

        // 逆ポーランド記法電卓を生成
        Calculator  calculator = new Calculator();

        // 標準入力から式を１行読み込んで、電卓で値を求めて表示
        String line;
        while ((line = input.readLine()) != null) {    // 1行読み込む
            try {
                // 入力された式の値を計算して表示
                long answer = calculator.compute(line);
                System.out.println("値は " + answer + "です");
            } catch (EmptyStackException e) {
                // スタックが空の場合、メッセージ文字列がないので自前でメッセージを表示
                System.out.println("式が正しくありません");
            } catch (Exception e) {
                // それ以外の例外は例外のメッセージを表示
                System.out.println(e.getMessage());
            }
        }
    }
}
