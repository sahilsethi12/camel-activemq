package dev.shared.resources.camel.mq.routes;

import dev.shared.resources.camel.mq.pojo.Order;
import dev.shared.resources.camel.mq.util.JsonHelper;
import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

@Component
public class MessageConsumerRoute extends RouteBuilder {

    @Override
    public void configure() {

        from("jms:queue:order.queue")
            .routeId("ReceiveOrderFromJMS")
            .process(exchange -> {
                String json = exchange.getMessage().getBody(String.class);
                Order order = JsonHelper.fromJson(json, Order.class);
                exchange.getMessage().setBody(order.toString());
            })
            .log("Received order from order queue : ${body}");
    }
}
