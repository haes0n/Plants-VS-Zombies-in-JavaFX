package utility;

import javafx.scene.image.Image;
import plant.*;

import java.util.Objects;

import static main.Game.*;

/**
 * <p>
 *     <code>Constant</code>类用来保存所有游戏中用到的常量。
 * </p>
 * <p>
 *     成员变量保存了草地上每个格子的坐标，暂停按钮的位置，僵尸生成的位置数据等。
 *     成员变量也记录了所有植物和僵尸的常量属性，比如植物的冷却时间，生命值，伤害，攻速，僵尸的生命值，移速等。
 * </p>
 */
public class Constant {
    /**
     * 记录了草地每个格子的坐标数据，包括这个格子的左上角的坐标以及右下角的坐标，也记录了上方植物选择列表的植物选择区域的坐标以及铲子的坐标。
     */
    public static final int[][] tiles = {
            {0, 0, 0, 0}, // 0 useless

            {36, 78, 112, 174}, // 1
            {112, 78, 192, 174}, // 2
            {192, 78, 274, 174}, // 3
            {274, 78, 351, 174}, // 4
            {351, 78, 440, 174}, // 5
            {440, 78, 519, 174}, // 6
            {519, 78, 594, 174}, // 7
            {594, 78, 672, 174}, // 8
            {672, 78, 761, 174}, // 9

            {36, 174, 112, 272}, // 10
            {112, 174, 192, 272}, // 11
            {192, 174, 274, 272}, // 12
            {274, 174, 351, 272}, // 13
            {351, 174, 440, 272}, // 14
            {440, 174, 519, 272}, // 15
            {519, 174, 594, 272}, // 16
            {594, 174, 672, 272}, // 17
            {672, 174, 761, 272}, // 18

            {36, 272, 112, 380}, // 19
            {112, 272, 192, 380}, // 20
            {192, 272, 274, 380}, // 21
            {274, 272, 351, 380}, // 22
            {351, 272, 440, 380}, // 23
            {440, 272, 519, 380}, // 24
            {519, 272, 594, 380}, // 25
            {594, 272, 672, 380}, // 26
            {672, 272, 761, 380}, // 27

            {36, 380, 112, 470}, // 28
            {112, 380, 192, 470}, // 29
            {192, 380, 274, 470}, // 30
            {274, 380, 351, 470}, // 31
            {351, 380, 440, 470}, // 32
            {440, 380, 519, 470}, // 33
            {519, 380, 594, 470}, // 34
            {594, 380, 672, 470}, // 35
            {672, 380, 761, 470}, // 36

            {36, 470, 112, 570}, // 37
            {112, 470, 192, 570}, // 38
            {192, 470, 274, 570}, // 39
            {274, 470, 351, 570}, // 40
            {351, 470, 440, 570}, // 41
            {440, 470, 519, 570}, // 42
            {519, 470, 594, 570}, // 43
            {594, 470, 672, 570}, // 44
            {672, 470, 761, 570}, // 45

            {97, 9, 145, 77}, // 46 Peashooter selected
            {156, 9, 204, 77}, // 47 Sunflower selected
            {215, 9, 263, 77}, // 48 Cherry Bomb selected
            {274, 9, 322, 77}, // 49 Wall-Nut selected
            {333, 9, 381, 77}, // 50 Potato Mine selected
            {392, 9, 440, 77}, // 51 Snow Pea selected
            {450, 9, 498, 77}, // 52 Chomper selected
            {509, 9, 557, 77}, // 53 Repeater selected

            {584, 12, 631, 59}, // 54 Shower selected(for removing plant)
            {681, 0, 794, 31} // 55 Pause Button
    };

    /**
     * 保存了新种下的植物出现的位置的坐标，在创建新植物时就会用到此变量的值。
     */
    public static final int[][] newPlantPosition = {
            {0, 0}, // 0 useless

            {44, 90}, // 1
            {122, 90}, // 2
            {201, 90}, // 3
            {283, 90}, // 4
            {363, 90}, // 5
            {446, 90}, // 6
            {526, 90}, // 7
            {601, 90}, // 8
            {683, 90}, // 9

            {44, 188}, // 10
            {122, 188}, // 11
            {201, 188}, // 12
            {283, 188}, // 13
            {363, 188}, // 14
            {446, 188}, // 15
            {526, 188}, // 16
            {601, 188}, // 17
            {683, 188}, // 18

            {44, 288}, // 19
            {122, 288}, // 20
            {201, 288}, // 21
            {283, 288}, // 22
            {363, 288}, // 23
            {446, 288}, // 24
            {526, 288}, // 25
            {601, 288}, // 26
            {683, 288}, // 27

            {44, 392}, // 28
            {122, 392}, // 29
            {201, 392}, // 30
            {283, 392}, // 31
            {363, 392}, // 32
            {446, 392}, // 33
            {526, 392}, // 34
            {601, 392}, // 35
            {683, 392}, // 36

            {44, 484}, // 37
            {122, 484}, // 38
            {201, 484}, // 39
            {283, 484}, // 40
            {363, 484}, // 41
            {446, 484}, // 42
            {526, 484}, // 43
            {601, 484}, // 44
            {683, 484}, // 45

            {97, 9}, // 46 Peashooter selected
            {156, 9}, // 47 Sunflower selected
            {215, 9}, // 48 Cherry Bomb selected
            {274, 9}, // 49 Wall-Nut selected
            {333, 9}, // 50 Potato Mine selected
            {392, 9}, // 51 Snow Pea selected
            {450, 9}, // 52 Chomper selected
            {509, 9}, // 53 Repeater selected

            {584, 12}, // 54 Shower location
            {681, 0} // 55 Pause Button location
    };

