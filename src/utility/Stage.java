package utility;

import zombie.FlagZombie;

import static utility.Constant.NORMAL_ZOMBIE;
import static utility.Constant.CONEHEAD_ZOMBIE;
import static utility.Constant.BUCKETHEAD_ZOMBIE;
import static utility.Constant.FLAG_ZOMBIE;
import static utility.Constant.NEWSPAPER_ZOMBIE;

/**
 * <p>
 *     <code>Stage</code>类为关卡设定类，用来设定每一关出现的僵尸种类以及僵尸出现的时间。
 * </p>
 */
public class Stage {
    /**
     * 关卡出现的僵尸，记录了出现僵尸的时间以及僵尸的种类。
     */
    public static double[][] stageZombie;

    /**
     * <p>
     *     设定第1关出现的僵尸。
     * </p>
     */
    public static void initializeStage1() {
        stageZombie = new double[][]{
                {8, NORMAL_ZOMBIE},{20, NORMAL_ZOMBIE},{22, NORMAL_ZOMBIE},{30, NORMAL_ZOMBIE},
                {32, CONEHEAD_ZOMBIE},{45, NORMAL_ZOMBIE},{78, FLAG_ZOMBIE},{80, NORMAL_ZOMBIE},
                {82, NORMAL_ZOMBIE},{84, NORMAL_ZOMBIE},{92,FLAG_ZOMBIE},{95, NORMAL_ZOMBIE},
                {97, NORMAL_ZOMBIE},{100, NORMAL_ZOMBIE},{118, CONEHEAD_ZOMBIE},{121, NORMAL_ZOMBIE}
        };
    }

    /**
     * <p>
     *     设定第2关出现的僵尸。
     * </p>
     */
    public static void initializeStage2() {
        stageZombie = new double[][]{
                {5, NORMAL_ZOMBIE},{19,NORMAL_ZOMBIE},{25, NORMAL_ZOMBIE},{30, NORMAL_ZOMBIE},{47, BUCKETHEAD_ZOMBIE},{55, NORMAL_ZOMBIE},{57, CONEHEAD_ZOMBIE},
                {58, NORMAL_ZOMBIE},{60, NORMAL_ZOMBIE},{67, NORMAL_ZOMBIE},{81, FLAG_ZOMBIE},{84, NORMAL_ZOMBIE},
                {94, BUCKETHEAD_ZOMBIE},{105, NORMAL_ZOMBIE},{115, NORMAL_ZOMBIE},{119,FLAG_ZOMBIE},{125, NORMAL_ZOMBIE},
                {127, CONEHEAD_ZOMBIE},{130, NORMAL_ZOMBIE},{134, NORMAL_ZOMBIE},{135, NEWSPAPER_ZOMBIE},{139, NORMAL_ZOMBIE},
        };
    }

    /**
     * <p>
     *     设定第3关出现的僵尸。
     * </p>
     */
    public static void initializeStage3() {
        stageZombie = new double[][]{
                {6, NORMAL_ZOMBIE},{21,NEWSPAPER_ZOMBIE},{27, NORMAL_ZOMBIE},{39, CONEHEAD_ZOMBIE},{45, NORMAL_ZOMBIE},{55, NORMAL_ZOMBIE},
                {64, NORMAL_ZOMBIE},{67, CONEHEAD_ZOMBIE},{75, NORMAL_ZOMBIE},{83, FLAG_ZOMBIE},{87, NORMAL_ZOMBIE},
                {94, NEWSPAPER_ZOMBIE},{108, NORMAL_ZOMBIE},{117, BUCKETHEAD_ZOMBIE},{124,FLAG_ZOMBIE},{127, NORMAL_ZOMBIE},
                {131, CONEHEAD_ZOMBIE},{135, NORMAL_ZOMBIE},{139, NORMAL_ZOMBIE},{142, NEWSPAPER_ZOMBIE},{154, BUCKETHEAD_ZOMBIE},
                {164, NORMAL_ZOMBIE},{169, NORMAL_ZOMBIE}
        };
    }

    /**
     * <p>
     *     设定第4关出现的僵尸。
     * </p>
     */
    public static void initializeStage4() {
        stageZombie = new double[][]{
                {5, NORMAL_ZOMBIE},{15,CONEHEAD_ZOMBIE},{27, NORMAL_ZOMBIE},{39, CONEHEAD_ZOMBIE},{45, NORMAL_ZOMBIE},{55, NORMAL_ZOMBIE},
                {60, NORMAL_ZOMBIE},{65, NORMAL_ZOMBIE},{67, NEWSPAPER_ZOMBIE},{75, NORMAL_ZOMBIE},{85, NORMAL_ZOMBIE},{87, FLAG_ZOMBIE},{88, NORMAL_ZOMBIE},
                {94, BUCKETHEAD_ZOMBIE},{104, NORMAL_ZOMBIE},{108, NORMAL_ZOMBIE},{117, CONEHEAD_ZOMBIE},{124,FLAG_ZOMBIE},{127, NORMAL_ZOMBIE},
                {131, NORMAL_ZOMBIE},{136, CONEHEAD_ZOMBIE},{139, NORMAL_ZOMBIE},{143, NORMAL_ZOMBIE},{147, NEWSPAPER_ZOMBIE},{153, NORMAL_ZOMBIE},
                {154, BUCKETHEAD_ZOMBIE},{158, NORMAL_ZOMBIE},{165, NORMAL_ZOMBIE},{169, NORMAL_ZOMBIE},{180,FLAG_ZOMBIE},{182, NORMAL_ZOMBIE},
                {183, NORMAL_ZOMBIE},{190, NEWSPAPER_ZOMBIE},{195, CONEHEAD_ZOMBIE},{201, NORMAL_ZOMBIE}
        };
    }

    /**
     * <p>
     *     设定第5关出现的僵尸。
     * </p>
     */
    public static void initializeStage5() {
        stageZombie = new double[][]{
                {1,BUCKETHEAD_ZOMBIE},{10, NORMAL_ZOMBIE},{35, NEWSPAPER_ZOMBIE},{55, CONEHEAD_ZOMBIE},{60, BUCKETHEAD_ZOMBIE}
        };
    }
}

