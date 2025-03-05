package commands;

import java.util.List;

public class PopCommand implements Command {
    @Override
    public void execute(List<String> arguments, CommandContext context) {
        if (!arguments.isEmpty()) {
            throw new IllegalArgumentException("POP command requires 0 argument.");
        }
        context.stack.pop();
    }
}
