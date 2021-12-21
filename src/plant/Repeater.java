package plant;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import utility.Constant;
import utility.Sprite;
import zombie.Zombie;

/**
 * <p>
 *     <code>Repeater</code>类为植物<code>Repeater</code>的具体实现类。
 * </p>
 */
public class Repeater extends Plant {
    /**
     * <code>Repeater</code>记录的时间，配合<code>recordedTime2</code>实现<code>Repeater</code>的攻击判定
     */
    public long elapsedTime2 = 0;
    /**
     * <code>Repeater</code>记录的时间，配合<code>elapsedTime2</code>实现<code>Repeater</code>的攻击判定
     */
    public long recordedTime2 = 0;

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>Repeater</code>对象。
     * </p>
     * <p>
     *     创建<code>Repeater</code>对象时，会对<code>Repeater</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>Repeater</code>所在的格子编号
     * @see Plant
     */
    public Repeater(int tileNumber) {
        super(tileNumber);
        recordedTime2 = System.currentTimeMillis();
        sunCost = Constant.REPEATER_SUNCOST;
        health = Constant.REPEATER_HEALTH;
        damage = Constant.REPEATER_DAMAGE;
        attackSpeed = Constant.REPEATER_ATTACK_SPEED;
        cooldownTime = Constant.REPEATER_COOLDOWN_TIME;
        firstPurchaseNoCooldown = true;
        setImage("/resources/Plants/RepeaterPea/RepeaterPea_0.png");
        setVelocity(0, 0);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>Repeater</code>对象。
     * </p>
     * <p>
     *     创建<code>Repeater</code>对象时，会对<code>Repeater</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>Repeater</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     * @see Plant
     */
    public Repeater(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/resources/Plants/RepeaterPea/RepeaterPea_0.png", width, height);
    }

    /**
     * <p>
     *     更新<code>Repeater</code>对象的属性及状态，也对<code>Repeater</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>Repeater</code>对象渲染到屏幕上。
     *     要是僵尸被攻击后，则僵尸的血量会对应的减少。
     *     <code>Repeater</code>的有效攻击范围为自己所在的格子以及前方所有格子，也就是一列，攻击方式为一次发射两颗子弹。
     *     <code>Repeater</code>在攻击时会生成新的<code>PeashooterBullet</code>对象，并添加到<code>bulletList</code>集合里。
     *     <code>PeashooterBullet</code>对象的属性及状态也会被更新，并且被渲染到屏幕上。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int changePic = 0;
        changePic = (int)(time%(Constant.REPEATER_IMAGE.length-1));
        setImage(Constant.REPEATER_IMAGE[changePic]);

        for (Zombie zombie : Game.zombieList) {
            if (zombie.row == row) {
                elapsedTime = System.currentTimeMillis() - recordedTime;
                elapsedTime2 = System.currentTimeMillis() - recordedTime2;

                if (elapsedTime >= attackSpeed * 1000) {
                    PeashooterBullet bullet = new PeashooterBullet(this);
                    this.bulletList.add(bullet);
                    recordedTime = System.currentTimeMillis();
                }
                if (elapsedTime2 >= attackSpeed * 1000 + 320) {
                    PeashooterBullet bullet = new PeashooterBullet(this);
                    this.bulletList.add(bullet);
                    recordedTime2 = recordedTime;
                }
                break;
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
