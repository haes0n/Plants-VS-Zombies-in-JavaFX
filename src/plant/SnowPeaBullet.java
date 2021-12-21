package plant;

import utility.Sprite;

/**
 * <p>
 *     <code>SnowPeaBullet</code>类为<code>SnowPea</code>对象攻击时所射出的子弹的具体实现。
 * </p>
 */
public class SnowPeaBullet extends Sprite {
    /**
     * <p>
     *     根据传入的<code>Plant</code>对象的坐标创建新的子弹。
     * </p>
     * @param plant 欲创建新的子弹的<code>Plant</code>对象
     */
    public SnowPeaBullet(Plant plant) {
        row = plant.row;
        setImage("/resources/Plants/SnowPea/SnowPea_pea.png", 22, 22);
        setPosition(plant.positionX + 55, plant.positionY + 5);
        setVelocity(100, 0);
    }
}
