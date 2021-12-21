package utility;

import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Cursor;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Modality;
import main.Main;

import java.io.IOException;

/**
 * 游戏主菜单的控制类。
 */
public class MainMenuController {

    /**
     * <p>
     *     开始游戏按钮的处理方法。
     * </p>
     * <p>
     *     进入关卡选择界面。
     * </p>
     * @throws IOException
     */
    public void startButtonClicked() throws IOException{
        Parent LevelSelectLayout = FXMLLoader.load(Main.class.getResource("/resources/Other/LevelSelect.fxml"));
        Main.setMainMenuScene(new Scene(LevelSelectLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());
//        Main.startMainGame(1);
    }

    /**
     * 当鼠标进入按钮区域改变鼠标样式的方法。
     */
    public void mouseOnButton(){
        Main.getMainMenuScene().setCursor(Cursor.HAND);
    }
    /**
     * 当鼠标离开按钮区域改变鼠标样式的方法。
     */
    public void mouseLeaveButton(){
        Main.getMainMenuScene().setCursor(Cursor.DEFAULT);
    }

    /**
     * <p>
     *     此方法处理退出按钮。
     * </p>
     * <p>
     *     进入确定退出界面
     * </p>
     * @throws IOException
     */
    public void quitButtonClicked() throws IOException {
        Parent confirmQuitLayout = FXMLLoader.load(Main.class.getResource("/resources/Other/MainMenuConfirmQuit.fxml"));
        Main.setMainMenuScene(new Scene(confirmQuitLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());

    }

    /**
     * 此方法处理确定退出按钮。
     */
    public void confirmQuitButton(){
        System.exit(0);
    }

    /**
     * 此方法处理取消退出的按钮。
     *
     * @throws IOException
     */
    public void cancelQuitButton() throws IOException{
        Parent cancelQuitLayout = FXMLLoader.load(Main.class.getResource("/resources/Other/MenuScreen.fxml"));
        Main.setMainMenuScene(new Scene(cancelQuitLayout));
        Main.getMainWindow().setScene(Main.getMainMenuScene());
    }

    /**
     * 选择第一关的按钮处理方法。
     */
    public void level1Button(){
        Main.startMainGame(1);
    }
    /**
     * 选择第二关的按钮处理方法。
     */
    public void level2Button(){
        Main.startMainGame(2);
    }
    /**
     * 选择第三关的按钮处理方法。
     */
    public void level3Button(){
        Main.startMainGame(3);
    }
    /**
     * 选择第四关的按钮处理方法。
     */
    public void level4Button(){
        Main.startMainGame(4);
    }
    /**
     * 选择第五关的按钮处理方法。
     */
    public void level5Button(){
        Main.startMainGame(5);
    }
}
