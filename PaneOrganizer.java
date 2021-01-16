package bouncingBall;

import javafx.scene.layout.Pane;

/**
 * Organizes GUI layout for bouncing ball.
 */
public class PaneOrganizer {
    private Pane _root;

    public PaneOrganizer() {
        _root = new Pane();
        new BouncingBall(_root);
    }

    public Pane getRoot() {
        return _root;
    }
}

