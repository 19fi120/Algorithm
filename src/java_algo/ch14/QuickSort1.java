package java_algo.ch14;

/**
 * クイックソート計算量:オーダーO(n_log n)
 */
class QuickSort1
{
    /*
     * 配列a[1]～a[r]を分割
     * 枢軸（ピボット）の添字をを返す
     */
    private static int partition(int[] a, int l, int r)
    {
        // ポインタiとjを初期化
        int i = l - 1;
        int j = r;

        // 右端の要素を枢軸(pivot)にする
        int pivot = a[r];

        // ポインタiとjがぶつかるまで繰り返す
        while (true) {
            // ポインタiを右にすすめる
            while (a[++i] < pivot)
                ;
            // ポインタjを左にすすめる
            while (i < --j && pivot < a[j])
                ;
            // ポインタiとjがぶつかったらループを抜ける
            if (i >= j)
                break;
            // iの指す要素とjの指す要素を交換
            int temp = a[i];
            a[i]     = a[j];
            a[j]     = temp;
        }
        // a[i]と枢軸(pivot)を交換
        int temp = a[i];
        a[i]     = a[r];
        a[r]     = temp;
        return i;
    }

    /*
     * 実際にクイックソートを行う
     *配列aのうちa[l]～a[r]を整列
     */
    private static void quickSort(int[] a, int l, int r)
    {
        // 整列する要素が1つなら、何もしないで戻る
        if (l >= r)
            return;

        // 枢軸(pivot)vを基準に分割
        int v = partition(a, l, r);

        // 左の部分配列a[l]～a[v-1]を整列
        quickSort(a, l, v - 1);

        // 右の部分配列a[v+1]～a[r]を整列
        quickSort(a, v + 1, r);
    }

    /*
     * クイックソートによって配列を整列
     * 
     * @param a   整列する配列
     */
    public static void sort(int[] a)
    {
        quickSort(a, 0, a.length - 1);
    }
}
