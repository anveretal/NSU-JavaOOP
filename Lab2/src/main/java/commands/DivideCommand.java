package commands;

import java.util.List;

public class DivideCommand implements Command {
    @Override
    public void execute(List<String> arguments, CommandContext context) {
        if (!arguments.isEmpty()) {
            throw new IllegalArgumentException("/ command requires 0 argument.");
        }
        try {
            double value1 = context.stack.pop();
            double value2 = context.stack.pop();
            if (value1 == 0) {
                throw new IllegalArgumentException("divide by zero.");
            }
            context.stack.push(value2 / value1);
        }
        catch (Exception e) {
            throw new RuntimeException(e.getLocalizedMessage());
        }
    }
}
