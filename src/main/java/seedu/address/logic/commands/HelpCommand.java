package seedu.address.logic.commands;

import seedu.address.model.Model;

/**
 * Format full help instructions for every command for display.
 */
public class HelpCommand extends Command {

    public static final String COMMAND_WORD = "help";

    public static final String MESSAGE_USAGE = COMMAND_WORD + ": Shows program usage instructions.\n"
            + "Example: " + COMMAND_WORD;

    public static final String SHOWING_HELP_MESSAGE = "Available commands:\n"
            + "- addContact: Adds a new contact\n"
            + "- addTrip: Adds a new trip with name, accommodation,"
            + " itinerary, date, optional customer names and optional note\n"
            + "- clear: Clear all contacts and trips\n"
            + "- deleteContact: Removes a contact at a specified index\n"
            + "- deleteTrip: Removes a trip at a specified index\n"
            + "- editContact: Edits a contact at a specified index\n"
            + "- editTrip: Edits a trip at a specified index\n"
            + "- exit: Exits the program\n"
            + "- find: Find contacts whose names contain any of the given keywords \n"
            + "- help: Shows program usage instructions\n"
            + "- listContact: Lists all contacts [can specify tag type]\n"
            + "- listTrip: Lists all trips ";

    @Override
    public CommandResult execute(Model model) {
        return new CommandResult(SHOWING_HELP_MESSAGE, false, false, false, null);
    }
}
