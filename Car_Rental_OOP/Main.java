package Projects.Car_Rental_OOP;


import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        //adding car

        CarRentalSystem rentalSystem=new CarRentalSystem();


        Car car1 = new Car("C001", "Toyota", "Camry", 50.00);
        Car car2 = new Car("C002", "Honda", "Accord", 55.00);
        Car car3 = new Car("C003", "Ford", "Mustang", 70.00);
        Car car4 = new Car("C004", "Chevrolet", "Malibu", 48.00);
        Car car5 = new Car("C005", "Nissan", "Altima", 52.00);
        Car car6 = new Car("C006", "BMW", "3 Series", 80.00);
        Car car7 = new Car("C007", "Mercedes-Benz", "C-Class", 85.00);
        Car car8 = new Car("C008", "Audi", "A4", 78.00);
        Car car9 = new Car("C009", "Hyundai", "Sonata", 45.00);
        Car car10 = new Car("C0010", "Kia", "Optima", 47.00);
        rentalSystem.addCar(car1);
        rentalSystem.addCar(car2);
        rentalSystem.addCar(car3);
        rentalSystem.addCar(car4);
        rentalSystem.addCar(car5);
        rentalSystem.addCar(car6);
        rentalSystem.addCar(car7);
        rentalSystem.addCar(car8);
        rentalSystem.addCar(car9);
        rentalSystem.addCar(car10);

        menu(rentalSystem);
    }

    private static void menu(CarRentalSystem rentalSystem) {

        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.println("---------------------------------------");
            System.out.println("1.Display available cars ");
            System.out.println("2.Rent a car ");
            System.out.println("3.Return a car ");
            System.out.println("4.Display customer's rented cars ");
            System.out.println("5.Search cars by model ");
            System.out.println("6.Sort available cars by price ");
            System.out.println("7. Exit");
            System.out.println("---------------------------------------");
            System.out.println("Enter your choice : ");
            int choice = sc.nextInt();
            sc.nextLine();


            switch (choice) {
                case 1:
                    System.out.println("-------------Available Cars-------------------");
                    rentalSystem.displayListOfAvailableCars();
                    break;
                case 2:
                    System.out.println("Enter the identifier to rent a Car :");
                    String identifier = sc.nextLine();
                    if(rentalSystem.checkAvailabilityOfCar(identifier))
                    {
                        System.out.println("Enter customer details : ");
                        System.out.println("Enter Name : ");
                        String name = sc.nextLine();
                        System.out.println("Enter LicenceNo : ");
                        String licenceNo = sc.nextLine();
                        System.out.println("Enter mobileNo : ");
                        String mobileNo = sc.nextLine();
                        Customer rentedCustomer = new Customer(name, licenceNo, mobileNo);

                        System.out.println("Enter how many days to rent a car ");
                        int days = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Are you want to confirm booking ? (Y/N)");
                        String confirmation = sc.nextLine();

                        if (confirmation.equalsIgnoreCase("Y")) {
                            rentalSystem.rentCar(identifier, rentedCustomer, days);
                        } else {
                            System.out.println("Rental canceled.");
                        }
                    }else{
                        System.out.println("Car is not available for rent.");
                    }

                    break;

                case 3:
                    System.out.println("\n== Return a Car ==\n");
                    System.out.print("Enter the car ID you want to return: ");
                    String carId = sc.nextLine();

                    rentalSystem.returnCar(carId);
                    break;

                case 4:
                    System.out.print("Enter customer name to display rented items: ");
                    String customerNameToDisplay = sc.nextLine();
                    rentalSystem.displayCustomerRentedCars(customerNameToDisplay);
                    break;

                case 5:
                    System.out.print("Enter car model to search: ");
                    String searchModel = sc.nextLine();
                    List<Car> searchedCarList = rentalSystem.searchCarByModel(searchModel);

                    System.out.println("\n---------------Searched car by model------------------");
                    displayCars(searchedCarList);
                    break;
                case 6:
                    System.out.println("-------------Sorted Available Cars by Price----------------");
                    List<Car> sortedCarsByPrice = rentalSystem.sortAvailableCarsByPrice();

                    displayCars( sortedCarsByPrice);
                    break;
                case 7:
                    System.out.println("Exiting the Rental System. Thank you!");
                    System.exit(0);
            }
        }
    }

    private static void displayCars( List<Car> cars){

        for (Car car : cars) {
            System.out.println(car);
        }
    }
}
