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
import java.util.UUID;

/**
 * this class handles all three MVC classes to generate a UI application.
 * It uses Swing & AWT libraries for generating GUI.
 */

class SwingView extends View implements ActionListener {

    JFrame frame;
    TextArea display;
    JButton createButton;
    JButton clearButton;
    Controller controller;

    @Override
    public void setup(Controller controller) {

        // A controller object to control all principles in the program
        // from a unique class.
        this.controller = controller;

        this.frame = new JFrame();

        // Create a list for holding all generated uuids
        // responsive to add and clear by two "generateButton" and
        // "clearButton" buttons.
        this.display = new TextArea("", 20, 80);
        this.display.setEditable(false);

        this.startMainLoop();

        // Create two button for generating uuid and append to the list (generateButton)
        // and clear the least (clearButton)
        this.createButton = new JButton("Generate UUID");
        this.createButton.addActionListener(this);

        this.clearButton = new JButton("Clear List");
        this.clearButton.addActionListener(this);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(0,2));
        buttonPanel.add(this.createButton);
        buttonPanel.add(this.clearButton);

        Container content = this.frame.getContentPane();
        content.setLayout(new BorderLayout());
        content.add("Center", this.display);
        content.add("South", buttonPanel);

        this.frame.setPreferredSize(new Dimension(300, 200));
        this.frame.setTitle("UUID generator");
        this.frame.pack();


    }

    @Override
    public void appendToList(UUID item) {
        this.display.append(item.toString() + "\n");
    }

    @Override
    public void clearList() {
        this.display.setText("");
    }

    @Override
    public void startMainLoop() {
        this.frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.createButton) {
            this.controller.handleClickGenerateUuid();
            Model model = controller.getModel();
            this.appendToList(model.getUuids().get(model.getUuids().size()-1));

        }else if (e.getSource() == this.clearButton) {
            this.controller.handleClickClearList();
            this.clearList();
        }
    }
}