package utility;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import main.Main;

import java.io.IOException;

/**
 * 主游戏循环体结束后输赢提示界面控制类
 */
public class WinLoseController {
    /**
     * <p>
     *     游戏循环体结束后输赢提示界面的控制方法
     * </p>
     * <p>
     *     点击任何一处回到主菜单界面
     * </p>
     * @throws IOException
     */
    public void clickToContinue() throws IOException {
        Parent mainMenuLayout = FXMLLoader.load(Main.class.getResource("/resources/Other/MenuScreen.fxml"));
        Main.setMainMenuScene(new Scene(mainMenuLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());
    }
}
