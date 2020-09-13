package gol.groovy

import java.util.Random
import spock.lang.Specification

class GridTest extends Specification {

    def "Grid creates new instance"() {
        setup:
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)

        when:
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        then:
        assert grid != null
        
        def actualCells = grid.getCells()
        assert actualCells != null
        assert actualCells.length == rowCount
        assert actualCells[0].length == columnCount
        
        for (int row = 0; row < actualCells.length; row++) {

            for (int column = 0; column < actualCells[row].length; column++) {

                Cell actualCell = actualCells[row][column]
                assert row == actualCell.getRow()
                assert column == actualCell.getColumn()
                assert actualCell.getState() != null
            }
        }
    }

    def "Grid throws ArrayIndexOutOfBoundsException when specified cell does not exist on grid"() {
        setup:
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)
        
        when:
        grid.getNeighborCells(4, 4)     
        
        then:
        thrown(ArrayIndexOutOfBoundsException)   
    }

    def "Grid gets neighbors of top left corner cell, in row-wise order"() {
        //      0   1   2
        //  0   C   N   X
        //  1   N   N   X
        //  2   X   X   X
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(0, 0)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 3
        assert neighbors[0].getRow() == 0 && neighbors[0].getColumn() == 1
        assert neighbors[1].getRow() == 1 && neighbors[1].getColumn() == 0 
        assert neighbors[2].getRow() == 1 && neighbors[2].getColumn() == 1                
    }

    def "Grid gets neighbors of top right corner cell, in row-wise order"() {
        //      0   1   2
        //  0   X   N   C
        //  1   X   N   N
        //  2   X   X   X
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(0, 2)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 3
        assert neighbors[0].getRow() == 0 && neighbors[0].getColumn() == 1
        assert neighbors[1].getRow() == 1 && neighbors[1].getColumn() == 1 
        assert neighbors[2].getRow() == 1 && neighbors[2].getColumn() == 2        
    }

    def "Grid gets neighbors of bottom left corner cell, in row-wise order"() {
        //      0   1   2
        //  0   X   X   X
        //  1   N   N   X
        //  2   C   N   X
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(2, 0)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 3
        assert neighbors[0].getRow() == 1 && neighbors[0].getColumn() == 0
        assert neighbors[1].getRow() == 1 && neighbors[1].getColumn() == 1 
        assert neighbors[2].getRow() == 2 && neighbors[2].getColumn() == 1  
    }

    def "Grid gets neighbors of bottom right corner cell, in row-wise order"() {
        //      0   1   2
        //  0   X   X   X
        //  1   X   N   N
        //  2   X   N   C  
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(2, 2)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 3
        assert neighbors[0].getRow() == 1 && neighbors[0].getColumn() == 1
        assert neighbors[1].getRow() == 1 && neighbors[1].getColumn() == 2 
        assert neighbors[2].getRow() == 2 && neighbors[2].getColumn() == 1                
    }

    def "Grid gets neighbors of top middle cell, in row-wise order"() {
        //      0   1   2
        //  0   N   C   N
        //  1   N   N   N
        //  2   X   X   X
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(0, 1)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 5
        assert neighbors[0].getRow() == 0 && neighbors[0].getColumn() == 0
        assert neighbors[1].getRow() == 0 && neighbors[1].getColumn() == 2 
        assert neighbors[2].getRow() == 1 && neighbors[2].getColumn() == 0
        assert neighbors[3].getRow() == 1 && neighbors[3].getColumn() == 1
        assert neighbors[4].getRow() == 1 && neighbors[4].getColumn() == 2                        
    }
    
    def "Grid gets neighbors of bottom middle cell, in row-wise order"() {
        //      0   1   2
        //  0   X   X   X
        //  1   N   N   N
        //  2   N   C   N
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(2, 1)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 5
        assert neighbors[0].getRow() == 1 && neighbors[0].getColumn() == 0
        assert neighbors[1].getRow() == 1 && neighbors[1].getColumn() == 1 
        assert neighbors[2].getRow() == 1 && neighbors[2].getColumn() == 2 
        assert neighbors[3].getRow() == 2 && neighbors[3].getColumn() == 0
        assert neighbors[4].getRow() == 2 && neighbors[4].getColumn() == 2                        
    }

    def "Grid gets neighbors of left middle cell, in row-wise order"() {
        //      0   1   2
        //  0   N   N   X
        //  1   C   N   X
        //  2   N   N   X
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(1,0)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 5
        assert neighbors[0].getRow() == 0 && neighbors[0].getColumn() == 0
        assert neighbors[1].getRow() == 0 && neighbors[1].getColumn() == 1 
        assert neighbors[2].getRow() == 1 && neighbors[2].getColumn() == 1 
        assert neighbors[3].getRow() == 2 && neighbors[3].getColumn() == 0
        assert neighbors[4].getRow() == 2 && neighbors[4].getColumn() == 1                       
    }

    def "Grid gets neighbors of right middle cell, in row-wise order"() {
        //      0   1   2
        //  0   X   N   N
        //  1   X   N   C
        //  2   X   N   N
        def rowCount = 3
        def columnCount = 3
        def seed = new Random()
        seed.setSeed(0)
        def grid = Grid.newInstance(rowCount, columnCount, seed)

        when:
        List<Cell> neighbors = grid.getNeighborCells(1,2)

        then:
        // neighbors = {(0,1), (1,0), (1,1)}
        assert neighbors.size() == 5
        assert neighbors[0].getRow() == 0 && neighbors[0].getColumn() == 1 
        assert neighbors[1].getRow() == 0 && neighbors[1].getColumn() == 2 
        assert neighbors[2].getRow() == 1 && neighbors[2].getColumn() == 1 
        assert neighbors[3].getRow() == 2 && neighbors[3].getColumn() == 1
        assert neighbors[4].getRow() == 2 && neighbors[4].getColumn() == 2                       
    }
}