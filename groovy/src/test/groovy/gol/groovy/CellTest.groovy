package gol.groovy

import spock.lang.Specification

class CellTest extends Specification {

    def "Unpopulated Cell becomes populated when it has 3 neighbors"() {
        setup:
        //      0   1
        //  0   S   P
        //  1   P   P
        Cell[] neighbors = [new Cell(0, 1, Cell.State.POPULATED),
            new Cell(1, 1, Cell.State.POPULATED),
            new Cell(1, 0, Cell.State.POPULATED)]

        Cell subject = new Cell(0, 0, Cell.State.UNPOPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.POPULATED == nextGeneration.getState()
    }

    def "Unpopulated Cell remains unpopulated when it has zero neighbors"() {
        setup:
        //      0   1
        //  0   S   U
        //  1   U   U
        Cell[] neighbors = [new Cell(0, 1, Cell.State.UNPOPULATED),
            new Cell(1, 1, Cell.State.UNPOPULATED),
            new Cell(1, 0, Cell.State.UNPOPULATED)]

        Cell subject = new Cell(0, 0, Cell.State.UNPOPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.UNPOPULATED == nextGeneration.getState()
    }

    def "Populated cell dies when it has zero neighbors"() {
        setup:
        //      0   1
        //  0   S   U
        //  1   U   U
        Cell[] neighbors = [new Cell(0, 1, Cell.State.UNPOPULATED),
            new Cell(1, 1, Cell.State.UNPOPULATED),
            new Cell(1, 0, Cell.State.UNPOPULATED)]

        Cell subject = new Cell(0, 0, Cell.State.POPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.UNPOPULATED == nextGeneration.getState()
    }

    def "Populated cell dies when it has only one neighbor"() {
        setup:
        //      0   1
        //  0   S   P
        //  1   U   U
        Cell[] neighbors = [new Cell(0, 1, Cell.State.POPULATED),
            new Cell(1, 1, Cell.State.UNPOPULATED),
            new Cell(1, 0, Cell.State.UNPOPULATED)]

        Cell subject = new Cell(0, 0, Cell.State.POPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.UNPOPULATED == nextGeneration.getState()
    }

    def "Populated cell dies when it has four neighbors"() {
        //      0   1   2
        //  0   P   S   P
        //  1   U   P   P
        Cell[] neighbors = [new Cell(0, 0, Cell.State.UNPOPULATED),
        new Cell(0, 2, Cell.State.POPULATED),
        new Cell(1, 0, Cell.State.UNPOPULATED),
        new Cell(1, 2, Cell.State.POPULATED),
        new Cell(2, 0, Cell.State.POPULATED),
        new Cell(2, 1, Cell.State.POPULATED),
        new Cell(2, 2, Cell.State.UNPOPULATED)]

        Cell subject = new Cell(1, 1, Cell.State.POPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.UNPOPULATED == nextGeneration.getState()
    }

    def "Populated cell dies when it has more than four neighbors"() {
        //      0   1   2
        //  0   U   S   P
        //  1   P   S   P
        //  2   P   P   U
        Cell[] neighbors = [new Cell(0, 0, Cell.State.UNPOPULATED),
        new Cell(0, 2, Cell.State.POPULATED),
        new Cell(1, 0, Cell.State.POPULATED),
        new Cell(1, 2, Cell.State.POPULATED),
        new Cell(2, 0, Cell.State.POPULATED),
        new Cell(2, 1, Cell.State.POPULATED),
        new Cell(2, 2, Cell.State.UNPOPULATED)]

        Cell subject = new Cell(1, 1, Cell.State.POPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.UNPOPULATED == nextGeneration.getState()        
    }

    def "Populated cell survives when it has two neighbors"() {
        setup:
        // S P
        // P U
        Cell[] neighbors = [new Cell(0, 1, Cell.State.POPULATED),
            new Cell(1, 1, Cell.State.UNPOPULATED),
            new Cell(1, 0, Cell.State.POPULATED)]

        Cell subject = new Cell(0, 0, Cell.State.POPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.POPULATED == nextGeneration.getState()  
    }

    def "Populated cell survives when it has three neighbors"() {
        setup:
        // S P
        // P P
        Cell[] neighbors = [new Cell(0, 1, Cell.State.POPULATED),
            new Cell(1, 1, Cell.State.POPULATED),
            new Cell(1, 0, Cell.State.POPULATED)]

        Cell subject = new Cell(0, 0, Cell.State.POPULATED)

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        assert subject.getRow() == nextGeneration.getRow()
        assert subject.getColumn() == nextGeneration.getColumn()
        assert Cell.State.POPULATED == nextGeneration.getState()        
    }
}