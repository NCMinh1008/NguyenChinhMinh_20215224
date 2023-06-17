package hust.soict.globalict.aims.screen;
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;


import javax.swing.*;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.store.Store;
import hust.soict.globalict.aims.cart.*;

public class StoreScreen extends JFrame{
	private Store store;
	private Cart cart;
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}

	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenu smUpdateStore = new JMenu("Update Store");
        JMenuItem addBookMenuItem = new JMenuItem("Add Book");

		addBookMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddItemToStoreScreen addItemScreen = new AddItemToStoreScreen(store);
                addItemScreen.setVisible(true);
                dispose(); // Close the current StoreScreen window
            }
        });
        smUpdateStore.add(addBookMenuItem);
        JMenuItem addCompactDiscMenuItem = new JMenuItem("Add CD");
        addCompactDiscMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddItemToStoreScreen addItemScreen = new AddItemToStoreScreen(store);
                addItemScreen.setVisible(true);
                dispose(); // Close the current StoreScreen window
            }
        });
        smUpdateStore.add(addCompactDiscMenuItem);
        JMenuItem addDigitalVideoDiscMenuItem = new JMenuItem("Add DVD");
        addDigitalVideoDiscMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                AddItemToStoreScreen addItemScreen = new AddItemToStoreScreen(store);
                addItemScreen.setVisible(true);
                dispose(); // Close the current StoreScreen window
            }
        });
        smUpdateStore.add(addDigitalVideoDiscMenuItem);

        menu.add(smUpdateStore);
        menu.add(new JMenuItem("View store"));
        menu.add(new JMenuItem("View cart"));
        
        JMenuBar menuBar = new JMenuBar();
        menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
        menuBar.add(menu);
        return menuBar;

	}
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout (new BoxLayout (header, BoxLayout.X_AXIS));
		
		JLabel title = new JLabel ("AIMS");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		JButton cart = new JButton("View cart");
		cart. setPreferredSize(new Dimension(100, 50));
		cart.setMaximumSize(new Dimension(100, 50));
		
		JButton addToCartButton = new JButton("Add to cart");
	    addToCartButton.setPreferredSize(new Dimension(100, 50));
	    addToCartButton.setMaximumSize(new Dimension(100, 50));
	    addToCartButton.addActionListener(new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            // Handle the "Add to cart" button click event
	        }
	    });
	    
	    
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
}
		
		
		JPanel createCenter() {
			JPanel center = new JPanel();
			center.setLayout(new GridLayout(3, 3, 2, 2));
			
			ArrayList<Media> mediaInStore = store.displayStoreItems();
			for(int i=0; i<9; i++) {
				MediaStore cell = new MediaStore(mediaInStore.get(i), this);
				center.add(cell);
			}
			
			return center;
		}
		
		
		
		

	public StoreScreen(Store store) {
		// TODO Auto-generated constructor stub
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
	}

	public void addToCart(Media media) {
        // Implement the logic to add the selected media to the cart
        cart.addMedia(media);
        // You can add any additional logic or UI updates here, if needed
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
