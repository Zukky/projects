import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class GLNBarcodeCheckerClass {
public static void main(String[] args) {

//instantiation
JFrame frame = new JFrame();
JPanel panel = new JPanel();
JTextField GLNTextBox = new JTextField();
JTextArea output = new JTextArea();
JLabel enterBarcode = new JLabel(Messages.getString("GLNBarcodeCheckerClass.0")); //$NON-NLS-1$

JButton submit = new JButton(Messages.getString("GLNBarcodeCheckerClass.1")); //$NON-NLS-1$
submit.addActionListener(new ActionListener() {
	
	@Override
	public void actionPerformed(ActionEvent arg0) {
		String textOfGLNTextBox = GLNTextBox.getText();
		int lengthOfGLNTextBox = GLNTextBox.getText().length();
		if (lengthOfGLNTextBox  <  12 || lengthOfGLNTextBox > 12 ) {		
			JOptionPane.showMessageDialog(null,Messages.getString("GLNBarcodeCheckerClass.2")); //$NON-NLS-1$
			
		} else {
		String first = textOfGLNTextBox.substring(0, 1);
		String second = textOfGLNTextBox.substring(1, 2);
		String third = textOfGLNTextBox.substring(2, 3);
		String fourth = textOfGLNTextBox.substring(3, 4);
		String fifth = textOfGLNTextBox.substring(4, 5);
		String sixth = textOfGLNTextBox.substring(5, 6);
		String seventh = textOfGLNTextBox.substring(6, 7);
		String eigth = textOfGLNTextBox.substring(7, 8);
		String ninth = textOfGLNTextBox.substring(8, 9);
		String tenth = textOfGLNTextBox.substring(9, 10);
		String eleventh = textOfGLNTextBox.substring(10, 11);
		String twelfth = textOfGLNTextBox.substring(11, 12);
	
		//convert substrings to int
		int a = Integer.parseInt(first);
		int b = Integer.parseInt(second);
		int c = Integer.parseInt(third);
		int d = Integer.parseInt(fourth);
		int e = Integer.parseInt(fifth);
		int f = Integer.parseInt(sixth);
		int g = Integer.parseInt(seventh);
		int h = Integer.parseInt(eigth);
		int i = Integer.parseInt(ninth);
		int j = Integer.parseInt(tenth);
		int k = Integer.parseInt(eleventh);
		int l = Integer.parseInt(twelfth);
		
		int set1 = (b + d + f + h + j + l)*3;
		int set2 = a + c + e + g + i + k;
		
		int sumOfSet1andSet2 = set1 + set2;
		int checkDigit = (10-(sumOfSet1andSet2%10))%10;
	
		//println for console logging
		System.out.println(Messages.getString("GLNBarcodeCheckerClass.3")+ checkDigit); //$NON-NLS-1$
		System.out.println(Messages.getString("GLNBarcodeCheckerClass.4") + textOfGLNTextBox + checkDigit); //$NON-NLS-1$
		
		//output to JTextArea for user
		output.setText(Messages.getString("GLNBarcodeCheckerClass.5") + Integer.toString(checkDigit) + Messages.getString("GLNBarcodeCheckerClass.6") + textOfGLNTextBox+ Integer.toString(checkDigit)); //$NON-NLS-1$ //$NON-NLS-2$
		
		}
}});


//Adding to the parents
frame.add(panel);
panel.add(enterBarcode, BorderLayout.WEST);
panel.add(GLNTextBox, BorderLayout.WEST);
panel.add(submit, BorderLayout.EAST);
panel.add(output, BorderLayout.SOUTH);


//enterBarcode label config

//GLNTextBox config
GLNTextBox.setPreferredSize(new Dimension(200,20));
GLNTextBox.setDocument(new JTextFieldLimit (12));
//submit config
submit.setPreferredSize(new Dimension(100,20));
//output config
output.setPreferredSize(new Dimension(200,35));
//frame config
frame.setTitle(Messages.getString("GLNBarcodeCheckerClass.7")); //$NON-NLS-1$
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
frame.setPreferredSize(new Dimension(400,100));
frame.setLocationRelativeTo(null);
frame.setResizable(false);
frame.setVisible(true);
frame.pack();

//terminate JVM on exit
frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
}
}
