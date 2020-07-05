package gol.groovy

public class Cell {

    private int row;
    private int column;
    private State state;

    Cell(int row, int column, State state) {

        this.row = row;
        this.column = column;
        this.state = state;
    }

    public Cell nextGeneration(Cell[] neighbors) {

        return new Cell(this.row, this.column, this.state.determineNextState(neighbors)) 
    }

    public int getRow() {

        return this.row
    }

    public int getColumn() {

        return this.column
    }
    
    public State getState() {

        return this.state
    }

    enum State {

        POPULATED {

            public State determineNextState(Cell[] cells) {

                int neighborCount = countdNeighbors(cells)
                if (neighborCount <= 1) { return UNPOPULATED} 
                if (neighborCount >= 4) { return UNPOPULATED}
                return POPULATED
            }
        }, 
        UNPOPULATED {
            public State determineNextState(Cell[] cells) {

                return countdNeighbors(cells) == 3 ? POPULATED : UNPOPULATED     
            }
        }

        private static int countdNeighbors(Cell[] cells) {

            int count = 0;
            cells.each{

                if (State.POPULATED == it.getState()) { count++ }
            }

            return count
        }

        public abstract State determineNextState(Cell[] cells);
    }
}