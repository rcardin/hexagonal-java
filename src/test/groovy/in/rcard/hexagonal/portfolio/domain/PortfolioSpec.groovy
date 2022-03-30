package in.rcard.hexagonal.portfolio.domain

import spock.lang.Specification

class PortfolioSpec extends Specification {
    def "buy should add the given quantity of a stock if already owned"() {
        given:
            var appleStock = new Stock("AAPL", 500L)
            var portfolio = new Portfolio("portfolio", ["AAPL": appleStock])
        when:
            var newPortfolio = portfolio.buy("AAPL", 100L)
        then:
            newPortfolio.stocks.size() == 1
            newPortfolio.stocks["AAPL"].owned == 600L
    }

    def "buy should add a new stock to the portfolio if not present"() {
        given:
            var appleStock = new Stock("AAPL", 500L)
            var portfolio = new Portfolio("portfolio", ["AAPL": appleStock])
        when:
            var newPortfolio = portfolio.buy("TSLA", 100L)
        then:
            newPortfolio.stocks.size() == 2
            newPortfolio.stocks["TSLA"].owned == 100L
            newPortfolio.stocks["AAPL"].owned == 500L
    }
}
