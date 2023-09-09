/**
 * interface Framework is a factory of creating components.
 */
package creational_pattern.factory_method_pattern.framework;

import creational_pattern.factory_method_pattern.button.Button;
import creational_pattern.factory_method_pattern.dialog_box.DialogBox;

public interface Framework {
    public Button createButton();

    public DialogBox createDialogBox();
}
