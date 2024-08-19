package CarRentalSystem;

public class Car {

  private String carId;
  private String carModel;
  private String carBrand;
  private double basePricePerDay;
  private boolean isAvailable;

  public Car(String carId, String carModel, String carBrand, double basePricePerDay) {
    this.carId = carId;
    this.carModel = carModel;
    this.carBrand = carBrand;
    this.basePricePerDay = basePricePerDay;
    this.isAvailable = true;
  }

  public String getCarId() {
    return carId;
  }

  public String getCarModel() {
    return carModel;
  }

  public String carBrand() {
    return carBrand;
  }

  public double calculatePrice(int days) {
    return basePricePerDay * days;
  }

  public boolean isAvailable() {
    return isAvailable;
  }

  public void rent() {
    isAvailable = false;
  }

  public void returnCar() {
    isAvailable = true;
  }
}