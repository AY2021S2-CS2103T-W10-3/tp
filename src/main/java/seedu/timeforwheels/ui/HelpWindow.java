package seedu.timeforwheels.ui;

import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.stage.Stage;
import seedu.timeforwheels.commons.core.LogsCenter;

/**
 * Controller for a help page
 */
public class HelpWindow extends UiPart<Stage> {

    public static final String USERGUIDE_URL = "https://ay2021s2-cs2103t-w10-3.github.io/tp/UserGuide.html";
    public static final String HELP_MESSAGE = "Add a delivery task - add n/NAME p/PHONE a/ADDRESS "
            + "e/EMAIL t/TAG d/DATETIME \n"
            + "Add a remark to a delivery task - remark TASK_NUMBER r/REMARK \n"
            + "Edit a delivery task (only way to add tag(s)"
            + " - edit TASK_NUMBER n/NAME p/PHONE a/ADDRESS e/EMAIL t/TAG d/DATETIME \n"
            + "Find delivery task(s) - find KEYWORD \n"
            + "Delete a delivery task - delete TASK_NUMBER \n"
            + "Clear all delivery tasks - clear \n"
            + "List all delivery tasks - list \n"
            + "Mark a delivery tasks as done - done TASK_NUMBER \n"
            + "Add tag(s) to a delivery task - edit TASK_NUMBER t/TAG \n"
            + "View all completed delivery tasks - completed \n"
            + "View all uncompleted delivery tasks - uncompleted \n"
            + "Sort all delivery tasks by completion status (incomplete first), urgency (for incomplete), then date"
            + " - sort \n"
            + "Statistics of delivery workflow - stats \n"
            + "Exit the application - exit \n\n"
            + "You may copy the URL of the user guide for more details: " + USERGUIDE_URL;

    private static final Logger logger = LogsCenter.getLogger(HelpWindow.class);
    private static final String FXML = "HelpWindow.fxml";

    @FXML
    private Button copyButton;

    @FXML
    private Label helpMessage;

    /**
     * Creates a new HelpWindow.
     *
     * @param root Stage to use as the root of the HelpWindow.
     */
    public HelpWindow(Stage root) {
        super(FXML, root);
        helpMessage.setText(HELP_MESSAGE);
    }

    /**
     * Creates a new HelpWindow.
     */
    public HelpWindow() {
        this(new Stage());
    }

    /**
     * Shows the help window.
     * @throws IllegalStateException
     * <ul>
     *     <li>
     *         if this method is called on a thread other than the JavaFX Application Thread.
     *     </li>
     *     <li>
     *         if this method is called during animation or layout processing.
     *     </li>
     *     <li>
     *         if this method is called on the primary stage.
     *     </li>
     *     <li>
     *         if {@code dialogStage} is already showing.
     *     </li>
     * </ul>
     */
    public void show() {
        logger.fine("Showing help page about the application.");
        getRoot().show();
        getRoot().centerOnScreen();
    }

    /**
     * Returns true if the help window is currently being shown.
     */
    public boolean isShowing() {
        return getRoot().isShowing();
    }

    /**
     * Hides the help window.
     */
    public void hide() {
        getRoot().hide();
    }

    /**
     * Focuses on the help window.
     */
    public void focus() {
        getRoot().requestFocus();
    }

    /**
     * Copies the URL to the user guide to the clipboard.
     */
    @FXML
    private void copyUrl() {
        final Clipboard clipboard = Clipboard.getSystemClipboard();
        final ClipboardContent url = new ClipboardContent();
        url.putString(USERGUIDE_URL);
        clipboard.setContent(url);
    }
}
