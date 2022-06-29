package hwr.oop;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class MarsRoverTest {
    Planet mars;
    Rover marsRover;

    @BeforeEach
    void setup() {
        int orientation = 0;
        int xStartPositionRover = 4;
        int yStartPositionRover = 4;
        mars = new Planet(10, xStartPositionRover, yStartPositionRover);
        marsRover = new Rover(mars, orientation, xStartPositionRover, yStartPositionRover);
    }

    @Test
    void turnRoverLeft() {
        marsRover.turnLeft();
        Assertions.assertThat(marsRover.getOrientation()).isEqualTo(270);
    }

    @Test
    void turnRoverRight() {
        marsRover.turnRight();
        Assertions.assertThat(marsRover.getOrientation()).isEqualTo(90);
    }
    @Test
    void moveRoverForward() {
        marsRover.moveForward();
        Assertions.assertThat((marsRover.getYPosition())).isEqualTo(3);
    }
    @Test
    void rotateLeft_moveBackwards() {
        marsRover.turnLeft();
        marsRover.moveBackward();
        Assertions.assertThat((marsRover.getXPosition())).isEqualTo(5);
    }

    @Test
    void moveAlongRouteToDestination_getFinalPosition() {
        String route = "ffrbllf";
        marsRover.followRoute(route);
        boolean correctPosition = (marsRover.getXPosition() == 2) && (marsRover.getYPosition() == 2);
        Assertions.assertThat(correctPosition).isTrue();
    }

    @Test
    void wrappingAtUpperRightCorner_getNewPosition() {
        int orientation = 0;
        int xStartPositionRover = 9;
        int yStartPositionRover = 0;
        mars = new Planet(10, xStartPositionRover, yStartPositionRover);
        marsRover = new Rover(mars, orientation, xStartPositionRover, yStartPositionRover);
        marsRover.moveForward();
        boolean correctPosition = (marsRover.getXPosition() == 2) && (marsRover.getYPosition() == 9);
        Assertions.assertThat(correctPosition).isTrue();
    }

    @Test
    void wrappingAtUpperRightCorner_getNewOrientation() {
        int orientation = 0;
        int xStartPositionRover = 9;
        int yStartPositionRover = 0;
        mars = new Planet(10, xStartPositionRover, yStartPositionRover);
        marsRover = new Rover(mars, orientation, xStartPositionRover, yStartPositionRover);
        marsRover.moveForward();
        Assertions.assertThat(marsRover.getOrientation()).isEqualTo(180);
    }
}