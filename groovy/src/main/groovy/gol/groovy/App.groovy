/*.g
 * This Groovy source file was generated by the Gradle 'init' task.
 */
package gol.groovy

class App {

    static void main(String[] args) {

        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(10, 10, seed)

        int generations = 3
        StringBuilder display = new StringBuilder()
        def cells = grid.cells

        for (int g = 0; g < generations; g++) 

            System.out.println("Generation " + g)
        
            for (int gridRow = 0; gridRow < cells.length; gridRow++) {

                for (int gridColumn = 0; gridColumn < cells[gridRow].length; gridColumn++) {

                    display.append(cells[gridRow][gridColumn].getState()).append("\t")
                }

                display.append("\n")
            }
       
            System.out.println(display.toString())

            grid.update()
        }
    }
