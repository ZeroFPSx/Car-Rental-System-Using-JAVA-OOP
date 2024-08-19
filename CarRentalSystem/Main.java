package CarRentalSystem;

public class Main {
  public static void main(String[] args) {
    CarRentalSystem rentalSystem = new CarRentalSystem();
    Car car1 = new Car("C001", "Toyota", "Fortuner", 60);
    Car car2 = new Car("C002", "Mahindra", "Scorpio", 40);
    Car car3 = new Car("C003", "Tata", "Harrier", 60);
    Car car4 = new Car("C004", "Suzuki", "Brezza", 30);
    rentalSystem.addCar(car1);
    rentalSystem.addCar(car2);
    rentalSystem.addCar(car3);
    rentalSystem.addCar(car4);
    rentalSystem.menu();
  }
}
