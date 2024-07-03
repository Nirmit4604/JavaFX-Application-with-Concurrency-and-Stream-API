package nirmittandel_sec001_ex01;


class Transaction implements Runnable {
    private Account account;
    private int amount;
    private boolean isDeposit;

    public Transaction(Account account, int amount, boolean isDeposit) {
        this.account = account;
        this.amount = amount;
        this.isDeposit = isDeposit;
    }

    @Override
    public void run() {
        if (isDeposit) {
            account.deposit(amount);
        } else {
            account.withdraw(amount);
        }
    }
}
