package plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import utility.Constant;
import utility.Sprite;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * <p>
 *     <code>Plant</code>类为每个具体的植物的父类。
 * </p>
 * <p>
 *     成员变量与植物的各个属性有关，比如植物的生命值和攻速等。方法与植物的状态的更新及显示有关。
 * </p>
 */
public class Plant extends Sprite {
    /**
     * 植物的生命值
     */
    public double health;
    /**
     * 植物所在格子编号
     */
    public int tile;
    /**
     * 植物一次攻击所造成的伤害
     */
    public double damage;
    /**
     * 植物的攻速
     */
    public double attackSpeed;
    /**
     * 购买植物所需的太阳数值
     */
    public double sunCost;
    /**
     * 植物的购买冷却时间
     */
    public double cooldownTime;
    /**
     * 植物记录的时间，配合<code>elapsedTime</code>实现植物的攻击判定
     */
    public long recordedTime;
    /**
     * 植物记录的时间，配合<code>recordedTime</code>实现植物的攻击判定
     */
    public long elapsedTime;
    /**
     * 植物被创建出来时的时间
     */
    public long createdTime;
    /**
     * 第一次购买植物是否无购买冷却时间
     */
    public boolean firstPurchaseNoCooldown;
    /**
     * 植物是否能在被种下的瞬间就开始第一次攻击
     */
    public boolean firstAttackNoCooldown;
    /**
     * 植物的子弹集合
     */
    public CopyOnWriteArrayList<Sprite> bulletList = new CopyOnWriteArrayList<>();

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>Plant</code>对象。
     * </p>
     * <p>
     *     创建<code>Plant</code>对象时，会对<code>Plant</code>的一些成员变量对应地进行初始化，<code>Game.tileHasPlant</code>集合也会加上这个格子编号。
     * </p>
     * @param tileNumber 欲种下的植物所在的格子编号
     */
    public Plant(int tileNumber) {
        elapsedTime = 0;
        recordedTime = System.currentTimeMillis();
        createdTime = System.currentTimeMillis();
        Game.tileHasPlant.add(tileNumber);
        tile = tileNumber;
        setPosition(Constant.newPlantPosition[tileNumber][0], Constant.newPlantPosition[tileNumber][1]);

        switch (tileNumber) {
            case 1, 2, 3, 4, 5, 6, 7, 8, 9 -> row = 1;
            case 10, 11, 12, 13, 14, 15, 16, 17, 18 -> row = 2;
            case 19, 20, 21, 22, 23, 24, 25, 26, 27 -> row = 3;
            case 28, 29, 30, 31, 32, 33, 34, 35, 36 -> row = 4;
            case 37, 38, 39, 40, 41, 42, 43, 44, 45 -> row = 5;
            default -> row = 0;
        }
    }

    /**
     * <p>
     *     更新<code>Plant</code>对象的属性及状态，比如更新图片坐标。
     * </p>
     * <p>
     *     此方法也把<code>Plant</code>对象渲染到屏幕上。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        this.render(context);
    }

    /**
     * <p>
     *     此方法用来更新植物购买栏中各个植物的购买冷却时间的显示。
     * </p>
     * <p>
     *     购买冷却时间的显示通过改变显示出来的半透明黑色长方形的长度来实现。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    public void updatePlantChosen(long time, GraphicsContext context) {
        elapsedTime = System.currentTimeMillis() - recordedTime;
        double cooldownPercentage = (elapsedTime / (cooldownTime * 10)) > 100 ? 100 : (elapsedTime / (cooldownTime * 10));

        context.setFill(new Color(0.0F, 0.0F, 0.0F, 0.4F));
        context.fillRect(Constant.newPlantPosition[tile][0], Constant.newPlantPosition[tile][1], 48, 68 - 68 * cooldownPercentage / 100);
    }
}
