package gol.groovy

class Grid {

    private Cell[][] cells;

    private Grid(Cell[][] cells) {

        this.cells = cells;
    }
    
    def getCells() {

        return this.cells
    }

    def getNeighborCells(int cellRow, int cellColumn) {

        def neighbors = []
        if (this.cells.length <= cellRow || this.cells[cellRow].length <= cellColumn) {

            throw new ArrayIndexOutOfBoundsException()

        } else {

            for (int gridRow = 0; gridRow < this.cells.length; gridRow++) {

                for (int gridColumn = 0; gridColumn < this.cells[gridRow].length; gridColumn++) {

                    if (isNeighbor(cellRow, cellColumn, gridRow, gridColumn)) {

                        neighbors << this.cells[gridRow][gridColumn]
                    } 
                }
            }

            return neighbors
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

    private static def isNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        if (isSpecifiedCell(cellRow, cellColumn, gridRow, gridColumn)) { return false }
        if (isTopLeftNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }
        if (isTopNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }
        if (isTopRightNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }
        if (isLeftNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }
        if (isRightNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }
        if (isBottomLeftNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }
        if (isBottomNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }
        if (isBottomRightNeighbor(cellRow, cellColumn, gridRow, gridColumn)) { return true }

        return false
    }

    private static def isSpecifiedCell(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return (cellRow == gridRow && cellColumn == gridColumn)
    }

    private static def isTopLeftNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return ((gridRow + 1) == cellRow) && ((gridColumn + 1) == cellColumn)
    }    

    private static def isTopNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return ((gridRow + 1) == cellRow) && (gridColumn == cellColumn)
    }    

    private static def isTopRightNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return ((gridRow + 1) == cellRow) && ((gridColumn - 1) == cellColumn)
    }    

    private static def isLeftNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return (gridRow == cellRow) && ((gridColumn + 1) == cellColumn)
    }    

    private static def isRightNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return (gridRow == cellRow) && ((gridColumn - 1) == cellColumn)
    }    

    private static def isBottomLeftNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return ((gridRow - 1) == cellRow) && ((gridColumn + 1) == cellColumn)
    }    

    private static def isBottomNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return ((gridRow - 1) == cellRow) && (gridColumn == cellColumn)
    }    

    private static def isBottomRightNeighbor(int cellRow, int cellColumn, int gridRow, int gridColumn) {

        return ((gridRow - 1) == cellRow) && ((gridColumn - 1) == cellColumn)
    } 
}