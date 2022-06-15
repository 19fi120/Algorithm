package java_algo.ch08;

/**
 * ハッシュ表で使うキー
 */
public class MyKey
{
    String str;         // キーとなる文字列

    /**
     * キーを生成
     *
     * @param s  キーとなる文字列
     */
    public MyKey(String s)
    {
        str = s;
    }

    /***
     * キーを比較する
     *
     * @param  o 比較するキー
     * @return このキーとキーoが等しければtrue、等しくなければfalse
     */
    public boolean equals(Object o)
    {
        // パラメータoがMyKeyオブジェクトか確認する
        if (! (o instanceof MyKey)) {
            return false;
        }
        // パラメータoをMyKey型にキャストして、内容を比較する
        MyKey k = (MyKey)o;
        return str.equals(k.str);
    }

    /***
     * キーのハッシュ値を返す
     *
     * @return キーのハッシュ値
     */
    public int hashCode()
    {
        int sum = 0;

        // 文字列に含まれるすべての文字のコードの和を求める
        for (int i = 0; i < str.length(); i++) {
            sum += (int)str.charAt(i);
        }
        return sum;
    }

    /**
     *キーの文字列表現を返す
     *
     * @return キーの文字列表現
     */
    public String toString()
    {
        return str;
    }
}
