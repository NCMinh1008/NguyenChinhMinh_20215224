package hust.soict.globalict.aims.screen;
import java.awt.*;

import java.awt.event.*;
import java.util.ArrayList;

import hust.soict.globalict.aims.media.Media;
import hust.soict.globalict.aims.media.Playable;
import hust.soict.globalict.aims.cart.*;

import javax.swing.*;

public class MediaStore extends JPanel{
	private Media media;
    private StoreScreen storeScreen;


	public MediaStore(Media media, StoreScreen storeScreen) {
		// TODO Auto-generated constructor stub
		this.media = media;
		this.storeScreen = storeScreen;
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel title = new JLabel(media.getTitle());
		this.setFont(new Font(title.getFont().getName(), Font.PLAIN, 20));
		title.setAlignmentX(CENTER_ALIGNMENT);
		
		JLabel cost = new JLabel(""+media.getCost()+" $");
		cost.setAlignmentX(CENTER_ALIGNMENT);
		
		JPanel container = new JPanel();
		container.setLayout(new FlowLayout(FlowLayout.CENTER));
		
		JButton addToCartButton = new JButton("Add to cart");
        addToCartButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Handle add to cart button click event
                addToCart();
            }
        });
		
        container.add(addToCartButton);
		if(media instanceof Playable) {
			JButton playButton = new JButton("Play");
            playButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Handle play button click event
                    playMedia();
                }
            });
            container.add(playButton);
		}
		
		this.add(Box.createVerticalGlue());
		this.add(title);
		this.add(cost);
		this.add(Box.createVerticalGlue());
		this.add(container);
		
		this.setBorder(BorderFactory.createLineBorder(Color.BLACK));
	}
		private void addToCart() {
	        // Implement the logic to add the media to the cart
	        // You can access the store instance from the StoreScreen class
	        // and call the appropriate method to add the media to the cart
	        storeScreen.addToCart(media);

	    }

	    private void playMedia() {
	        // Implement the logic to play the media in a dialog window (JDialog)
	        JDialog dialog = new JDialog();
	        // Display the media in the dialog window
	        dialog.setVisible(true);
	    }
	

}
