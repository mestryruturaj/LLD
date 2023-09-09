package creational_pattern.factory_method_pattern.framework;

import creational_pattern.factory_method_pattern.button.Button;
import creational_pattern.factory_method_pattern.button.IOSButton;
import creational_pattern.factory_method_pattern.dialog_box.DialogBox;
import creational_pattern.factory_method_pattern.dialog_box.IOSDialogBox;

public class IOSFramework implements Framework {

    @Override
    public Button createButton() {
        return new IOSButton();
    }

    @Override
    public DialogBox createDialogBox() {
        return new IOSDialogBox();
    }
}
