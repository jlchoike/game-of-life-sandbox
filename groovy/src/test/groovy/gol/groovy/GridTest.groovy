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

    def "Grid gets neighbors of upper left corner cell, in row-wise order"() {
        //      0   1
        //  0   C   N
        //  1   N   N
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
                
    }

    def "Grid gets neighbors of upper right corner cell, in row-wise order"() {
        //      0   1
        //  0   N   C
        //  1   N   N
    }

    def "Grid gets neighbors of lower left corner cell, in row-wise order"() {
        //      0   1
        //  0   N   N
        //  1   C   N
    }

    def "Grid gets neighbors of lower right corner cell, in row-wise order"() {
        //      0   1
        //  0   N   N
        //  1   N   C        
    }

    def "Grid gets neighbors of top middle cell, in row-wise order"() {
        //      0   1   2
        //  0   N   C   N
        //  1   N   N   N
    }
    
    def "Grid gets neighbors of bottom middle cell, in row-wise order"() {
        //      0   1   2
        //  0   N   N   N
        //  1   N   C   N
    }

    def "Grid gets neighbors of left middle cell, in row-wise order"() {
        //      0   1
        //  0   N   N
        //  1   C   N
        //  2   N   N
    }

    def "Grid gets neighbors of right middle cell, in row-wise order"() {
        //      0   1
        //  0   N   N
        //  1   N   C
        //  2   N   N
    }
}