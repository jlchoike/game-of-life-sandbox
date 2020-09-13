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

    def nextGeneration(List<Cell> neighbors) {

        return new Cell(this.row, this.column, this.state.determineNextState(neighbors)) 
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

        POPULATED("P") {

            public State determineNextState(List<Cell> cells) {

                int neighborCount = countdNeighbors(cells)
                if (neighborCount <= 1) { return UNPOPULATED} 
                if (neighborCount >= 4) { return UNPOPULATED}
                return POPULATED
            }
        }, 
        UNPOPULATED(" ") {
            public State determineNextState(List<Cell> cells) {

                return countdNeighbors(cells) == 3 ? POPULATED : UNPOPULATED     
            }
        }

        State(final String stateCode) {

            this.stateCode = stateCode
        }

        private String stateCode;

        public getStateCode() {

            return this.stateCode;
        }

        private static int countdNeighbors(List<Cell> cells) {

            int count = 0;
            cells.each{

                if (State.POPULATED == it.getState()) { count++ }
            }

            return count
        }

        public abstract State determineNextState(List<Cell> cells);
    }
}