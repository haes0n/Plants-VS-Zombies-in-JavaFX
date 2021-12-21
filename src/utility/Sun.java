package utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import main.Game;
import plant.Plant;
import plant.Sunflower;

import java.awt.event.MouseEvent;
import java.util.Random;

/**
 * <p>
 *     <code>Sun</code>类为太阳的具体实现类，也有一些和太阳有关的方法。
 * </p>
 */
public class Sun extends Sprite {
    /**
     * 记录时间，配合<code>recordedTime</code>和<code>timeIsRecorded</code>实现对太阳出现及消失的控制.
     */
    public long elapsedTime;
    /**
     * 记录时间，配合<code>elapsedTime</code>和<code>timeIsRecorded</code>实现对太阳出现及消失的控制.
     */
    public long recordedTime = 3021051038495L;
    /**
     * 描述太阳的状态，配合<code>elapsedTime</code>和<code>recordedTime</code>实现对太阳出现及消失的控制.
     */
    public boolean timeIsRecorded = false;

    /**
     * <p>
     *     创建一个<code>Sun</code>对象。
     * </p>
     * <p>
     *     此构造方法创建的<code>Sun</code>对象会在屏幕最上方任意x轴位置出现，并开始掉落。
     * </p>
     */
    public Sun() {
        int r = new Random().nextInt(770);
        setImage("/resources/Plants/Sun/Sun_0.png", 60, 60);
        setVelocity(0, Constant.SUN_DROP_SPEED);
        setPosition(r, 0);
    }

    /**
     * <p>
     *     根据传入的<code>Sunflower</code>对象的坐标创建一个<code>Sun</code>对象。
     * </p>
     * <p>
     *     此构造方法创建的<code>Sun</code>对象会出现在<code>Sunflower</code>对象的附近。
     * </p>
     */
    public Sun(Sunflower sunflower) {
        double x = (new Random().nextInt(40)) + (sunflower.positionX + sunflower.width / 2 - 20);
        double y = (new Random().nextInt(40)) + (sunflower.positionY + sunflower.height / 2 - 20);
        recordedTime = System.currentTimeMillis();
        setImage("/resources/Plants/Sun/Sun_0.png", 60, 60);
        setVelocity(0, 0);
        if (x < 0) {
            x = 0;
        } else if (x > 740) {
            x = 740;
        }
        setPosition(x, y);
    }

    /**
     * <p>
     *     更新太阳的显示状态及把太阳渲染到屏幕上。
     * </p>
     * <p>
     *     要是太阳被向日葵生产出来后或是掉落到屏幕最下方超过了6秒后，太阳会消失掉，无法再获取。
     *     若是太阳还在掉落的过程，则此方法会更新太阳的y轴坐标。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    @Override
    public void update(long time, GraphicsContext context) {
        elapsedTime = System.currentTimeMillis() - recordedTime;
        if (elapsedTime > 6000) {
            Game.sunList.remove(this);
        }

        if (positionY < 540) {
            setPosition(positionX + velocityX * 1 / 60, positionY + velocityY * 1 / 60);
        } else if (!timeIsRecorded) {
            recordedTime = System.currentTimeMillis();
            timeIsRecorded = true;
        }
        this.render(context);
    }

    /**
     * <p>
     *     生成天空掉落掉落的太阳。
     * </p>
     * <p>
     *     太阳每隔10秒生成一次。
     * </p>
     */
    public static void generateSun() {
        Game.sunGenerationElapsedTime = System.currentTimeMillis() - Game.sunGenerationRecordedTime;
        if (Game.sunGenerationElapsedTime >= 10000) {
            Game.sunList.add(new Sun());
            Game.sunGenerationRecordedTime = System.currentTimeMillis();
        }
    }

    /**
     * <p>
     *    更新当前的阳光数值的显示。
     * </p>
     * @param context <code>GraphicsContext</code>对象
     */
    public static void updateCurrentSun(GraphicsContext context) {
        String s = String.valueOf(Game.sun);
        context.setFont(new Font(20));
        context.setFill(Color.LIGHTGOLDENRODYELLOW);
        context.fillRect(21, 60, 56, 21);
        context.setFill(Color.BLACK);
        context.fillText(s, 33, 78, 37);
    }

}
