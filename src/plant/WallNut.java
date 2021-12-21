package plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;
import utility.Constant;

/**
 * <p>
 *     <code>WallNut</code>类为植物<code>WallNut</code>的具体实现类。
 * </p>
 */
public class WallNut extends Plant {
    public final Image WALLNUT_IMAGE_1 = createImage("/resources/Plants/WallNut/WallNut/WallNut_0.png");
    public final Image WALLNUT_IMAGE_2 = createImage("/resources/Plants/WallNut/WallNut/WallNut_1.png");
    public final Image WALLNUT_IMAGE_3 = createImage("/resources/Plants/WallNut/WallNut/WallNut_2.png");
    public final Image WALLNUT_IMAGE_4 = createImage("/resources/Plants/WallNut/WallNut/WallNut_3.png");
    public final Image WALLNUT_IMAGE_5 = createImage("/resources/Plants/WallNut/WallNut/WallNut_4.png");
    public final Image WALLNUT_IMAGE_6 = createImage("/resources/Plants/WallNut/WallNut/WallNut_5.png");
    public final Image WALLNUT_IMAGE_7 = createImage("/resources/Plants/WallNut/WallNut/WallNut_6.png");
    public final Image WALLNUT_IMAGE_8 = createImage("/resources/Plants/WallNut/WallNut/WallNut_7.png");
    public final Image WALLNUT_IMAGE_9 = createImage("/resources/Plants/WallNut/WallNut/WallNut_8.png");
    public final Image WALLNUT_IMAGE_10 = createImage("/resources/Plants/WallNut/WallNut/WallNut_9.png");
    public final Image WALLNUT_IMAGE_11 = createImage("/resources/Plants/WallNut/WallNut/WallNut_10.png");
    public final Image WALLNUT_IMAGE_12 = createImage("/resources/Plants/WallNut/WallNut/WallNut_11.png");
    public final Image WALLNUT_IMAGE_13 = createImage("/resources/Plants/WallNut/WallNut/WallNut_12.png");
    public final Image WALLNUT_IMAGE_14 = createImage("/resources/Plants/WallNut/WallNut/WallNut_13.png");
    public final Image WALLNUT_IMAGE_15 = createImage("/resources/Plants/WallNut/WallNut/WallNut_14.png");
    public final Image WALLNUT_IMAGE_16 = createImage("/resources/Plants/WallNut/WallNut/WallNut_15.png");
    public final Image[] WALLNUT_IMAGE = {
            WALLNUT_IMAGE_1, WALLNUT_IMAGE_2, WALLNUT_IMAGE_3, WALLNUT_IMAGE_4, WALLNUT_IMAGE_5, WALLNUT_IMAGE_6,
            WALLNUT_IMAGE_7, WALLNUT_IMAGE_8, WALLNUT_IMAGE_9, WALLNUT_IMAGE_10, WALLNUT_IMAGE_11, WALLNUT_IMAGE_12,
            WALLNUT_IMAGE_13, WALLNUT_IMAGE_14, WALLNUT_IMAGE_15, WALLNUT_IMAGE_16
    };

    public final Image WALLNUT_CRACKED1_IMAGE_1 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_0.png");
    public final Image WALLNUT_CRACKED1_IMAGE_2 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_1.png");
    public final Image WALLNUT_CRACKED1_IMAGE_3 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_2.png");
    public final Image WALLNUT_CRACKED1_IMAGE_4 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_3.png");
    public final Image WALLNUT_CRACKED1_IMAGE_5 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_4.png");
    public final Image WALLNUT_CRACKED1_IMAGE_6 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_5.png");
    public final Image WALLNUT_CRACKED1_IMAGE_7 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_6.png");
    public final Image WALLNUT_CRACKED1_IMAGE_8 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_7.png");
    public final Image WALLNUT_CRACKED1_IMAGE_9 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_8.png");
    public final Image WALLNUT_CRACKED1_IMAGE_10 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_9.png");
    public final Image WALLNUT_CRACKED1_IMAGE_11 = createImage("/resources/Plants/WallNut/WallNut_cracked1/WallNut_cracked1_10.png");
    public final Image[] WALLNUT_CRACKED1_IMAGE = {
            WALLNUT_CRACKED1_IMAGE_1, WALLNUT_CRACKED1_IMAGE_2, WALLNUT_CRACKED1_IMAGE_3, WALLNUT_CRACKED1_IMAGE_4, WALLNUT_CRACKED1_IMAGE_5,
            WALLNUT_CRACKED1_IMAGE_6, WALLNUT_CRACKED1_IMAGE_7, WALLNUT_CRACKED1_IMAGE_8, WALLNUT_CRACKED1_IMAGE_9, WALLNUT_CRACKED1_IMAGE_10,
            WALLNUT_CRACKED1_IMAGE_11
    };

