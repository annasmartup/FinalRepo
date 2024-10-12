import java.util.ArrayList;
import java.util.List;

class AnimalService {
    private List<Animal> animals;

    public AnimalService() {
        this.animals = new ArrayList<>();
    }

    public void addAnimal(String type, String name, String birthDate) {
        Animal animal = null;
        switch (type.toLowerCase()) {
            case "собака":
                animal = new Dog(name, birthDate);
                break;
            case "кошка":
                animal = new Cat(name, birthDate);
                break;
            case "хомяк":
                animal = new Hamster(name, birthDate);
                break;
            case "лошадь":
                animal = new Horse(name, birthDate);
                break;
            case "верблюд":
                animal = new Camel(name, birthDate);
                break;
            case "осел":
                animal = new Donkey(name, birthDate);
                break;
            default:
                System.out.println("Unknown animal type.");
                return;
        }
        animals.add(animal);
        System.out.println("Животное добавлено.");
    }

    public void trainAnimal(String name, String command) {
        Animal foundAnimal = findAnimalByName(name);
        if (foundAnimal != null) {
            foundAnimal.addCommand(command);
            System.out.println("Команда добавлена.");
        } else {
            System.out.println("Animal not found.");
        }
    }

    public void showAnimalCommands(String name) {
        Animal foundAnimal = findAnimalByName(name);
        if (foundAnimal != null) {
            System.out.println("Команды для животного " + name + ": " + foundAnimal.getCommands());
        } else {
            System.out.println("Animal not found.");
        }
    }

    private Animal findAnimalByName(String name) {
        for (Animal animal : animals) {
            if (animal.getName().equalsIgnoreCase(name)) {
                return animal;
            }
        }
        return null;
    }
}