    private static final Object o = new Object();

    /**
     * 太阳的编号
     */
    public static final int SUN = 0;
    /**
     * 太阳掉落的速度
     */
    public static final double SUN_DROP_SPEED = 30;

    /**
     * 普通僵尸（Normal Zombie）的编号
     */
    public static final int NORMAL_ZOMBIE = 1;
    /**
     * 普通僵尸（Normal Zombie）的一次攻击所造成的伤害
     */
    public static final double NORMAL_ZOMBIE_DAMAGE = 1;
    /**
     * 普通僵尸（Normal Zombie）的生命值
     */
    public static final double NORMAL_ZOMBIE_HEALTH = 10;
    /**
     * 普通僵尸（Normal Zombie）的攻速
     */
    public static final double NORMAL_ZOMBIE_ATTACK_SPEED = 1;
    /**
     * 普通僵尸（Normal Zombie）的移速
     */
    public static final double NORMAL_ZOMBIE_MOVEMENT_SPEED = -16.67;

    /**
     * 路障僵尸（Conehead Zombie）的编号
     */
    public static final int CONEHEAD_ZOMBIE = 2;
    /**
     * 路障僵尸（Conehead Zombie）的一次攻击所造成的伤害
     */
    public static final double CONEHEAD_ZOMBIE_DAMAGE = 1;
    /**
     * 路障僵尸（Conehead Zombie）的生命值
     */
    public static final double CONEHEAD_ZOMBIE_HEALTH = 29;
    /**
     * 路障僵尸（Conehead Zombie）的攻速
     */
    public static final double CONEHEAD_ZOMBIE_ATTACK_SPEED = 1;
    /**
     * 路障僵尸（Conehead Zombie）的移速
     */
    public static final double CONEHEAD_ZOMBIE_MOVEMENT_SPEED = -16.67;

    /**
     * 铁桶僵尸（Buckethead Zombie）的编号
     */
    public static final int BUCKETHEAD_ZOMBIE = 3;
    /**
     * 铁桶僵尸（Buckethead Zombie）的一次攻击所造成的伤害
     */
    public static final double BUCKETHEAD_ZOMBIE_DAMAGE = 1;
    /**
     * 铁桶僵尸（Buckethead Zombie）的生命值
     */
    public static final double BUCKETHEAD_ZOMBIE_HEALTH = 65;
    /**
     * 铁桶僵尸（Buckethead Zombie）的攻速
     */
    public static final double BUCKETHEAD_ZOMBIE_ATTACK_SPEED = 1;
    /**
     * 铁桶僵尸（Buckethead Zombie）的移速
     */
    public static final double BUCKETHEAD_ZOMBIE_MOVEMENT_SPEED = -16.67;

    /**
     * 摇旗僵尸（Flag Zombie）的编号
     */
    public static final int FLAG_ZOMBIE = 4;
    /**
     * 摇旗僵尸（Flag Zombie）的一次攻击所造成的伤害
     */
    public static final double FLAG_ZOMBIE_DAMAGE = 1;
    /**
     * 摇旗僵尸（Flag Zombie）的生命值
     */
    public static final double FLAG_ZOMBIE_HEALTH = 10;
    /**
     * 摇旗僵尸（Flag Zombie）的攻速
     */
    public static final double FLAG_ZOMBIE_ATTACK_SPEED = 1;
    /**
     * 摇旗僵尸（Flag Zombie）的移速
     */
    public static final double FLAG_ZOMBIE_MOVEMENT_SPEED = -22.22;

    /**
     * 读报僵尸（Newspaper Zombie）的编号
     */
    public static final int NEWSPAPER_ZOMBIE = 5;
    /**
     * 读报僵尸（Newspaper Zombie）的一次攻击所造成的伤害
     */
    public static final double NEWSPAPER_ZOMBIE_DAMAGE = 1;
    /**
     * 读报僵尸（Newspaper Zombie）的生命值
     */
    public static final double NEWSPAPER_ZOMBIE_HEALTH = 17; // 8 for newspaper, 9 for zombie
    /**
     * 读报僵尸（Newspaper Zombie）的攻速
     */
    public static final double NEWSPAPER_ZOMBIE_ATTACK_SPEED = 1;
    /**
     * 读报僵尸（Newspaper Zombie）失去报纸前的移速
     */
    public static final double NEWSPAPER_ZOMBIE_MOVEMENT_SPEED = -16.67;
    /**
     * 读报僵尸（Newspaper Zombie）失去报纸后的移速
     */
    public static final double NEWSPAPER_ZOMBIE_RAGE_MOVEMENT_SPEED = -41.67; // after losing newspaper

