package pattern.factory.method.pattern;

import pattern.factory.method.pattern.button.Button;
import pattern.factory.method.pattern.dialog_box.DialogBox;
import pattern.factory.method.pattern.framework.AndroidFramework;
import pattern.factory.method.pattern.framework.Framework;
import pattern.factory.method.pattern.framework.IOSFramework;

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
