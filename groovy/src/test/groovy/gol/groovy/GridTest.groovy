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

    def "Grid gets neighbors of upper left corner cell, in clockwise order"() {

    }

    def "Grid gets neighbors of upper right corner cell, in clockwise order"() {

    }

    def "Grid gets neighbors of lower left corner cell, in clockwise order"() {

    }

    def "Grid gets neighbors of lower right corner cell, in clockwise order"() {
        
    }
}