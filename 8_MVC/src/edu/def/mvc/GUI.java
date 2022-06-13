package edu.def.mvc;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.UUID;

public class GUI implements View {

    private Controller controller;
    private TextArea textArea;

    public GUI() {
    }

    @Override
    public void setup(Controller controller) {

        this.controller = controller;

        JFrame frame = new JFrame();

        JButton button1 = new JButton("Generate UUID");
        event1 e1 = new event1();
        button1.addActionListener(e1);
        JButton button2 = new JButton("Clear list");
        event2 e2 = new event2();
        button2.addActionListener(e2);

        this.textArea = new TextArea(5, 20);
        textArea.setEditable(false);

        for ( UUID uuid : this.controller.getModel().getUuids()){
            textArea.append(uuid.toString() + "\n");
        }

        JLabel label = new JLabel("Result: ");

        JPanel panel = new JPanel();
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setLayout(new GridLayout(0, 1));
        panel.add(label);
        panel.add(textArea);
        panel.add(button1);
        panel.add(button2);

        frame.add(panel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("UUIDGen");
        frame.pack();
        frame.setVisible(true);
    }

    @Override
    public void appendToList() {

    }

    @Override
    public void clearList() {

    }

    @Override
    public void startMainLoop() {

    }

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

    class event2 implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            controller.handleClickClearList();
            textArea.setText(null);
        }
    }
}
