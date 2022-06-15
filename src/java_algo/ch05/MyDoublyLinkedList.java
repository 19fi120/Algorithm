package java_algo.ch05;

/**
 *連結リスト（双方向）
 * 常に要素（整数）が昇順
 */
import java.util.NoSuchElementException;

public class MyDoublyLinkedList
{
    final CellDouble head;    // 連結リストの頭へのリンク

    /**
     * 連結リストの生成
     * 生成される連結リストは空になっている
     */
    public MyDoublyLinkedList()
    {
    	// 連結リストの頭を割当
        head = new CellDouble("**List Head**");

        // リストの頭のprevとnextが自分自身を指すように
        head.prev = head.next = head;
    }

    /**
     *  双方向リストのセルpの直後にデータdataを昇順になるよう挿入
     *
     * @param p     このセルの直後にデータを挿入
     * @param data  挿入するデータ
     */
    private void insertAfter(CellDouble p, Object data)
    {
        CellDouble x = new CellDouble(data);
        x.prev = p;
        x.next = p.next;
        p.next.prev = x;
        p.next = x;
    }

    /**
     * 双方向リストのセルの先頭ににデータdataを挿入
     *
     * @param data  挿入するデータ
     */
    public void insertFirst(Object data)
    {
        // リストの頭の次に挿入
        insertAfter(head, data);
    }

    /**
     *双方向リストのセルの末尾ににデータdataを挿入
     *
     * @param data  挿入するデータ
     */
    public void insertLast(Object data)
    {
        // 最後の要素の次に挿入
        insertAfter(head.prev, data);
    }

    /**
     * セルの削除
     */
    private void removeCell(CellDouble p)
    {
        p.prev.next = p.next;
        p.next.prev = p.prev;
    }
    
    /**
     * 双方向リストの先頭のセルを削除
     *
     * @return 削除した要素
     * 要素がなければ	例外：NoSuchElementException
     */
    public Object removeFirst()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("双方向リストが空です");
        }

        // 最初のセルを削除し、値を返す
        CellDouble cell = head.next;
        removeCell(cell);
        return cell.data;
    }

    /**
     * 双方向リストの末尾のセルを削除
     *
     * @return 削除した要素
     * 要素がなければ	例外：NoSuchElementException
     */
    public Object removeLast()
    {
        if (isEmpty()) {
            throw new NoSuchElementException("双方向リストが空です");
        }

     // 最初のセルを削除し、値を返す
        CellDouble cell = head.prev;
        removeCell(cell);
        return cell.data;
    }

    /**
     *双方向リストが空かどうか
     *
     * @return 要素がなければtrue、あればfalse
     */
    public boolean isEmpty()
    {
        return head.next == head;
    }

    /**
     *双方向リストを表す文字列表現を返す
     *
     * @return 双方向リストを表す文字列表現
     */
    public String toString()
    {
        String s = "[";
        for (CellDouble p = head.next; p != head; p = p.next) {
            s += p.data + " ";
        }
        s += "]";
        return s;
    }

    /**
     *テスト用メインルーチン
     */
    public static void main(String args[])
    {
        MyDoublyLinkedList list = new MyDoublyLinkedList();

        // 要素を挿入
        System.out.print("初期状態（空リスト）"); 
        System.out.println(list);
        
        list.insertFirst("a");
        System.out.print("aを先頭に挿入");    
        System.out.println(list);
        
        list.insertLast("b");
        System.out.print("bを末尾に挿入");    
        System.out.println(list);
        
        list.insertFirst("c");
        System.out.print("cを先頭に挿入");    
        System.out.println(list);
        
        list.insertFirst("d");
        System.out.print("dを先頭に挿入");    
        System.out.println(list);
        
        list.insertLast("e");
        System.out.print("eを末尾に挿入");    
        System.out.println(list);

        // 要素を削除
        // 変数iを利用して、先頭と末尾から交互に要素を削除
        int  i = 0;

        while(!list.isEmpty()) {
            if (i++ % 2 == 0) {
                System.out.print(list.removeFirst() + "を先頭から取り出した");
            } else {
                System.out.print(list.removeLast() +  "を末尾から取り出した");
            }
            System.out.println(list);
        }
    }
}
