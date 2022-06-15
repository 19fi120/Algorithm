package java_algo.ch08;

/**
 * チェイン法によるハッシュ表
 */
public class HashC
{
    /**
     * 連結リストのセル
     */
    private static class Cell
    {
        MyKey  key;     // キー
        Object data;    
        Cell   next;    

        /**
         * セルを生成
         *
         * @param key  キー
         * @param data データ
         */
        private Cell(MyKey key, Object data)
        {
            this.key  = key;
            this.data = data;
        }
    }

    Cell[] table;       // ハッシュ法の実体
    int    bucketSize;  // バケットの個数
    int    nElements;   // 登録されているデータの個数

    // デフォルトのハッシュ表の大きさ
    static final int  DEFAULT_BUCKET_SIZE = 50;

    /**
     * ハッシュ表を生成
     */
    public HashC()
    {
        this(DEFAULT_BUCKET_SIZE);
    }

    /**
     * ハッシュ表を生成
     *
     * @param bucketSize  ハッシュ表の大きさ
     */
    public HashC(int bucketSize)
    {
        // ハッシュ表の実体の配列を割り当てる
        table = new Cell[bucketSize];

        // ハッシュ表のバケットの個数を記録しておく
        this.bucketSize = bucketSize;

        // 要素の個数を0にする
        nElements = 0;
    }

    /**
     *	ハッシュ関数を求める
     * キーとなるオブジェクトのhashCodeメソッドが返した値を、バケットの個数で割った余りを返す
     *
     * @param key  キー
     * @return 与えられたキーに対するハッシュ値
     */
    private int hash(MyKey key)
    {
        return key.hashCode() % bucketSize;
    }

    /**
     * ハッシュ表を探索する
     *
     * @param key  探すべきキー
     * @return データが見つかればそれを返す
     *          見つかれなければnullを返す
     */
    public Object find(MyKey key)
    {
        for (Cell p = table[hash(key)]; p != null; p = p.next) {
            if (key.equals(p.key)) {
                return p.data;
            }
        }
        return null;
    }

    /**
     * ハッシュ表にデータを挿入
     *
     * @param  key  キー
     * @param  data 登録するデータ
     * @return 登録に成功すればtrue,失敗すればfalseを返す
     */
    public boolean insert(MyKey key, Object data)
    {
        if (find(key) != null) {
            return false;
        }
        Cell p = new Cell(key, data);
        int  h = hash(key);
        p.next = table[h];
        table[h] = p;

        nElements++;    // 要素の個数を１つ増やす
        return true;
    }

    /**
     * ハッシュ表からデータが削除
     *
     * @param key  削除すべきデータのキー
     * @return 削除に成功したらtrue、データが見つからなければfalseを返す
     */
    public boolean delete(MyKey key)
    {
        int  h = hash(key);

        // そのバケットは空か？
        if (table[h] == null) {
            return false;
        }

        // リストの先頭のセルが削除すべきデータか？
        if (key.equals(table[h].key)) {
            Cell p = table[h];
            table[h] = p.next;
            nElements--;        // 要素の個数を１つ減らす
            return true;
        }

        // リストの２番目以降のセルについて順番をチェックする
        Cell p;
        Cell q;
        for (q = table[h], p = q.next; p != null; q = p, p = p.next) {
            if (key.equals(p.key)) {
                q.next = p.next;
                nElements--;    // 要素の個数を１つ減らす
                return true;
            }
        }
        return false;
    }

    /**
     * ハッシュ表の内容を表す文字列を返す
     *
     * @return ハッシュ表の内容を表す文字列
     */
    public String toString()
    {
        String s = "";

        // すべてのバケットを順に処理する
        for (int i = 0; i < table.length; i++) {
            s += "バケット" + i + ":";

            // このバケットの内容を文字列sに追加する
            for (Cell p = table[i]; p != null; p = p.next) {
                s += "[" + p.key + ":" + p.data + "] ";
            }
            s += "\n";
        }
        // 最後に登録されている要素の個数を追加する
        s += "要素の個数" + nElements + "\n";
        return s;
    }
}
