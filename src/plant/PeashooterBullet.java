package plant;

import utility.Sprite;

/**
 * <p>
 *     <code>PeashooterBullet</code>类为<code>Peashooter</code>和<code>Repeater</code>对象攻击时所射出的子弹的具体实现。
 * </p>
 */
public class PeashooterBullet extends Sprite {
    /**
     * <p>
     *     根据传入的<code>Plant</code>对象的坐标创建新的子弹。
     * </p>
     * @param plant 欲创建新的子弹的<code>Plant</code>对象
     */
    public PeashooterBullet(Plant plant) {
        row = plant.row;
        setImage("/resources/Plants/Peashooter/Peashooter_pea.png", 20, 20);
        setPosition(plant.positionX + 55, plant.positionY + 5);
        setVelocity(100, 0);
    }
}
