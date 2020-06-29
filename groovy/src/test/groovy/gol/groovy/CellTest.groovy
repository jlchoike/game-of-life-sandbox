package gol.groovy

import spock.lang.Specification

class CellTest extends Specification {

    def "Unpopulated Cell becomes populated when it has 3 neighbors"() {
        setup:
        def subject = new Cell(0, 0, Cell.State.UNPOPULATED)

        // C P
        // P P
        def neighbors = [ new Cell(0, 1, Cell.State.POPULATED),
            new Cell(1, 1, Cell.State.POPULATED),
            new Cell(1, 0, Cell.State.POPULATED)
            ]

        when:
        Cell nextGeneration = subject.nextGeneration(neighbors)

        then:
        nextGeneration.getState()
    }

    def "Populated cell dies when it has zero neighbors"() {

    }

    def "Populated cell dies when it has only one neighbor"() {
        
    }

    def "Populated cell dies when it has four neighbors"() {
        
    }

    def "Populated cell dies when it has more than four neighbors"() {
        
    }

    def "Populated cell survives when it has two neighbors"() {
        
    }

    def "Populated cell survives when it has three neighbors"() {
        
    }
}