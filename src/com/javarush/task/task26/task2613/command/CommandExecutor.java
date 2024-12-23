package com.javarush.task.task26.task2613.command;

import com.javarush.task.task26.task2613.Operation;
import com.javarush.task.task26.task2613.exception.InterruptOperationException;
import com.javarush.task.task26.task2613.exception.NotEnoughMoneyException;

import java.util.HashMap;
import java.util.Map;

public class CommandExecutor {
    private static final Map<Operation, Command> allKnownCommandsMap = new HashMap<Operation, Command>();

    private CommandExecutor() {
    }

    static {
        allKnownCommandsMap.put(Operation.LOGIN, new LoginCommand());
        allKnownCommandsMap.put(Operation.INFO, new InfoCommand());
        allKnownCommandsMap.put(Operation.EXIT, new ExitCommand());
        allKnownCommandsMap.put(Operation.DEPOSIT, new DepositCommand());
        allKnownCommandsMap.put(Operation.WITHDRAW, new WithdrawCommand());
    }

    public static final void execute(Operation operation) throws InterruptOperationException, NotEnoughMoneyException {
        Command command = allKnownCommandsMap.get(operation);
        command.execute();
    }
}
