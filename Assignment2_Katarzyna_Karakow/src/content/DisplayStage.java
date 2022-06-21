/*

 */
package content;

import java.util.ArrayList;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class DisplayStage extends Stage {

    private Label lblDisplay = new Label();
    private Pane pane = new Pane(lblDisplay);
    private Scene scene = new Scene(pane, 400, 400);

    public DisplayStage(ArrayList<Record> recordsList) {
        for (int sub = 0; sub < recordsList.size(); sub++) {
            Record two = recordsList.get(sub);
            lblDisplay.setText("ID: " + two.getID()
                    + "Name: " + two.getName()
                    + "Address: " + two.getAddress()
                    + "City: " + two.getCity());
        }
            setScene(scene);
    }

}
