import commands.CommandContext;
import factories.CommandFactory;
import factories.FactoryGenerator;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Properties;

public class Calculator {
    public void executeCommands(Properties properties, BufferedReader reader) {
        CommandContext context = new CommandContext();
        FactoryGenerator factoryGenerator = new FactoryGenerator();
        try {
            String commandLine;
            while ((commandLine = reader.readLine()) != null) {
                if (!commandLine.startsWith("#")) {
                    String[] commandAndArguments = commandLine.split(" ");

                    CommandFactory commandFactory = factoryGenerator.
                            generateCommandFactoryByCommand(commandAndArguments[0], properties);
                    List<String> arguments = new ArrayList<>(Arrays.asList(commandAndArguments).subList(1, commandAndArguments.length));

                    commandFactory.createCommand().execute(arguments, context);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
