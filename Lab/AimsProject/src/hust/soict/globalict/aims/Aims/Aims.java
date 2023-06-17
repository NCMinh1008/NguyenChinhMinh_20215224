package hust.soict.globalict.aims.Aims;
import hust.soict.globalict.aims.cart.Cart;
import hust.soict.globalict.aims.exception.PlayerException;
import hust.soict.globalict.aims.media.*;
import java.util.Scanner;
import hust.soict.globalict.aims.store.Store;
import javax.swing.JOptionPane;

public class Aims {
	private static Store store;
    private static Cart cart;
    private static Scanner scanner;

    public static void main(String[] args) throws PlayerException {
    	store = new Store();
        cart = new Cart();
        scanner = new Scanner(System.in);

        showMenu();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        while (choice != 0) {
            try {
                switch (choice) {
                    case 1:
                        viewStore();
                        break;
                    case 2:
                        updateStore();
                        break;
                    case 3:
                        viewCart();
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            } catch (PlayerException e) {
                System.out.println("Player Exception occurred: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, e.getMessage(), "Player Exception", JOptionPane.ERROR_MESSAGE);
            } catch (Exception e) {
                System.out.println("An unexpected exception occurred: " + e.getMessage());
                e.printStackTrace();
                JOptionPane.showMessageDialog(null, "An unexpected exception occurred.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            showMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        }

        System.out.println("Exiting the program...");
        scanner.close();
    }

    public static void showMenu() {
        System.out.println("AIMS:");
        System.out.println("--------------------------------");
        System.out.println("1. View store");
        System.out.println("2. Update store");
        System.out.println("3. See current cart");
        System.out.println("0. Exit");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3");
    }

    public static void viewStore() throws PlayerException {
        store.displayStoreItems();
        storeMenu();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        while (choice != 0) {
            switch (choice) {
                case 1:
                    seeMediaDetails();
                    break;
                case 2:
                    addToCart();
                    break;
                case 3:
                    playMedia();
                    break;
                case 4:
                    viewCart();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            storeMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        }
    }

    public static void storeMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. See a media's details");
        System.out.println("2. Add a media to cart");
        System.out.println("3. Play a media");
        System.out.println("4. See current cart");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4");
    }

    public static void seeMediaDetails() throws PlayerException {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.findMediaByTitle(title);
        if (media != null) {
            media.displayInfo();
            mediaDetailsMenu();
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    cart.addMedia(media);
                    System.out.println("Media added to cart.");
                    break;
                case 2:
                    if (media instanceof Playable) {
                        ((Playable) media).play();
                    } else {
                        System.out.println("This media is not playable.");
                    }
                    break;
                case 0:
                    // Go back to the store menu
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void mediaDetailsMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add to cart");
        System.out.println("2. Play");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void addToCart() {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.findMediaByTitle(title);
        if (media != null) {
            cart.addMedia(media);
            if (media instanceof DigitalVideoDisc) {
                int dvdCount = cart.getDVDCount();
                System.out.println("DVDs in cart: " + dvdCount);
            }
            System.out.println("Media added to cart.");
        } else {
            System.out.println("Media not found.");
        }
    }

    public static void playMedia() throws PlayerException {
        System.out.println("Enter the title of the media:");
        String title = scanner.nextLine();

        Media media = store.findMediaByTitle(title);
        if (media != null) {
            if (media instanceof Playable) {
                try {
                    ((Playable) media).play();
                } catch (PlayerException e) {
                    System.out.println("Player Exception occurred: " + e.getMessage());
                    e.printStackTrace();
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Player Exception", JOptionPane.ERROR_MESSAGE);
                }
            } else {
                System.out.println("This media is not playable.");
            }
        } else {
            System.out.println("Media not found.");
        }
    }
    public static void updateStore() {
    	updateStoreMenu();
    	int choice = scanner.nextInt();
        scanner.nextLine();

        while (choice != 0) {
            switch (choice) {
                case 1:
                    // addMedia depends on requirement of users
                    break;
                case 2:
                    // removeMedia depends on requirement of users
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }

            updateStoreMenu();
            choice = scanner.nextInt();
            scanner.nextLine();
        }
    }
    public static void updateStoreMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Add a media to store");
        System.out.println("2. Remove a media from store");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2");
    }

    public static void viewCart() throws PlayerException {
        cart.displayCart();
        cartMenu();
        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        while (choice != 0) {
            switch (choice) {
                case 1:
                    filterMedia();
                    break;
                case 2:
                    sortMedia();
                    break;
                case 3:
                    removeMediaFromCart();
                    break;
                case 4:
                    playMedia();
                    break;
                case 5:
                    placeOrder();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

            cartMenu();
            choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character
        }
    }

    public static void cartMenu() {
        System.out.println("Options:");
        System.out.println("--------------------------------");
        System.out.println("1. Filter medias in cart");
        System.out.println("2. Sort medias in cart");
        System.out.println("3. Remove media from cart");
        System.out.println("4. Play a media");
        System.out.println("5. Place order");
        System.out.println("0. Back");
        System.out.println("--------------------------------");
        System.out.println("Please choose a number: 0-1-2-3-4-5");
    }

    public static void filterMedia() {
        System.out.println("Filter medias in cart by:");
        System.out.println("1. ID");
        System.out.println("2. Title");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
            case 1:
                System.out.println("Enter the ID of the media:");
                int id = scanner.nextInt();
                scanner.nextLine(); // Consume newline character
                cart.filterMediaByID(id);
                break;
            case 2:
                System.out.println("Enter the title of the media:");
                String title = scanner.nextLine();
                cart.filterMediaByTitle(title);
                break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void sortMedia() {
        System.out.println("Sort medias in cart by:");
        System.out.println("1. Title");
        System.out.println("2. Cost");

        int choice = scanner.nextInt();
        scanner.nextLine(); // Consume newline character

        switch (choice) {
        case 1:
            cart.sortMediaByTitle();
            break;
        case 2:
            cart.sortMediaByCost();
            break;
            default:
                System.out.println("Invalid choice. Please try again.");
        }
    }

    public static void removeMediaFromCart() {
        System.out.println("Enter the title of the media to remove:");
        String title = scanner.nextLine();
        cart.removeMediaByTitle(title);
        System.out.println("Media removed from cart.");
    }

    public static void placeOrder() {
        System.out.println("Order created.");
        cart.clear();
    }
		
	

}
