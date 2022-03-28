package in.rcard.hexagonal.portfolio.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class StockTest {
  
  @Test
  void addShouldAddTheGivenQuantityToTheOwnedStocks() {
    final Stock appleStocks = new Stock("AAPL", 1000L);
    final Stock updatedAppleStocks = appleStocks.add(100L);
  
    assertThat(appleStocks)
        .hasFieldOrPropertyWithValue("name", "AAPL")
        .hasFieldOrPropertyWithValue("owned", 1000L);
  
    assertThat(updatedAppleStocks)
        .hasFieldOrPropertyWithValue("name", "AAPL")
        .hasFieldOrPropertyWithValue("owned", 1100L);
  }
}