    /**
     * 豌豆射手（Peashooter）的编号
     */
    public static final int PEASHOOTER = 1;
    /**
     * 购买豌豆射手（Peashooter）所需的太阳数值
     */
    public static final int PEASHOOTER_SUNCOST = 100;
    /**
     * 豌豆射手（Peashooter）一次攻击所造成的伤害
     */
    public static final double PEASHOOTER_DAMAGE = 1;
    /**
     * 豌豆射手（Peashooter）的生命值
     */
    public static final double PEASHOOTER_HEALTH = 6;
    /**
     * 豌豆射手（Peashooter）的攻速
     */
    public static final double PEASHOOTER_ATTACK_SPEED = 1.5;
    /**
     * 豌豆射手（Peashooter）的购买冷却时间
     */
    public static final double PEASHOOTER_COOLDOWN_TIME = 7.5;

    /**
     * 向日葵（Sunflower）的编号
     */
    public static final int SUNFLOWER = 2;
    /**
     * 购买向日葵（Sunflower）所需的太阳数值
     */
    public static final int SUNFLOWER_SUNCOST = 50;
    /**
     * 向日葵（Sunflower）一次攻击所造成的伤害
     */
    public static final double SUNFLOWER_DAMAGE = 0;
    /**
     * 向日葵（Sunflower）的生命值
     */
    public static final double SUNFLOWER_HEALTH = 6;
    /**
     * 向日葵（Sunflower）生产太阳的间隔时间
     */
    public static final double SUNFLOWER_ATTACK_SPEED = 24;
    /**
     * 向日葵（Sunflower）的购买冷却时间
     */
    public static final double SUNFLOWER_COOLDOWN_TIME = 7.5;

    /**
     * 樱桃炸弹（Cherry Bomb）的编号
     */
    public static final int CHERRY_BOMB = 3;
    /**
     * 购买樱桃炸弹（Cherry Bomb）所需的太阳数值
     */
    public static final int CHERRY_BOMB_SUNCOST = 150;
    /**
     * 樱桃炸弹（Cherry Bomb）一次攻击所造成的伤害
     */
    public static final double CHERRY_BOMB_DAMAGE = 90;
    /**
     * 樱桃炸弹（Cherry Bomb）的生命值
     */
    public static final double CHERRY_BOMB_HEALTH = 9999;
    /**
     * 樱桃炸弹（Cherry Bomb）的攻击等待时间
     */
    public static final double CHERRY_BOMB_ATTACK_SPEED = 1;
    /**
     * 樱桃炸弹（Cherry Bomb）的购买冷却时间
     */
    public static final double CHERRY_BOMB_COOLDOWN_TIME = 50;

    /**
     * 坚果墙（Wall-Nut）的编号
     */
    public static final int WALLNUT = 4;
    /**
     * 购买坚果墙（Wall-Nut）所需的太阳数值
     */
    public static final int WALLNUT_SUNCOST = 50;
    /**
     * 坚果墙（Wall-Nut）一次攻击所造成的伤害
     */
    public static final double WALLNUT_DAMAGE = 0;
    /**
     * 坚果墙（Wall-Nut）的生命值
     */
    public static final double WALLNUT_HEALTH = 72;
    /**
     * 坚果墙（Wall-Nut）的攻速
     */
    public static final double WALLNUT_ATTACK_SPEED = 0;
    /**
     * 坚果墙（Wall-Nut）的购买冷却时间
     */
    public static final double WALLNUT_COOLDOWN_TIME = 30;

    /**
     * 土豆地雷（Potato Mine）的编号
     */
    public static final int POTATO_MINE = 5;
    /**
     * 购买土豆地雷（Potato Mine）所需的太阳数值
     */
    public static final int POTATO_MINE_SUNCOST = 25;
    /**
     * 土豆地雷（Potato Mine）攻击还未冷却好时的伤害
     */
    public static final double POTATO_MINE_INITIALIZE_DAMAGE = 0;
    /**
     * 土豆地雷（Potato Mine）攻击冷却完成后的伤害
     */
    public static final double POTATO_MINE_READY_DAMAGE = 90;
    /**
     * 土豆地雷（Potato Mine）的生命值
     */
    public static final double POTATO_MINE_HEALTH = 6;
    /**
     * 土豆地雷（Potato Mine）的攻击等待时间
     */
    public static final double POTATO_MINE_ATTACK_SPEED = 15;
    /**
     * 土豆地雷（Potato Mine）的购买冷却时间
     */
    public static final double POTATO_MINE_COOLDOWN_TIME = 30;

    /**
     * 雪花射手（Snow Pea）的编号
     */
    public static final int SNOW_PEA = 6;
    /**
     * 购买雪花射手（Snow Pea）所需的太阳数值
     */
    public static final int SNOW_PEA_SUNCOST = 175;
    /**
     * 雪花射手（Snow Pea）一次攻击所造成的伤害
     */
    public static final double SNOW_PEA_DAMAGE = 1; // fires snowpea when attack
    /**
     * 雪花射手（Snow Pea）的生命值
     */
    public static final double SNOW_PEA_HEALTH = 6;
    /**
     * 雪花射手（Snow Pea）的攻速
     */
    public static final double SNOW_PEA_ATTACK_SPEED = 1.5;
    /**
     * 雪花射手（Snow Pea）的购买冷却时间
     */
    public static final double SNOW_PEA_COOLDOWN_TIME = 7.5;
    /**
     * 雪花射手（Snow Pea）的图片宽度
     */
    public static final double SNOW_PEA_WIDTH = 71;
    /**
     * 雪花射手（Snow Pea）的图片高度
     */
    public static final double SNOW_PEA_HEIGHT = 71;

