package commands;

import java.util.List;

public class PushCommand implements Command {
    @Override
    public void execute(List<String> arguments, CommandContext context) {
        if (arguments.size() != 1) {
            throw new IllegalArgumentException("PUSH command requires 1 argument.");
        }
        context.stack.push(context.definedValues.get(arguments.get(0)));
    }
}
