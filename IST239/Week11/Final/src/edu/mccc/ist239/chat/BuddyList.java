package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

/**
 * JPanel to manage the user's buddy list
 * Based on Sun's JList example
 */
public class BuddyList extends JPanel implements ListSelectionListener {
    private ChatTest chat;
    private JList list;
    private DefaultListModel listModel;

    private static final String addString = "Add";
    private static final String removeString = "Remove";
    private JButton removeButton;
    private JTextField employeeName;

    public BuddyList(ChatTest chat) {
        super(new BorderLayout());
        setBorder(
            BorderFactory.createTitledBorder(
                "Buddy List"
            )
        );
        this.chat = chat;

        listModel = new DefaultListModel();
        //listModel.addElement("");
        //listModel.addElement("kyle");

        //Create the list and put it in a scroll pane.
        list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        list.addListSelectionListener(this);
        list.addMouseListener(new BuddyMouseListener());
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);

        JButton addButton = new JButton(addString);
        AddListener addListener = new AddListener(addButton);
        addButton.setActionCommand(addString);
        addButton.addActionListener(addListener);
        addButton.setEnabled(false);

        removeButton = new JButton(removeString);
        removeButton.setActionCommand(removeString);
        removeButton.addActionListener(new RemoveListener());

        employeeName = new JTextField(10);
        employeeName.addActionListener(addListener);
        employeeName.getDocument().addDocumentListener(addListener);
        //String name = listModel.getElementAt(list.getSelectedIndex()).toString();

        //Create a panel that uses BoxLayout.

        //ADD/REMOVE
        JPanel addRemovePane = new JPanel();
        addRemovePane.setLayout(new BoxLayout(addRemovePane,
                                           BoxLayout.LINE_AXIS));
        addRemovePane.add(removeButton);
        addRemovePane.add(Box.createHorizontalStrut(5));
        addRemovePane.add(new JSeparator(SwingConstants.VERTICAL));
        addRemovePane.add(Box.createHorizontalStrut(5));
        addRemovePane.add(employeeName);
        addRemovePane.add(addButton);
        addRemovePane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));

        add(listScrollPane, BorderLayout.CENTER);

        //FILE/NEW
        JButton fileButton   = new JButton("File");
        JButton frameButton = new JButton("New");
        frameButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("newFrame Button pressed");
                    //Open a new frame
                    //new ChatWindow(BuddyList.this, "TEST");
                }
            }
        );

        JPanel filePane = new JPanel();
        filePane.add(fileButton);
        filePane.add(frameButton);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new BoxLayout(
                buttonPanel,
                BoxLayout.Y_AXIS
            )
        );
        buttonPanel.add(addRemovePane);
        buttonPanel.add(filePane);

        add(buttonPanel, BorderLayout.PAGE_END);
    }

    /**
     * Add buddy button clicked
     */
    public void addBuddy(String username, boolean local) {
        listModel.addElement(username);
        if (local) {
            //Send it to the server
            ChatClient client = chat.getChatClient();
            client.sendBuddyMessage(username);
        }
    }

    /**
     * Delete buddies
     */

    /**
     * Just clear the local list
     */
    public void clearBuddies() {
        listModel.clear();
    }

    class RemoveListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            //This method can be called only if
            //there's a valid selection
            //so go ahead and remove whatever's selected.
            int index = list.getSelectedIndex();
            listModel.remove(index);

            int size = listModel.getSize();

            if (size == 0) { //Nobody's left, disable firing.
                removeButton.setEnabled(false);

            } else { //Select an index.
                if (index == listModel.getSize()) {
                    //removed item in last position
                    index--;
                }

                list.setSelectedIndex(index);
                list.ensureIndexIsVisible(index);
            }
        }
    }

    /**
     * Add buddies
     * This listener is shared by the text field and the add button.
     */
    class AddListener implements ActionListener, DocumentListener {
        private boolean alreadyEnabled = false;
        private JButton button;

        public AddListener(JButton button) {
            this.button = button;
        }

        //Required by ActionListener.
        public void actionPerformed(ActionEvent e) {
            String name = employeeName.getText();

            //User didn't type in a unique name...
            if (name.equals("") || alreadyInList(name)) {
                Toolkit.getDefaultToolkit().beep();
                employeeName.requestFocusInWindow();
                employeeName.selectAll();
                return;
            }

            int index = list.getSelectedIndex(); //get selected index
            if (index == -1) { //no selection, so insert at beginning
                index = 0;
            } else {           //add after the selected item
                index++;
            }

            listModel.insertElementAt(employeeName.getText(), index);
            //If we just wanted to add to the end, we'd do this:
            //listModel.addElement(employeeName.getText());

            //Reset the text field.
            employeeName.requestFocusInWindow();
            employeeName.setText("");

            //Select the new item and make it visible.
            list.setSelectedIndex(index);
            list.ensureIndexIsVisible(index);
        }

        //This method tests for string equality. You could certainly
        //get more sophisticated about the algorithm.  For example,
        //you might want to ignore white space and capitalization.
        protected boolean alreadyInList(String name) {
            return listModel.contains(name);
        }

        //Required by DocumentListener.
        public void insertUpdate(DocumentEvent e) {
            enableButton();
        }

        //Required by DocumentListener.
        public void removeUpdate(DocumentEvent e) {
            handleEmptyTextField(e);
        }

        //Required by DocumentListener.
        public void changedUpdate(DocumentEvent e) {
            if (!handleEmptyTextField(e)) {
                enableButton();
            }
        }

        private void enableButton() {
            if (!alreadyEnabled) {
                button.setEnabled(true);
            }
        }

        private boolean handleEmptyTextField(DocumentEvent e) {
            if (e.getDocument().getLength() <= 0) {
                button.setEnabled(false);
                alreadyEnabled = false;
                return true;
            }
            return false;
        }
    }

    class BuddyMouseListener extends MouseAdapter {
        public void mouseClicked(MouseEvent e){
            if (e.getClickCount() == 2) {
                int index = list.locationToIndex(e.getPoint());
                ListModel dlm = list.getModel();
                Object item   = dlm.getElementAt(index);;
                list.ensureIndexIsVisible(index);
                System.out.println("Double clicked on " + item);

                chat.privateIM(item.toString());
            }
        }
    }

    //This method is required by ListSelectionListener.
    public void valueChanged(ListSelectionEvent e) {
        if (e.getValueIsAdjusting() == false) {
            if (list.getSelectedIndex() == -1) {
                //No selection, disable remove button.
                removeButton.setEnabled(false);
            } else {
                //Selection, enable the remove button.
                removeButton.setEnabled(true);
            }
        }
    }
}
