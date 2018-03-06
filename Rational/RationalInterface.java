package Rational;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RationalInterface {

	public static void main(String[] args) {
   		JFrame frame = new JFrame("FRACTIONS"); // The main window
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // This tells the
		// program to exit when the frame is closed
		frame.setBounds(0, 0, 400, 400);
		// First two numbers set position, second two set size

		RationalNumbers one = new RationalNumbers(1, 2);

		JPanel north = new JPanel(); // JPanels allow me to place the buttons

		JLabel numLabel1 = new JLabel("Numerator1: ");
		JLabel denLabel1 = new JLabel("Denominator1: ");
		final int FIELD_WIDTH = 5;
		final JTextField numField1 = new JTextField(FIELD_WIDTH);
		numField1.setText("0");
		final JTextField denField1 = new JTextField(FIELD_WIDTH);
		denField1.setText("1");

		JLabel ratio1 = new JLabel("");
		JButton reduceButton1 = new JButton(" Reduce x");
		reduceButton1.setBackground(Color.BLUE);
		reduceButton1.setForeground(Color.WHITE);
		JLabel numLabel2 = new JLabel("Numerator2: ");
		JLabel denLabel2 = new JLabel("Denominator2: ");
		final JTextField numField2 = new JTextField(FIELD_WIDTH);
		numField2.setText("0");
		final JTextField denField2 = new JTextField(FIELD_WIDTH);
		denField2.setText("1");

		// The button to trigger the calculation
		int num2 = Integer.parseInt(numField2.getText());
		int den2 = Integer.parseInt(denField2.getText());
		JLabel ratio2 = new JLabel();
		JButton reduceButton2 = new JButton("Reduce y");
		reduceButton2.setBackground(Color.BLUE);
		reduceButton2.setForeground(Color.WHITE);
		JButton addButton1 = new JButton(" Add x and y");
		addButton1.setBackground(new Color(102, 205, 170));
		addButton1.setForeground(Color.WHITE);
		JLabel ratio3 = new JLabel();
		JButton subtractButton1 = new JButton(" Subtract x and y");
		subtractButton1.setBackground(new Color(250, 250, 210));
		JLabel ratio4 = new JLabel();
		JButton multiplyButton1 = new JButton(" Multiply x and y");
		multiplyButton1.setBackground(new Color(72, 61, 139));
		multiplyButton1.setForeground(Color.WHITE);
		JLabel ratio5 = new JLabel();
		JButton divideButton1 = new JButton(" Divide x and y");
		divideButton1.setBackground(new Color(220, 134, 103));
		divideButton1.setForeground(Color.WHITE);
		JLabel ratio6 = new JLabel();

		// The panel that holds the input components
		north.setLayout(new GridLayout(11, 2));

		north.add(numLabel1);
		north.add(numField1);
		north.add(denLabel1);
		north.add(denField1);
		north.add(reduceButton1);
		north.add(ratio1);
		north.add(numLabel2);
		north.add(numField2);
		north.add(denLabel2);
		north.add(denField2);
		north.add(reduceButton2);
		north.add(ratio2);
		north.add(addButton1);
		north.add(ratio3);
		north.add(subtractButton1);
		north.add(ratio4);
		north.add(multiplyButton1);
		north.add(ratio5);
		north.add(divideButton1);
		north.add(ratio6);

		frame.getContentPane().add(north, BorderLayout.NORTH);

		frame.getContentPane().add(BorderLayout.NORTH, north); // BorderLayout
		// allows me to attach the JPanel to the border of the frame

		frame.setVisible(true); // Makes the frame visible

		// This makes the button work. all of the code is the parameter of the
		// method
		reduceButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				int num1 = Integer.parseInt(numField1.getText());
				int den1 = Integer.parseInt(denField1.getText());

				one.setNum(num1);
				one.setDen(den1);
				ratio1.setText("Simplified: " + one.getNumber());
			}
		});

		reduceButton2.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				int num2 = Integer.parseInt(numField2.getText());
				int den2 = Integer.parseInt(denField2.getText());

				RationalNumbers a = new RationalNumbers(num2, den2);
				ratio2.setText("Simplified: " + a.getNumber());
			}
		});

		addButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				int num1 = Integer.parseInt(numField1.getText());
				int den1 = Integer.parseInt(denField1.getText());
				int num2 = Integer.parseInt(numField2.getText());
				int den2 = Integer.parseInt(denField2.getText());
				RationalNumbers a = new RationalNumbers(num1, den1);
				RationalNumbers b = new RationalNumbers(num2, den2);
				RationalNumbers c = a.add(b);

				ratio3.setText("Simplified: " + c.getNumber());
			}
		});
		subtractButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				int num1 = Integer.parseInt(numField1.getText());
				int den1 = Integer.parseInt(denField1.getText());
				int num2 = Integer.parseInt(numField2.getText());
				int den2 = Integer.parseInt(denField2.getText());
				RationalNumbers a = new RationalNumbers(num1, den1);
				RationalNumbers b = new RationalNumbers(num2, den2);
				RationalNumbers c = a.subtract(b);

				ratio4.setText("Simplified: " + c.getNumber());
			}
		});

		multiplyButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				int num1 = Integer.parseInt(numField1.getText());
				int den1 = Integer.parseInt(denField1.getText());
				int num2 = Integer.parseInt(numField2.getText());
				int den2 = Integer.parseInt(denField2.getText());
				RationalNumbers a = new RationalNumbers(num1, den1);
				RationalNumbers b = new RationalNumbers(num2, den2);
				RationalNumbers c = a.multiply(b);

				ratio5.setText("Simplified: " + c.getNumber());
			}
		});

		divideButton1.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent evt) {
				int num1 = Integer.parseInt(numField1.getText());
				int den1 = Integer.parseInt(denField1.getText());
				int num2 = Integer.parseInt(numField2.getText());
				int den2 = Integer.parseInt(denField2.getText());
				RationalNumbers a = new RationalNumbers(num1, den1);
				RationalNumbers b = new RationalNumbers(num2, den2);
				RationalNumbers c = a.divide(b);

				ratio6.setText("Simplified: " + c.getNumber());
			}
		});

	}
}