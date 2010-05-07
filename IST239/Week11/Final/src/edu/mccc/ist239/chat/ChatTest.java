package edu.mccc.ist239.chat;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;


/**
 * The actual client GUI. A ChatClient object is used to send/received messages from the server.
 */
public class ChatTest extends JPanel implements ChatClientListener {
    private ChatClient chatClient;
    private JTextArea nameField;
    private JTextArea chatText;
    private JTextField inputField;

    public ChatTest() {
        this.chatClient = new ChatClient(
            //This should the the actual user name. Currently just dead weight
            "Bob",
            "127.0.0.1"
        );
        chatClient.addChatClientListener(this);
        initGUI();
    }
    private void initGUI() {
        //GUI
        setLayout(new BorderLayout());
        chatText = new JTextArea();
        chatText.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(chatText);

        JButton sendButton = new JButton("Send");
        sendButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    sendMessage();
                }
            }
        );
        JPanel namePanel = new JPanel();
        namePanel.setLayout(
            new BorderLayout()
        );
        namePanel.setBorder(
            BorderFactory.createLineBorder(
                Color.BLACK
            )
        );
        namePanel.add(
            new JLabel(
                "Name: "
            ),
            BorderLayout.WEST
        );
        nameField = new JTextArea();
        nameField.setRows(1);
        namePanel.add(
            nameField,
            BorderLayout.CENTER
        );

        inputField = new JTextField();
        inputField.addKeyListener(
            new KeyAdapter() {
                public void keyPressed(KeyEvent e) {
                    if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                        sendMessage();
                    }
                }
            }
        );
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(
            sendButton,
            BorderLayout.EAST
        );
        inputPanel.add(
            inputField,
            BorderLayout.CENTER
        );

        add(
            namePanel,
            BorderLayout.NORTH
        );
        add(
            //chatText,
            scrollPane,
            BorderLayout.CENTER
        );
        add(
            inputPanel,
            BorderLayout.SOUTH
        );

        JButton frameButton = new JButton("New Conversation");
        frameButton.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    System.out.println("newFrame Button pressed");
                    //Open a new frame
                    new ChatWindow(ChatTest.this);
                }
            }
        );
        add(
            makeSidePanel(),
            BorderLayout.EAST
        );

        setPreferredSize(
            new Dimension(
                800,
                600
            )
        );
    }

    /**
     * Creates the panel that holds the buddy list, etc
     */
    private JPanel makeSidePanel() {
        JPanel panel = new JPanel();
        panel.setLayout(
            new BorderLayout()
        );
        //BUDDY LIST
        JPanel buddyListPanel = new JPanel();
        buddyListPanel.add(
            new JLabel("Buddy List")
        );
        
        buddyListPanel.setBackground(
            Color.WHITE
        );

        //BUTTONS
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(
            new GridLayout(
                1, 
                3
            )
        );
        JButton addButton    = new JButton("Add");
        JButton removeButton = new JButton("Remove");
        JButton fileButton   = new JButton("File");

        buttonPanel.add(
            addButton
        );
        buttonPanel.add(
            removeButton
        );
        buttonPanel.add(
            fileButton
        );

        panel.add(
            buddyListPanel,
            BorderLayout.CENTER
        );
        panel.add(
            buttonPanel,
            BorderLayout.SOUTH
        );

        return panel;
    }

    /**
     * Attaches the menu to the given JFrame
     */
    private void makeMenu(JFrame frame) {
        JMenuBar menuBar;
        JMenu menu, submenu;
        JMenuItem menuItem;
        JRadioButtonMenuItem rbMenuItem;
        JCheckBoxMenuItem cbMenuItem;
        //Create the menu bar.
        menuBar = new JMenuBar();
        
        //Build the first menu.
        menu = new JMenu("A Menu");
        
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                        "The only menu in this program that has menu items");
        menuBar.add(menu);

        //a group of JMenuItems
        menuItem = new JMenuItem("A text-only menu item",
                KeyEvent.VK_T);
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_1, ActionEvent.ALT_MASK));
        menuItem.getAccessibleContext().setAccessibleDescription(
                "This doesn't really do anything");
        menu.add(menuItem);

        menuItem = new JMenuItem("Both text and icon",
                new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_B);
        menu.add(menuItem);

        menuItem = new JMenuItem(new ImageIcon("images/middle.gif"));
        menuItem.setMnemonic(KeyEvent.VK_D);
        menu.add(menuItem);

        //a group of radio button menu items
        menu.addSeparator();
        ButtonGroup group = new ButtonGroup();
        rbMenuItem = new JRadioButtonMenuItem("A radio button menu item");
        rbMenuItem.setSelected(true);
        rbMenuItem.setMnemonic(KeyEvent.VK_R);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        rbMenuItem = new JRadioButtonMenuItem("Another one");
        rbMenuItem.setMnemonic(KeyEvent.VK_O);
        group.add(rbMenuItem);
        menu.add(rbMenuItem);

        //a group of check box menu items
        menu.addSeparator();
        cbMenuItem = new JCheckBoxMenuItem("A check box menu item");
        cbMenuItem.setMnemonic(KeyEvent.VK_C);
        menu.add(cbMenuItem);

        cbMenuItem = new JCheckBoxMenuItem("Another one");
        cbMenuItem.setMnemonic(KeyEvent.VK_H);
        menu.add(cbMenuItem);

        //a submenu
        menu.addSeparator();
        submenu = new JMenu("A submenu");
        submenu.setMnemonic(KeyEvent.VK_S);

        menuItem = new JMenuItem("An item in the submenu");
        menuItem.setAccelerator(KeyStroke.getKeyStroke(
                    KeyEvent.VK_2, ActionEvent.ALT_MASK));
        submenu.add(menuItem);

        menuItem = new JMenuItem("Another item");
        submenu.add(menuItem);
        menu.add(submenu);

        //Build second menu in the menu bar.
        menu = new JMenu("Another Menu");
        menu.setMnemonic(KeyEvent.VK_N);
        menu.getAccessibleContext().setAccessibleDescription(
                "This menu does nothing");
        menuBar.add(menu);

        frame.setJMenuBar(menuBar);
    }

    public static void main(String[] sa) {
		JFrame frame = new JFrame();
		frame.setTitle("Chat Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);
        ChatTest ct = new ChatTest();
        frame.add(
            ct
        );
        ct.makeMenu(frame);
		frame.pack();
		frame.setVisible(true);
    }

    public void messageReceived(ChatClientEvent e) {
        System.out.println("Message received!: " + e.getMessage());
        chatText.append(e.getMessage() + "\n");
    }

    private void sendMessage() {
        chatClient.sendMessage(
            nameField.getText() + ": " + inputField.getText()
        );
        inputField.setText("");
    }
}
