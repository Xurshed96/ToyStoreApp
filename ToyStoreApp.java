import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

class Toy {
    String name;
    double weight;

    public Toy(String name, double weight) {
        this.name = name;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Toy{" +
                "name='" + name + '\'' +
                ", weight=" + weight +
                '}';
    }
}

class ToyStore {
    List<Toy> toys;
    Random random;

    public ToyStore() {
        toys = new ArrayList<>();
        random = new Random();
    }

    public void addToy(String name, double weight) {
        Toy toy = new Toy(name, weight);
        toys.add(toy);
    }

    public Toy getRandomToy() {
        if (toys.isEmpty()) {
            return null;
        }

        int randomIndex = random.nextInt(toys.size());
        return toys.get(randomIndex);
    }
}

public class ToyStoreApp {
    public static void main(String[] args) {
        ToyStore toyStore = new ToyStore();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Добавить новую игрушку");
            System.out.println("2. Выбрать случайную игрушку");
            System.out.println("3. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Введите название игрушки: ");
                    String name = scanner.next();
                    System.out.print("Введите вес игрушки: ");
                    double weight = scanner.nextDouble();
                    toyStore.addToy(name, weight);
                    System.out.println("Игрушка добавлена!");
                    break;
                case 2:
                    Toy randomToy = toyStore.getRandomToy();
                    if (randomToy != null) {
                        System.out.println("Случайная игрушка: " + randomToy);
                    } else {
                        System.out.println("Магазин пуст. Добавьте игрушки.");
                    }
                    break;
                case 3:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }
}
