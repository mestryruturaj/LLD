package pattern.adapter_pattern;

public interface BankApi {
    public boolean transferMoneyTo(String to, double amt);

    public double getBalance(String pin);
}
