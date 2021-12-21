package plant;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import utility.Constant;
import utility.Sprite;
import zombie.Zombie;

/**
 * <p>
 *     <code>SnowPea</code>类为植物<code>SnowPea</code>的具体实现类。
 * </p>
 */
public class SnowPea extends Plant {
    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>SnowPea</code>对象。
     * </p>
     * <p>
     *     创建<code>SnowPea</code>对象时，会对<code>SnowPea</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>SnowPea</code>所在的格子编号
     * @see Plant
     */
    public SnowPea(int tileNumber) {
        super(tileNumber);
        sunCost = Constant.SNOW_PEA_SUNCOST;
        health = Constant.SNOW_PEA_HEALTH;
        damage = Constant.SNOW_PEA_DAMAGE;
        attackSpeed = Constant.SNOW_PEA_ATTACK_SPEED;
        cooldownTime = Constant.SNOW_PEA_COOLDOWN_TIME;
        firstPurchaseNoCooldown = true;
        setImage("/resources/Plants/SnowPea/SnowPea_0.png");
        setVelocity(0, 0);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>SnowPea</code>对象。
     * </p>
     * <p>
     *     创建<code>SnowPea</code>对象时，会对<code>SnowPea</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>SnowPea</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     * @see Plant
     */
    public SnowPea(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage("/resources/Plants/SnowPea/SnowPea_0.png", width, height);
    }

    /**
     * <p>
     *     更新<code>SnowPea</code>对象的属性及状态，也对<code>SnowPea</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>SnowPea</code>对象渲染到屏幕上。
     *     要是僵尸被攻击后，则僵尸的血量会对应的减少。
     *     <code>SnowPea</code>的有效攻击范围为自己所在的格子以及前方所有格子，也就是一列。
     *     <code>SnowPea</code>的攻击发射的子弹会让僵尸的攻速及移速都被降低一半。
     *     <code>SnowPea</code>在攻击时会生成新的<code>SnowPeaBullet</code>对象，并添加到<code>bulletList</code>集合里。
     *     <code>SnowPeaBullet</code>对象的属性及状态也会被更新，并且被渲染到屏幕上。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int changePic = 0;
        changePic = (int)(time%(Constant.SNOW_PEA_IMAGE.length-1));
        setImage(Constant.SNOW_PEA_IMAGE[changePic]);

        for (Zombie zombie : Game.zombieList) {
            if (zombie.row == row) {
                elapsedTime = System.currentTimeMillis() - recordedTime;

                if (elapsedTime >= attackSpeed * 1000) {
                    SnowPeaBullet bullet = new SnowPeaBullet(this);
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
                    zombie.isSlowDown = true;
                    zombie.slowDownTime = System.currentTimeMillis();
                    this.bulletList.remove(bullet);
                    break;
                }
            }

            bullet.render(context);
        }
    }
}
