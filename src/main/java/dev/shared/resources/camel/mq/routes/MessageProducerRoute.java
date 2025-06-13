package dev.shared.resources.camel.mq.routes;

import dev.shared.resources.camel.mq.pojo.Order;
import dev.shared.resources.camel.mq.util.JsonHelper;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageProducerRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("timer:sendTimer?period=5000")
            .routeId("SendOrderToJMS")
            .process(exchange -> {
                Order order = new Order(UUID.randomUUID().toString(), System.currentTimeMillis(), "Laptop",
                                        ThreadLocalRandom.current().nextInt(1, 200));
                String orderJson = JsonHelper.toJson(order);
                exchange.getMessage().setBody(orderJson);
            })
            .to("jms:queue:order.queue")
            .log("Order sent to order queue");
    }
}
