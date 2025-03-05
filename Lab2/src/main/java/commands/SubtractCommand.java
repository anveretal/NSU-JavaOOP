package commands;

import java.util.List;

public class SubtractCommand implements Command {
    @Override
    public void execute(List<String> arguments, CommandContext context) {
        if (!arguments.isEmpty()) {
            throw new IllegalArgumentException("- command requires 0 argument.");
        }
        double value1 = context.stack.pop();
        double value2 = context.stack.pop();
        context.stack.push(value2 - value1);
    }
}
