package plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;
import utility.Constant;
import zombie.Zombie;

/**
 * <p>
 *     <code>CherryBomb</code>类为植物<code>CherryBomb</code>的具体实现类。
 * </p>
 */
public class CherryBomb extends Plant {
    /**
     * 是否已被使用
     */
    public boolean isUsed = false;

    public final Image CHERRY_BOMB_IMAGE_1 = createImage("/resources/Plants/CherryBomb/CherryBomb_0.png");
    public final Image CHERRY_BOMB_IMAGE_2 = createImage("/resources/Plants/CherryBomb/CherryBomb_1.png");
    public final Image CHERRY_BOMB_IMAGE_3 = createImage("/resources/Plants/CherryBomb/CherryBomb_2.png");
    public final Image CHERRY_BOMB_IMAGE_4 = createImage("/resources/Plants/CherryBomb/CherryBomb_3.png");
    public final Image CHERRY_BOMB_IMAGE_5 = createImage("/resources/Plants/CherryBomb/CherryBomb_4.png");
    public final Image CHERRY_BOMB_IMAGE_6 = createImage("/resources/Plants/CherryBomb/CherryBomb_5.png");
    public final Image CHERRY_BOMB_IMAGE_7 = createImage("/resources/Plants/CherryBomb/CherryBomb_6.png");
    public final Image[] CHERRY_BOMB_IMAGE = {
            CHERRY_BOMB_IMAGE_1, CHERRY_BOMB_IMAGE_2, CHERRY_BOMB_IMAGE_3, CHERRY_BOMB_IMAGE_4, CHERRY_BOMB_IMAGE_5, CHERRY_BOMB_IMAGE_6,
            CHERRY_BOMB_IMAGE_7
    };

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>CherryBomb</code>对象。
     * </p>
     * <p>
     *     创建<code>CherryBomb</code>对象时，会对<code>CherryBomb</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>CherryBomb</code>所在的格子编号
     * @see Plant
     */
    public CherryBomb(int tileNumber) {
        super(tileNumber);
        sunCost = Constant.CHERRY_BOMB_SUNCOST;
        health = Constant.CHERRY_BOMB_HEALTH;
        damage = Constant.CHERRY_BOMB_DAMAGE;
        attackSpeed = Constant.CHERRY_BOMB_ATTACK_SPEED;
        cooldownTime = Constant.CHERRY_BOMB_COOLDOWN_TIME;
        firstPurchaseNoCooldown = false;
        setImage(CHERRY_BOMB_IMAGE[0]);
        setVelocity(0, 0);
        setPosition(positionX - 12, positionY - 5);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>CherryBomb</code>对象。
     * </p>
     * <p>
     *     创建<code>CherryBomb</code>对象时，会对<code>CherryBomb</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>CherryBomb</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     */
    public CherryBomb(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/resources/Plants/CherryBomb/CherryBomb_0.png", width, height);
    }

    /**
     * <p>
     *     更新<code>CherryBomb</code>对象的属性及状态，也对<code>CherryBomb</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>CherryBomb</code>对象渲染到屏幕上。
     *     要是僵尸被攻击后，则僵尸的血量会对应的减少。
     *     <code>CherryBomb</code>的有效伤害范围为以自己为中心的3*3的范围。
     *     <code>CherryBomb</code>在攻击后就会消失。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     * @see Plant
     *
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int i = (int) ((System.currentTimeMillis() - createdTime) / (1000 / 7) % CHERRY_BOMB_IMAGE.length);
        setImage(CHERRY_BOMB_IMAGE[i]);

        elapsedTime = System.currentTimeMillis() - recordedTime;

        if (elapsedTime >= attackSpeed * 1000) {
            for (Zombie zombie : Game.zombieList) {
                int tile = Constant.getTile(zombie.positionX + zombie.width / 2, zombie.positionY + zombie.height / 2);

                if (this.row == zombie.row) {
                    if (tile == this.tile || tile + 1 == this.tile || tile - 1 == this.tile) {
                        zombie.health -= damage;
                    }
                } else {
                    if (tile - 9 == this.tile || tile + 9 == this.tile || tile + 8 == this.tile ||
                            tile - 8 == this.tile || tile + 10 == this.tile || tile - 10 == this.tile) {
                        zombie.health -= damage;
                    }
                }
            }
            isUsed = true;
        }

        if (health <= 0 || isUsed) {
            Game.plantList.remove(this);
            Game.tileHasPlant.remove(tile);
        }

        this.render(context);
    }
}
