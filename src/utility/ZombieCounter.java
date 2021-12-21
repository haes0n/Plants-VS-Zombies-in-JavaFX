package utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Game;

import static main.Game.otherSprite;

/**
 * 游戏进度条类
 */
public class ZombieCounter extends Sprite{
    private static int deadZombieCount=0;

    /**
     * 绘画与更新进度条的方法
     *
     * @param context
     */
    public static void updateZombieCounter(GraphicsContext context) {
        //Progress Bar
        double gameLen = Stage.stageZombie[(Stage.stageZombie.length-1)][0]*1000L;
        double progress = Game.gameElapsedtime;

        double progressPercentage = progress/gameLen*120;
        if(Stage.stageZombie[(Stage.stageZombie.length-1)][0]*1000L - Game.gameElapsedtime <=0){
            progressPercentage = 120;
        }
        context.strokeRoundRect(670,38,120,20,5,5);
        context.setFill(Color.FORESTGREEN);
        context.fillRoundRect(790-progressPercentage,38,progressPercentage,20 ,5,5);
        //Zombie head
        Sprite zombieCounterImage = new Sprite();
        zombieCounterImage.setImage("/resources/Other/ZombieHead.png",32,33);
        zombieCounterImage.setPosition(765-progressPercentage,32);
        zombieCounterImage.render(context);
    }

    /**
     * 设置游戏死了多少僵尸的个数的设置
     * @param zombieDied
     */
    public static void setDeadZombieCount(int zombieDied) {
        deadZombieCount = zombieDied;
    }

    /**
     * 获取当前游戏中死了多少僵尸
     * @return
     */
    public static int getDeadZombieCount() {
        return deadZombieCount;
    }
}
