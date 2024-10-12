import java.util.ArrayList;
import java.util.List;

abstract class Animal {
    protected String name;
    protected String birthDate;
    protected List<String> commands;

    public Animal(String name, String birthDate) {
        this.name = name;
        this.birthDate = birthDate;
        this.commands = new ArrayList<>();
    }

    public void addCommand(String command) {
        commands.add(command);
    }

    public List<String> getCommands() {
        return commands;
    }

    public String getName() {
        return name;
    }

    public String getBirthDate() {
        return birthDate;
    }
}