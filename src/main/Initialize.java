package main;

import plant.*;
import utility.Sprite;
import zombie.NormalZombie;
import zombie.Zombie;

import java.util.Collections;

import static main.Game.otherSprite;
import static main.Game.plantChosenList;
import static utility.Constant.currentStage;

/**
 * <p>
 *     <code>Initialize</code>类用来记录一些游戏初始化时的过程，其方法都与游戏初始化有关。
 * </p>
 */
public class Initialize {
    /**
     * <p>
     *     初始化植物购买栏，也就是游戏画面上方显示的一排可供玩家购买的植物。
     * </p>
     * <p>
     *     初始化的时候会对应地把这些植物的冷却时间等属性设置好。
     * </p>
     */
    public static void initializePlantChosenList() {
        Peashooter peashooter = new Peashooter(46, 48, 68);
        Sunflower sunflower = new Sunflower(47, 48, 68);
        CherryBomb cherryBomb = new CherryBomb(48, 48, 68);
        WallNut wallNut = new WallNut(49, 48, 68);
        PotatoMine potatoMine = new PotatoMine(50, 48, 68);
        SnowPea snowPea = new SnowPea(51, 48, 68);
        Chomper chomper = new Chomper(52, 48, 68);
        Repeater repeater = new Repeater(53, 48, 68);
        Collections.addAll(plantChosenList, peashooter, sunflower, cherryBomb, wallNut, potatoMine, snowPea, chomper, repeater);
        for (Plant plant : plantChosenList) {
            if (plant.firstPurchaseNoCooldown) {
                plant.recordedTime = 0;
            }
        }
    }

    /**
     * <p>
     *     初始化一些其他元素，包括背景草地图片，暂停按钮等。
     * </p>
     * <p>
     *     在初始化的时候也会把这些元素的坐标设置好。
     * </p>
     */
    public static void initializeOtherSpriteList() {
        otherSprite.add(new Sprite("/resources/Other/grassTiles.png"));
        otherSprite.add(new Sprite("/resources/Other/plantChosenList.png"));
        Sprite pauseButton = new Sprite("/resources/Other/pauseButton.png");
        pauseButton.setPosition(681, 0);
        otherSprite.add(pauseButton);
    }

    /**
     * <p>
     *     根据当前关卡编号，初始化当前关卡出现的僵尸，也就是设定当前关卡应该出现哪些僵尸。
     * </p>
     */
    public static void initializeStage() {
        switch (currentStage) {
            case 1 -> utility.Stage.initializeStage1();
            case 2 -> utility.Stage.initializeStage2();
            case 3 -> utility.Stage.initializeStage3();
            case 4 -> utility.Stage.initializeStage4();
            case 5 -> utility.Stage.initializeStage5();
        }
    }
}
