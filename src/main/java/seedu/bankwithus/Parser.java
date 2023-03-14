package seedu.bankwithus;

import seedu.bankwithus.exceptions.CommandNotFoundException;

import java.util.Scanner;

public class Parser {

    private BankWithUs bwu;

    public Parser(BankWithUs bwu) {
        this.bwu = bwu;
    }

    /**
     * Parses the user input into command and arguments.
     */

    public void parseUserInput(String input) throws CommandNotFoundException {
        // Split input by space
        String[] split = input.trim().split("\\s+", 2);
        String command = split[0];
        String args = split.length == 2 ? split[1] : "";

        switch (command) {
            case "exit":
                bwu.isExitEntered = true;
                break;
            default:
                throw new CommandNotFoundException();
        }
    }

    public void parseSavedFile(AccountList list) {
        Scanner myReader = new Scanner("data/save.txt");
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            String[] splitDetails = data.split("\\$");
            String name = splitDetails[0];
            String balance = splitDetails[1];
            list.addAccount(name, balance);
        }
    }

}
