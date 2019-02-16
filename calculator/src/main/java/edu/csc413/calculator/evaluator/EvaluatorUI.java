package edu.csc413.calculator.evaluator;

import edu.csc413.calculator.operators.Operator;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EvaluatorUI extends JFrame implements ActionListener {

    private TextField txField = new TextField();
    private Panel buttonPanel = new Panel();

    // total of 20 buttons on the calculator,
    // numbered from left to right, top to bottom
    // bText[] array contains the text for corresponding buttons
    private static final String[] bText = {
            "7", "8", "9", "+", "4", "5", "6", "-", "1", "2", "3",
            "*", "0", "^", "=", "/", "(", ")", "C", "CE"
    };

    /**
     * C  is for clear, clears entire expression
     * CE is for clear expression, clears last entry up until the last operator.
     */
    private Button[] buttons = new Button[bText.length];

    public static void main(String argv[]) {
        EvaluatorUI calc = new EvaluatorUI();
    }

    public EvaluatorUI() {
        setLayout(new BorderLayout());
        this.txField.setPreferredSize(new Dimension(600, 50));
        this.txField.setFont(new Font("Courier", Font.BOLD, 28));

        add(txField, BorderLayout.NORTH);
        txField.setEditable(false);

        add(buttonPanel, BorderLayout.CENTER);
        buttonPanel.setLayout(new GridLayout(5, 4));

        //create 20 buttons with corresponding text in bText[] array
        Button bt;
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            bt = new Button(bText[i]);
            bt.setFont(new Font("Courier", Font.BOLD, 28));
            buttons[i] = bt;
        }

        //add buttons to button panel
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttonPanel.add(buttons[i]);
        }

        //set up buttons to listen for mouse input
        for (int i = 0; i < EvaluatorUI.bText.length; i++) {
            buttons[i].addActionListener(this);
        }

        setTitle("Calculator");
        setSize(400, 400);
        setLocationByPlatform(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
    }

    // filled in by me
    public void actionPerformed(ActionEvent arg0) {
        // keep adding input to text field until = sign is pressed, or
        // until other if statement triggered (C or CE)

        // if user clicks CE, clear until we reach most recent operator
        // couldn't figure out a way to do this without treating the CE button as a backspace
        // Tom Sechrist figured out a cool way, though, so I used his for loop logic.
        // added ability to have CE delete the operator if that is the last thing entered
        // (Sometimes I would accidentally click an operator twice and would have to start over)
        if (arg0.getActionCommand().equals("CE")) {
            int fieldLength = (txField.getText().length());

            // don't need to do anything if nothing on txField
            if (fieldLength > 0) {
                boolean clicked = false;

                if (Operator.check(String.valueOf(txField.getText().charAt(fieldLength - 1))) && (fieldLength != 0)) {
                    clicked = true;
                    txField.setText(txField.getText().substring(0, (fieldLength - 1)));
                }
                // if char at position[i] is an operand, delete it
                // loops until operator found.

                // update fieldLength
                fieldLength = (txField.getText().length());
                if (!clicked && (fieldLength != 0)) {
                    // couldn't figure out how to get rid of StringIndexOutOfBoundsException that would happen
                    // if CE was used until text field clear. used try catch to hide the bug.
                    // would fix it in future updates with more time.
                    try {
                        for (int i = fieldLength - 1; Operand.check(String.valueOf(txField.getText().charAt(i))); i--) {
//                        if (fieldLength > 1)
                            txField.setText(txField.getText().substring(0, i));
                        }
                    } catch (StringIndexOutOfBoundsException error) {
                    }
                }
            }
        }
        // if user clicks C, entire textfield is cleared
        else if (arg0.getActionCommand().equals("C")) {
            txField.setText("");
        }

        // when user clicks =, we evaluate the expression they typed in
        else if (arg0.getActionCommand().equals("=")) {
            Evaluator compute = new Evaluator();
            txField.setText(String.valueOf(compute.eval(txField.getText())));
        } else if (!arg0.getActionCommand().equals("=")) {
            txField.setText(txField.getText() + arg0.getActionCommand());
        }
    }
}

