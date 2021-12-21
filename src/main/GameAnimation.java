package main;

import javafx.animation.AnimationTimer;
import plant.Plant;
import utility.*;
import zombie.Zombie;

import static main.Game.*;
import static main.Game.gameLose;

/**
 * <p>
 *     <code>AnimationTimer</code>类负责的就是游戏的主体循环，这其中<code>handle</code>方法每1/60秒会被调用一次。
 *     因此，此类靠调用<code>handle</code>方法来渲染动画的各个画面帧，以实现动画效果。
 * </p>
 */
public class GameAnimation extends AnimationTimer {
    /**
     * 游戏是否处于刚开始状态
     */
    private boolean isStart = false;
    /**
     * 游戏正式开始时间
     */
    private long startTime = 0;

    /**
     * <p>
     *     处理主循环中每次循环应该实现的程序的方法。
     *     游戏主体主循环每1/60秒会调用一次此方法。
     * </p>
     * <p>
     *     对于游戏的绝大部分操作，判定，僵尸的移动实现以及子弹的移动等都写在了<code>handle</code>方法内部，并且游戏画面的刷新也靠着<code>handle</code>方法实现。
     *     游戏的胜负也在<code>handle</code>方法内判定。
     * </p>
     * @param l 每次运行此方法时的时间
     */
    @Override
    public void handle(long l) {
        if(isStart){
            startTime = l;
            isStart = false;
        }
        long time = (long)((l - startTime )/(1e8));
        for (Sprite sprite : otherSprite) {
            sprite.render(Main.getContext());
        }

        Zombie.generateZombie();
        Sun.generateSun();
        Sun.updateCurrentSun(Main.getContext());
        ZombieCounter.updateZombieCounter(Main.getContext());

        for(LawnMower lm : lawnMowers){
            lm.update(time,Main.getContext());
        }

        for (Plant p : plantChosenList) {
            p.updatePlantChosen(time, Main.getContext());
        }

        for (Plant p : plantList) {
            p.update(time, Main.getContext());
        }

        for (Zombie z : zombieList) {
            z.update(time, Main.getContext());
        }

        for (Sun s : sunList) {
            s.update(time, Main.getContext());
        }

        if (plantChosen != null) {
            plantChosen.render(Main.getContext());
        }

        if (gameIsWin()) {
            stop();
//            System.out.println("hi");
            gameWin();
        }
        if (gameIsLose()) {
            stop();
            gameLose();
        }
    }

    /**
     * 此方法将开始主游戏体的主循环
     */
    @Override
    public void start() {
        super.start();
        isStart = true;
    }
}
