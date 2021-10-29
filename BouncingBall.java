package workshop4solution;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.util.Duration;

/**
 * FILL IN THIS CLASS FOR DEMO
 * Top-level logical class of our program, contains timeline of bouncing ball.
 */
public class BouncingBall {
    private Ball ball;
    private Pane demoPane;
    private Rectangle bottomLine;

    public BouncingBall(Pane demoPane) {
        this.demoPane = demoPane;
        this.setUpBottomLine();
        this.ball = new Ball(demoPane);
        this.setUpTimeline();
    }

    private void setUpBottomLine() {
        this.bottomLine = new Rectangle();
        this.bottomLine.setHeight(Constants.GROUND_HEIGHT);
        this.bottomLine.setWidth(Constants.GROUND_WIDTH);
        this.bottomLine.setX(Constants.GROUND_X);
        this.bottomLine.setY(Constants.GROUND_Y);
        this.bottomLine.setFill(Color.BLUEVIOLET);
        this.demoPane.getChildren().add(this.bottomLine);
    }

    private void setUpTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), (ActionEvent e) -> this.updateBall());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }
    private void bounce(){
        if (this.ball.getBall().intersects(this.bottomLine.getLayoutBounds())){
            this.ball.setVelocity(Constants.REBOUND_VELOCITY);
        }
    }

    private void updateBall() {
        //TODO implement bounce simulation algorithm
        this.ball.updateVelocity();
        this.ball.updatePosition();
        this.bounce();

    }
}
