package pocolor.asciicraft.command;

import pocolor.asciicraft.command.exceptions.*;

public abstract class Command {
    public abstract int execute(String... args) throws InvalidArgumentException;

    public static String[] parse(String input) throws MalformedCommandException {
        if (!input.matches("[a-z\\d_ ]+")) {
            throw new MalformedCommandException("");  // TODO(write error message)
        }
        if (input.contains(" ")) {
            return input.split(" +");
        }
        return new String[] {input};
    }
}
