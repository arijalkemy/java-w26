public interface Transaction {
    default boolean transaccionOk() {
        return true;
    }

    default boolean transaccionNoOk() {
        return false;
    }
}
