package structural_pattern.adapter_pattern;

public class Client {
    public static void main(String[] args) {
        BankApi bankApi = new YesBankApiAdapter(new YesBankApi());

        String accountNumber = "0801xxxx";
        double amt = 91.32;

        bankApi.transferMoneyTo(accountNumber, amt);
        bankApi.getBalance("123");
    }
}
