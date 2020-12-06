package in.rcard.hexagonal.portfolio.domain;

import java.util.Set;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Portfolio {
  private final String name;
  private final Set<Stock> stocks;
}
