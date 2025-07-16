/**
 * interface Framework is a factory of creating components.
 */
package pattern.factory.method.pattern.framework;

import pattern.factory.method.pattern.button.Button;
import pattern.factory.method.pattern.dialog_box.DialogBox;

public interface Framework {
    public Button createButton();

    public DialogBox createDialogBox();
}
