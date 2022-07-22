package libraryManagementSystem.wishlist;

import java.awt.Font;
import java.beans.PropertyVetoException;
import java.sql.SQLException;
import java.util.HashMap;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class Wishlist {

	public static void main(String[] args) throws PropertyVetoException, SQLException {
		MainFrame obj = new MainFrame();

	}

}

class MainFrame extends JFrame {

	public static HashMap<String, JInternalFrame> frames = new HashMap<String, JInternalFrame>();

	// String data[] = { "Java", "C++", "Python" };

	// DefaultListModel<String> l1 = new DefaultListModel<>();
	JLabel heading = new JLabel("My Wishlist");
	JLabel l1 = new JLabel("Base label");
	JLabel l2 = new JLabel("Lower than base label");

	JLayeredPane pane = new JLayeredPane();
	JLayeredPane pane2 = new JLayeredPane();

	JButton addBookButton = new JButton("Click here to add a book to wishlist");
	JButton viewBooksButton = new JButton("Click here to view your books wishlist");
	JButton updateBookButton = new JButton("Click here to update a book in wishlist");
	JButton deleteBookButton = new JButton("Click here to delete a book from wishlist");

	JPanel wishlistPanel = new JPanel();
	JInternalFrame wishlist = new JInternalFrame("Wishlist page", false, false, false, false);
	JDesktopPane desktop = new JDesktopPane();

	public MainFrame() throws PropertyVetoException, SQLException {

		heading.setFont(new Font("Serif", Font.PLAIN, 40));

		UtilityFunctions.addProperly(wishlistPanel, heading, (float) 0.5, 0, 10);
		UtilityFunctions.addProperly(wishlistPanel, addBookButton, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(wishlistPanel, viewBooksButton, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(wishlistPanel, updateBookButton, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(wishlistPanel, deleteBookButton, (float) 0.5, 0, 5);

		wishlistPanel.setLayout(new BoxLayout(wishlistPanel, BoxLayout.Y_AXIS));

		wishlist.add(wishlistPanel);
		wishlist.setVisible(true);
		wishlist.setSelected(true);

		MainFrame.frames.put("WishlistPage", wishlist);

		desktop.setSize(500, 500);
		desktop.setVisible(true);
		desktop.add(wishlist);
		desktop.setDragMode(JDesktopPane.OUTLINE_DRAG_MODE);

		pack();
		setContentPane(desktop);

		addBookButton.addActionListener(ae -> {
			try {
				AddBook addBookObj = new AddBook();
				desktop.add(addBookObj.addBookIF);
				addBookObj.addBookIF.setSelected(true);
				addBookObj.addBookIF.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});

		viewBooksButton.addActionListener(ae -> {
			try {
				ViewBooks viewBooksObj = new ViewBooks();
				desktop.add(viewBooksObj.viewBookIF);
				viewBooksObj.viewBookIF.setSelected(true);
				viewBooksObj.viewBookIF.setMaximum(true);
			} catch (PropertyVetoException | SQLException e) {
				e.printStackTrace();
			}
		});

		updateBookButton.addActionListener(ae -> {
			try {
				UpdateBook updateBookObj = new UpdateBook();
				desktop.add(updateBookObj.updateBookIF);
				updateBookObj.updateBookIF.setSelected(true);
				updateBookObj.updateBookIF.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});

		deleteBookButton.addActionListener(ae -> {
			try {
				DeleteBook deleteBookObj = new DeleteBook();
				desktop.add(deleteBookObj.deleteBookIF);
				deleteBookObj.deleteBookIF.setSelected(true);
				deleteBookObj.deleteBookIF.setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});

		wishlist.setMaximum(true);

		// setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
		setVisible(true);
		setSize(500, 500); // pack();
		setDefaultCloseOperation(3);
	}

}
