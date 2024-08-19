package CarRentalSystem;

public class Main {
  public static void main(String[] args) {
    CarRentalSystem rentalSystem = new CarRentalSystem();
    Car car1 = new Car("C001", "Toyota", "Camry", 60);
    rentalSystem.addCar(car1);
    rentalSystem.menu();
  }
}
