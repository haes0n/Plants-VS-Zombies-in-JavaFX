package zombie;

import javafx.scene.canvas.GraphicsContext;
import main.Game;
import plant.CherryBomb;
import plant.Plant;
import utility.Constant;
import utility.LawnMower;
import utility.Sprite;
import utility.ZombieCounter;

/**
 * <p>
 *     <code>NewspaperZombie</code>类为僵尸<code>NewspaperZombie</code>的具体实现类。
 * </p>
 */
public class NewspaperZombie extends Zombie {
    private boolean hasPaper = true;

    /**
     * <p>
     *     创建<code>NewspaperZombie</code>对象。
     * </p>
     * <p>
     *     创建<code>NewspaperZombie</code>对象时，会对<code>NewspaperZombie</code>的一些成员变量对应地进行初始化。
     *     <code>NewspaperZombie</code>会被随机地创建在第1至第5行草地的其中一行上。
     * </p>
     * @see Zombie
     */
    public NewspaperZombie() {
        super();
        health = Constant.NEWSPAPER_ZOMBIE_HEALTH;
        damage = Constant.NEWSPAPER_ZOMBIE_DAMAGE;
        attackSpeed = Constant.NEWSPAPER_ZOMBIE_ATTACK_SPEED;
        setImage("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_0.png");
        setVelocity(Constant.NEWSPAPER_ZOMBIE_MOVEMENT_SPEED, 0);
        setPosition(positionX, positionY - 5);
    }

    /**
     * 判断是否与其他植物相撞
     *
     * @param otherSprite 其他的<code>Sprite</code>对象
     * @return boolean 返回是否相撞
     */
    public boolean isOverlapped(Sprite otherSprite) {
        double offset = 30;
        if (this.row == otherSprite.row) {
            return !(this.positionX + this.width < otherSprite.positionX || otherSprite.positionX + otherSprite.width < this.positionX + offset);
        }
        return false;
    }

    /**
     * <p>
     *     更新<code>NewspaperZombie</code>对象的属性及状态，也对<code>NewspaperZombie</code>的攻击进行更新与判定。
     * </p>
     * <p>
     *     此方法也把<code>NewspaperZombie</code>对象渲染到屏幕上。
     *     要是<code>NewspaperZombie</code>与植物产生碰撞时，就会停止移动，开始攻击植物，直到植物血量归0或是<code>NewspaperZombie</code>死亡为止。
     *     要是<code>NewspaperZombie</code>被减速了，则其移速和攻速会变为原本的值的一半。
     *     要是<code>NewspaperZombie</code>的报纸被摧毁了，则会改变其显示形态，并且增加移速。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        int flag = 0;
        int changePic = 0;

        if (System.currentTimeMillis() - slowDownTime > 5000) {
            isSlowDown = false;
        }
        if (isSlowDown) {
            if (health <= 9) {
                setImage("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_0.png");
                setVelocity(Constant.NEWSPAPER_ZOMBIE_RAGE_MOVEMENT_SPEED / 2, 0);
            } else {
                setVelocity(Constant.NEWSPAPER_ZOMBIE_MOVEMENT_SPEED / 2, 0);
            }
            attackSpeed = Constant.NEWSPAPER_ZOMBIE_ATTACK_SPEED / 2;
        } else {
            if (health <= 9) {
                hasPaper = false;
                setImage("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_0.png");
                setVelocity(Constant.NEWSPAPER_ZOMBIE_RAGE_MOVEMENT_SPEED, 0);
            } else {
                setVelocity(Constant.NEWSPAPER_ZOMBIE_MOVEMENT_SPEED, 0);
            }
            attackSpeed = Constant.NEWSPAPER_ZOMBIE_ATTACK_SPEED;
        }

        for(LawnMower lawnMower : Game.lawnMowers){
            if(this.row == lawnMower.row && this.isOverlapped(lawnMower)){
                Game.zombieList.remove(this);
            }
        }

        for (Plant plant : Game.plantList) {
            if (this.isOverlapped(plant) && !(plant instanceof CherryBomb)) {
                elapsedTime = System.currentTimeMillis() - recordedTime;
                flag = 1;
                if(hasPaper == true){
                    changePic = (int)(time%(Constant.NEWSPAPER_ZOMBIE_ATTACK_IMAGE.length-1));
                    setImage(Constant.NEWSPAPER_ZOMBIE_ATTACK_IMAGE[changePic]);
                }
                else{
                    changePic = (int)(time%(Constant.NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE.length-1));
                    setImage(Constant.NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE[changePic]);
                }
                if (elapsedTime >= attackSpeed * 1000) {
                    plant.health -= damage;
                    recordedTime = System.currentTimeMillis();
                    break;
                }
            }
        }

        if (flag == 0) {
            if(hasPaper == true){
                changePic = (int)(time%(Constant.NEWSPAPER_ZOMBIE_MOVING_IMAGE.length-1));
                setImage(Constant.NEWSPAPER_ZOMBIE_MOVING_IMAGE[changePic]);
            }
            else{
                changePic = (int)(time%(Constant.NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE.length-1));
                setImage(Constant.NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE[changePic]);
            }

            this.setPosition(positionX + velocityX * 1 / 60, positionY + velocityY * 1 / 60);
        }

        if (health <= 0) {
            ZombieCounter.setDeadZombieCount(ZombieCounter.getDeadZombieCount()+1);
            this.health = 0;
            Game.zombieList.remove(this);
        }
        this.updateHealthBar(context,Constant.NEWSPAPER_ZOMBIE);
        this.render(context);
    }
}
