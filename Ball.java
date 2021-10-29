package workshop4solution;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;

/**
 * Wrapper class of a circle - represents a ball.
 */
public class Ball {

    private Circle ball;
    private double velocity;

    public Ball(Pane pane) {
        this.ball = new Circle();
        this.ball.setRadius(Constants.BALL_RADIUS);
        this.ball.setCenterX(Constants.SCENE_WIDTH / 2);
        this.ball.setCenterY(Constants.BALL_START_Y);
        pane.getChildren().addAll(this.ball);
    }
    public void updateVelocity(){
        this.velocity = this.velocity + (Constants.GRAVITY*Constants.DURATION);
    }
    public void updatePosition(){
        this.setYLocation(this.getYLocation() + this.velocity * (Constants.DURATION));
    }

    public void setVelocity(double newVel) {
        this.velocity = newVel;
    }

    public Circle getBall() {
        return this.ball;
    }

    public void setYLocation(double y) {
        this.ball.setCenterY(y);
    }

    public double getYLocation() {
        return this.ball.getCenterY();
    }
}