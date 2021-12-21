package plant;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import main.Game;
import utility.Constant;
import utility.Sprite;
import zombie.Zombie;

/**
 * <p>
 *     <code>Peashooter</code>类为植物<code>Peashooter</code>的具体实现类。
 * </p>
 */
public class Peashooter extends Plant {
    public final Image PEASHOOTER_IMAGE_1 = createImage("/resources/Plants/Peashooter/Peashooter_0.png");
    public final Image PEASHOOTER_IMAGE_2 = createImage("/resources/Plants/Peashooter/Peashooter_1.png");
    public final Image PEASHOOTER_IMAGE_3 = createImage("/resources/Plants/Peashooter/Peashooter_2.png");
    public final Image PEASHOOTER_IMAGE_4 = createImage("/resources/Plants/Peashooter/Peashooter_3.png");
    public final Image PEASHOOTER_IMAGE_5 = createImage("/resources/Plants/Peashooter/Peashooter_4.png");
    public final Image PEASHOOTER_IMAGE_6 = createImage("/resources/Plants/Peashooter/Peashooter_5.png");
    public final Image PEASHOOTER_IMAGE_7 = createImage("/resources/Plants/Peashooter/Peashooter_6.png");
    public final Image PEASHOOTER_IMAGE_8 = createImage("/resources/Plants/Peashooter/Peashooter_7.png");
    public final Image PEASHOOTER_IMAGE_9 = createImage("/resources/Plants/Peashooter/Peashooter_8.png");
    public final Image PEASHOOTER_IMAGE_10 = createImage("/resources/Plants/Peashooter/Peashooter_9.png");
    public final Image PEASHOOTER_IMAGE_11 = createImage("/resources/Plants/Peashooter/Peashooter_10.png");
    public final Image PEASHOOTER_IMAGE_12 = createImage("/resources/Plants/Peashooter/Peashooter_11.png");
    public final Image PEASHOOTER_IMAGE_13 = createImage("/resources/Plants/Peashooter/Peashooter_12.png");
    public final Image[] PEASHOOTER_IMAGE = {
            PEASHOOTER_IMAGE_1, PEASHOOTER_IMAGE_2, PEASHOOTER_IMAGE_3, PEASHOOTER_IMAGE_4, PEASHOOTER_IMAGE_5, PEASHOOTER_IMAGE_6,
            PEASHOOTER_IMAGE_7, PEASHOOTER_IMAGE_8, PEASHOOTER_IMAGE_9, PEASHOOTER_IMAGE_10, PEASHOOTER_IMAGE_11, PEASHOOTER_IMAGE_12,
            PEASHOOTER_IMAGE_13
    };

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>Peashooter</code>对象。
     * </p>
     * <p>
     *     创建<code>Peashooter</code>对象时，会对<code>Peashooter</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>Peashooter</code>所在的格子编号
     * @see Plant
     */
    public Peashooter(int tileNumber) {
        super(tileNumber);
        sunCost = Constant.PEASHOOTER_SUNCOST;
        health = Constant.PEASHOOTER_HEALTH;
        damage = Constant.PEASHOOTER_DAMAGE;
        attackSpeed = Constant.PEASHOOTER_ATTACK_SPEED;
        cooldownTime = Constant.PEASHOOTER_COOLDOWN_TIME;
        firstPurchaseNoCooldown = true;
        setImage(PEASHOOTER_IMAGE[0]);
        setVelocity(0, 0);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>Peashooter</code>对象。
     * </p>
     * <p>
     *     创建<code>Peashooter</code>对象时，会对<code>Peashooter</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>Peashooter</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     * @see Plant
     */
    public Peashooter(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/resources/Plants/Peashooter/Peashooter_0.png", width, height);
    }

    /**
     * <p>
     *     更新<code>Peashooter</code>对象的属性及状态，也对<code>Peashooter</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>Peashooter</code>对象渲染到屏幕上。
     *     要是僵尸被攻击后，则僵尸的血量会对应的减少。
     *     <code>Peashooter</code>的有效攻击范围为自己所在的格子以及前方所有格子，也就是一列。
     *     <code>Peashooter</code>在攻击时会生成新的<code>PeashooterBullet</code>对象，并添加到<code>bulletList</code>集合里。
     *     <code>PeashooterBullet</code>对象的属性及状态也会被更新，并且被渲染到屏幕上。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int i = (int) ((System.currentTimeMillis() - createdTime) / PEASHOOTER_IMAGE.length / 6 % PEASHOOTER_IMAGE.length);
        setImage(PEASHOOTER_IMAGE[i]);

        for (Zombie zombie : Game.zombieList) {
            if (zombie.row == row) {
                elapsedTime = System.currentTimeMillis() - recordedTime;

                if (elapsedTime >= attackSpeed * 1000) {
                    PeashooterBullet bullet = new PeashooterBullet(this);
                    this.bulletList.add(bullet);
                    recordedTime = System.currentTimeMillis();
                    break;
                }
            }
        }

        if (health <= 0) {
            Game.plantList.remove(this);
            Game.tileHasPlant.remove(tile);
        }

        this.render(context);

        for (Sprite bullet : this.bulletList) {
            bullet.setPosition(bullet.positionX + bullet.velocityX * 1 / 60, bullet.positionY + bullet.velocityY * 1 / 60);

            for (Zombie zombie : Game.zombieList) {
                if (bullet.isOverlapped(zombie)) {
                    zombie.health -= damage;
                    this.bulletList.remove(bullet);
                    break;
                }
            }

            bullet.render(context);
        }
    }
}
