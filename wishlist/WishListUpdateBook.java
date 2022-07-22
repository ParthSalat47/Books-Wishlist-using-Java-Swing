package libraryManagementSystem.wishlist;

import java.awt.FlowLayout;
import java.awt.Font;
import java.beans.PropertyVetoException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import libraryManagementSystem.Dao.WishListDAO;

public class WishListUpdateBook {

	public static void main(String[] args) throws PropertyVetoException {
		UpdateBook obj = new UpdateBook();

	}

}

class UpdateBook extends JFrame {
	JInternalFrame updateBookIF = new JInternalFrame("Update a book", false, false, false, false);
	JTextField BookNameTF1 = new JTextField(20);
	JTextField BookNameTF2 = new JTextField(20);
	JLabel heading1 = new JLabel("Type the book name you want to change and press 'Enter' key");
	JLabel heading2 = new JLabel("Type the new book name and press 'Enter' key");
	JLabel result = new JLabel();
	JPanel updateBookPanel = new JPanel();
	JButton goBack = new JButton("Go back to wishlist page");

	public UpdateBook() throws PropertyVetoException {
		updateBookIF.add(updateBookPanel);
		updateBookIF.setVisible(true);
		
		UtilityFunctions.addProperly(updateBookPanel, heading1, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(updateBookPanel, BookNameTF1, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(updateBookPanel, heading2, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(updateBookPanel, BookNameTF2, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(updateBookPanel, heading1, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(updateBookPanel, goBack, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(updateBookPanel, result, (float) 0.5, 0, 5);
		
		updateBookPanel.setLayout(new BoxLayout(updateBookPanel, BoxLayout.Y_AXIS));

		heading1.setFont(new Font("Serif", Font.PLAIN, 20));
		heading2.setFont(new Font("Serif", Font.PLAIN, 20));
		result.setFont(new Font("Serif", Font.ITALIC, 25));
		result.setVisible(false);

		BookNameTF2.addActionListener(ae -> {
			if(BookNameTF1.getText().length() < 1 || BookNameTF2.getText().length() < 1)
				result.setText("Book name text field can't be kept empty!");
			else if(WishListDAO.checkDuplicates("TempUser", BookNameTF2.getText()))
				result.setText("The updated book is already present in your Wishlist!");
			else if (WishListDAO.updateBook("TempUser", BookNameTF1.getText(), BookNameTF2.getText()) == 0)
				result.setText("No such book exists!");
			else
				result.setText("Updated successfully!");

			result.setVisible(true);
		});

		goBack.addActionListener(ae -> {
			try {
				MainFrame.frames.get("WishlistPage").setSelected(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});

	}

}
