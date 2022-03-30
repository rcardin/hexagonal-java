package in.rcard.hexagonal.portfolio.domain

import spock.lang.Specification

class StockSpec extends Specification {
    def "add should increase of the given quantity the owned stocks"() {
        given:
            var appleStocks = new Stock("AAPL", 1000L)
        when:
            var updatedAppleStocks = appleStocks.add(100L)
        then:
            updatedAppleStocks.name == "AAPL"
            updatedAppleStocks.owned == 1100L
            appleStocks.owned == 1000L
    }
}
