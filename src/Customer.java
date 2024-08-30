// Clase que representa un cliente
public class Customer {
    private String name;
    private String contactNumber;

    public Customer(String name, String contactNumber) {
        this.name = name;
        this.contactNumber = contactNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void displayInfo() {
        System.out.println("Cliente: " + name + ", Numero de contacto: " + contactNumber);
    }

}
