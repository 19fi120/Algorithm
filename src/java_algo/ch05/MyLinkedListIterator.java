package java_algo.ch05;

/**
 * 単方向連結リストのイテレータ
 */
import java.util.Iterator;
import java.util.NoSuchElementException;

public class MyLinkedListIterator implements Iterator
{
    private Cell p;     

    /**
     * generate Iterator
     *
     * @param list  
     */
    public MyLinkedListIterator(MyLinkedList list)
    {
        // 着目点を設定
        p = list.header;
    }

    /**
     * @return 次の要素があればtrue、なければfalse
     */
    public boolean hasNext()
    {
        return p.next != null;
    }

    /**
     *
     * @return 次の要素が持つ値
     */
    public Object next()
    {
        // 次の要素がない	例外：NoSuchElementException
        if (p.next == null) {
            throw new NoSuchElementException();
        }

        // 次の要素
        p = p.next;
        return p.data;
    }

    /**
     * 要素を削除
     */
    public void remove()
    {
        // メソッド未実装
        // 例外：UnsupportedOperationException
        throw new UnsupportedOperationException();
    }

    /**
     * テスト用のメインルーチン
     */
    public static void main(String args[])
    {
        // 連結リストlistを作成して、要素20, 15, 18, 37, 3を追加
        MyLinkedList list = new MyLinkedList();
        list.insert(20);        
        list.insert(15);        
        list.insert(18);
        list.insert(37);        
        list.insert(3);
        System.out.println(list);

        // イテレータを利用して、すべての要素を表示
        System.out.println("----<イテレータ>--------");
        Iterator iter = list.iterator();
        int count = 1;
        while (iter.hasNext()) {
            System.out.println(count++ + "番目の数" + iter.next());
        }

        // 拡張for文(for-each文)を利用して、すべての要素を表示(Java 5以降)
        System.out.println("----<拡張for文>--------");
        count = 1;
        for (Object o: list) {
            System.out.println(count++ + "番目の数" + o);
        }
    }
}
