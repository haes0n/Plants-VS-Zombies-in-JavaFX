package zombie;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import main.Game;
import utility.Constant;
import utility.Sprite;
import utility.Stage;

import java.util.Random;

import static utility.Constant.NORMAL_ZOMBIE;
import static utility.Constant.CONEHEAD_ZOMBIE;
import static utility.Constant.BUCKETHEAD_ZOMBIE;
import static utility.Constant.FLAG_ZOMBIE;
import static utility.Constant.NEWSPAPER_ZOMBIE;

/**
 * <p>
 *     <code>Zombie</code>类为每个具体的僵尸的父类。
 * </p>
 * <p>
 *     成员变量与僵尸的各个属性有关，比如僵尸的生命值和攻速等。方法与僵尸的状态的更新及显示有关。
 * </p>
 */
public class Zombie extends Sprite {
    /**
     * 僵尸的生命值
     */
    public double health;
    /**
     * 僵尸一次攻击所造成的伤害
     */
    public double damage;
    /**
     * 僵尸的攻速
     */
    public double attackSpeed;
    /**
     * 僵尸记录的时间，配合<code>elapsedTime</code>实现僵尸的攻击判定
     */
    public long recordedTime;
    /**
     * 僵尸记录的时间，配合<code>recordedTime</code>实现僵尸的攻击判定
     */
    public long elapsedTime;
    /**
     * 僵尸是否被减速了
     */
    public boolean isSlowDown;
    /**
     * 僵尸被减速的时间，用来实现对减速效果的判定
     */
    public long slowDownTime;

    /**
     * <p>
     *     创建<code>Zombie</code>对象。
     * </p>
     * <p>
     *     创建<code>Zombie</code>对象时，会对<code>Zombie</code>的一些成员变量对应地进行初始化。
     *     <code>Zombie</code>会被随机地创建在第1至第5行草地的其中一行上。
     * </p>
     */
    public Zombie() {
        elapsedTime = 0;
        recordedTime = System.currentTimeMillis();
        isSlowDown = false;

        int r = (new Random().nextInt(5)) + 1;
        switch (r) {
            case 1 -> {
                setPosition(750, 42);
                row = 1;
            }
            case 2 -> {
                setPosition(750, 138);
                row = 2;
            }
            case 3 -> {
                setPosition(750, 249);
                row = 3;
            }
            case 4 -> {
                setPosition(750, 331);
                row = 4;
            }
            case 5 -> {
                setPosition(750, 439);
                row = 5;
            }
            default -> {
                setPosition(0, 0);
                row = 0;
            }
        }
    }

    /**
     * <p>
     *     更新<code>Zombie</code>对象的属性及状态，比如更新图片坐标。
     * </p>
     * <p>
     *     此方法也把<code>Zombie</code>对象渲染到屏幕上。
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
     *     根据<code>Stage</code>类中<code>stageZombie</code>的值来生成当前关卡的僵尸。
     * </p>
     * <p>
     *     僵尸会被随机生成在第1至第5行其中一行上。
     *     僵尸生成后会被添加到<code>Game</code>类的<code>zombieList</code>集合里。
     * </p>
     */
    public static void generateZombie() {
        Game.gameElapsedtime = System.currentTimeMillis() - Game.gameRecordedTime;

        if (Game.currentZombie < Stage.stageZombie.length && Game.gameElapsedtime >= Stage.stageZombie[Game.currentZombie][0] * 1000L) {
            switch ((int) Stage.stageZombie[Game.currentZombie][1]) {
                case NORMAL_ZOMBIE -> Game.zombieList.add(new NormalZombie());
                case CONEHEAD_ZOMBIE -> Game.zombieList.add(new ConeheadZombie());
                case BUCKETHEAD_ZOMBIE -> Game.zombieList.add(new BucketheadZombie());
                case FLAG_ZOMBIE -> Game.zombieList.add(new FlagZombie());
                case NEWSPAPER_ZOMBIE -> Game.zombieList.add(new NewspaperZombie());
            }
            Game.currentZombie++;
        }
    }

    public void updateHealthBar(GraphicsContext context, int zombieType){
        double healthBarWidth=80;
        double healthBarHeight=6;
        double healthPercentage;
        if(zombieType==1){
            healthPercentage = this.health/ Constant.NORMAL_ZOMBIE_HEALTH * healthBarWidth;
        }
        else if(zombieType==2){
            healthPercentage = this.health/ Constant.CONEHEAD_ZOMBIE_HEALTH * healthBarWidth;
        }
        else if(zombieType==3){
            healthPercentage = this.health/ Constant.BUCKETHEAD_ZOMBIE_HEALTH * healthBarWidth;
        }
        else if(zombieType==4){
            healthPercentage = this.health/ Constant.FLAG_ZOMBIE_HEALTH * healthBarWidth;
        }
        else{
            healthPercentage = this.health/ Constant.NEWSPAPER_ZOMBIE_HEALTH * healthBarWidth;
        }
        context.strokeRoundRect(this.positionX,this.positionY-healthBarHeight-5,healthBarWidth,healthBarHeight,5,5);
        if(healthPercentage/healthBarWidth<=0.2){
            context.setFill(Color.ORANGERED);
        }
        else if(healthPercentage/healthBarWidth>0.2 && healthPercentage/healthBarWidth<=0.6){
            context.setFill(Color.ORANGE);
        }
        else{
            context.setFill(Color.GREENYELLOW);
        }
        context.fillRoundRect(this.positionX,this.positionY-healthBarHeight-5,healthPercentage,healthBarHeight ,5,5);
    }
}
