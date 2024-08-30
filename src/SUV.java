// Clase que representa un SUV
public class SUV extends Car{

    private boolean isFourWheelDrive;

    public SUV(String brand, String model, int year, double price, boolean isFourWheelDrive) {
        super(brand, model, year, price);
        this.isFourWheelDrive = isFourWheelDrive;
    }

    public boolean isFourWheelDrive() {
        return isFourWheelDrive;
    }

    public void setFourWheelDrive(boolean fourWheelDrive) {
        isFourWheelDrive = fourWheelDrive;
    }

    public String getType() {
        return "SUV";
    }

    public void displayInfo() {
        super.displayInfo();
        System.out.println("Tipo: SUV, Traccion 4x4: " + (isFourWheelDrive ? "Si" : "No"));
    }


}
