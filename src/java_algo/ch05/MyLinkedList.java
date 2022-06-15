package java_algo.ch05;

/**
 * 連結リスト（単方向）
 * 常に要素（整数）が昇順
 */
public class MyLinkedList implements Iterable
{
    final Cell header;        // 連結リストの頭へのリンク

    /**
     * 連結リストの生成
     * 生成される連結リストは空になっている
     */
    public MyLinkedList()
    {
        header = new Cell("**List Head**");     // 連結リストの頭の生成
    }

    /**
     * 昇順になるよう挿入
     *
     * @param num  挿入する要素（整数）
     */
    public void insert(int num)
    {
        // 挿入すべき場所を探す
        Cell p = header.next;
        Cell q = header;
        while (p != null && num > (Integer)p.data) {  // オートアンボクシング
        											  //ラッパークラスからプリミティブ型への変換
        											  //<==> オートボクシング（オートアンボクシングの逆）
            q = p;
            p = p.next;
        }

        // セルを挿入
        Cell newCell = new Cell(num);                 // オートアンボクシング
        newCell.next = p;
        q.next = newCell;
    }

    /**
     * イテレータを得る
     *
     * @return 連結リストに対するイテレータ
     */
    public MyLinkedListIterator iterator()
    {
        return new MyLinkedListIterator(this);
    }

    /**
     * 連結リストを表す文字列を返す
     *
     * @return 連結リストを表す文字列
     */
    public String toString()
    {
        String s = "[";
        for (Cell p = header.next; p != null; p = p.next) {
            s += p.data + " ";
        }
        s += "]";
        return s;
    }

    /**
     * テスト用メインルーチン
     */
    public static void main(String args[])
    {
        MyLinkedList list = new MyLinkedList();

        System.out.println(list);
        list.insert(5);         
        System.out.println(list);
        list.insert(7);         
        System.out.println(list);
        list.insert(2);         
        System.out.println(list);
        list.insert(12);        
        System.out.println(list);
        list.insert(4);         
        System.out.println(list);
    }
}
