package creational_pattern.factory_method_pattern.framework;

import creational_pattern.factory_method_pattern.button.AndroidButton;
import creational_pattern.factory_method_pattern.button.Button;
import creational_pattern.factory_method_pattern.dialog_box.AndroidDialogBox;
import creational_pattern.factory_method_pattern.dialog_box.DialogBox;

public class AndroidFramework implements Framework {
    @Override
    public Button createButton() {
        return new AndroidButton();
    }

    @Override
    public DialogBox createDialogBox() {
        return new AndroidDialogBox();
    }
}
