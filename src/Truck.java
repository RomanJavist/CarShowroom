// Clase que representa un Truck (camion)
public class Truck extends Car{

    private double loadCapacity;

    public Truck(String brand, String model, int year, double price, double loadCapacity) {
        super(brand, model, year, price);
        this.loadCapacity = loadCapacity;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public void setLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
    }

    public String getType() {
        return "Camion";
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipo: Camion, Capacidad de carga: " + loadCapacity + " toneladas");
    }

}
