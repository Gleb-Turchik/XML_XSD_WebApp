package by.epam.xmlweb.command;

/**
 * Created by Диана и Глеб on 27.06.2016.
 */
public enum CommandEnum {
    LOGIN(new LoginCommand()),
    LOGOUT(new LogoutCommand()),
    DOM(new ParserCommand("dom")),
    SAX(new ParserCommand("sax")),
    STAX(new ParserCommand("stax")),
    BACK(new BackCommand()),
    LANGUAGE(new LanguageCommand());

    private Command command;
    CommandEnum(Command command) {
        this.command = command;
    }
    public Command getCurrentCommand() {
        return command;
    }
}
