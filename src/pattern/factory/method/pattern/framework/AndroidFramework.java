package pattern.factory.method.pattern.framework;

import pattern.factory.method.pattern.button.AndroidButton;
import pattern.factory.method.pattern.button.Button;
import pattern.factory.method.pattern.dialog_box.AndroidDialogBox;
import pattern.factory.method.pattern.dialog_box.DialogBox;

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
