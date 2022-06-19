/**
 @author Saman Pordanesh <a href="mailto:sina.pordanesh@yahoo.com">
 sina.pordanesh@yahoo.com</a>
 @version 1.0
 @since 1.0
 */

package edu.def.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;


/**
 * this class handles all three MVC classes to generate an UI application.
 * It uses AWT library for generating GUI.
 */


public class GUI implements View {

//    private Controller controller;
    private TextArea textArea;

    JFrame frame;
    JTextArea display;
    JButton createButton;
    JButton clearButton;
    Controller controller;

    public GUI() {
    }

    @Override
    public void setup(Controller controller) {

        // A controller object to control all principles in the program
        // from a unique class.
        this.controller = controller;


        this.frame = new JFrame();
        this.display = new JTextArea("", 20, 80);

        // Create two button for generating uuid and append to the list (generateButton)
        // and clear the least (clearButton)
        JButton generateButton = this.appendToList();
        JButton clearButton = this.clearList();

        // Create a list for holding all generated uuids
        // responsive to add and clear by two "generateButton" and
        // "clearButton" buttons.
        this.list();

        JLabel label = new JLabel("Result: ");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(textArea);
        panel.add(generateButton);
        panel.add(clearButton);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("UUIDGen");
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Starting a GUI list for holding all generated UUIDs.
     * Presents all generated UUIDs which Model class has.
     */
    @Override
    public void list() {
        this.textArea = new TextArea(5, 20);
        textArea.setEditable(false);

        for ( UUID uuid : this.controller.getModel().getUuids()){
            textArea.append(uuid.toString() + "\n");
        }
    }

    /**
     * Generating a button view and its related functionality.
     * @return: return a button object.
     */
    @Override
    public JButton appendToList() {
        /**
         * this class is defining a specific behaviour for a button.
         * A button can link to this class
         */
        class event1 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleClickGenerateUuid();
                ArrayList<UUID> uuids = controller.getModel().getUuids();
                if (!uuids.isEmpty()){
                    textArea.append(uuids.get(uuids.size()-1).toString() + "\n");
                }
            }
        }
        JButton generateButton = new JButton("Generate UUID");
        event1 e1 = new event1();
        generateButton.addActionListener(e1);
        return generateButton;
    }

    /**
     * Generating a button view and its related functionality.
     * @return: return a button object.
     */
    @Override
    public JButton clearList() {
        /**
         * this class is defining a specific behaviour for a button.
         * A button can link to this class.
         * The point is that it should inherit ActionListener interface to
         * handle on click action.
         */
        class event2 implements ActionListener{
            @Override
            public void actionPerformed(ActionEvent e) {
                controller.handleClickClearList();
                textArea.setText(null);
            }
        }
        JButton clearButton = new JButton("Clear list");
        event2 e2 = new event2();
        clearButton.addActionListener(e2);
        return clearButton;
    }

}
