package in.rcard.hexagonal.stock.price;

import in.rcard.hexagonal.stock.price.application.StockPriceUpdateService;
import in.rcard.hexagonal.stock.price.application.port.in.StockPriceUpdateUseCase;
import in.rcard.hexagonal.stock.price.application.port.out.StockPriceUpdatePort;
import java.util.HashMap;
import java.util.Map;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.KafkaListenerContainerFactory;
import org.springframework.kafka.core.ConsumerFactory;
import org.springframework.kafka.core.DefaultKafkaConsumerFactory;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.KafkaListenerErrorHandler;
import org.springframework.kafka.listener.ListenerExecutionFailedException;
import org.springframework.messaging.Message;

@EnableKafka
@Configuration
@Slf4j
public class StockPriceUpdateConfiguration {
  @Bean
  public StockPriceUpdateUseCase stockPriceUpdateUseCase(StockPriceUpdatePort port) {
    return new StockPriceUpdateService(port);
  }
  
//  @Bean
//  KafkaListenerContainerFactory<ConcurrentMessageListenerContainer<Integer, String>>
//  kafkaListenerContainerFactory() {
//    ConcurrentKafkaListenerContainerFactory<Integer, String> factory =
//        new ConcurrentKafkaListenerContainerFactory<>();
//    factory.setConsumerFactory(consumerFactory());
//    factory.setConcurrency(3);
//    factory.getContainerProperties().setPollTimeout(3000);
//    return factory;
//  }
//
//  @Bean
//  public ConsumerFactory<Integer, String> consumerFactory() {
//    return new DefaultKafkaConsumerFactory<>(consumerConfigs());
//  }
//
//  @Bean
//  public Map<String, Object> consumerConfigs() {
//    Map<String, Object> props = new HashMap<>();
//    props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
//    // And many other...
//    return props;
//  }
  
  @Bean
  public KafkaListenerErrorHandler kafkaListenerErrorHandler() {
    return (message, exception) -> {
      log.error("Something went wrong: {}", message, exception);
      return null;
    };
  }
}
