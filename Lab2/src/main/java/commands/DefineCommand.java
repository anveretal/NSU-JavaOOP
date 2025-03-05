package commands;

import java.util.List;

public class DefineCommand implements Command {
    @Override
    public void execute(List<String> arguments, CommandContext context) {
        if (arguments.size() != 2) {
            throw new IllegalArgumentException("DEFINE command requires 2 argument.");
        }
        context.definedValues.put(arguments.get(0), Double.parseDouble(arguments.get(1)));
    }
}