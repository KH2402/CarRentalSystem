package Projects.Car_Rental_OOP;

public class Car {

    private String carId;
    private String brand;
    private String model;
    private double basePricePerDay;
    private boolean isAvailable;

    public Car(String carId,String brand, String model, double basePricePerDay) {
        this.carId = carId;
        this.brand=brand;
        this.model = model;
        this.isAvailable=true;
        this.basePricePerDay = basePricePerDay;
    }

    //rentCar
    public void rentCar(){
        this.isAvailable=false;
    }
    //returnCar
    public void returnCar(){
        this.isAvailable=true;
    }
    //calculate price
    public double calculatePrice(int rentalDays) {
        return this.basePricePerDay * rentalDays;
    }

    //getter and setter
    public String getCarId() {
        return carId;
    }
    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getBrand() {
        return brand;
    }
    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

    public double getBasePricePerDay() {
        return basePricePerDay;
    }
    public void setBasePricePerDay(double basePricePerDay) {
        this.basePricePerDay = basePricePerDay;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Car{" +
                "carId='" + carId + '\'' +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", basePricePerDay=" + basePricePerDay +
                '}';
    }
}