    public final Image WALLNUT_CRACKED2_IMAGE_1 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_0.png");
    public final Image WALLNUT_CRACKED2_IMAGE_2 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_1.png");
    public final Image WALLNUT_CRACKED2_IMAGE_3 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_2.png");
    public final Image WALLNUT_CRACKED2_IMAGE_4 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_3.png");
    public final Image WALLNUT_CRACKED2_IMAGE_5 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_4.png");
    public final Image WALLNUT_CRACKED2_IMAGE_6 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_5.png");
    public final Image WALLNUT_CRACKED2_IMAGE_7 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_6.png");
    public final Image WALLNUT_CRACKED2_IMAGE_8 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_7.png");
    public final Image WALLNUT_CRACKED2_IMAGE_9 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_8.png");
    public final Image WALLNUT_CRACKED2_IMAGE_10 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_9.png");
    public final Image WALLNUT_CRACKED2_IMAGE_11 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_10.png");
    public final Image WALLNUT_CRACKED2_IMAGE_12 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_11.png");
    public final Image WALLNUT_CRACKED2_IMAGE_13 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_12.png");
    public final Image WALLNUT_CRACKED2_IMAGE_14 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_13.png");
    public final Image WALLNUT_CRACKED2_IMAGE_15 = createImage("/resources/Plants/WallNut/WallNut_cracked2/WallNut_cracked2_14.png");
    public final Image[] WALLNUT_CRACKED2_IMAGE = {
            WALLNUT_CRACKED2_IMAGE_1, WALLNUT_CRACKED2_IMAGE_2, WALLNUT_CRACKED2_IMAGE_3, WALLNUT_CRACKED2_IMAGE_4, WALLNUT_CRACKED2_IMAGE_5,
            WALLNUT_CRACKED2_IMAGE_6, WALLNUT_CRACKED2_IMAGE_7, WALLNUT_CRACKED2_IMAGE_8, WALLNUT_CRACKED2_IMAGE_9, WALLNUT_CRACKED2_IMAGE_10,
            WALLNUT_CRACKED2_IMAGE_11, WALLNUT_CRACKED2_IMAGE_12, WALLNUT_CRACKED2_IMAGE_13, WALLNUT_CRACKED2_IMAGE_14, WALLNUT_CRACKED2_IMAGE_15
    };

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>WallNut</code>对象。
     * </p>
     * <p>
     *     创建<code>WallNut</code>对象时，会对<code>WallNut</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>WallNut</code>所在的格子编号
     * @see Plant
     */
    public WallNut(int tileNumber) {
        super(tileNumber);
        sunCost = Constant.WALLNUT_SUNCOST;
        health = Constant.WALLNUT_HEALTH;
        damage = Constant.WALLNUT_DAMAGE;
        attackSpeed = Constant.WALLNUT_ATTACK_SPEED;
        cooldownTime = Constant.WALLNUT_COOLDOWN_TIME;
        firstPurchaseNoCooldown = false;
        setImage(WALLNUT_IMAGE[0]);
        setVelocity(0, 0);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>WallNut</code>对象。
     * </p>
     * <p>
     *     创建<code>WallNut</code>对象时，会对<code>WallNut</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>WallNut</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     * @see Plant
     */
    public WallNut(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/resources/Plants/WallNut/WallNut/WallNut_0.png", width, height);
    }

    /**
     * <p>
     *     更新<code>WallNut</code>对象的属性及状态，也对<code>WallNut</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>WallNut</code>对象渲染到屏幕上。
     *     <code>WallNut</code>会随着血量的减少而改变形态。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        if (health <= Constant.WALLNUT_HEALTH * 1 / 3) {
            int i = (int) ((System.currentTimeMillis() - createdTime) / WALLNUT_CRACKED2_IMAGE.length / 6 % WALLNUT_CRACKED2_IMAGE.length);
            setImage(WALLNUT_CRACKED2_IMAGE[i]);
        } else if (health <= Constant.WALLNUT_HEALTH * 2 / 3) {
            int i = (int) ((System.currentTimeMillis() - createdTime) / WALLNUT_CRACKED1_IMAGE.length / 6 % WALLNUT_CRACKED1_IMAGE.length);
            setImage(WALLNUT_CRACKED1_IMAGE[i]);
        } else {
            int i = (int) ((System.currentTimeMillis() - createdTime) / WALLNUT_IMAGE.length / 6 % WALLNUT_IMAGE.length);
            setImage(WALLNUT_IMAGE[i]);
        }

        if (health <= 0) {
            Game.plantList.remove(this);
            Game.tileHasPlant.remove(tile);
        }

        this.render(context);
    }
}
