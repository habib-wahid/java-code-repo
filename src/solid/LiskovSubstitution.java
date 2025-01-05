package solid;

import java.util.ArrayList;
import java.util.List;

class Vehicle {
    public int getNumberOfWheels() {
        return 2;
    }
}

class EngineVehicle extends Vehicle {
    public Boolean hasEngine() {
        return true;
    }
}

class Car extends EngineVehicle {
    @Override
    public int getNumberOfWheels() {
        return 4;
    }
}

class MotorCycle extends EngineVehicle {
}

class ByCycle extends Vehicle {
}

public class LiskovSubstitution {
    public static void main(String[] args) {
        List<Vehicle> vehicles = new ArrayList<>();
        vehicles.add(new Car());
        vehicles.add(new MotorCycle());
        vehicles.add(new ByCycle());
        vehicles.forEach(vehicle -> System.out.println(vehicle.getNumberOfWheels()));

        List<EngineVehicle> engineVehicles = new ArrayList<>();
        engineVehicles.add(new Car());
        engineVehicles.add(new MotorCycle());
        engineVehicles.stream().forEach(engineVehicle -> System.out.println(engineVehicle.hasEngine()));
    }
}
