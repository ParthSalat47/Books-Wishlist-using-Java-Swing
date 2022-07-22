package libraryManagementSystem.wishlist;

import java.awt.Container;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JTextField;

public class UtilityFunctions {

	public static void main(String[] args) {

	}

	// Use this only for BoxLayout
	public static void addProperly(Container container, JComponent jComponent, float horizontalAlignment, int width,
			int height) {
		jComponent.setAlignmentX(horizontalAlignment);
		container.add(jComponent);
		container.add(Box.createRigidArea(new Dimension(width, height)));

		if (JButton.class.isAssignableFrom(jComponent.getClass())) {
			// Unfortunately, BoxLayout doesn't honor changing size of a JButton
			jComponent.setPreferredSize(new Dimension(500, 80));
		}
		
		if (JTextField.class.isAssignableFrom(jComponent.getClass())) {
			 jComponent.setMaximumSize(jComponent.getPreferredSize());
		}

	}

}
