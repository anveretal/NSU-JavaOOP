package factories;

import java.lang.reflect.InvocationTargetException;
import java.util.Properties;

public class FactoryGenerator {
    public CommandFactory generateCommandFactoryByCommand(String command, Properties properties) {
        CommandFactory commandFactory;

        try {
            commandFactory = (CommandFactory) Class.forName(properties.getProperty(command))
                    .getDeclaredConstructor().newInstance();
        } catch (RuntimeException | InvocationTargetException | ClassNotFoundException |
                 InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }

        return commandFactory;
    }
}
