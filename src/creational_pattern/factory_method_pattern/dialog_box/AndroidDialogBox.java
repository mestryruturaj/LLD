package creational_pattern.factory_method_pattern.dialog_box;

public class AndroidDialogBox extends AbstractDialogBox{
    @Override
    public void setColor(String color) {
        System.out.println(String.format("Color of AndroidDialogBox is updated to %s.", color));
    }

    @Override
    public void updateDialogBox(Integer length, Integer breadth) {
        this.length = length;
        this.breadth = breadth;
        System.out.println(String.format("Android dialog box is updated to length of %d, and width of %d.", length, breadth));
    }

    public AndroidDialogBox() {
        System.out.println("Android dialog box is created.");
    }
}
