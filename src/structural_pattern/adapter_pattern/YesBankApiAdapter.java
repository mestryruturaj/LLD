package structural_pattern.adapter_pattern;

public class YesBankApiAdapter implements BankApi {
    private YesBankApi yesBankApi;

    public YesBankApiAdapter(YesBankApi yesBankApi) {
        this.yesBankApi = yesBankApi;
    }

    @Override
    public boolean transferMoneyTo(String to, double amt) {
        return yesBankApi.sendMoney(to, amt);
    }

    @Override
    public double getBalance(String pin) {
        return yesBankApi.checkBalance(pin);
    }
}
