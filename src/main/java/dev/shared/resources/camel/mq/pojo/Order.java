package dev.shared.resources.camel.mq.pojo;

public class Order {

    private String orderId;
    private long timestamp;
    private String item;
    private int quantity;

    public Order(final String orderId, final long timestamp, final String item, final int quantity) {

        this.orderId = orderId;
        this.timestamp = timestamp;
        this.item = item;
        this.quantity = quantity;
    }

    public String getOrderId() {

        return orderId;
    }

    public void setOrderId(final String orderId) {

        this.orderId = orderId;
    }

    public long getTimestamp() {

        return timestamp;
    }

    public void setTimestamp(final long timestamp) {

        this.timestamp = timestamp;
    }

    public String getItem() {

        return item;
    }

    public void setItem(final String item) {

        this.item = item;
    }

    public int getQuantity() {

        return quantity;
    }

    public void setQuantity(final int quantity) {

        this.quantity = quantity;
    }

    @Override
    public String toString() {

        return "Order{" +
            "orderId='" + orderId + '\'' +
            ", timestamp=" + timestamp +
            ", item='" + item + '\'' +
            ", quantity=" + quantity +
            '}';
    }
}
