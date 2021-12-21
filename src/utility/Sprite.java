package utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;

import java.util.Objects;

/**
 * <p>
 *     <code>Sprite</code>类是游戏实现过程中的每个游戏元素的父类。
 * </p>
 * <p>
 *     此类的成员变量包括了每个游戏元素最基本的属性以及这个元素的图片对象，也就是呈现在屏幕上的图片。
 *     方法则与元素的显示和更新有关。
 * </p>
 */
public class Sprite {
    /**
     * 元素的x轴坐标
     */
    public double positionX;
    /**
     * 元素的y轴坐标
     */
    public double positionY;
    /**
     * 元素在x轴上的移速
     */
    public double velocityX;
    /**
     * 元素在y轴上的移速
     */
    public double velocityY;
    /**
     * 图片的宽度
     */
    public double width;
    /**
     * 图片的长度
     */
    public double height;
    /**
     * 元素所在的行（草地一共分为五行）
     */
    public int row;
    /**
     * 图片对象，就是元素呈现在屏幕上的图片
     */
    public Image image;

    /**
     * <p>
     *     创建一个<code>Sprite</code>对象。
     * </p>
     */
    public Sprite() {
    }

    /**
     * <p>
     *     创建一个<code>Sprite</code>对象，根据传入的图片路径来创建<code>Image</code>对象，并赋值给<code>image</code>成员变量。
     * </p>
     * @param path 图片路径
     */
    public Sprite(String path) {
        this();
        setImage(path);
    }

    /**
     * <p>
     *     根据传入的图片路径，创建<code>Image</code>对象，并赋值给<code>image</code>成员变量。
     * </p>
     * <p>
     *     同时根据<code>image</code>的宽度和长度设置<code>width</code>以及<code>height</code>的值。
     * </p>
     * @param path 图片路径
     */
    public void setImage(String path) {
        this.image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(path)));
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }

    /**
     * <p>
     *     把传入的<code>Image</code>对象赋值给<code>image</code>成员变量。
     * </p>
     * <p>
     *     同时根据<code>image</code>的宽度和长度设置<code>width</code>以及<code>height</code>的值。
     * </p>
     * @param image 传入的<code>Image</code>对象
     */
    public void setImage(Image image) {
        this.image = image;
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }

    /**
     * <p>
     *     根据传入的图片路径和指定的图片长宽，创建指定长宽的code>Image</code>对象，并赋值给<code>image</code>成员变量。
     * </p>
     * <p>
     *     同时根据<code>image</code>的宽度和长度设置<code>width</code>以及<code>height</code>的值。
     * </p>
     * @param path 图片路径
     * @param width 指定的创建出来的图片的宽度
     * @param height 指定的创建出来的图片的长度
     */
    public void setImage(String path, double width, double height) {
        this.image = new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(path)), width, height, false, false);
        this.width = this.image.getWidth();
        this.height = this.image.getHeight();
    }

    /**
     * <p>
     *     根据传入的图片路径，创建<code>Image</code>对象，并返回。
     * </p>
     * @param path 图片路径
     * @return 创建的<code>Image</code>对象
     */
    public Image createImage(String path) {
        return new Image(Objects.requireNonNull(this.getClass().getResourceAsStream(path)));
    }

    /**
     * <p>
     *     根据传入的x轴以及y轴坐标，设置其的<code>positionX</code>和<code>positionY</code>变量的值。
     * </p>
     * @param x x轴坐标
     * @param y y轴坐标
     */
    public void setPosition(double x, double y) {
        this.positionX = x;
        this.positionY = y;
    }

    /**
     * <p>
     *     根据传入的元素在x轴上的移速以及元素在y轴上的移速，设置其的<code>velocityX</code>和<code>velocityY</code>变量的值。
     * </p>
     * @param x 元素在x轴上的移速
     * @param y 元素在y轴上的移速
     */
    public void setVelocity(double x, double y) {
        this.velocityX = x;
        this.velocityY = y;
    }

    /**
     * <p>
     *     判断传入的<code>Sprite</code>对象是否与<code>this</code>相交，即是否产生了碰撞。
     * </p>
     * @param otherSprite 其他的<code>Sprite</code>对象
     * @return <code>true</code> 如果传入的<code>Sprite</code>对象与<code>this</code>产生碰撞了。
     */
    public boolean isOverlapped(Sprite otherSprite) {
//        boolean notOverlapped = this.positionX + this.width < otherSprite.positionX ||
//                otherSprite.positionX + otherSprite.width < this.positionX ||
//                this.positionY + this.height < otherSprite.positionY ||
//                otherSprite.positionY + otherSprite.height < this.positionY;
        if (this.row == otherSprite.row) {
            return !(this.positionX + this.width < otherSprite.positionX || otherSprite.positionX + otherSprite.width < this.positionX);
        }
        return false;
    }

    /**
     * <p>
     *     更新<code>Sprite</code>对象的属性及状态，比如更新图片坐标。
     * </p>
     * <p>
     *     此方法也把<code>Sprite</code>对象渲染到屏幕上。
     * </p>
     * @param time 时间
     * @param context <code>GraphicsContext</code>对象
     */
    public void update(long time, GraphicsContext context) {
        this.render(context);
    }

    /**
     * <p>
     *     此方法为把<code>Sprite</code>对象渲染到屏幕上的具体实现。
     * </p>
     * @param context <code>GraphicsContext</code>对象
     */
    public void render(GraphicsContext context) {
        context.save();
        context.translate(this.positionX, this.positionY);
        context.drawImage(this.image, 0, 0);
        context.restore();
    }
}
