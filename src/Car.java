import java.util.Date;

public class Car {
    private int id;
    private String brand;
    private String motor;
    private Date manufacteredDate;
    private int price;
    private String license_plate;

    public Car(String brand, String motor, Date manufacteredDate, int price, String license_plate) {
        this.brand = brand;
        this.motor = motor;
        this.manufacteredDate = manufacteredDate;
        this.price = price;
        this.license_plate = license_plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Override
    public String toString() {
        return "Car{" +
                " brand='" + brand + '\'' +
                ", motor='" + motor + '\'' +
                ", manufacteredDate=" + manufacteredDate +
                ", price=" + price +
                ", license_plate='" + license_plate + '\'' +
                '}';
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

    public String getLicense_plate() {
        return license_plate;
    }

    public void setLicense_plate(String license_plate) {
        this.license_plate = license_plate;
    }
}
