package java_algo.ch15;

/**
 * 連結リストのセル
 */
class Cell
{
    Cell   next;        // 次のセルへのリンク
    int    data;        // このセルが持つデータ

    /**
     * セルを生成
     *
     * @param data  このセルが持つデータ
     */
    Cell(int data)
    {
        next      = null;
        this.data = data;
    }
}
