package plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;
import utility.Constant;
import utility.Sun;

/**
 * <p>
 *     <code>Sunflower</code>类为植物<code>Sunflower</code>的具体实现类。
 * </p>
 */
public class Sunflower extends Plant {
    /**
     * 是否是生产出的第一个太阳
     */
    public boolean isFirstSun = true;

    public final Image SUNFLOWER_IMAGE_1 = createImage("/resources/Plants/SunFlower/SunFlower_0.png");
    public final Image SUNFLOWER_IMAGE_2 = createImage("/resources/Plants/SunFlower/SunFlower_1.png");
    public final Image SUNFLOWER_IMAGE_3 = createImage("/resources/Plants/SunFlower/SunFlower_2.png");
    public final Image SUNFLOWER_IMAGE_4 = createImage("/resources/Plants/SunFlower/SunFlower_3.png");
    public final Image SUNFLOWER_IMAGE_5 = createImage("/resources/Plants/SunFlower/SunFlower_4.png");
    public final Image SUNFLOWER_IMAGE_6 = createImage("/resources/Plants/SunFlower/SunFlower_5.png");
    public final Image SUNFLOWER_IMAGE_7 = createImage("/resources/Plants/SunFlower/SunFlower_6.png");
    public final Image SUNFLOWER_IMAGE_8 = createImage("/resources/Plants/SunFlower/SunFlower_7.png");
    public final Image SUNFLOWER_IMAGE_9 = createImage("/resources/Plants/SunFlower/SunFlower_8.png");
    public final Image SUNFLOWER_IMAGE_10 = createImage("/resources/Plants/SunFlower/SunFlower_9.png");
    public final Image SUNFLOWER_IMAGE_11 = createImage("/resources/Plants/SunFlower/SunFlower_10.png");
    public final Image SUNFLOWER_IMAGE_12 = createImage("/resources/Plants/SunFlower/SunFlower_11.png");
    public final Image SUNFLOWER_IMAGE_13 = createImage("/resources/Plants/SunFlower/SunFlower_12.png");
    public final Image SUNFLOWER_IMAGE_14 = createImage("/resources/Plants/SunFlower/SunFlower_13.png");
    public final Image SUNFLOWER_IMAGE_15 = createImage("/resources/Plants/SunFlower/SunFlower_14.png");
    public final Image SUNFLOWER_IMAGE_16 = createImage("/resources/Plants/SunFlower/SunFlower_15.png");
    public final Image SUNFLOWER_IMAGE_17 = createImage("/resources/Plants/SunFlower/SunFlower_16.png");
    public final Image[] SUNFLOWER_IMAGE = {
            SUNFLOWER_IMAGE_1, SUNFLOWER_IMAGE_2, SUNFLOWER_IMAGE_3, SUNFLOWER_IMAGE_4, SUNFLOWER_IMAGE_5, SUNFLOWER_IMAGE_6,
            SUNFLOWER_IMAGE_7, SUNFLOWER_IMAGE_8, SUNFLOWER_IMAGE_9, SUNFLOWER_IMAGE_10, SUNFLOWER_IMAGE_11, SUNFLOWER_IMAGE_12,
            SUNFLOWER_IMAGE_13, SUNFLOWER_IMAGE_14, SUNFLOWER_IMAGE_15, SUNFLOWER_IMAGE_16, SUNFLOWER_IMAGE_17
    };

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>Sunflower</code>对象。
     * </p>
     * <p>
     *     创建<code>Sunflower</code>对象时，会对<code>Sunflower</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>Sunflower</code>所在的格子编号
     * @see Plant
     */
    public Sunflower(int tileNumber) {
        super(tileNumber);
        sunCost = Constant.SUNFLOWER_SUNCOST;
        health = Constant.SUNFLOWER_HEALTH;
        damage = Constant.SUNFLOWER_DAMAGE;
        attackSpeed = Constant.SUNFLOWER_ATTACK_SPEED;
        cooldownTime = Constant.SUNFLOWER_COOLDOWN_TIME;
        firstPurchaseNoCooldown = true;
        setImage(SUNFLOWER_IMAGE[0]);
        setVelocity(0, 0);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>Sunflower</code>对象。
     * </p>
     * <p>
     *     创建<code>Sunflower</code>对象时，会对<code>Sunflower</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>Sunflower</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     * @see Plant
     */
    public Sunflower(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/resources/Plants/SunFlower/SunFlower_0.png", width, height);
    }

    /**
     * <p>
     *     更新<code>Sunflower</code>对象的属性及状态，也对<code>Sunflower</code>的太阳生产进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>Sunflower</code>对象渲染到屏幕上。
     *     <code>Sunflower</code>每隔一段时间就会生产太阳。
     *     太阳可以点击获取，要是一段时间内没被点击掉则会消失。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int i = (int) ((System.currentTimeMillis() - createdTime) / SUNFLOWER_IMAGE.length / 6 % SUNFLOWER_IMAGE.length);
        setImage(SUNFLOWER_IMAGE[i]);

        elapsedTime = System.currentTimeMillis() - recordedTime;

        if (elapsedTime > attackSpeed * 1000 || (elapsedTime > 5000 && isFirstSun)) {
            Sun sun = new Sun(this);
            Game.sunList.add(sun);
            recordedTime = System.currentTimeMillis();
            isFirstSun = false;
        }

        if (health <= 0) {
            Game.plantList.remove(this);
            Game.tileHasPlant.remove(tile);
        }

        this.render(context);
    }
}
