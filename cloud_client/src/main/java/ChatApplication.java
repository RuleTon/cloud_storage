import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ChatApplication extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent parent = FXMLLoader.load(getClass().getResource("chatLayout.fxml"));
        primaryStage.setScene(new Scene(parent));
        primaryStage.setTitle("Chat");
        primaryStage.show();
    }
}
