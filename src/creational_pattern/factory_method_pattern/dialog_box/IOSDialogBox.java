package creational_pattern.factory_method_pattern.dialog_box;

public class IOSDialogBox extends AbstractDialogBox {
    @Override
    public void setColor(String color) {
        System.out.println(String.format("Color of IOSDialogBox is updated to %s.", color));
    }

    @Override
    public void updateDialogBox(Integer length, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
        System.out.println(String.format("IOS dialog box is updated to length of %d, and width of %d.", length, breadth));
    }
}