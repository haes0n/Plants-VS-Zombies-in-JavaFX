package plant;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import utility.Constant;
import zombie.Zombie;

/**
 * <p>
 *     <code>Chomper</code>类为植物<code>Chomper</code>的具体实现类。
 * </p>
 */
public class Chomper extends Plant {
    private boolean isOnCoolDown = false;
    private boolean isDigesting = false;
    private boolean isAttacking = false;
    private long startAttackTime = 0;
    private Zombie target;

    /**
     * <p>
     *     根据传入的格子编号，在对应的格子上创建<code>Chomper</code>对象。
     * </p>
     * <p>
     *     创建<code>Chomper</code>对象时，会对<code>Chomper</code>的一些成员变量对应地进行初始化。
     * </p>
     * @param tileNumber 欲种下的<code>Chomper</code>所在的格子编号
     * @see Plant
     */
    public Chomper(int tileNumber) {
        super(tileNumber);
        sunCost = Constant.CHOMPER_SUNCOST;
        health = Constant.CHOMPER_HEALTH;
        damage = Constant.CHOMPER_DAMAGE;
        attackSpeed = Constant.CHOMPER_ATTACK_SPEED;
        cooldownTime = Constant.CHOMPER_COOLDOWN_TIME;
        firstPurchaseNoCooldown = false;
        firstAttackNoCooldown = true;
        setImage(Constant.CHOMPER_IMAGE_1);
        setVelocity(0, 0);
        setPosition(positionX + 3, positionY - 5);
    }

    /**
     * <p>
     *     根据传入的格子编号以及指定的图片长宽，在对应的格子上创建<code>Chomper</code>对象。
     * </p>
     * <p>
     *     创建<code>Chomper</code>对象时，会对<code>Chomper</code>的一些成员变量对应地进行初始化。
     *     此对象的图片长宽为传入的参数中指定的长宽。
     * </p>
     * @param tileNumber 欲种下的<code>Chomper</code>所在的格子编号
     * @param width 指定的图片宽度
     * @param height 指定的图片长度
     */
    public Chomper(int tileNumber, double width, double height) {
        this(tileNumber);
        setImage(Constant.CHOMPER_IMAGE_1);
    }

    /**
     * <p>
     *     更新<code>Chomper</code>对象的属性及状态，也对<code>Chomper</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>Chomper</code>对象渲染到屏幕上。
     *     要是僵尸被攻击后，则僵尸的血量会对应的减少。
     *     <code>Chomper</code>的有效攻击范围为自己所在的格子以及前一个格子。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     * @see Plant
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int changePic = 0;

        for (Zombie zombie : Game.zombieList) {
            int tile = Constant.getTile(zombie.positionX + zombie.width*3/5, zombie.positionY + zombie.height / 2);
            if (this.row == zombie.row) {
                if (tile == this.tile || tile - 1 == this.tile) {
                    if(!isOnCoolDown){
                        isOnCoolDown = true;
                        startAttackTime = time;
                        target = zombie;
                        isAttacking = true;
                    }
                }
            }
        }
        if(time - startAttackTime >= Constant.CHOMPER_ATTACK_SPEED * 10){
            isOnCoolDown = false;
        }
        if(isAttacking){
            attack(time,startAttackTime,target);
        }
        if(!isAttacking && isDigesting){
            changePic = (int)(time%(Constant.CHOMPER_DIGEST_IMAGE.length-1));
            setImage(Constant.CHOMPER_DIGEST_IMAGE[changePic]);
        }
        if(!isAttacking && !isDigesting){
            changePic = (int)(time%(Constant.CHOMPER_IMAGE.length-1));
            setImage(Constant.CHOMPER_IMAGE[changePic]);
        }


        if (health <= 0) {
            Game.plantList.remove(this);
            Game.tileHasPlant.remove(tile);
        }

        this.render(context);
    }

    /**
     * 实现攻击僵尸的动画，以及改变<code>Chomper</code>对象的状态
     *
     * @param time 时间
     * @param startAttackTime 开始攻击的时间
     * @param target 攻击的僵尸对象
     */
    public void attack(long time,long startAttackTime, Zombie target){
        int changePic = 0;
        if((time - startAttackTime <= Constant.CHOMPER_ATTACK_IMAGE.length-1)){
            isAttacking = true;
            changePic = (int)(time%(Constant.CHOMPER_ATTACK_IMAGE.length-1));
            setImage(Constant.CHOMPER_ATTACK_IMAGE[changePic]);
        }
        else if(time - startAttackTime >= Constant.CHOMPER_ATTACK_IMAGE.length-1){
            target.health -= damage;
            isAttacking = false;
            isDigesting = true;
        }
    }
}