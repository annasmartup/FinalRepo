import java.util.Scanner;

class Menu {
    private AnimalService animalService;
    private Scanner scanner;

    public Menu() {
        this.animalService = new AnimalService();
        this.scanner = new Scanner(System.in);
    }

    public void show() {
        while (true) {
            System.out.println("1. Завести новое животное");
            System.out.println("2. Обучить животное новой команде");
            System.out.println("3. Показать команды животного");
            System.out.println("4. Выйти");
            System.out.print("Выберите действие: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // очистка буфера

            switch (choice) {
                case 1:
                    addAnimal();  // Добавляем новое животное
                    break;
                case 2:
                    trainAnimal();  // Обучаем животное
                    break;
                case 3:
                    showAnimalCommands();  // Показываем команды
                    break;
                case 4:
                    System.out.println("Выход из программы.");
                    return;  // Выходим из программы
                default:
                    System.out.println("Некорректный выбор. Попробуйте снова.");
            }
        }
    }

    private void addAnimal() {
        System.out.print("Введите тип животного (собака, кошка, хомяк, лошадь, верблюд, осел): ");
        String type = scanner.nextLine();
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите дату рождения животного: ");
        String birthDate = scanner.nextLine();

        try (Counter counter = new Counter()) {
            animalService.addAnimal(type, name, birthDate);  // Добавляем животное
            counter.add();  // Увеличиваем счетчик
            System.out.println("Общее количество животных: " + counter.getCount());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void trainAnimal() {
        System.out.print("Введите имя животного: ");
        String name = scanner.nextLine();
        System.out.print("Введите команду: ");
        String command = scanner.nextLine();

        animalService.trainAnimal(name, command);  // Обучаем животное
    }

    private void showAnimalCommands() {
        System.out.print("Введите имя животного для показа команд: ");
        String name = scanner.nextLine();

        animalService.showAnimalCommands(name);  // Показываем команды
    }
}