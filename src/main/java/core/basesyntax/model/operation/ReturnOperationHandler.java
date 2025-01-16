package core.basesyntax.model.operation;

import core.basesyntax.db.Storage;
import core.basesyntax.model.FruitTransaction;
import core.basesyntax.model.OperationHandler;

public class ReturnOperationHandler implements OperationHandler {
    private final Storage storage;

    public ReturnOperationHandler(Storage storage) {
        this.storage = storage;
    }

    @Override
    public void handle(FruitTransaction transaction) {
        int currentAmount = storage.getInventory().getOrDefault(transaction.getFruit(),
                storage.getDefaultInventoryValue());
        storage.getInventory().put(transaction.getFruit(),
                transaction.getQuantity() + currentAmount);
    }

}
