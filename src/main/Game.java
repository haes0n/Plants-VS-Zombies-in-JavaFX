package main;

import javafx.animation.AnimationTimer;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import plant.Plant;
import utility.LawnMower;
import utility.Sprite;
import utility.Stage;
import utility.Sun;
import zombie.Zombie;

import java.io.IOException;
import java.util.HashSet;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 *  <p>
 *      code>Game</code>类用来保存在一局游戏（一个关卡）运行过程中产生及需要记录的所有数据。
 *  </p>
 *  <p>
 *       这里的成员变量的值都会随着游戏事件的触发而改变，比如鼠标点击等事件。
 *       方法则是关于游戏状态，比如是否获胜或是失败的判定以及对应状态改变后，比如游戏获胜后执行的代码。
 *  </p>
 */
public class Game {
    /**
     * 保存一个关卡中场地上出现的僵尸。
     */
    public static CopyOnWriteArrayList<Zombie> zombieList = new CopyOnWriteArrayList<>();
    /**
     * 记录时间，配合<code>gameElpasedTime</code>一起实现僵尸生成时间的计算及控制。
     */
    public static long gameRecordedTime = 0;
    /**
     * 记录时间，配合<code>gameRecordedTime</code>一起实现僵尸生成时间的计算及控制。
     */
    public static long gameElapsedtime = 0;
    /**
     * 记录当前关卡已经生成了多少只僵尸。
     */
    public static int currentZombie = 0;

    /**
     * 保存一个关卡中场地上玩家种下的植物。
     */
    public static CopyOnWriteArrayList<Plant> plantList = new CopyOnWriteArrayList<>();
    /**
     * 记录某个格子是否已经有植物被种下了。
     */
    public static HashSet<Integer> tileHasPlant = new HashSet<>();

    /**
     * 保存一个关卡中场地上出现的所有自然掉落太阳和太阳花产出的太阳。
     */
    public static CopyOnWriteArrayList<Sun> sunList = new CopyOnWriteArrayList<>();
    /**
     * 记录时间，配合<code>sunGenerationElapsedTime</code>一起实现太阳自然掉落时间的计算和控制。
     */
    public static long sunGenerationRecordedTime = 0;
    /**
     * 记录时间，配合<code>sunGenerationRecordedTime</code>一起实现太阳自然掉落时间的计算和控制。
     */
    public static long sunGenerationElapsedTime = 0;
    /**
     * 记录当前太阳的值。
     */
    public static int sun = 200;

    /**
     * 保存植物选择区域中的8种植物。
     */
    public static CopyOnWriteArrayList<Plant> plantChosenList = new CopyOnWriteArrayList<>();
    /**
     * 记录当前选择的还未种下的植物。
     */
    public static int plantSelected = 0;

    /**
     * 记录是否选择了铲子，但还未使用。
     */
    public static boolean showerSelected = false;
    /**
     * 在选择了新植物后，随着鼠标坐标改变而改变的选择的植物的画面。
     */
    public static Sprite plantChosen;

    /**
     * 保存一些其他游戏渲染过程中用到的图画，比如背景图片草地。
     */
    public static CopyOnWriteArrayList<Sprite> otherSprite = new CopyOnWriteArrayList<>();

    /**
     * 记录当前游戏是否被暂停了。
     */
    public static boolean gameIsPause = false;
    /**
     * 记录游戏暂停时的时间，以在游戏恢复时通过此变量的值恢复游戏状态。
     */
    public static long gamePauseTime;
    /**
     * 保存了<code>AnimationTimer</code>对象，以便可以方便地在别的类或方法调用。
     */
    public static AnimationTimer recordedAnimationTimer;

    public static CopyOnWriteArrayList<LawnMower> lawnMowers = new CopyOnWriteArrayList<>();

    /**
     * <p>
     *     判断当前关卡是否获胜了。
     * </p>
     * @return <code>true</code> 如果当前关卡获胜了
     */
    public static boolean gameIsWin() {
        return currentZombie == Stage.stageZombie.length && zombieList.size() == 0;
    }

    /**
     * <p>
     *     关卡获胜后执行的方法。
     * </p>
     */
    public static void gameWin() {
        try{
            Main.getMediaPlayer().stop();
            Parent winSceneLayout = FXMLLoader.load(Main.class.getResource("/resources/Other/WinScene.fxml"));
            Main.setMainMenuScene(new Scene(winSceneLayout));
            Main.getMainWindow().setScene(Main.getMainMenuScene());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * <p>
     *     判断当前关卡是否失败了。
     * </p>
     * @return <code>true</code> 如果当前关卡失败了。
     */
    public static boolean gameIsLose() {
        for (Zombie zombie : zombieList) {
            if (zombie.positionX < -40) {
                return true;
            }
        }
        return false;
    }

    /**
     * <p>
     *     关卡失败后执行的方法。
     * </p>
     */
    public static void gameLose() {
        try{
            Main.getMediaPlayer().stop();
            Parent loseSceneLayout = FXMLLoader.load(Main.class.getResource("/resources/Other/LoseScene.fxml"));
            Main.setMainMenuScene(new Scene(loseSceneLayout));
            Main.getMainWindow().setScene(Main.getMainMenuScene());
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * <p>
     *     游戏被暂停时执行的方法。
     * </p>
     * <p>
     *     此方法会记录一些时间变量，以便在游戏继续运行时恢复游戏状态。
     * </p>
     */
    public static void gamePause() {
        gameIsPause = true;
        recordedAnimationTimer.stop();
        Main.getMediaPlayer().pause();
        gamePauseTime = System.currentTimeMillis();
    }

    /**
     * <p>
     *     游戏在被暂停后，再次点击暂停按钮使游戏恢复运行时执行的方法。
     * </p>
     * <p>
     *     此方法会根据<code>gamePause</code>方法在执行时所保存的变量的值来恢复游戏状态。
     * </p>
     */
    public static void gameContinue() {
        gameIsPause = false;
        long pauseTime = System.currentTimeMillis() - gamePauseTime;

        for (Zombie zombie : zombieList) {
            zombie.recordedTime += pauseTime;
        }
        for (Plant plant : plantList) {
            plant.recordedTime += pauseTime;
        }
        for (Plant plant : plantChosenList) {
            plant.recordedTime += pauseTime;
        }
        for (Sun sun : sunList) {
            sun.recordedTime += pauseTime;
        }
        gameRecordedTime += pauseTime;
        sunGenerationRecordedTime += pauseTime;
        Main.getMediaPlayer().play();
        recordedAnimationTimer.start();
    }

    /**
     * 初始化关卡的方法
     */
    public static void InitializeGame(){
        zombieList = new CopyOnWriteArrayList<>();
        gameRecordedTime = System.currentTimeMillis();
        gameElapsedtime = 0;
        currentZombie = 0;

        plantList = new CopyOnWriteArrayList<>();
        tileHasPlant = new HashSet<>();

        sunList = new CopyOnWriteArrayList<>();
        sunGenerationRecordedTime = 0;
        sunGenerationElapsedTime = 0;
        sun = 200;

        plantChosenList = new CopyOnWriteArrayList<>();
        plantSelected = 0;
        showerSelected = false;

        otherSprite = new CopyOnWriteArrayList<>();
        lawnMowers = LawnMower.initialize();
    }
}
