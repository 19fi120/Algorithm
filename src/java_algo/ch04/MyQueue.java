package java_algo.ch04;

/*
 * 配列による待ち行列の実装
 */
import java.util.Arrays;
import java.util.NoSuchElementException;

public class MyQueue
{
    private Object  queue[];    
    private int  queueSize;     
    private int  front;         // 待ち行列の先頭
    private int  rear;          // 待ち行列の末尾（実際には末尾の次の要素を指す）

    // デフォルトの待ち行列の大きさ
    private static final int  DEFAULT_QUEUE_SIZE = 100;

    /**
     *待ち行列の生成
     */
    public MyQueue()
    {
        this(DEFAULT_QUEUE_SIZE);
    }

    /**
     * 待ち行列の生成
     *
     * @param size
     */
    public MyQueue(int size)
    {
        queueSize = size;
        queue = new Object[size];
        front = rear = 0;
    }

    /**
     * 次に要素の添字を求める
     *
     * @param a 現在の要素の添字
     */
    private int next(int a)
    {
        return (a + 1) % queueSize;
    }

    public void clear()
    {
        front = rear = 0;
        Arrays.fill(queue, 0, queueSize, null);  // 待ち行列をnullでクリア
    }

    /**
     * @param x  待ち行列に入れるデータ
     */
    public void enqueue(Object x)
    {
        if (next(rear) == front) {
            throw new IllegalStateException("これ以上待ち行列に要素を追加できません");
        }
        queue[rear] = x;
        rear = next(rear);
    }

    /**
     * @return  待ち行列から取り出したデータ
     */
    public Object dequeue()
    {
        if (front == rear) {
            throw new NoSuchElementException("待ち行列が空なので要素を取り出せません");
        }
        Object x = queue[front];
        queue[front] = null;            // 要素をnullでクリア
        front = next(front);
        return x;
    }

    /**
     * @return  待ち行列が空ならtrue、空でなければfalseを返す
     */
    public boolean isEmpty()
    {
        return front == rear;
    }

    /**
     * 待ち行列の内容を表す文字列を返す
     *
     * @return 待ち行列の内容を表す文字列
     */
    public String toString()
    {
        String s = "MyQueue=[";
        for (int i = front; i != rear; i = next(i)) {
            s += queue[i] + " ";
        }
        s += "] front=" + front + " rear=" + rear;
        return s;
    }

    /**
     * テスト用メインルーチン
     */
    public static void main(String args[])
    {
        MyQueue q = new MyQueue(5);

        q.enqueue("a");        
        System.out.println("aを入れた");
        q.enqueue("b");         
        System.out.println("bを入れた");
        q.enqueue("c");         
        System.out.println("cを入れた");
        System.out.println(q);
        System.out.println(q.dequeue() + "を取り出した");
        System.out.println(q.dequeue() + "を取り出した");
        System.out.println(q);
        
        q.enqueue("d");         
        System.out.println("dを入れた");
        q.enqueue("e");         
        System.out.println("eを入れた");
        System.out.println(q.dequeue() + "を取り出した");
        System.out.println(q);
        
        q.enqueue("f");         
        System.out.println("fを入れた");
        System.out.println(q.dequeue() + "を取り出した");
        System.out.println(q.dequeue() + "を取り出した");
        System.out.println(q);
        q.clear();              
        
        System.out.println("待ち行列をクリアした");
        System.out.println(q);
        q.enqueue("g");         
        System.out.println("gを入れた");
        q.enqueue("h");         
        System.out.println("hを入れた");
        System.out.println(q);
    }
}
