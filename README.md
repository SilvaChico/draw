# Drawing Program

This program is able to create a canvas and drawings on the canvas by issuing various commands. Its interface is the following:

|    Command    |                                                                                   Description                                                                                    |
| :-----------: | :------------------------------------------------------------------------------------------------------------------------------------------------------------------------------: |
|     C w h     |                                                               Should create a new canvas of width w and height h.                                                                |
| L x1 y1 x2 y2 | Should create a new line from (x1,y1) to (x2,y2) . Currently only horizontal or vertical lines are supported. Horizontal and vertical lines will be drawn using the x character. |
| R x1 y1 x2 y2 |     Should create a new rectangle, whose upper left corner is (x1,y1) and lower right corner is (x2,y2) . Horizontal and vertical lines will be drawn using the x character.     |
|       Q       |                                                                             Should quit the program.                                                                             |

## Build and run the program

To build and run the application, run the following commands on the command line inside the project directory:

```bash
./gradlew run --console=plain
```

To run tests:

```bash
./gradlew test
```

## Design decisions
Even though I had never worked with kotlin before I decided it would be a good chance to try it out.
Please feel free to ask me any questions related with my solution.
Hope you like it !
