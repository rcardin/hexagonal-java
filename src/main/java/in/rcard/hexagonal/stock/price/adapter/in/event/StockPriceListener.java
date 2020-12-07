package in.rcard.hexagonal.stock.price.adapter.in.event;

import in.rcard.hexagonal.stock.price.application.port.in.StockPriceUpdateUseCase;
import in.rcard.hexagonal.stock.price.application.port.in.StockPriceUpdateUseCase.StockPriceUpdateCommand;
import lombok.AllArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.Acknowledgment;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StockPriceListener {
  private final StockPriceUpdateUseCase useCase;

  @KafkaListener(
      id = "priceListener",
      topics = {"prices"},
      groupId = "prices"
//      ,
//      properties = {
//        "key.deserializer=org.apache.kafka.common.serialization.StringDeserializer",
//        "value.deserializer=org.apache.kafka.common.serialization.DoubleDeserializer"
//      }
      //      ,
      //      containerFactory = "kafkaListenerContainerFactory"
      ,
      errorHandler = "kafkaListenerErrorHandler")
  public void listenToPrices(
      @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY) String stock, @Payload Double price) {
    useCase.updatePrice(new StockPriceUpdateCommand(stock, price));
  }

  /*
   RECORD: Commit the offset when the listener returns after processing the record.
   BATCH: Commit the offset when all the records returned by the poll() have been processed.
   TIME: Commit the offset when all the records returned by the poll() have been processed, as long as the ackTime since the last commit has been exceeded.
   COUNT: Commit the offset when all the records returned by the poll() have been processed, as long as ackCount records have been received since the last commit.
   COUNT_TIME: Similar to TIME and COUNT, but the commit is performed if either condition is true.
   MANUAL: The message listener is responsible to acknowledge() the Acknowledgment. After that, the same semantics as BATCH are applied.
   MANUAL_IMMEDIATE: Commit the offset immediately when the Acknowledgment.acknowledge() method is called by the listener.
  */
  //  public void listenToPrices(
  //      @Header(name = KafkaHeaders.RECEIVED_MESSAGE_KEY) String stock,
  //      @Payload Double price,
  //      Acknowledgment ack) {
  //    useCase.updatePrice(new StockPriceUpdateCommand(stock, price));
  //    ack.acknowledge();
  //  }
}
