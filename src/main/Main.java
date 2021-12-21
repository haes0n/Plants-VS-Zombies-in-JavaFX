package main;


import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import plant.*;
import utility.MainMenuController;
import utility.Sprite;
import utility.Sun;
import zombie.Zombie;

import java.util.concurrent.CopyOnWriteArrayList;

import static main.Game.*;
import static utility.Constant.*;

/**
 * <p>
 *     <code>Main</code>类是程序的起点，也是程序的主体所在。
 * </p>
 * @author 叶菸淮
 * @author 张健泓
 * @author 陈子庆
 */
public class Main extends Application {
    /**
     * 游戏的主窗口
     */
    private static Stage mainWindow;
    /**
     * 主游戏体页面的布局
     */
    private static BorderPane root;
    /**
     * 主游戏体的屏幕
     */
    private static Scene scene;
    /**
     * 主游戏体的画布
     */
    private static Canvas canvas;
    /**
     * 主游戏体的画笔
     */
    private static GraphicsContext context;

    /**
     * 游戏的主菜单页面的布局
     */
    private static Parent mainMenuLayout;
    /**
     * 游戏的主菜单页面
     */
    private static Scene mainMenuScene;

    /**
     * 主游戏体的音乐播放器
     */
    private static MediaPlayer mediaPlayer;

    /**
     * <p>
     *     程序的起点。
     * </p>
     * @param args 命令行参数
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * <p>
     *     游戏的入口方法，main函数调用此方法进入游戏主页面。
     * </p>
     * <p>
     *     首先对游戏窗口进行一些初始设置，如标题，游戏窗口大小等。随后进入游戏主页面。
     * </p>
     * @param stage <code>Stage</code>对象
     * @throws Exception 方法调用时失败时抛出的异常
     */
    @Override
    public void start(Stage stage) throws Exception {
        stage.setTitle("Plants VS Zombies");
        stage.setResizable(false);
        stage.setAlwaysOnTop(true);

        mainWindow = stage;
        mainMenuLayout = FXMLLoader.load(Main.class.getResource("/resources/Other/MenuScreen.fxml"));
        mainMenuScene = new Scene(mainMenuLayout,800,600);

        stage.setScene(mainMenuScene);
        stage.show();
    }

