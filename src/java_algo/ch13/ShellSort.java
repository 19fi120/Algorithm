package java_algo.ch13;

/**
 * シェルソート計算量:オーダーO(n^1.5)
 * 挿入ソートを変形
 */
class ShellSort
{
    /*
     * シェルソートによって配列を整列
     * 
     * @param a   整列する配列
     */
    public static void sort(int[] a)
    {
        int  n = a.length;      // 配列の要素数
        int  h;					//h-ソート	3倍して1加えると丁度いい
        						// n / 9 を超えると手間がかかり、損

        for (h = 1; h < n / 9; h = h * 3 + 1)	//h-ソートを設定
            ;

        for (; h > 0; h /= 3) {
            for (int i = h; i < n; i++) {
                int j = i;
                while (j >= h && a[j - h] > a[j]) {
                    int temp = a[j];
                    a[j]     = a[j - h];
                    a[j - h] = temp;
                    j -= h;
                }
            }
        }
    }
}
