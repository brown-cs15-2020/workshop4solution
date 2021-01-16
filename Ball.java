package bouncingBall;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Wrapper class of a circle - represents a ball.
 */
public class Ball {

    private Circle _ball;

    public Ball(Pane pane) {
        _ball = new Circle();
        _ball.setRadius(Constants.BALL_RADIUS);
        _ball.setCenterX(Constants.SCENE_WIDTH / 2);
        _ball.setCenterY(Constants.BALL_START_Y);
        pane.getChildren().addAll(_ball);
    }

    public Circle getBall() {
        return _ball;
    }

    public void setYLocation(double y) {
        _ball.setCenterY(y);
    }

    public double getYLocation() {
        return _ball.getCenterY();
    }
}