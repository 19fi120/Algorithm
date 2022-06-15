package java_algo.ch05;

/**
 * 連結リスト（単方向）のセル
 */
class Cell
{
    Cell   next;        // 次のセルへのリンク
    Object data;        

    /**
     *セルを生成
     *
     * @param data  
     */
    Cell(Object data)
    {
        next      = null;
        this.data = data;
    }
}
