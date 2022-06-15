package java_algo.ch03;

//makeClone
//Robot robita = new Robot(new Position(10, 20), "ロビタ");


/**
 * ロボット
 */
public class Robot
{
    private Position position;
    private String   name;

    /*
     * ロボットを生成
     * @param position  
     * @param name      
     */
    public Robot(Position position, String name)
    {
        this.position = position;
        this.name     = name;
    }

    public void moveX(int xDelta)
    {
        position.moveX(xDelta);
    }

    public void moveY(int yDelta)
    {
        position.moveY(yDelta);
    }

    public void moveXY(int xDelta, int yDelta)
    {
        position.moveXY(xDelta, yDelta);
    }

    public String getName()
    {
        return name;
    }

    public Position getPosition()
    {
        return position;
    }

    /*
     * ロボットの情報を表す文字列を返す
     * @return   ロボットの情報を表す文字列
     */
    public String toString()
    {
        return "name:" + name + " position:" + position;
    }
}
