package libraryManagementSystem.wishlist;

import java.awt.Dimension;
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

public class WishListAddBook {

	public static void main(String[] args) throws PropertyVetoException {
		AddBook obj = new AddBook();

	}

}

class AddBook extends JFrame {
	JInternalFrame addBookIF = new JInternalFrame("Add a book", false, false, false, false);
	JTextField BookNameTF = new JTextField(30);
	JLabel heading = new JLabel("Type the book name and press 'Enter' key");
	JLabel result = new JLabel("Added successfully!");
	JPanel addBookPanel = new JPanel();
	JButton goBack = new JButton("Go back to wishlist page");

	public AddBook() throws PropertyVetoException {
		addBookIF.add(addBookPanel);
		addBookIF.setVisible(true);
		
		UtilityFunctions.addProperly(addBookPanel, heading, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(addBookPanel, BookNameTF, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(addBookPanel, goBack, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(addBookPanel, result, (float) 0.5, 0, 5);
		
		addBookPanel.setLayout(new BoxLayout(addBookPanel, BoxLayout.Y_AXIS));

		heading.setFont(new Font("Serif", Font.PLAIN, 20));
		result.setFont(new Font("Serif", Font.ITALIC, 25));
		result.setVisible(false);

		BookNameTF.addActionListener(ae -> {
			if(BookNameTF.getText().length() < 1)
				result.setText("A book must have a name!");
			else if(WishListDAO.checkDuplicates("TempUser", BookNameTF.getText()))
				result.setText("This book is already present in your Wishlist!");
			else if (!WishListDAO.addBook("TempUser", BookNameTF.getText()))
				result.setText("Insertion failed!");
			else 
				result.setText("Added book successfully!");
			

			result.setVisible(true);
		});

		goBack.addActionListener(ae -> {
			try {
				MainFrame.frames.get("WishlistPage").setSelected(true);
				// MainFrame.frames.get("WishlistPage").setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});

	}

}
