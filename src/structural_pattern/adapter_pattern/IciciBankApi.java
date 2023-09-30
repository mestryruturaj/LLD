package structural_pattern.adapter_pattern;

public class IciciBankApi {
    public boolean transferMoney(String to, double amt) {
        System.out.println(String.format("Amount of RS. %.2f is successfully sent to a/c no. %s.", amt, to));
        return true;
    }

    public double fetchBalance(String pin) {
        return 0.0;
    }
}
