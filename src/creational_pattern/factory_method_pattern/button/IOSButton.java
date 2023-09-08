package creational_pattern.factory_method_pattern.button;

public class IOSButton extends AbstractButton{
    @Override
    public void setColor(String color) {
        System.out.println(String.format("Color of IOSButton is updated to %s.", color));
    }

    @Override
    public void updateButton(Integer length, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
        System.out.println(String.format("IOS button is updated to length of %d, and width of %d.", length, breadth));
    }
}
