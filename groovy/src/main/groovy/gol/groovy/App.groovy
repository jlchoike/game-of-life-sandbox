/*.g
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package gol.groovy

class App {

    static void main(String[] args) {

        def seed = new Random()
        seed.setSeed(System.currentTimeMillis())
        def grid = Grid.newInstance(10, 10, seed)

        int generations = 10
        (0..generations).each {
            def cells = grid.cells
            System.out.println("Generation " + generation)
            System.out.println(generateGrid(cells))
            grid.update()
        }
    }

    private static String generateGrid(Cell[][] cells) {
        StringBuilder display = new StringBuilder();

        cells.eachWithIndex { Cell[] rowCells, int row ->
            entry.eachWithIndex { Cell columnCells, int column ->
                display.append(cells[gridRow][gridColumn].getState().getStateCode()).append("\t")
            }
            display.append("\n")
        }
        return display.toString();
    }
}
