package utility;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import plant.CherryBomb;
import plant.Plant;
import zombie.Zombie;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *     <code>LawnMower</code>类实现了游戏中的除草机，此防御游戏的最后一道防线
 * </p>
 */
public class LawnMower extends Sprite{
    private boolean go = false;
    private static LawnMower LawnMower1 = new LawnMower(-15,100,1);
    private static LawnMower LawnMower2 = new LawnMower(-15,200,2);
    private static LawnMower LawnMower3 = new LawnMower(-15,290,3);
    private static LawnMower LawnMower4 = new LawnMower(-15,390,4);
    private static LawnMower LawnMower5 = new LawnMower(-15,490,5);
    private static CopyOnWriteArrayList<LawnMower> lawnMowers = new CopyOnWriteArrayList<>();

    /**
     * <p>
     *     LawnMower的私有构造器
     * </p>
     *
     * @param x 割草机的x坐标
     * @param y 割草机的y坐标
     * @param row 割草机所在列
     */
    private LawnMower(double x,double y,int row){
        this.setImage(Constant.LAWN_MOWER_IMAGE);
        this.setPosition(x,y);
        this.row = row;
    };


    /**
     * <p>
     *     更新<code>LawnMower</code>对象的属性及状态，比如更新图片坐标。
     * </p>
     * <p>
     *     此方法也把<code>Plant</code>对象渲染到屏幕上。
     * </p>
     *
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    public void update(long time, GraphicsContext context) {
        for(Zombie zombie:Game.zombieList){
            if(this.row == zombie.row && this.isOverlapped(zombie)){
                go=true;
            }
        }
        if(go == true){
            this.positionX += 2.5;
        }
        if(this.positionX>=800){
            Game.lawnMowers.remove(this);
        }
        this.render(context);
    }

    public static CopyOnWriteArrayList<LawnMower> initialize(){
        lawnMowers.add(LawnMower1);
        lawnMowers.add(LawnMower2);
        lawnMowers.add(LawnMower3);
        lawnMowers.add(LawnMower4);
        lawnMowers.add(LawnMower5);
        return lawnMowers;
    }
}
