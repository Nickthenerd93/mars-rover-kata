package hwr.oop;

import java.util.HashMap;
import java.util.Map;

class Planet {
    private final int planetDiameter;
    private final Position roverPosition;
    private final Map<Position, Field> fields = new HashMap<>();

    public Planet(int planetDiameter, Position roverPosition) {
        this.planetDiameter = planetDiameter;
        this.roverPosition = roverPosition;
        generatePlainFields();
    }

    void generatePlainFields() {
        for (int x = 0; x < planetDiameter; x++) {
            for (int y = 0; y < planetDiameter; y++) {
                Position position = new Position(x, y);
                FieldType plain = new Plain();
                Field field = new Field(plain);
                fields.put(position, field);
            }
        }
    }

    int getPlanetDiameter() {
        return planetDiameter;
    }

    int getArea() {

        return planetDiameter * planetDiameter;
    }

    FieldType getFieldType(Position position) {
        Field field = fields.get(position);
        FieldType fieldType = field.getFieldType();
        return fieldType;
    }

    void setObstacle(FieldType fieldType, Position position) {
        Field field = new Field(fieldType);
        fields.replace(position, field);
    }
}
