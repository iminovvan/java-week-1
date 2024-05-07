import java.util.Objects;

public class Coffee {
    private int coffeeID;
    private String name;
    private int volume;
    private double price;
    private boolean withIce;

    public Coffee(){

    }

    public Coffee(int coffeeID, String name, int volume, double price, boolean withIce){
        this.coffeeID = coffeeID;
        this.name = name;
        this.volume = volume;
        this.price = price;
        this.withIce = withIce;
    }

    //getters and setters

    public int getCoffeeID() {
        return coffeeID;
    }

    public void setCoffeeID(int coffeeID) {
        this.coffeeID = coffeeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public boolean isWithIce() {
        return withIce;
    }

    public void setWithIce(boolean withIce) {
        this.withIce = withIce;
    }


    @Override
    public String toString() {
        return "Coffee{" +
                "coffeeID=" + coffeeID +
                ", name='" + name + '\'' +
                ", volume=" + volume +
                ", price=" + price +
                ", withIce=" + withIce +
                '}';
    }
}
