package gol.groovy

class Grid {

    private Cell[][] cells;

    private Grid(Cell[][] cells) {

        this.cells = cells;
    }
    
    def getCells() {

        return this.cells
    }

    def List<Cell> getNeighborCells(int row, int column) {

        if (this.cells.length <= row || this.cells[row].length <= column) {

            throw new ArrayIndexOutOfBoundsException()

        } else {

            

        }
    }

    static def newInstance(int rows, int columns, Random seed) {

        Cell[][] cells = new Cell[rows][columns]
        for (int row = 0; row < rows; row++) {

            for (int column = 0; column < columns; column++) {

                Cell cell = new Cell(row, column, determineInitialState(seed, (rows * columns)))
                cells[row][column] = cell
            }
        }

        return new Grid(cells) 
    }

    private static def determineInitialState(Random seed, int bound) {

        return ((seed.nextInt(bound) % 2) == 0) ? Cell.State.POPULATED : Cell.State.UNPOPULATED
    }


}