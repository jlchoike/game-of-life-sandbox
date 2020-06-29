package gol.groovy

class Cell {

    private int row;
    private int column;
    private State state;

    Cell(int row, int column, State state) {

        this.row = row;
        this.column = column;
        this.state = state;
    }

    def nextGeneration(Cell[] neighbors) {

        return new Cell(row, column, POPULATED);
    }

    def getRow() {

        return this.row
    }

    def getColumn() {

        return this.column
    }
    
    def getState() {

        return this.state
    }

    enum State {

        POPULATED, UNPOPULATED
    }
}