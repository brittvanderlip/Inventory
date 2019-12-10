/** Assignment2
  Book.java
  @author Brittany Vanderlip
  105182221
  Nov 18, 2019
  */
import java.io.*;

/**Class shoe. A subclass of Item.java*/
public class Shoe extends Item implements Comparable <Shoe>, Serializable{
  private String colour;      //White, silver, red, beige, brown, blue, black, or pink
  private double size;        //size 1.00 to 20.00

  /**Overloaded Contructor: Calls super class constructor and sets default values*/
  public Shoe(double price, int quantity, String item, int item_id){
    super(price, quantity, item, item_id);
    colour = "No Colour";      //Default
    size = 7.5;                //Default
  }

  /**OVERLOADED CONSTRUCTOR that calls the above overloaded constructor*/
  public Shoe(double price, int quantity, String item, int item_id, String colour, double size){
    this(price, quantity, item, item_id);
    setColour(colour);
    setSize(size);
  }

  /**CompareTo method to sort based on shoe size*/
  @Override
  public int compareTo(Shoe other){
    return (Integer) (Double.compare(this.size, other.size));
  }

  /**DISPLAY METHOD: Displays the shoe parameters entered by user or default if out of range*/
  @Override
  public String Display(){
    return "\n\nID: " + getID() + "\nType: Shoe\nShoe Colour: " + getColour() + "\nSize: " + getSize() + "\nPrice: $" + getPrice() + " each\nQuantity: " + getQuantity() + "\n";

  }

  /**PURCHASE METHOD: Decrements the quantity of item after purchase and displays what the user has purchased*/
  @Override
  public String Purchase(int num){
    this.quantity = quantity - num;
    return "\nThank you for purchasing " + num + " many " + getColour() + " shoes in size " + getSize();
  }

  /**MUTATOR METHODS*/
  public String setColour(String colour){
    if(isValidColour(colour)){
      this.colour = colour;
    }
    return colour;
  }

  public double setSize(double size){
    if(isValidSize(size)){
      this.size = size;
    }
    return size;
  }

  /**ACESSOR METHODS*/
  public String getColour(){
    return colour;
  }

  public double getSize(){
    return size;
  }

  /**HELPER METHODS:
     Determine is the colour is valid and if the size is between a size 1 and 20 */
  private boolean isValidColour(String colour){
    if(colour.equalsIgnoreCase("white")){
        return true;
    }
    else if(colour.equalsIgnoreCase("silver")){
        return true;
    }
    else if(colour.equalsIgnoreCase("red")){
        return true;
    }
    else if(colour.equalsIgnoreCase("beige")){
        return true;
    }
    else if(colour.equalsIgnoreCase("brown")){
        return true;
    }
    else if(colour.equalsIgnoreCase("blue")){
        return true;
    }
    else if(colour.equalsIgnoreCase("black")){
        return true;
    }
    else if(colour.equalsIgnoreCase("pink")){
        return true;
    }
    else{
        return false;
    }
  }

  private boolean isValidSize(double size){
    return(size >= 1 && size <= 20);
  }

  public String toString(){
    return Display();
  }
}
