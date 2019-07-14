class VehicleTest {
    public static void main(String[] args) {
        Vehicle bike = new Vehicle("red");
        Vehicle car = new Vehicle("green",4);
        bike.setNumberOfWheels(2);
        int bikeWheels = bike.getNumberOfWheels();
        String bikeColor = bike.getColor();
        int carWheels = car.getNumberOfWheels();
        String carColor = car.getColor();
        System.out.println("Bike object - Wheels: " + bikeWheels + ", Color: " + bikeColor);
        System.out.println("Car object - Wheels: " + carWheels + ", Color: " + carColor);
    }
}
