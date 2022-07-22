package libraryManagementSystem.wishlist;

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

public class WishListDeleteBook {

	public static void main(String[] args) {
		DeleteBook obj = new DeleteBook();

	}

}

class DeleteBook extends JFrame {

	JInternalFrame deleteBookIF = new JInternalFrame("Delete a book", false, false, false, false);
	JTextField BookNameTF = new JTextField(20);
	JLabel heading = new JLabel("Type the book name and press 'Enter' key");
	JLabel result = new JLabel();
	JPanel deleteBookPanel = new JPanel();
	JButton goBack = new JButton("Go back to wishlist page");

	DeleteBook() {
		deleteBookIF.add(deleteBookPanel);
		deleteBookIF.setVisible(true);
		
		BookNameTF.setMaximumSize(BookNameTF.getPreferredSize() );
		
		UtilityFunctions.addProperly(deleteBookPanel, heading, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(deleteBookPanel, BookNameTF, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(deleteBookPanel, goBack, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(deleteBookPanel, result, (float) 0.5, 0, 5);
		
		deleteBookPanel.setLayout(new BoxLayout(deleteBookPanel, BoxLayout.Y_AXIS));

		heading.setFont(new Font("Serif", Font.PLAIN, 20));
		result.setFont(new Font("Serif", Font.ITALIC, 25));
		result.setVisible(false);

		BookNameTF.addActionListener(ae -> {
			if (WishListDAO.deleteBook("TempUser", BookNameTF.getText()) == 0)
				result.setText("No such book exists in the Wishlist!");
			else
				result.setText("Deleted successfully!");

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
