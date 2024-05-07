public class Order {
    private int orderID;
    private Customer customer;
    private Coffee coffee;
    private String nameOrder;
    private double price;


    public Order() {
    }

    public Order(int orderID, Customer customer, Coffee coffee, String nameOrder, double price) {
        this.orderID = orderID;
        this.customer = customer;
        this.coffee = coffee;
        this.nameOrder = nameOrder;
        this.price = price;
    }


    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }

    public String getNameOrder() {
        return nameOrder;
    }

    public void setNameOrder(String nameOrder) {
        this.nameOrder = nameOrder;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Coffee getCoffee() {
        return coffee;
    }

    public void setCoffee(Coffee coffee) {
        this.coffee = coffee;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", customer=" + customer +
                ", coffee=" + coffee +
                ", nameOrder='" + nameOrder + '\'' +
                ", price=" + price +
                '}';
    }
}
