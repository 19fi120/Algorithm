package java_algo.ch03;

/*
 * 配列によるスタック実装（ジェネリック型）
 */
import java.util.Arrays;
import java.util.EmptyStackException;

//ジェネリック型
public class GenericStack<E>                                    // E(element), T(type), K(key), V(value)
{
    private E  stack[];         // スタック本体                 // @@@
    private int  stackSize;     
    private int  sp;            // スタックのポインタ

    private static final int  DEFAULT_STACK_SIZE = 100; 

    public GenericStack()                                       // @@@
    {
        this(DEFAULT_STACK_SIZE);
    }

    /**
     * @param size 
     */
    @SuppressWarnings("unchecked")                              // @@@ Added
    public GenericStack(int size)                               // @@@
    {
        // 配列stackには、pushメソッドによってEクラス           // @@@ Added
        // @SuppressWarnings("unchecked")によってキャストは安全                                       // @@@ Added
        stack = (E[]) new Object[size];                         // @@@
        stackSize = size;
        sp = 0;
    }

    public void clear()
    {
        Arrays.fill(stack, 0, sp, null);   // スタックをnullでクリア
        sp = 0;                            // スタックポインタを０に
    }

    public void push(E x)                                       // @@@
    {
        if (sp >= stackSize) {
            throw new IllegalStateException("Stack overflow");
        }
        stack[sp++] = x;
    }

    public E pop()                                              // @@@
    {
        if (sp <= 0) {
            throw new EmptyStackException();
        }
        E  value = stack[--sp];                                 // @@@
        stack[sp] = null;               // 空いた要素をnullでクリア
        return value;
    }

    public boolean isEmpty()
    {
        return sp == 0;
    }

    /*
     * スタックの内容を表す文字列を返す
     *
     * @return スタックの内容を表す文字列
     */
    public String toString()
    {
        String s = "GenericStack=[";                            // @@@
        for (int i = 0; i < sp; i++) {
            s = s + stack[i];
            if (i < sp - 1)
                s = s + ",";
        }
        s = s + "]";
        return s;
    }
}
