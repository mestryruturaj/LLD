package pattern.factory.method.pattern.framework;

import pattern.factory.method.pattern.button.Button;
import pattern.factory.method.pattern.button.IOSButton;
import pattern.factory.method.pattern.dialog_box.DialogBox;
import pattern.factory.method.pattern.dialog_box.IOSDialogBox;

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
