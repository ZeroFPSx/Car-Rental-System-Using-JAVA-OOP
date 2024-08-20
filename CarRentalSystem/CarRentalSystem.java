package CarRentalSystem;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

public class CarRentalSystem {
  private List<Car> cars;
  private List<Customer> customers;
  private List<Rental> rentals;

  public CarRentalSystem() {
    cars = new ArrayList<>();
    customers = new ArrayList<>();
    rentals = new ArrayList<>();
  }

  public void addCar(Car car) {
    cars.add(car);
  }

  public void addCustomer(Customer customer) {
    customers.add(customer);
  }

  public void rentCar(Car car, Customer customer, int days) {
    if (car.isAvailable()) {
      car.rent();
      rentals.add(new Rental(car, customer, days));
    } else
      System.out.println("Car is not available for rent.");
  }

  public void returnCar(Car car) {
    car.returnCar();
    Rental rentalToRemove = null;
    for (Rental rental : rentals) {
      if (rental.getCar() == car) {
        rentalToRemove = rental;
        break;
      }
    }
    if (rentalToRemove != null) {
      rentals.remove(rentalToRemove);
      System.out.println("Car returned Successfully");
    } else
      System.out.println("Car was not rented");
  }

  public void menu() {
    Scanner sc = new Scanner(System.in);

    while (true) {
      System.out.println("\n----------Welcome to Car Rental Service----------");
      System.out.println("1. Rent a Car");
      System.out.println("2. Return a Car");
      System.out.println("3. Exit");

      int choice = sc.nextInt();
      sc.nextLine();

      if (choice == 1) {
        System.out.println("\n-----Rent a Car-----");
        System.out.println("Enter your name: ");
        String customerName = sc.nextLine();

        System.out.println("\nAvailable Cars");
        for (Car car : cars) {
          if (car.isAvailable()) {
            System.out.println(car.getCarId() + "  - " + car.getCarModel() + " " + car.carBrand());
          }
        }

        System.out.println("Enter the carID of the Car you want: ");
        String carId = sc.nextLine();

        System.out.println("Enter the number of days you want to rent: ");
        int rentalDays = sc.nextInt();
        if (rentalDays > 0) {
          sc.nextLine();
        } else {
          System.out.println("Enter a valid Number!");
          break;
        }

        Customer newCustomer = new Customer("CUS" + (customers.size() + 1), customerName);
        addCustomer(newCustomer);

        Car selectedCar = null;
        for (Car car : cars) {
          if (car.getCarId().equals(carId) && car.isAvailable()) {
            selectedCar = car;
            break;
          }
        }
        if (selectedCar != null) {
          double totalPrice = selectedCar.calculatePrice(rentalDays);
          System.out.println("\n-----Rental Information-----");
          System.out.println("Customer ID: " + newCustomer.getCustomerId());
          System.out.println("Customer Name: " + newCustomer.getName());
          System.out.println("Car: " + selectedCar.carBrand() + " " + selectedCar.getCarModel());
          System.out.println("Rental Days: " + rentalDays);
          System.out.println("Total Price: " + totalPrice + "$");

          System.out.println("\nConfirm rental (Y/N): ");
          String confirm = sc.nextLine();

          if (confirm.equalsIgnoreCase("Y")) {
            rentCar(selectedCar, newCustomer, rentalDays);
            System.out.println("\nCar rented Successfully");

          } else {
            System.out.println("\nRental Cancelled");

          }
        } else {
          System.out.println("\nInvalid car selection or car not  available to rent.");

        }

      } else if (choice == 2) {
        System.out.println("\n-----Return a Car----");
        System.out.println("Enter the ID of the car you want to return.");
        String carId = sc.nextLine();

        Car carToReturn = null;
        for (Car car : cars) {
          if (car.getCarId().equals(carId) && !car.isAvailable()) {
            carToReturn = car;
            break;
          }
        }
        if (carToReturn != null) {
          Customer customer = null;
          for (Rental rental : rentals) {
            if (rental.getCar() == carToReturn) {
              customer = rental.getCustomer();
              break;
            }
          }
          if (customer != null) {
            returnCar(carToReturn);
            System.out.println("Car is returned Successfully by " + customer.getName());
          } else
            System.out.println("Car was not rented or rental information missing.");
        } else
          System.out.println("Invalid Car ID or car is not rented.");
      } else if (choice == 3)
        break;
      else
        System.out.println("Invalid Choice!");
    }
    System.out.println("\nThank you for using the Car Rental System!");
    sc.close();
  }
}