    /**
     * 食人花（Chomper）的编号
     */
    public static final int CHOMPER = 7;
    /**
     * 购买食人花（Chomper）所需的太阳数值
     */
    public static final int CHOMPER_SUNCOST = 150;
    /**
     * 食人花（Chomper）一次攻击所造成的伤害
     */
    public static final double CHOMPER_DAMAGE = 120;
    /**
     * 食人花（Chomper）的生命值
     */
    public static final double CHOMPER_HEALTH = 6;
    /**
     * 食人花（Chomper）的攻速
     */
    public static final double CHOMPER_ATTACK_SPEED = 42;
    /**
     * 食人花（Chomper）的购买冷却时间
     */
    public static final double CHOMPER_COOLDOWN_TIME = 7.5;
    /**
     * 食人花（Chomper）的图片宽度
     */
    public static final double CHOMPER_WIDTH = 100;
    /**
     * 食人花（Chomper）的图片高度
     */
    public static final double CHOMPER_HEIGHT = 96;

    /**
     * 双枪豌豆（Repeater）的编号
     */
    public static final int REPEATER = 8;
    /**
     * 购买双枪豌豆（Repeater）所需的太阳数值
     */
    public static final int REPEATER_SUNCOST = 200;
    /**
     * 双枪豌豆（Repeater）一次攻击所造成的伤害
     */
    public static final double REPEATER_DAMAGE = 1; // fires 2 peas per attack
    /**
     * 双枪豌豆（Repeater）的生命值
     */
    public static final double REPEATER_HEALTH = 6;
    /**
     * 双枪豌豆（Repeater）的攻速
     */
    public static final double REPEATER_ATTACK_SPEED = 1.5;
    /**
     * 双枪豌豆（Repeater）的购买冷却时间
     */
    public static final double REPEATER_COOLDOWN_TIME = 7.5;
    /**
     * 双枪豌豆（Repeater）的图片宽度
     */
    public static final double REPEATER_WIDTH = 73;
    /**
     * 双枪豌豆（Repeater）的图片高度
     */
    public static final double REPEATER_HEIGHT = 71;

    /**
     * 当前游戏关卡
     */
    public static int currentStage = 1;

    /**
     * <p>
     *     传入一个x轴以及y轴坐标，返回这个坐标所在的格子的编号。
     * </p>
     * @param x x轴坐标
     * @param y y轴坐标
     * @return 这个坐标所在的格子的编号
     */
    public static int getTile(double x, double y) {
        for (int i = 0; i < tiles.length; i++) {
            if (x >= tiles[i][0] && x <= tiles[i][2] && y >= tiles[i][1] && y <= tiles[i][3]) {
                return i;
            }
        }
        return 0;
    }

    /**
     * <p>
     *     在当前玩家没有选择购买新植物以及选择使用铲子的情况下，此方法将被调用，用来判定玩家是否选择购买了新植物或点击了铲子。
     * </p>
     * <p>
     *     若是玩家点击购买了新植物或使用了铲子，则会把对应植物或铲子的图片显示出来，并且这个图片跟着鼠标的移动而移动。
     *     若是玩家什么都没选择，或是点击了非法区域，则此方法什么都不做。
     * </p>
     * @param tileNumber 玩家鼠标点击的坐标对应的格子编号
     * @param x 玩家鼠标点击的位置的x轴坐标
     * @param y 玩家鼠标点击的位置的y轴坐标
     */
    public static void getMovingPlantPicture(int tileNumber, double x, double y) {
        if (tileNumber >= 46 && tileNumber <= 53 && sun >= plantChosenList.get(tileNumber - 46).sunCost) {
            Plant p = plantChosenList.get(tileNumber - 46);
            p.elapsedTime = System.currentTimeMillis() - p.recordedTime;

            if (p.elapsedTime > p.cooldownTime * 1000 || p.firstPurchaseNoCooldown) {
                switch (tileNumber) {
                    case 46 -> {
                        plantSelected = 1;
                        plantChosen = new Peashooter(0);
                    }
                    case 47 -> {
                        plantSelected = 2;
                        plantChosen = new Sunflower(0);
                    }
                    case 48 -> {
                        plantSelected = 3;
                        plantChosen = new CherryBomb(0);
                    }
                    case 49 -> {
                        plantSelected = 4;
                        plantChosen = new WallNut(0);
                    }
                    case 50 -> {
                        plantSelected = 5;
                        plantChosen = new PotatoMine(0);
                    }
                    case 51 -> {
                        plantSelected = 6;
                        plantChosen = new SnowPea(0);
                    }
                    case 52 -> {
                        plantSelected = 7;
                        plantChosen = new Chomper(0);
                    }
                    case 53 -> {
                        plantSelected = 8;
                        plantChosen = new Repeater(0);
                    }
                }

                plantChosen.setPosition(x - plantChosen.width / 2, y - plantChosen.height / 2);
            }
        } else if (tileNumber == 54) {
            showerSelected = true;
            plantChosen = new Sprite("/resources/Other/showel.png");
            plantChosen.setPosition(x - 33, y - 33);
        } else {
            plantSelected = 0;
            showerSelected = false;
        }
    }

