package plant;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import utility.Constant;
import zombie.Zombie;

/**
 * <p>
 *     <code>PotatoMine</code>类为植物<code>PotatoMine</code>的具体实现类。
 * </p>
 */
public class PotatoMine extends Plant {
    /**
     * 是否已经准备好攻击了
     */
    public boolean isReady = false;
    /**
     * 是否已被使用
     */
    public boolean isUsed = false;

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>PotatoMine</code>对象。
     * </p>
     * <p>
     *     创建<code>PotatoMine</code>对象时，会对<code>PotatoMine</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>PotatoMine</code>所在的格子编号
     * @see Plant
     */
    public PotatoMine(int tileNumber) {
        super(tileNumber);
        sunCost = Constant.POTATO_MINE_SUNCOST;
        health = Constant.POTATO_MINE_HEALTH;
        damage = Constant.POTATO_MINE_INITIALIZE_DAMAGE;
        attackSpeed = Constant.POTATO_MINE_ATTACK_SPEED;
        cooldownTime = Constant.POTATO_MINE_COOLDOWN_TIME;
        firstPurchaseNoCooldown = true;
        setImage("/resources/Plants/PotatoMine/PotatoMineInit/PotatoMineInit_0.png");
        setVelocity(0, 0);
        setPosition(positionX - 3, positionY + 15);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>PotatoMine</code>对象。
     * </p>
     * <p>
     *     创建<code>PotatoMine</code>对象时，会对<code>PotatoMine</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>PotatoMine</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     * @see Plant
     */
    public PotatoMine(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/resources/Plants/PotatoMine/PotatoMineInit/PotatoMineInit_0.png", width, height);
    }

    /**
     * <p>
     *     <code>PotatoMine</code>攻击准备好后执行的方法。
     * </p>
     * <p>
     *     <code>PotatoMine</code>会从草地下冒出来。
     * </p>
     */
    public void potatoMineReady() {
        setImage("/resources/Plants/PotatoMine/PotatoMine/PotatoMine_0.png");
        damage = Constant.POTATO_MINE_READY_DAMAGE;
        setPosition(positionX - 3, positionY + 7);
    }
    /**
     * <p>
     *     <code>PotatoMine</code>攻击准备好后执行的重载方法。
     * </p>
     * <p>
     *     <code>PotatoMine</code>会从草地下冒出来。
     * </p>
     *
     * @see #potatoMineReady
     */
    public void potatoMineReady(double width, double height) {
        setImage("/resources/Plants/PotatoMine/PotatoMine/PotatoMine_0.png", width, height);
        damage = Constant.POTATO_MINE_READY_DAMAGE;
        setPosition(positionX, positionY - 5);
    }

    /**
     * <p>
     *     更新<code>PotatoMine</code>对象的属性及状态，也对<code>PotatoMine</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>PotatoMine</code>对象渲染到屏幕上。
     *     要是僵尸被攻击后，则僵尸的血量会对应的减少。
     *     <code>PotatoMine</code>的有效攻击范围为自己所在的格子。
     *     <code>PotatoMine</code>只有在攻击准备好，从草地下冒出来后，才能攻击，攻击完就会消失。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        elapsedTime = System.currentTimeMillis() - recordedTime;
        if (elapsedTime >= attackSpeed * 1000 && !isReady) {
            potatoMineReady();
            isReady = true;
        }

        if (isReady) {
            for (Zombie zombie : Game.zombieList) {
                if (this.isOverlapped(zombie)) {
                    zombie.health -= damage;
                    isUsed = true;
                }
            }
        }

        if (health <= 0 || isUsed) {
            Game.plantList.remove(this);
            Game.tileHasPlant.remove(tile);
        }

        this.render(context);
    }
}
