// Clase que representa un Sedan
public class Sedan extends Car {

    private boolean hasSunroof;

    public Sedan(String brand, String model, int year, double price, boolean hasSunroof) {
        super(brand, model, year, price);
        this.hasSunroof = hasSunroof;
    }

    public boolean isHasSunroof() {
        return hasSunroof;
    }

    public void setHasSunroof(boolean hasSunroof) {
        this.hasSunroof = hasSunroof;
    }

    public String getType() {
        return "Sedan";
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipo: Sedan, Techo solar: " + (hasSunroof ? "Si" : "No"));
    }
}
