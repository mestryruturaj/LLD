package pattern.adapter_pattern;

public class YesBankApi {
    public boolean sendMoney(String to, double amt) {
        System.out.println(String.format("Amount of RS. %.2f is successfully sent to a/c no. %s.", amt, to));
        return true;
    }

    public double checkBalance(String pin) {
        return 0.00;
    }
}
