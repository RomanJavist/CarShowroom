import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

// Clase principal que maneja el showroom de autos
public class CarShowroom {
    private static ArrayList<Car> cars = new ArrayList<>(); // Lista de autos disponibles
    private static ArrayList<Customer> customers = new ArrayList<>(); // Lista de clientes

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Agregamos algunos autos al showroom
        cars.add(new Sedan("Toyota", "Camry", 2021, 30000, true));
        cars.add(new Sedan("Toyota", "Supra", 2019, 27000, false));
        cars.add(new SUV("Honda", "CR-V", 2022, 35000, true));
        cars.add(new Truck("Ford", "F-150", 2023, 45000, 3.5));

        // Agregamos algunos clientes
        customers.add(new Customer("Juan", "+7(3854)732122"));
        customers.add(new Customer("Julia", "+549-351-777-222"));

        boolean running = true;

        // Bucle principal que maneja el menu de opciones
        while (running) {
            System.out.println("Menu:");
            System.out.println("1. Anadir nuevo auto");
            System.out.println("2. Mostrar todos los autos");
            System.out.println("3. Buscar auto por marca");
            System.out.println("4. Anadir nuevo cliente");
            System.out.println("5. Mostrar todos los clientes");
            System.out.println("6. Salir");
            System.out.print("Elija una accion: ");

            int choice = -1;
            try {
                choice = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida. Por favor, ingrese un numero.");
                scanner.nextLine();
                continue;
            }

            // Ejecutamos la accion seleccionada
            switch (choice) {
                case 1:
                    addCar(scanner);
                    break;
                case 2:
                    showAllCars();
                    break;
                case 3:
                    searchCarByBrand(scanner);
                    break;
                case 4:
                    addCustomer(scanner);
                    break;
                case 5:
                    showAllCustomers();
                    break;
                case 6:
                    running = false;
                    break;
                default:
                    System.out.println("Option no valida, intentelo de nuevo.");
            }

        }
        scanner.close();
    }

    // Metodo para agregar un nuevo auto al showroom
    private static void addCar(Scanner scanner) {
        String type = "";
        while (true) {
            System.out.print("Ingrese el tipo de auto (Sedan, SUV, Truck): ");
            type = scanner.nextLine();
            if (type.equalsIgnoreCase("Sedan") || type.equalsIgnoreCase("SUV") || type.equalsIgnoreCase("Truck")) {
                break;
            } else {
                System.out.println("Tipo de auto no valido. Por favor, ingrese Sedan, SUV o Truck.");
            }
        }

        String brand = "";
        System.out.print("Ingrese la marca: ");
        brand = scanner.nextLine();

        String model = "";
        System.out.print("Ingrese el modelo: ");
        model = scanner.nextLine();

        int year = 0;
        while (true) {
            System.out.print("Ingrese el ano: ");
            try {
                year = scanner.nextInt();
                scanner.nextLine();
                if (year >= 1945 && year <= 2024) {
                    break;
                } else {
                    System.out.println("Ano no valido. Por favor, ingrese un ano entre 1945 y 2024.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida. Por favor, ingrese un numero.");
                scanner.nextLine();
            }
        }

        double price = 0;
        while (true) {
            System.out.print("Ingrese el precio: ");
            try {
                price = scanner.nextDouble();
                scanner.nextLine();
                if (price >= 0) {
                    break;
                } else {
                    System.out.println("Precio no valido. Por favor, ingrese un valor positivo.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Entrada no valida. Por favor, ingrese un numero.");
                scanner.nextLine();
            }
        }

        switch (type.toLowerCase()) {

            case "sedan":
                boolean hasSunroof = false;
                while (true) {
                    System.out.println("Tiene techo solar? (true/false): ");
                    try {
                        hasSunroof = scanner.nextBoolean();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no valida. Por favor, ingrese true o false");
                        scanner.nextLine();
                    }
                }
                cars.add(new Sedan(brand, model, year, price, hasSunroof));
                break;

            case "suv":
                boolean isFourWheelDrive = false;
                while (true) {
                    System.out.println("Tiene traccion 4x4? (true/false): ");
                    try {
                        isFourWheelDrive = scanner.nextBoolean();
                        scanner.nextLine();
                        break;
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no valida. Por favor, ingrese true o false");
                        scanner.nextLine();
                    }
                }
                cars.add(new SUV(brand, model, year, price, isFourWheelDrive));
                break;

            case "truck":
                double loadCapacity = 0;
                while (true) {
                    System.out.print("Ingrese la capacidad de carga (tonelados): ");
                    try {
                        loadCapacity = scanner.nextDouble();
                        scanner.nextLine();
                        if (loadCapacity >= 0) {
                            break;
                        } else {
                            System.out.println("Capacidad de carga no valida. Por favor, ingrese un valor positivo.");
                        }
                    } catch (InputMismatchException e) {
                        System.out.println("Entrada no valida. Por favor, ingrese un numero.");
                        scanner.nextLine();
                    }
                }
                cars.add(new Truck(brand, model, year, price, loadCapacity));
                break;
        }
    }

    // Metodo para mostrar todos los autos en el showroom
    private static void showAllCars() {
        if (cars.isEmpty()) {
            System.out.println();
            System.out.println("No se han anadido autos");
            System.out.println();
        } else {
            for (Car car : cars) {
                car.displayInfo();
                System.out.println();
            }
        }
    }

    // Metodo para buscar un auto por marca
    private static void searchCarByBrand(Scanner scanner) {
        System.out.print("Ingrese la marca para buscar: ");
        String brand = scanner.nextLine();
        boolean found = false;

        for (Car car : cars) {
            if (car.getBrand().equalsIgnoreCase(brand)) {
                car.displayInfo();
                System.out.println();
                found = true;
            }
        }

        if (!found) {
            System.out.println();
            System.out.println("No se encontro un auto con la marca " + brand + ".");
            System.out.println();
        }
    }

    // Metodo para agregar un nuevo cliente
    private static void addCustomer(Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String name = scanner.nextLine();

        System.out.print("Ingrese el numero de contacto del cliente: ");
        String contactNumber = scanner.nextLine();

        customers.add(new Customer(name, contactNumber));
        System.out.println("Cliente agregado exitosamente!");
    }

    // Metodo para mostrar todos los clientes
    private static void showAllCustomers() {
        if (customers.isEmpty()) {
            System.out.println();
            System.out.println("No se han anadido clientes");
            System.out.println();
        } else {
            for (Customer customer : customers) {
                customer.displayInfo();
                System.out.println();
            }
        }
    }

}

