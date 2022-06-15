package java_algo.ch15;

/**
 * 配列版マージソート計算量:オーダーO(n_log n)
 */
class MergeSortArray
{
    /* 
     * 作業用配列
     *  外部整列
     */
    private static int[] b;

    /*
     * 配列をマージソートする
     * a[low]～a[high]の要素を整列
     *
     * @param a    整列すべき配列
     * @param low  配列する範囲の下限
     * @param high 配列する範囲の上限
     */
    private static void mergeSortArray(int[] a, int low, int high)
    {
        // もし要素が1つしかなければ、即座に戻る
        if (low >= high) {
            return;
        }

        // 列を2つの分割する場所midを決める
        int mid = (low + high) / 2;

        // 前半の要素a[low]～a[mid]を整列
        mergeSortArray(a, low, mid);

        // 後半の要素a[mid+1]～a[high]を整列
        mergeSortArray(a, mid + 1, high);

        // 前半の要素をそのまま作業用配列bにコピーする
        System.arraycopy(a, low, b, low, mid - low + 1);

        // 後半の要素を逆順に作業用配列bにコピーする
        for (int i = mid + 1, j = high; i <= high; i++, j--) {
            b[i] = a[j];
        }

        // 作業用配列bの両端から取り出したデータをマージして配列aに入れる
        int i = low;
        int j = high;
        for (int k = low; k <= high; k++) {
            if (b[i] <= b[j]) {
                a[k] = b[i++];
            } else {
                a[k] = b[j--];
            }
        }
    }

    /*
     * マージソートによって配列を整列
     * 
     * @param a   整列する配列
     */
    public static void sort(int[] a)
    {

        b = new int[a.length];                  // 作業用配列を確保

        mergeSortArray(a, 0, a.length - 1);     // 配列aをマージソートする

        b = null;                               // 作業用配列を解放する
    }
}
