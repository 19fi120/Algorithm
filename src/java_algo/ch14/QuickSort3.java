package java_algo.ch14;

/**
 * クイックソート計算量:オーダーO(n_log n)
 * 番兵(sentinel):条件aを成立させる要素bをあらかじめ配列の最後に入れておく
 */
class QuickSort3
{
    /*
     * クイックソート(菲再帰)：スタックオーバーフロー対策済み
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
     * クイックソートによって配列を整列
     * 
     * @param a   整列する配列
     */
    public static void sort(int[] a)
    {
        int n = a.length;
        int[] low  = new int[30];
        int[]  high= new int[30];
        int sp;

        // スタックを初期化
        low[0]  = 0;
        high[0] = n - 1;
        sp = 1;

        // スタックが空になるまで繰り返す
        while (sp > 0) {
            // スタックから、整列する範囲を取り出す
            int l = low[--sp];
            int r = high[sp];

         // 整列する要素が1つなら、なにもしない(再びwhile文を実行する)
            if (l >= r) {
                // 何もしない
            } else {
                // 枢軸（pivot）vを基準に分割
                int v = partition(a, l, r);
                
                // 左右の部分配列のうち、短い方を先に処理
                if (v - l < r - v) {
                    // 左部分配列を先に整列(スタックなので、「左右」の順に積むことに注意)
                    low[sp]    = v + 1;
                    high[sp++] = r;
                    low[sp]    = l;
                    high[sp++] = v - 1;
                } else {
                    // 右部分配列を先に整列(スタックなので、「左右」の順に積むことに注意)
                    low[sp]    = l;
                    high[sp++] = v - 1;
                    low[sp]    = v + 1;
                    high[sp++] = r;
                }
            }
        }
    }
}
