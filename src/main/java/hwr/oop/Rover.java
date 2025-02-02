package hwr.oop;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Rover {
    private final Planet mars;
    private Orientation cardinalDirection;
    private Position roverPosition;
    private String roverStatusMessage;

    public Rover(Planet mars, Orientation cardinalDirection, Position roverPosition) {
        this.cardinalDirection = cardinalDirection;
        this.mars = mars;
        this.roverPosition = roverPosition;
        this.roverStatusMessage = "Start Engine";
    }

    Orientation getOrientation() {

        return cardinalDirection;
    }

    Position getRoverPosition() {

        return roverPosition;
    }

    int getYPosition() {

        return roverPosition.getYCoordinate();
    }

    int getXPosition() {

        return roverPosition.getXCoordinate();
    }

    void turnLeft() {
        if (cardinalDirection == Orientation.N) {
            this.cardinalDirection = Orientation.W;
        } else if (cardinalDirection == Orientation.E) {
            this.cardinalDirection = Orientation.N;
        } else if (cardinalDirection == Orientation.S) {
            this.cardinalDirection = Orientation.E;
        } else if (cardinalDirection == Orientation.W) {
            this.cardinalDirection = Orientation.S;
        }
    }

    void turnRight() {
        if (cardinalDirection == Orientation.N) {
            this.cardinalDirection = Orientation.E;
        } else if (cardinalDirection == Orientation.E) {
            this.cardinalDirection = Orientation.S;
        } else if (cardinalDirection == Orientation.S) {
            this.cardinalDirection = Orientation.W;
        } else if (cardinalDirection == Orientation.W) {
            this.cardinalDirection = Orientation.N;
        }
    }

    String getRoverStatusMessage() {
        return roverStatusMessage;
    }

    void detectObstacle(Position frontPosition) {
        FieldType frontFieldType = mars.getFieldType(frontPosition);
        if (frontFieldType instanceof Plain) {
            this.roverStatusMessage = "OK";
        }
        if (frontFieldType instanceof Martian) {
            this.roverStatusMessage = "Watch out Martian";
        }
    }

    void roverChangeInPosition(int xChange, int yChange) {
        Position frontPosition;
        int roverXCoordinate = roverPosition.getXCoordinate();
        int roverYCoordinate = roverPosition.getYCoordinate();
        int roverWrappedX = mars.getPlanetDiameter() - (roverXCoordinate + 1);
        boolean xCenterBoundary = (roverXCoordinate > 0) && (roverXCoordinate < mars.getPlanetDiameter() - 1);
        boolean xLowerMargin = (roverXCoordinate == 0) && (cardinalDirection == Orientation.E);
        boolean xUpperMargin = (roverXCoordinate == mars.getPlanetDiameter() - 1) && (cardinalDirection == Orientation.W);
        boolean yCenterBoundary = (roverYCoordinate > 0) && (roverYCoordinate < mars.getPlanetDiameter() - 1);
        boolean yLowerMargin = (roverYCoordinate == 0) && (cardinalDirection == Orientation.S);
        boolean yUpperMargin = (roverYCoordinate == mars.getPlanetDiameter() - 1) && (cardinalDirection == Orientation.N);
        boolean centerFieldEverythingIsFine = xCenterBoundary && yCenterBoundary;
        boolean onMarginsButLookingIntoTheRightDirection = xLowerMargin || xUpperMargin || yLowerMargin || yUpperMargin;

        if (centerFieldEverythingIsFine || onMarginsButLookingIntoTheRightDirection) {
            frontPosition = new Position(roverPosition.getXCoordinate() + xChange, roverPosition.getYCoordinate() + yChange);
            detectObstacle(frontPosition);
            if (roverStatusMessage.equals("OK")) {
                this.roverPosition = frontPosition;
            }
        } else if (roverYCoordinate == 0 && cardinalDirection == Orientation.N) {
            frontPosition = new Position(roverWrappedX, roverYCoordinate);
            detectObstacle(frontPosition);
            if (roverStatusMessage.equals("OK")) {
                this.roverPosition = frontPosition;
                this.cardinalDirection = Orientation.S;
            }
        } else if (roverYCoordinate == mars.getPlanetDiameter() - 1 && cardinalDirection == Orientation.S) {
            frontPosition = new Position(roverWrappedX, roverYCoordinate);
            detectObstacle(frontPosition);
            if (roverStatusMessage.equals("OK")) {
                this.roverPosition = frontPosition;
                this.cardinalDirection = Orientation.N;
            }
        } else if (roverXCoordinate == 0 && cardinalDirection == Orientation.W) {
            frontPosition = new Position(mars.getPlanetDiameter() - 1, roverYCoordinate);
            detectObstacle(frontPosition);
            if (roverStatusMessage.equals("OK")) {
                this.roverPosition = frontPosition;
            }
        } else if (roverXCoordinate == mars.getPlanetDiameter() - 1 && cardinalDirection == Orientation.E) {
            frontPosition = new Position(0, roverYCoordinate);
            detectObstacle(frontPosition);
            if (roverStatusMessage.equals("OK")) {
                this.roverPosition = frontPosition;
            }
        }
    }

    void moveForward() {
        if (cardinalDirection == Orientation.N) {
            roverChangeInPosition(0, -1);
        } else if (cardinalDirection == Orientation.E) {
            roverChangeInPosition(1, 0);
        } else if (cardinalDirection == Orientation.S) {
            roverChangeInPosition(0, 1);
        } else if (cardinalDirection == Orientation.W) {
            roverChangeInPosition(-1, 0);
        }
    }

    void moveBackward() {
        if (cardinalDirection == Orientation.N) {
            roverChangeInPosition(0, 1);
        } else if (cardinalDirection == Orientation.E) {
            roverChangeInPosition(-1, 0);
        } else if (cardinalDirection == Orientation.S) {
            roverChangeInPosition(0, -1);
        } else if (cardinalDirection == Orientation.W) {
            roverChangeInPosition(1, 0);
        }
    }

    void followRoute(String route) {
        List<String> routeSteps = new ArrayList<>(Arrays.asList(route.split(",")));
        for (String step : routeSteps) {
            if (roverStatusMessage.equals("Watch out Martian")) {
                System.out.println(roverStatusMessage);
                break;
            } else if (step.equals("r")) {
                this.turnRight();
            } else if (step.equals("l")) {
                this.turnLeft();
            } else if (step.equals("f")) {
                this.moveForward();
            } else if (step.equals("b")) {
                this.moveBackward();
            }
        }
    }
}
