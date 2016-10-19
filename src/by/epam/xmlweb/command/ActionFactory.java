package by.epam.xmlweb.command;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public class ActionFactory {
    public static Command defineCommand(String commandName) {
        Command current = null;
        if (commandName == null || commandName.isEmpty()) {
            return new EmptyCommand();
        }
        try {
            CommandEnum currentEnum = CommandEnum.valueOf(commandName.toUpperCase());
            current = currentEnum.getCurrentCommand();
        } catch (IllegalArgumentException e) {
            current = new EmptyCommand();
        }
        return current;
    }
}
