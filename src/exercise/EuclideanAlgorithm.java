package exercise;

import java.io.BufferedReader;
import java.io.InputStreamReader;

//入力
//962 388
public class EuclideanAlgorithm {
	
	public static void main(String[] args) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
            String[] str = bufferedReader.readLine().split(" ");
            int x = Integer.parseInt(str[0]);
            int y = Integer.parseInt(str[1]);

            System.out.println(getCommonDivisor(x, y));

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    private static int getCommonDivisor(int x, int y) {
        int biggerNum = Math.max(x, y);
        int smallerNum = Math.min(x, y);

        // 大きい方から小さい方を割った余を求める
        int surplus = biggerNum % smallerNum;

        // 割り切れていれば、それを返す
        if (surplus == 0) {
            return smallerNum;
        }
        // 割り切れなければ再帰的に自信を呼び出す
        surplus = getCommonDivisor(smallerNum, surplus);

        return surplus;
    }
}