    /**
     * SnowPea 的图片集
     */
    public static final Image SNOW_PEA_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_0.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_1.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_2.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_3.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_4.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_5.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_6.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_7.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_8.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_9.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_10.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_11.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_12.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_14 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_13.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image SNOW_PEA_IMAGE_15 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/SnowPea/SnowPea_14.png")).toString(),SNOW_PEA_WIDTH,SNOW_PEA_HEIGHT,false,false);
    public static final Image[] SNOW_PEA_IMAGE = {
            SNOW_PEA_IMAGE_1, SNOW_PEA_IMAGE_2, SNOW_PEA_IMAGE_3, SNOW_PEA_IMAGE_4, SNOW_PEA_IMAGE_5, SNOW_PEA_IMAGE_6,
            SNOW_PEA_IMAGE_7, SNOW_PEA_IMAGE_8, SNOW_PEA_IMAGE_9, SNOW_PEA_IMAGE_10, SNOW_PEA_IMAGE_11, SNOW_PEA_IMAGE_12,
            SNOW_PEA_IMAGE_13, SNOW_PEA_IMAGE_14, SNOW_PEA_IMAGE_15
    };

    /**
     * Repeater 的图片集
     */
    public static final Image REPEATER_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_0.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_1.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_2.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_3.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_4.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_5.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_6.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_7.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_8.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_9.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_10.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_11.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_12.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_14 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_13.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image REPEATER_IMAGE_15 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/RepeaterPea/RepeaterPea_14.png")).toString(),REPEATER_WIDTH,REPEATER_HEIGHT,false,false);
    public static final Image[] REPEATER_IMAGE = {
            REPEATER_IMAGE_1, REPEATER_IMAGE_2, REPEATER_IMAGE_3, REPEATER_IMAGE_4, REPEATER_IMAGE_5, REPEATER_IMAGE_6,
            REPEATER_IMAGE_7, REPEATER_IMAGE_8, REPEATER_IMAGE_9, REPEATER_IMAGE_10, REPEATER_IMAGE_11, REPEATER_IMAGE_12,
            REPEATER_IMAGE_13, REPEATER_IMAGE_14, REPEATER_IMAGE_15
    };

    /**
     * Chomper 的图片集
     */
    public static final Image CHOMPER_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_0.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_1.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_2.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_3.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_4.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_5.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_6.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_7.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_8.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_9.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_10.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_11.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/Chomper/Chomper_12.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image[] CHOMPER_IMAGE = {
            CHOMPER_IMAGE_1, CHOMPER_IMAGE_2, CHOMPER_IMAGE_3, CHOMPER_IMAGE_4, CHOMPER_IMAGE_5, CHOMPER_IMAGE_6,
            CHOMPER_IMAGE_7, CHOMPER_IMAGE_8, CHOMPER_IMAGE_9, CHOMPER_IMAGE_10, CHOMPER_IMAGE_11, CHOMPER_IMAGE_12, CHOMPER_IMAGE_13
    };
    /**
     * Chomper 的攻击图片集
     */
    public static final Image CHOMPER_ATTACK_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_0.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_1.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_2.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_3.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_4.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_5.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_6.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_7.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_ATTACK_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperAttack/ChomperAttack_8.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image[] CHOMPER_ATTACK_IMAGE = {
            CHOMPER_ATTACK_IMAGE_1, CHOMPER_ATTACK_IMAGE_2, CHOMPER_ATTACK_IMAGE_3, CHOMPER_ATTACK_IMAGE_4, CHOMPER_ATTACK_IMAGE_5, CHOMPER_ATTACK_IMAGE_6,
            CHOMPER_ATTACK_IMAGE_7, CHOMPER_ATTACK_IMAGE_8, CHOMPER_ATTACK_IMAGE_9
    };
    /**
     * Chomper 的消化图片集
     */
    public static final Image CHOMPER_DIGEST_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperDigest/ChomperDigest_0.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_DIGEST_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperDigest/ChomperDigest_1.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_DIGEST_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperDigest/ChomperDigest_2.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_DIGEST_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperDigest/ChomperDigest_3.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_DIGEST_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperDigest/ChomperDigest_4.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image CHOMPER_DIGEST_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Plants/Chomper/ChomperDigest/ChomperDigest_5.png")).toString(),CHOMPER_WIDTH, CHOMPER_HEIGHT,false,false);
    public static final Image[] CHOMPER_DIGEST_IMAGE = {
            CHOMPER_DIGEST_IMAGE_1, CHOMPER_DIGEST_IMAGE_2, CHOMPER_DIGEST_IMAGE_3, CHOMPER_DIGEST_IMAGE_4, CHOMPER_DIGEST_IMAGE_5, CHOMPER_DIGEST_IMAGE_6,
    };

