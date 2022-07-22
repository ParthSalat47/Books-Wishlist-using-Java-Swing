package libraryManagementSystem.wishlist;

import java.awt.Component;
import java.beans.PropertyVetoException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JList;
import javax.swing.JPanel;

import libraryManagementSystem.Dao.WishListDAO;

public class WishListViewBooks {

	public static void main(String[] args) throws SQLException {
		ViewBooks obj = new ViewBooks();

	}

}

class ViewBooks extends JFrame {

	JInternalFrame viewBookIF = new JInternalFrame("View wishlist books", false, false, false, false);

	JPanel wishlistPanel = new JPanel();

	JButton goBack = new JButton("Go back to wishlist page");

	JList<Object> list;

	public ViewBooks() throws SQLException {
		Object data[] = getBooksName("TempUser");
		list = new JList<Object>(data);
		list.setAlignmentX(Component.CENTER_ALIGNMENT);

		viewBookIF.add(wishlistPanel);
		viewBookIF.setVisible(true);

		UtilityFunctions.addProperly(wishlistPanel, list, (float) 0.5, 0, 5);
		UtilityFunctions.addProperly(wishlistPanel, goBack, (float) 0.5, 0, 5);

		wishlistPanel.setLayout(new BoxLayout(wishlistPanel, BoxLayout.Y_AXIS));
		
		goBack.addActionListener(ae -> {
			try {
				MainFrame.frames.get("WishlistPage").setSelected(true);
				// MainFrame.frames.get("WishlistPage").setMaximum(true);
			} catch (PropertyVetoException e) {
				e.printStackTrace();
			}
		});
	}

	Object[] getBooksName(String userName) throws SQLException {
		ArrayList<String> BooksList = new ArrayList<String>();
		ResultSet rs = WishListDAO.getBooks(userName);

		while (rs.next()) {
			BooksList.add(rs.getString(1));
		}

		Object BooksArray[] = BooksList.toArray();

		return BooksArray;
	}

}
