package bouncingBall;

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
    private Ball _ball;
    private Pane _demoPane;
    private Rectangle _bottomLine;

    public BouncingBall(Pane demoPane) {
        _demoPane = demoPane;
        _bottomLine = new Rectangle();
        _bottomLine.setHeight(Constants.GROUND_HEIGHT);
        _bottomLine.setWidth(Constants.GROUND_WIDTH);
        _bottomLine.setX(Constants.GROUND_X);
        _bottomLine.setY(Constants.GROUND_Y);
        _bottomLine.setFill(Color.BLUEVIOLET);
        _demoPane.getChildren().add(_bottomLine);
        _ball = new Ball(demoPane);
        this.setUpTimeline();
    }

    private void setUpTimeline() {
        KeyFrame kf = new KeyFrame(Duration.seconds(Constants.DURATION), new DemoHandler());
        Timeline timeline = new Timeline(kf);
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
    }

    private class DemoHandler implements EventHandler<ActionEvent> {
        private double _velocity;
        private double _currentVelocity;
        private double _position;
        public DemoHandler() {
            _velocity = 10;
        }

        @Override
        public void handle(ActionEvent event) {
            this.updateBall();
        }

        private void updateBall() {
            //TODO implement bounce simulation algorithm
            if(_ball.getBall().intersects(_bottomLine.getX(),_bottomLine.getY(),_bottomLine.getWidth()
                    ,_bottomLine.getHeight())){
                _currentVelocity = Constants.REBOUND_VELOCITY;

            }else{
                _currentVelocity = _currentVelocity + Constants.DURATION * Constants.GRAVITY;
            }
            _position = _ball.getYLocation() + _currentVelocity * Constants.DURATION;
            _ball.setYLocation(_position);
        }
    }


}