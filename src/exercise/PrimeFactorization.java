package exercise;

import java.util.Scanner;

public class PrimeFactorization {

	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num;
        
        System.out.println("素因数分解");

        while (true) {
            System.out.print("2以上の整数を入力してください。：");
            num = sc.nextInt();

            if (num < 2) {
                System.out.println("2よりも小さい整数です。");
            } else
                break;
        }

        int x = num;
        System.out.print(num + " = ");

        for (int i = 2;i <= num;) {
            if (x % i == 0) { // 最小の因数を求める 
                System.out.print(i);
                if (x != i)
                    System.out.print(" * "); // xと因数が同値になったら＊の挿入をやめる
                x /= i; // 最小の因数で割った数を代入する
            } else
                i++;
        }
    }
}
