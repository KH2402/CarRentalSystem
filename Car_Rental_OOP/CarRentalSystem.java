package Projects.Car_Rental_OOP;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CarRentalSystem {
    private List<Car> cars;
    private List<Customer> customers;
    private List<Rental> rentals;


    public CarRentalSystem() {//List<Car> cars, List<Customer> customers, int days
        this.cars = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.rentals=new ArrayList<>();

    }

    public void addCar(Car car){
        this.cars.add(car);

    }

    public void addCustomer(Customer customer){
        this.customers.add(customer);
    }

    public void rentCar(String identifier, Customer rentedCustomer, int days){
        for (Car car:cars) {
            if (car.getCarId().equals(identifier) && car.isAvailable()){
                Rental rental=new Rental(car,rentedCustomer,days);
                car.rentCar();  // it makes availability false
                this.rentals.add(rental);

                slip(car,rentedCustomer,days);

                System.out.println("\nCar rented successfully.");
                return;
            }
        }
        System.out.println("Invalid car selection or car not available for ren");

    }

    private void slip(Car selectedCar, Customer rentedCustomer, int rentalDays){

        double totalPrice = selectedCar.calculatePrice(rentalDays);
        System.out.println("\n== Rental Information ==\n");
        System.out.println("Customer Name: " + rentedCustomer.getName());
        System.out.println("Car: " + selectedCar.getBrand() + " " + selectedCar.getModel());
        System.out.println("Rental Days: " + rentalDays);
        System.out.printf("Total Price: $%.2f%n", totalPrice);
        System.out.println();
    }
    public void returnCar(String carId){
        boolean flag=true;

        for (Car car:cars) {
            if( car.getCarId().equals(carId) && (!car.isAvailable()) ){

                flag=false;

                car.returnCar();// it makes car available

                for (Rental rental:rentals) {

                    if (rental.getCar().equals(car)){/////////////

                        String customerName=rental.getCustomer().getName();
                        this.rentals.remove(rental);  // remove associated car with customer
                        System.out.println("Car returned successfully by "+customerName);
                        return;
                    }
                }
            }
        }
        if(flag){
            System.out.println("Invalid car ID or car is not rented.");
        }else {
            System.out.println("Car was not rented or rental information is missing.");
        }
    }

    public boolean checkAvailabilityOfCar(String identifier){
        for (Car car:cars) {
            if( car.getCarId().equals(identifier) && car.isAvailable() )
            {
                return true;
            }
        }
        return false;
    }

    public void displayCustomerRentedCars(String customerName){
        for (Rental rental:rentals) {
            if(rental.getCustomer().getName().toLowerCase().contains(customerName.toLowerCase())){
                System.out.println(rental.getCustomer().getName()+" rented car : "+rental.getCar().getBrand()+","+rental.getCar().getModel());
            }
        }
    }
    public void displayListOfAvailableCars(){
        for (Car car:cars) {
            if(car.isAvailable()){
                System.out.println(car);
            }
        }
    }
    public List<Car> searchCarByModel(String model){
        List<Car> searchResults=new ArrayList<>();
        for (Car car:cars) {
            if(car.getModel().toLowerCase().contains(model.toLowerCase())){
                searchResults.add(car);
            }
        }
        return searchResults;
    }

    public List<Car> sortAvailableCarsByPrice() {
        List<Car> availableCars=new ArrayList<>();

        for(Car car:cars){
            if(car.isAvailable()){
                availableCars.add(car);
            }
        }
        Collections.sort(availableCars, new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return Double.compare(o1.getBasePricePerDay(),o2.getBasePricePerDay());
            }
        });

        return availableCars;
    }
}
