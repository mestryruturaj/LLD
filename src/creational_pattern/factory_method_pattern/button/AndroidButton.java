package creational_pattern.factory_method_pattern.button;

public class AndroidButton extends AbstractButton{
    @Override
    public void setColor(String color) {
        System.out.println(String.format("Color of AndroidButton is updated to %s.", color));
    }

    @Override
    public void updateButton(Integer length, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
        System.out.println(String.format("Android button is updated to length of %d, and width of %d.", length, breadth));
    }

    public AndroidButton() {
        System.out.println("Android button is created");
    }
}
