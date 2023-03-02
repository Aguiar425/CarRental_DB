import java.util.Date;

public class Car {
    private int id;
    private String brand;
    private String motor;
    private Date manufacteredDate;
    private int price;
    private Boolean isRented;

    public Car(int id, String brand, String motor, Date manufacteredDate, int price, Boolean isRented) {
        this.id = id;
        this.brand = brand;
        this.motor = motor;
        this.manufacteredDate = manufacteredDate;
        this.price = price;
        this.isRented = isRented;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getMotor() {
        return motor;
    }

    public void setMotor(String motor) {
        this.motor = motor;
    }

    public Date getManufacteredDate() {
        return manufacteredDate;
    }

    public void setManufacteredDate(Date manufacteredDate) {
        this.manufacteredDate = manufacteredDate;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Boolean getRented() {
        return isRented;
    }

    public void setRented(Boolean rented) {
        isRented = rented;
    }
}
