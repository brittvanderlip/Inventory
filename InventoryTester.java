/** Assignment2
  Book.java
  @author Brittany Vanderlip
  105182221
  Nov 18, 2019
  */

import java.util.*;
import java.io.*;

/**Class InventoryTester that contains the main menu*/
public class InventoryTester implements Serializable{
@SuppressWarnings("unchecked")


  /**Main Method*/
  public void openMenu(){
    /**Variable declarations*/
    int quantity, year;
    int Yes = 1, id, i = 0, length=0, index;
    String author, title, label, manufacturer, colour;
    double price, size;

    /**Setting array list of type Item to hold products in inventory*/
    ArrayList<Item> inventory = new ArrayList<>();

    /**Main Menu*/
    while(Yes == 1){
      System.out.println("\n*****MENU*****\n");
      System.out.println("1) Add an item to the inventory");
      System.out.println("2) Display all items");
      System.out.println("3) Display only books sorted by author name");
      System.out.println("4) Display only gifts sorted by label");
      System.out.println("5) Display only shoes sorted by size");
      System.out.println("6) Delete an item from inventory");
      System.out.println("7) Purchase an item from inventory");
      System.out.println("8) Save your shopping experience to a file");
      System.out.println("9) Load your created file");
      System.out.println("10) Done shopping!");

      Scanner scan = new Scanner(System.in);
      int option = scan.nextInt();
      switch(option){
        /** Case to add a book, gift card or shoe to inventory*/
        case 1: System.out.println("\n1) Press 1 to add a BOOK to the inventory");
                System.out.println("2) Press 2 to add a GIFT CARD to the inventory");
                System.out.println("3) Press 3 to add a SHOE to the inventory");
                Scanner scan1 = new Scanner(System.in);
                int itemType = scan1.nextInt();
                {
                  switch(itemType){
                    /**Type Book: Ask user to enter information about product*/
                    case 1: System.out.println("\nWho is the AUTHOR?");
                            Scanner scan2 = new Scanner(System.in);
                            author = scan2.nextLine();
                            System.out.println("\nWhat is the TITLE of the book?");
                            title = scan2.nextLine();
                            System.out.println("\nWhat YEAR was the book published?");
                            year = scan2.nextInt();
                            System.out.println("\nHow much is the book?");
                            price = scan2.nextDouble();
                            System.out.println("\nHow many would you like to add to inventory?");
                            quantity = scan2.nextInt();

                            id = i+1;
                            Book newBook= new Book(price, quantity, "Book", id, author, title, year);
                            inventory.add(newBook);
                            ++i;
                            length++;
                            break;

                    /**Type GiftCard: Ask user to enter information about product*/
                    case 2: System.out.println("\nWhat store are you purchasing from?");
                            Scanner scan3 = new Scanner(System.in);
                            label = scan3.nextLine();
                            System.out.println("\nWhere was the gift card manufacterured?");
                            manufacturer = scan3.nextLine();
                            System.out.println("\nHow much money would you like to put on the card?");
                            price = scan3.nextDouble();
                            System.out.println("\nHow many would you like to add to inventory?");
                            quantity = scan3.nextInt();

                            id = i+1;
                            GiftCard newGiftCard = new GiftCard(price, quantity, "Gift Card", id, label, manufacturer);
                            inventory.add(newGiftCard);
                            ++i;
                            length++;
                            break;

                    /**Type Shoe: Ask user to enter information about product*/
                    case 3: System.out.println("\nWhat colour shoe would you like to purchase?\nwhite, silver, red, beige, brown, blue, black, or pink?");
                            Scanner scan4 = new Scanner(System.in);
                            colour = scan4.nextLine();
                            System.out.println("\nWhat size shoe would you like?");
                            size = scan4.nextDouble();
                            System.out.println("\nHow much does the shoe cost?");
                            price = scan4.nextDouble();
                            System.out.println("\nHow many would you like to add to inventory?");
                            quantity = scan4.nextInt();

                            id = i+1;
                            Shoe newShoe = new Shoe(price, quantity, "Shoe", id, colour, size);
                            inventory.add(newShoe);
                            ++i;
                            length++;
                            break;
                  }
                  break;
                }

        /**Print the inventory array list*/
        case 2:if(length == 0){
                System.out.println("\nInventory is empty!\n");
              }
              else{
                System.out.println("\n****INVENTORY****");
                for(int j = 0; j < length ; j++){
                  System.out.println(inventory.get(j) + "\n");
                }
              }
                break;


        /**Display BOOKS in order of author name*/
        case 3: int bookLength = 0;
                index = 0;

                for(int j = 0; j < length ; j++){
                  if(inventory.get(j).getItem().equals("Book")){
                    bookLength++;
                  }
                }

                Book[] bookOnly = new Book[bookLength];
                for(int k = 0; k < length; k++){
                  if(inventory.get(k).getItem().equals("Book")){
                    bookOnly[index] = (Book)inventory.get(k);
                    index++;
                  }
                }

                Arrays.sort(bookOnly);
                for(int k = 0; k < bookLength; k++){
                  System.out.println(bookOnly[k]);
                }
                break;

      /**Display gift cards in order of label*/
      case 4: int cardLength = 0;
              index = 0;

              for(int j = 0; j < length ; j++){
                if(inventory.get(j).getItem().equals("Gift Card")){
                    cardLength++;
                }
              }

              GiftCard[] cardOnly = new GiftCard[cardLength];
              for(int k = 0; k < length; k++){
                if(inventory.get(k).getItem().equals("Gift Card")){
                  cardOnly[index] = (GiftCard)inventory.get(k);
                  index++;
                 }
                }

              Arrays.sort(cardOnly);
              for(int k = 0; k < cardLength; k++){
                System.out.println(cardOnly[k]);
              }
              break;

    /**Display shoes in increasing order of shoe size*/
     case 5:  int shoeLength = 0;
              index = 0;

              for(int j = 0; j < length ; j++){
                if(inventory.get(j).getItem().equals("Shoe")){
                  shoeLength++;
                }
              }

              Shoe[] shoeOnly = new Shoe[shoeLength];
              for(int k = 0; k < length; k++){
                if(inventory.get(k).getItem().equals("Shoe")){
                  shoeOnly[index] = (Shoe)inventory.get(k);
                  index++;
                }
              }

              Arrays.sort(shoeOnly);
              for(int k = 0; k < shoeLength; k++){
                System.out.println(shoeOnly[k]);
              }
              break;


        /**Delete product from inventory based on ID number */
        case 6: System.out.println("\nChoose an item by id that you wish to delete from inventory.");
                Scanner scan5 = new Scanner(System.in);
                id = scan5.nextInt();

                inventory.remove(id-1);
                length--;
                index = 1;

                /**Setting ID's back by 1 to match indexes in array list*/
                for(int j = 0; j < length; j++){
                  inventory.get(j).item_id = index++;
                }


                System.out.println("\nYou have deleted item at ID: " + id);
                break;

        /**Purchase item from inventory based on id number*/
        case 7: System.out.println("\nWhich item would you like to purchase?");
                Scanner scan6 = new Scanner(System.in);
                id = scan6.nextInt();
                System.out.println("\nHow many would you like to purchase?");
                Scanner scan7 = new Scanner(System.in);
                int quant = scan7.nextInt();


                if(inventory.get(id-1).getQuantity()==0){
                  System.out.println("\nSorry, we are out of stock.");
                }

                else if (inventory.get(id-1).getQuantity() < quant){
                  System.out.println("\nSorry, we don't have that many in stock. We only have " + inventory.get(id-1).getQuantity() + " available.");
                }
                else
                  System.out.println(inventory.get(id-1).Purchase(quant));
                break;

        /**Serialization: Saving to a file*/
        case 8: try{
                  ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream("StoreFront.txt"));
                  output.writeObject(inventory);
                  output.close();
                }

                catch(IOException e){
                  System.out.println("Exception caught");
                }

                System.out.println("\nInventory saved to StoreFront.txt.\n");
                break;

        /**Serialization: Reading from a file*/
        case 9: try{
                  ObjectInputStream input = new ObjectInputStream(new FileInputStream("StoreFront.txt"));
                  inventory = (ArrayList<Item>)input.readObject();

                  input.close();
                  System.out.println(inventory);
                 }

               catch(ClassNotFoundException | IOException e){
                 System.out.println("Exception caught");
               }
               break;

        /**Exit menu*/
        case 10: System.out.println("We hope to see you shopping again soon!");
                Yes = -1;
                break;

        /**Invalid option*/
        default: System.out.println("\nNot a valid option. Please try again.\n");
                 break;
              }
    }
  }
}
