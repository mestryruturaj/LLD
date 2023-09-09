package creational_pattern.factory_method_pattern;

import creational_pattern.factory_method_pattern.button.Button;
import creational_pattern.factory_method_pattern.dialog_box.DialogBox;
import creational_pattern.factory_method_pattern.framework.AndroidFramework;
import creational_pattern.factory_method_pattern.framework.Framework;
import creational_pattern.factory_method_pattern.framework.IOSFramework;

public class Client {
    public static void main(String[] args) {
        Framework androidFramework = new AndroidFramework();
        Button androidButton = androidFramework.createButton();
        DialogBox androidDialogBox = androidFramework.createDialogBox();
        androidButton.setColor("Green");

        Framework iosFramework = new IOSFramework();
        Button iosButton = iosFramework.createButton();
        DialogBox iosDialogbox = iosFramework.createDialogBox();
        iosButton.setColor("White");
    }
}
