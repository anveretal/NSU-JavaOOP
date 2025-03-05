package commands;

import java.util.List;

public class SqrtCommand implements Command{
    @Override
    public void execute(List<String> arguments, CommandContext context) {
        if (!arguments.isEmpty()) {
            throw new IllegalArgumentException("SQRT command requires 0 argument.");
        }
        double value = context.stack.pop();
        if (value < 0) {
            throw new IllegalArgumentException("SQRT command requires a positive number.");
        }
        context.stack.push(Math.sqrt(value));
    }
}
