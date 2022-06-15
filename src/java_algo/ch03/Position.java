package java_algo.ch03;

/**
 * 位置
 */
public class Position
{
    private int x;      // X座標
    private int y;      // Y座標

    /*
     * 位置を生成
     * @param x
     * @param y
     */
    public Position(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    /*
     *
     * @param xDelta
     */
    public void moveX(int xDelta)
    {
        x += xDelta;
    }

    /*
     * @param yDelta
     */
    public void moveY(int yDelta)
    {
        y += yDelta;
    }

    /*
     * @param xDelta
     * @param yDelta
     */
    public void moveXY(int xDelta, int yDelta)
    {
        x += xDelta;
        y += yDelta;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    /*
     * 位置を表す文字列を返す
     * @return  位置を表す文字列
     */
    public String toString()
    {
        return "(" + x + ", " + y + ")";
    }

    /*
     * 位置が等しいかどうかを調べる
     *
     * @param o   比較対象の位置
     * @return    等しければtrue、等しくなければfalseを返す
     */
    public boolean equals(Object o)
    {
        // パラメータoをPosition型にキャスト
        // Positionクラスでなければ、falseを返す
        if (! (o instanceof Position)) {
            return false;
        }

        // パラメータoをPosition型にキャスト
        // 各フィールドの内容を比較
        Position  pos = (Position)o;
        return this.x == pos.x && this.y == pos.y;
    }

    /*
     * equalsメソッドを定義した場合必ずhashCodeメソッドも定義しなければならない
     * ハッシュ値を求める
     *
     * @return    このオブジェクトのハッシュ値を返す
     */
    public int hashCode()
    {
        int result = 17;
        result = result * 31 + x;
        result = result * 31 + y;
        return result;
    }
}
