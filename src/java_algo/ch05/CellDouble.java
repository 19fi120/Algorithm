package java_algo.ch05;

/**
 * 双方向リストのセル
 */
class CellDouble
{
    CellDouble   prev;  
    CellDouble   next;  
    Object       data;  

    /**
     * セルを生成
     *
     * @param data  
     */
    CellDouble(Object data)
    {
        prev = next = null;
        this.data   = data;
    }
}
