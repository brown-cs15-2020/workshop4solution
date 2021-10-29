package workshop4solution;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * This is the App class that starts the program.
 */
public class App extends Application {

    /**
     * Starts the program.
     * @param stage Main stage for the program GUI
     */
    @Override
    public void start(Stage stage) {
        stage.setTitle("Bouncing Ball!");
        PaneOrganizer organizer = new PaneOrganizer();
        Scene scene = new Scene(organizer.getRoot(), Constants.SCENE_WIDTH, Constants.SCENE_HEIGHT);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] argv) {
        launch(argv);
    }
}