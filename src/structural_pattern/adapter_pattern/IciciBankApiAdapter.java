package structural_pattern.adapter_pattern;

public class IciciBankApiAdapter implements BankApi {
    private IciciBankApi iciciBankApi;

    public IciciBankApiAdapter(IciciBankApi iciciBankApi) {
        this.iciciBankApi = iciciBankApi;
    }
    @Override
    public boolean transferMoneyTo(String to, double amt) {
        return iciciBankApi.transferMoney(to, amt);
    }

    @Override
    public double getBalance(String pin) {
        return iciciBankApi.fetchBalance(pin);
    }
}
