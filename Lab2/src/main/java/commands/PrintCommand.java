package commands;

import java.util.List;

public class PrintCommand implements Command {
    @Override
    public void execute(List<String> arguments, CommandContext context) {
        if (!arguments.isEmpty()) {
            throw new IllegalArgumentException("PRINT command requires 0 argument.");
        }
        System.out.println(context.stack.peek());
    }
}