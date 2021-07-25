package sample;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class NewDialogController {
    @FXML
    private TextField titleField;

    @FXML
    private TextField usernameField;

    @FXML
    private TextField valueField;

    @FXML
    private TextField websiteField;

    public Password processDialog() {
        String username = usernameField.getText().trim();
        String value = valueField.getText().trim();
        String website = websiteField.getText().trim();
        String title = titleField.getText().trim();

        Password item = new Password(title,username,value,website);
        PasswordData.getInstance().passwordList.add(item);
        return item;
    }

}