    /**
     * Normal Zombie 的行走图片集
     */
    public static final Image ZOMBIE_WALKING_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_0.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_1.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_2.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_3.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_4.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_5.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_6.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_7.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_8.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_9.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_10.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_11.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_12.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_14 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_13.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_15 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_14.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_16 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_15.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_17 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_16.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_18 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_17.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_19 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_18.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_20 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_19.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_21 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_20.png")).toString());
    public static final Image ZOMBIE_WALKING_IMAGE_22 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/Zombie/Zombie_21.png")).toString());
    public static final Image[] ZOMBIE_WALKING_IMAGE = {
            ZOMBIE_WALKING_IMAGE_1, ZOMBIE_WALKING_IMAGE_2, ZOMBIE_WALKING_IMAGE_3, ZOMBIE_WALKING_IMAGE_4, ZOMBIE_WALKING_IMAGE_5, ZOMBIE_WALKING_IMAGE_6,
            ZOMBIE_WALKING_IMAGE_7, ZOMBIE_WALKING_IMAGE_8, ZOMBIE_WALKING_IMAGE_9, ZOMBIE_WALKING_IMAGE_10, ZOMBIE_WALKING_IMAGE_11, ZOMBIE_WALKING_IMAGE_12,
            ZOMBIE_WALKING_IMAGE_13,ZOMBIE_WALKING_IMAGE_14,ZOMBIE_WALKING_IMAGE_15,ZOMBIE_WALKING_IMAGE_16,ZOMBIE_WALKING_IMAGE_17,ZOMBIE_WALKING_IMAGE_18,
            ZOMBIE_WALKING_IMAGE_19,ZOMBIE_WALKING_IMAGE_20,ZOMBIE_WALKING_IMAGE_21,ZOMBIE_WALKING_IMAGE_22
    };
    /**
     * Normal Zombie 的攻击图片集
     */
    public static final Image ZOMBIE_ATTACK_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_0.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_1.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_2.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_3.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_4.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_5.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_6.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_7.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_8.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_9.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_10.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_11.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_12.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_14 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_13.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_15 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_14.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_16 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_15.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_17 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_16.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_18 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_17.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_19 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_18.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_20 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_19.png")).toString());
    public static final Image ZOMBIE_ATTACK_IMAGE_21 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NormalZombie/ZombieAttack/ZombieAttack_20.png")).toString());
    public static final Image[] ZOMBIE_ATTACK_IMAGE = {
            ZOMBIE_ATTACK_IMAGE_1, ZOMBIE_ATTACK_IMAGE_2, ZOMBIE_ATTACK_IMAGE_3, ZOMBIE_ATTACK_IMAGE_4, ZOMBIE_ATTACK_IMAGE_5, ZOMBIE_ATTACK_IMAGE_6,
            ZOMBIE_ATTACK_IMAGE_7, ZOMBIE_ATTACK_IMAGE_8, ZOMBIE_ATTACK_IMAGE_9, ZOMBIE_ATTACK_IMAGE_10, ZOMBIE_ATTACK_IMAGE_11, ZOMBIE_ATTACK_IMAGE_12,
            ZOMBIE_ATTACK_IMAGE_13,ZOMBIE_ATTACK_IMAGE_14,ZOMBIE_ATTACK_IMAGE_15,ZOMBIE_ATTACK_IMAGE_16,ZOMBIE_ATTACK_IMAGE_17,ZOMBIE_ATTACK_IMAGE_18,
            ZOMBIE_ATTACK_IMAGE_19,ZOMBIE_ATTACK_IMAGE_20,ZOMBIE_ATTACK_IMAGE_21
    };

    /**
     * BucketHead Zombie 的行走图片集
     */
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_0.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_1.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_2.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_3.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_4.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_5.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_6.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_7.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_8.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_9.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_10.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_11.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_12.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_14 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_13.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_WALKING_IMAGE_15 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombie/BucketheadZombie_14.png")).toString());
    public static final Image[] BUCKETHEAD_ZOMBIE_WALKING_IMAGE = {
            BUCKETHEAD_ZOMBIE_WALKING_IMAGE_1, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_2, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_3, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_4, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_5, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_6,
            BUCKETHEAD_ZOMBIE_WALKING_IMAGE_7, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_8, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_9, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_10, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_11, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_12,
            BUCKETHEAD_ZOMBIE_WALKING_IMAGE_13, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_14, BUCKETHEAD_ZOMBIE_WALKING_IMAGE_15
    };
    /**
     * BucketHead Zombie 的攻击图片集
     */
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_0.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_1.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_2.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_3.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_4.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_5.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_6.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_7.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_8.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_9.png")).toString());
    public static final Image BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/BucketheadZombie/BucketheadZombieAttack/BucketheadZombieAttack_10.png")).toString());
    public static final Image[] BUCKETHEAD_ZOMBIE_ATTACK_IMAGE = {
            BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_1, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_2, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_3, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_4, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_5, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_6,
            BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_7, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_8, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_9, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_10, BUCKETHEAD_ZOMBIE_ATTACK_IMAGE_11
    };

