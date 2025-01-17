package core.basesyntax.model.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private static final int DEFAULT_AMOUNT = 0;
    private final Storage storage;

    public ReturnOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentAmount = storage.getInventory().getOrDefault(transaction.getFruit(),
                DEFAULT_AMOUNT);
        storage.getInventory().put(transaction.getFruit(),
                transaction.getQuantity() + currentAmount);
    }

}
