/** Assignment2
  Item.java
  @author Brittany Vanderlip
  105182221
  Nov 18, 2019
  */
import java.io.*;

/**Abstract class Item */
abstract class Item implements Serializable{
  protected int item_id;      //Positive integer
  protected double price;      //>=0
  protected int quantity;      //>=0
  protected String item;      //Cannot be empty


  /** ABSTRACT METHOD DECLARATION */
  public abstract String Display();
  public abstract String Purchase(int num);

  /** DEFAULT CONSTRUCTOR */
  public Item(){
    price = 0.00;
    quantity = 0;
    item = "Nothing";
  }


  /**OVERLOADED CONSTRUCTOR*/
  public Item(Double price, int quantity, String item, int item_id){
    this();
    setPrice(price);
    setQuantity(quantity);
    setItem(item);
    setID(item_id);
  }


  /**MUTATOR METHODS*/
  public double setPrice(double price){
    if(isValidPrice(price)){
      this.price = price;
    }
    return price;
  }

  public int setQuantity(int quantity){
    if(isValidQuantity(quantity)){
      this.quantity = quantity;
    }
    return quantity;
  }

  public String setItem(String item){
    if(isValidItem(item)){
      this.item = item;
    }
    return item;
  }

  public int setID(int item_id){
    this.item_id = item_id;
    return item_id;
  }

  /**ACCESSOR METHODS*/
  public double getPrice(){
    return price;
  }

  public String getItem(){
    return item;
  }


  public int getQuantity(){
    return quantity;
  }

  public int getID(){
    return item_id;
  }

  /** HELPER METHODS:
      Checking if quantity is greater than or equal to 0
      And if title is not empty*/
  private boolean isValidPrice(double price){
    return(price >= 0.00);
  }
  private boolean isValidQuantity(int quantity){
    return(quantity >= 0);
  }

  private boolean isValidItem(String item){
    return(item.isEmpty()?false:true);
  }

}