    /**
     * ConeHead Zombie 的行走图片集
     */
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_0.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_1.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_2.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_3.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_4.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_5.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_6.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_7.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_8.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_9.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_10.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_11.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_12.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_14 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_13.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_15 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_14.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_16 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_15.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_17 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_16.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_18 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_17.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_19 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_18.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_20 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_19.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_MOVING_IMAGE_21 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombie/ConeheadZombie_20.png")).toString());
    public static final Image[] CONEHEAD_ZOMBIE_MOVING_IMAGE = {
            CONEHEAD_ZOMBIE_MOVING_IMAGE_1, CONEHEAD_ZOMBIE_MOVING_IMAGE_2, CONEHEAD_ZOMBIE_MOVING_IMAGE_3, CONEHEAD_ZOMBIE_MOVING_IMAGE_4, CONEHEAD_ZOMBIE_MOVING_IMAGE_5, CONEHEAD_ZOMBIE_MOVING_IMAGE_6,
            CONEHEAD_ZOMBIE_MOVING_IMAGE_7, CONEHEAD_ZOMBIE_MOVING_IMAGE_8, CONEHEAD_ZOMBIE_MOVING_IMAGE_9, CONEHEAD_ZOMBIE_MOVING_IMAGE_10, CONEHEAD_ZOMBIE_MOVING_IMAGE_11, CONEHEAD_ZOMBIE_MOVING_IMAGE_12,
            CONEHEAD_ZOMBIE_MOVING_IMAGE_13, CONEHEAD_ZOMBIE_MOVING_IMAGE_14, CONEHEAD_ZOMBIE_MOVING_IMAGE_15, CONEHEAD_ZOMBIE_MOVING_IMAGE_16,CONEHEAD_ZOMBIE_MOVING_IMAGE_17,
            CONEHEAD_ZOMBIE_MOVING_IMAGE_18, CONEHEAD_ZOMBIE_MOVING_IMAGE_19, CONEHEAD_ZOMBIE_MOVING_IMAGE_20, CONEHEAD_ZOMBIE_MOVING_IMAGE_21,
    };
    /**
     * ConeHead Zombie 的攻击图片集
     */
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_0.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_1.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_2.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_3.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_4.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_5.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_6.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_7.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_8.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_9.png")).toString());
    public static final Image CONEHEAD_ZOMBIE_ATTACK_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/ConeheadZombie/ConeheadZombieAttack/ConeheadZombieAttack_10.png")).toString());
    public static final Image[] CONEHEAD_ZOMBIE_ATTACK_IMAGE = {
            CONEHEAD_ZOMBIE_ATTACK_IMAGE_1, CONEHEAD_ZOMBIE_ATTACK_IMAGE_2, CONEHEAD_ZOMBIE_ATTACK_IMAGE_3, CONEHEAD_ZOMBIE_ATTACK_IMAGE_4, CONEHEAD_ZOMBIE_ATTACK_IMAGE_5, CONEHEAD_ZOMBIE_ATTACK_IMAGE_6,
            CONEHEAD_ZOMBIE_ATTACK_IMAGE_7, CONEHEAD_ZOMBIE_ATTACK_IMAGE_8, CONEHEAD_ZOMBIE_ATTACK_IMAGE_9, CONEHEAD_ZOMBIE_ATTACK_IMAGE_10, CONEHEAD_ZOMBIE_ATTACK_IMAGE_11
    };

    /**
     * Flag Zombie 的行走图片集
     */
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_1.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_2.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_3.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_4.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_5.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_6.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_7.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_8.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_9.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_10.png")).toString());
    public static final Image FLAG_ZOMBIE_MOVING_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombie/FlagZombie_11.png")).toString());
    public static final Image[] FLAG_ZOMBIE_MOVING_IMAGE = {
            FLAG_ZOMBIE_MOVING_IMAGE_1, FLAG_ZOMBIE_MOVING_IMAGE_2, FLAG_ZOMBIE_MOVING_IMAGE_3, FLAG_ZOMBIE_MOVING_IMAGE_4, FLAG_ZOMBIE_MOVING_IMAGE_5, FLAG_ZOMBIE_MOVING_IMAGE_6,
            FLAG_ZOMBIE_MOVING_IMAGE_7, FLAG_ZOMBIE_MOVING_IMAGE_8, FLAG_ZOMBIE_MOVING_IMAGE_9, FLAG_ZOMBIE_MOVING_IMAGE_10, FLAG_ZOMBIE_MOVING_IMAGE_11
    };
    /**
     * ConeHead Zombie 的攻击图片集
     */
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_0.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_1.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_2.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_3.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_4.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_5.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_6.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_7.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_8.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_9.png")).toString());
    public static final Image FLAG_ZOMBIE_ATTACK_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/FlagZombie/FlagZombieAttack/FlagZombieAttack_10.png")).toString());
    public static final Image[] FLAG_ZOMBIE_ATTACK_IMAGE = {
            FLAG_ZOMBIE_ATTACK_IMAGE_1, FLAG_ZOMBIE_ATTACK_IMAGE_2, FLAG_ZOMBIE_ATTACK_IMAGE_3, FLAG_ZOMBIE_ATTACK_IMAGE_4, FLAG_ZOMBIE_ATTACK_IMAGE_5, FLAG_ZOMBIE_ATTACK_IMAGE_6,
            FLAG_ZOMBIE_ATTACK_IMAGE_7, FLAG_ZOMBIE_ATTACK_IMAGE_8, FLAG_ZOMBIE_ATTACK_IMAGE_9, FLAG_ZOMBIE_ATTACK_IMAGE_10, FLAG_ZOMBIE_ATTACK_IMAGE_11
    };