    /**
     * <p>
     *     主游戏体的开始方法。
     * </p>
     * <p>
     *     在主页面选择关卡后，先设置关卡并初始化。
     *     之后对游戏的页面设定了监听器。
     *     首先设置的是鼠标点击事件的监听器，要是鼠标被点击后，会根据鼠标点击的目标及位置执行相应的操纵。
     *     在点击了植物购买栏目中的某个植物，购买了植物后，要是鼠标下一次点击的位置为合法位置，则会在对应坐标的格子上种下新植物，否则什么都不做。
     *     在点击了铲子后，要是下一次鼠标点击的目标是植物，则铲子会把这植物删去。要是鼠标点击的是太阳，则太阳会消失掉，阳光值相应地增加。
     *     鼠标点击监听器也对暂停按钮进行监测，要是监测到暂停按钮被点击就会暂停游戏或恢复游戏运行。
     *     然后设置了鼠标移动事件的监听器，用来实现在点击购买新植物后，植物会随着鼠标坐标的改变而改变显示位置。
     *     随后游戏正式开始。
     * </p>
     * @param stage 游戏关卡
     * @see MainMenuController 主菜单点击开始进入选择关卡，选择关卡后随即调用此方法
     */
    public static void startMainGame(int stage){
        currentStage = stage;

        //song
        Media media = new Media(Main.class.getResource("/resources/Music/game1.mp3").toString());
        mediaPlayer = new MediaPlayer(media);
        mediaPlayer.play();

        //Initialize
        Game.InitializeGame();
        Initialize.initializeOtherSpriteList();
        Initialize.initializePlantChosenList();
        Initialize.initializeStage();

        root = new BorderPane();
        canvas = new Canvas(800, 600);
        context = canvas.getGraphicsContext2D();
        root.setCenter(canvas);
        scene = new Scene(root);

        mainWindow.setScene(scene);

        canvas.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                double x = mouseEvent.getX();
                double y = mouseEvent.getY();
                int tileNumber = getTile(x, y);

                for (Sun sun : sunList) {
                    if (x >= sun.positionX && x <= sun.positionX + sun.width && y >= sun.positionY && y <= sun.positionY + sun.height) {
                        Game.sun += 25;
                        sunList.remove(sun);
                        return;
                    }
                }

                if (tileNumber == 55 && !gameIsPause) {
                    gamePause();
                    return;
                }
                if (tileNumber == 55) {
                    gameContinue();
                    return;
                }

                if (showerSelected && !gameIsPause) {
                    if (tileNumber >= 1 && tileNumber <= 45 && tileHasPlant.contains(tileNumber)) {
                        for (Plant plant : plantList) {
                            if (plant.tile == tileNumber) {
                                plantList.remove(plant);
                                tileHasPlant.remove(tileNumber);
                                break;
                            }
                        }
                    }

                    plantChosen = null;
                    showerSelected = false;
                    return;
                }

                if (plantSelected > 0 && !gameIsPause) {
                    Plant p = plantChosenList.get(plantSelected - 1);

                    if (tileNumber >= 1 && tileNumber <= 45 && !tileHasPlant.contains(tileNumber) && sun >= p.sunCost) {
                        switch (plantSelected) {
                            case PEASHOOTER -> plantList.add(new Peashooter(tileNumber));
                            case SUNFLOWER -> plantList.add(new Sunflower(tileNumber));
                            case CHERRY_BOMB -> plantList.add(new CherryBomb(tileNumber));
                            case WALLNUT -> plantList.add(new WallNut(tileNumber));
                            case POTATO_MINE -> plantList.add(new PotatoMine(tileNumber));
                            case SNOW_PEA -> plantList.add(new SnowPea(tileNumber));
                            case CHOMPER -> plantList.add(new Chomper(tileNumber));
                            case REPEATER -> plantList.add(new Repeater(tileNumber));
                        }

                        sun -= p.sunCost;
                        p.firstPurchaseNoCooldown = false;
                        p.recordedTime = System.currentTimeMillis();
                    }

                    plantChosen = null;
                    plantSelected = 0;
                } else if (!gameIsPause) {
                    getMovingPlantPicture(tileNumber, x, y);
                }
            }
        });

        canvas.setOnMouseMoved(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                if (plantSelected > 0 || showerSelected) {
                    plantChosen.setPosition(mouseEvent.getX() - plantChosen.width / 2, mouseEvent.getY() - plantChosen.height / 2);
                }
            }
        });
        GameAnimation animationTimer = new GameAnimation();
        animationTimer.start();
        recordedAnimationTimer = animationTimer;
    }

    /**
     * <p>
     *     获取游戏主窗口方法
     * </p>
     * @return 返回游戏主窗口
     */
    public static Stage getMainWindow() {
        return mainWindow;
    }

    /**
     * <p>
     *     获取游戏主菜单页面方法
     * </p>
     * @return 返回游戏主菜单页面
     */
    public static Scene getMainMenuScene() {
        return mainMenuScene;
    }

    /**
     * <p>
     *     设置游戏主菜单页面方法
     * </p>
     * @param mainMenuScene 欲设置的游戏主菜单页面
     */
    public static void setMainMenuScene(Scene mainMenuScene) {
        Main.mainMenuScene = mainMenuScene;
    }

    /**
     * <p>
     *     获取主游戏体画笔方法
     * </p>
     * @return 返回主游戏体画笔
     */
    public static GraphicsContext getContext() {
        return context;
    }

    /**
     * <p>
     *     获取主游戏体音乐播放器方法
     * </p>
     * @return 返回主游戏体音乐播放器
     */
    public static MediaPlayer getMediaPlayer() {
        return mediaPlayer;
    }

}
