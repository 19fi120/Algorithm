package java_algo.ch12;

/**
 * 挿入ソート計算量:オーダーO(n^2)
 */
class InsertionSort
{
    /*
     * 挿入ソートによって配列を整列
     * 
     * @param a   整列する配列
     */
    public static void sort(int[] a)
    {
        int  n = a.length;      // 配列の要素数

        for (int i = 1; i < n; i++) {
            int j = i;
            while (j >= 1 && a[j - 1] > a[j]) {
                int temp = a[j];
                a[j]     = a[j - 1];
                a[j - 1] = temp;
                j--;
            }
        }
    }
}
