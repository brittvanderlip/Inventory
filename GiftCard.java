/** Assignment2
  GiftCard.java
  @author Brittany Vanderlip
  105182221
  Nov 18, 2019
  */

import java.io.*;

/**Class GiftCard. A subclass of Item.java*/
public class GiftCard extends Item implements Comparable <GiftCard>, Serializable{
    private String label;      //White, silver, red, beige, brown, blue, black, or pink
    private String manufacturer;        //size 1.00 to 20.00

    public GiftCard(double price, int quantity, String item, int item_id){
      super(price, quantity, item, item_id);
      label = "No Label";
      manufacturer = "No Manufacturer";
    }

    /**OVERLOADED CONSTRUCTOR that calls the above overloaded constructor*/
    public GiftCard(double price, int quantity, String item, int item_id, String label, String manufacturer){
      this(price, quantity, item, item_id);
      setLabel(label);
      setManufacturer(manufacturer);
    }

    /**CompareTo method to sort based on gift card label*/
    @Override
    public int compareTo(GiftCard other){
      return this.label.compareTo(other.label);
    }

    /**DISPLAY METHOD: Displays the shoe parameters entered by user or default if out of range*/
    @Override
    public String Display(){
     return "\n\nID: " + getID() + "\nType: GiftCard\nLabel: " + getLabel() + "\nManufacturer: " + getManufacturer() + "\nPrice: $" + getPrice() + " each\nQuantity: " + getQuantity()  + "\n";

    }

    /**PURCHASE METHOD: Decrements the quantity of item after purchase and displays what the user has purchased*/
    @Override
    public String Purchase(int num){
      this.quantity = quantity - num;
      return "\nThank you for purchasing " + num + " many gift cards items for " + getLabel() + " made in " + getManufacturer();
    }

    /**MUTATOR METHODS*/
    public String setLabel(String label){
      if(isValidLabel(label)){
        this.label = label;
      }
      return label;
    }

    public String setManufacturer(String manufacturer){
      if(isValidManufacturer(manufacturer)){
        this.manufacturer = manufacturer;
      }
      return manufacturer;
    }

    /**ACESSOR METHODS*/
    public String getLabel(){
      return label;
    }

    public String getManufacturer(){
      return manufacturer;
    }

    /**HELPER METHODS:
       Determine is the label and manufacturer fields are empty */
    private boolean isValidLabel(String label){
      return(label.isEmpty()?false:true);
    }
    private boolean isValidManufacturer(String manufacturer){
      return(manufacturer.isEmpty()?false:true);
    }
    public String toString(){
      return Display();
    }
  }
