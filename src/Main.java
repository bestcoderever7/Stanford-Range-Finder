import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class Main {
	JFrame frame = new JFrame("Range Finder");
	JPanel panel = new JPanel();

	public static void main(String[] args) {
		new Main().run();
	}

	private void run() {
		// TODO Auto-generated method stub
		frame.add(panel);
		frame.setVisible(true);
		JOptionPane
				.showMessageDialog(
						null,
						"This program finds the highest and lowest of a set of numbers. Please enter as many numbers as you want, and when you are done, enter '0'.");
		boolean sentinelEntered = false;
		Stack<Integer> numbersEntered = new Stack<Integer>();
		while (sentinelEntered == false) {
			String numberEntered = JOptionPane
					.showInputDialog("Enter a number.");
			if (numberEntered != "") {
				int numEntered = Integer.parseInt(numberEntered);
				JLabel label = new JLabel("" + numEntered);
				panel.add(label);
				frame.pack();
				if (numEntered != 0) {
					numbersEntered.push(numEntered);
				} else {
					if (numbersEntered.empty() == false) {
						sentinelEntered = true;
					} else {
						JOptionPane.showMessageDialog(null, "You have not entered any numbers.");
					}
				}
			}
		}
		int highestNum = 0;
		int lowestNum = 0;
		int i = 0;
		while (numbersEntered.empty() == false) {
			i++;
			if (numbersEntered.peek() > highestNum) {
				highestNum = numbersEntered.peek();
			} if (numbersEntered.peek() < lowestNum || i == 1) {
				lowestNum = numbersEntered.peek();
				
			}
			numbersEntered.pop();
		}
		JLabel label = new JLabel("Highest Number: " + highestNum
				+ " Lowest Number: " + lowestNum);
		panel.add(label);
		frame.pack();
	}
}
