package lucas.hazardous.mongodb_test;

import javax.swing.*;

public class BookViewerPanel extends JPanel {
    private JTextArea textArea;

    public BookViewerPanel() {
        textArea = new JTextArea("", 25, 40);
        textArea.setLineWrap(true);
        var scrollingPanel = new JScrollPane(textArea);
        scrollingPanel.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        add(scrollingPanel);
    }

    public JTextArea getTextArea() {
        return textArea;
    }
}
