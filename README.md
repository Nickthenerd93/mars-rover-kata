# Mars Rover

This repository contains a student project created for an ongoing lecture on object-oriented programming with Java at HWR Berlin (summer term 2022).

> :warning: This code is for educational purpose only. Do not rely on it!

## Abstract

You’re part of the team that explores Mars by sending remotely controlled vehicles to the surface of the planet. Develop an API that translates the commands sent from earth to instructions that are understood by the rover.

https://kata-log.rocks/mars-rover-kata

## Required Features:
- setup the planet with a starting point for the rover
- Implement wrapping at edges. But be careful, planets are spheres. Connect the x edge to the other x edge, so (1,1) for x-1 to (5,1), but connect vertical edges towards themselves in inverted coordinates, so (1,1) for y-1 connects to (5,1)
- implement basic communication via a Collection of commands
- Implement commands that move the rover forward/backward (f,b)
- Implement commands that turn the rover left/right (l,r)
- Implement obstacle detection before each move to a new square. If a given sequence of commands encounters an obstacle, the rover moves up to the last possible point, aborts the sequence and reports the obstacle
- Implement a detection feature, which distinguish between rocks, craters and martians. If the obstacle is an martian, the rover has to shoot a picture (ASCII-Alien in console)

[TODO]: # (State the most interesting problems you encountered during the project.)

## Feature List

[TODO]: # (For each feature implemented, add a row to the table!)

| Number | Feature | Tests |
|--------|---------|-------|
| 1      |setup planet with starting point for the rover|https://github.com/Nickthenerd93/mars-rover-kata/blob/dev/src/test/java/hwr/oop/PlanetTest.java |
| 2      |communication commands| https://github.com/Nickthenerd93/mars-rover-kata/blob/dev/src/test/java/hwr/oop/MarsRoverTest.java |
| 3      |wrapping| https://github.com/Nickthenerd93/mars-rover-kata/blob/dev/src/test/java/hwr/oop/MarsRoverTest.java |
| 4      |obstacle detection| https://github.com/Nickthenerd93/mars-rover-kata/blob/dev/src/test/java/hwr/oop/MarsRoverTest.java |
| 5      |detection feature| https://github.com/Nickthenerd93/mars-rover-kata/blob/dev/src/test/java/hwr/oop/MarsRoverTest.java |

## Additional Dependencies

[TODO]: # (For each additional dependency your project requires- Add an additional row to the table!)

| Number | Dependency Name | Dependency Description | Why is it necessary? |
|--------|-----------------|------------------------|----------------------|
| 1      | Assertj         | Testing Suite          | For Testing          |