    /**
     * Newspaper Zombie 有报纸状态下的行走图片集
     */
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_1.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_2.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_3.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_4.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_5.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_6.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_7.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_8.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_9.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_10.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_11.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_12.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_13.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_14 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_14.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_15 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_15.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_16 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_16.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_17 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_17.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_MOVING_IMAGE_18 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombie/NewspaperZombie_18.png")).toString());
    public static final Image[] NEWSPAPER_ZOMBIE_MOVING_IMAGE = {
            NEWSPAPER_ZOMBIE_MOVING_IMAGE_1, NEWSPAPER_ZOMBIE_MOVING_IMAGE_2, NEWSPAPER_ZOMBIE_MOVING_IMAGE_3, NEWSPAPER_ZOMBIE_MOVING_IMAGE_4, NEWSPAPER_ZOMBIE_MOVING_IMAGE_5, NEWSPAPER_ZOMBIE_MOVING_IMAGE_6,
            NEWSPAPER_ZOMBIE_MOVING_IMAGE_7, NEWSPAPER_ZOMBIE_MOVING_IMAGE_8, NEWSPAPER_ZOMBIE_MOVING_IMAGE_9, NEWSPAPER_ZOMBIE_MOVING_IMAGE_10, NEWSPAPER_ZOMBIE_MOVING_IMAGE_11,NEWSPAPER_ZOMBIE_MOVING_IMAGE_12,
            NEWSPAPER_ZOMBIE_MOVING_IMAGE_13,NEWSPAPER_ZOMBIE_MOVING_IMAGE_14,NEWSPAPER_ZOMBIE_MOVING_IMAGE_15,NEWSPAPER_ZOMBIE_MOVING_IMAGE_16,NEWSPAPER_ZOMBIE_MOVING_IMAGE_17,NEWSPAPER_ZOMBIE_MOVING_IMAGE_18,
    };
    /**
     * Newspaper Zombie 有报纸状态下的攻击图片集
     */
    public static final Image NEWSPAPER_ZOMBIE_ATTACK_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieAttack/NewspaperZombieAttack_1.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_ATTACK_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieAttack/NewspaperZombieAttack_2.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_ATTACK_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieAttack/NewspaperZombieAttack_3.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_ATTACK_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieAttack/NewspaperZombieAttack_4.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_ATTACK_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieAttack/NewspaperZombieAttack_5.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_ATTACK_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieAttack/NewspaperZombieAttack_6.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_ATTACK_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieAttack/NewspaperZombieAttack_7.png")).toString());

    public static final Image[] NEWSPAPER_ZOMBIE_ATTACK_IMAGE = {
            NEWSPAPER_ZOMBIE_ATTACK_IMAGE_1, NEWSPAPER_ZOMBIE_ATTACK_IMAGE_2, NEWSPAPER_ZOMBIE_ATTACK_IMAGE_3, NEWSPAPER_ZOMBIE_ATTACK_IMAGE_4, NEWSPAPER_ZOMBIE_ATTACK_IMAGE_5, NEWSPAPER_ZOMBIE_ATTACK_IMAGE_6,
            NEWSPAPER_ZOMBIE_ATTACK_IMAGE_7
    };
    /**
     * Newspaper Zombie 无报纸状态下的行走图片集
     */
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_1.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_2.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_3.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_4.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_5.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_6.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_7 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_7.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_8 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_8.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_9 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_9.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_10 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_10.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_11 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_11.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_12 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_12.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_13 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaper/NewspaperZombieNoPaper_13.png")).toString());
    public static final Image[] NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE = {
            NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_1, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_2, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_3, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_4, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_5, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_6,
            NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_7, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_8, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_9, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_10, NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_11,NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_12,
            NEWSPAPER_ZOMBIE_NO_PAPER_MOVING_IMAGE_13,
    };
    /**
     * Newspaper Zombie 无报纸状态下的攻击图片集
     */
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_1 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaperAttack/NewspaperZombieNoPaperAttack_1.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_2 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaperAttack/NewspaperZombieNoPaperAttack_2.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_3 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaperAttack/NewspaperZombieNoPaperAttack_3.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_4 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaperAttack/NewspaperZombieNoPaperAttack_4.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_5 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaperAttack/NewspaperZombieNoPaperAttack_5.png")).toString());
    public static final Image NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_6 = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Zombies/NewspaperZombie/NewspaperZombieNoPaperAttack/NewspaperZombieNoPaperAttack_6.png")).toString());
    public static final Image[] NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE = {
            NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_1, NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_2, NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_3, NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_4, NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_5, NEWSPAPER_ZOMBIE_NO_PAPER_ATTACK_IMAGE_6
    };

    /**
     * LawnMower 的图片
     */
    public static final Image LAWN_MOWER_IMAGE = new Image(Objects.requireNonNull(Constant.class.getResource("/resources/Other/LawnMower.png")).toString(),60,60,false,false);

}
