/** Assignment2
  Book.java
  @author Brittany Vanderlip
  105182221
  Nov 18, 2019
  */

import java.io.*;

/**Class Book. A subclass of Item.java*/
public class Book extends Item implements Comparable <Book>, Serializable{
  private String author;         //Authos name
  private String title;         //Title of Book
  private int year;             //Year book was published. Must be >1800

  /**OVERLOADED CONSTRUCTOR that implements the super class constructor*/
  public Book(double price, int quantity, String item, int item_id){
    super(price, quantity, item, item_id);
    author = "No Author";     //Default when author parameter is empty
    title = "No Title";       //Default when title parameter is empty
    year = 2010;              //Default when year is out of bounds
  }

  /**OVERLOADED CONSTRUCTOR that calls the above overloaded constructor*/
  public Book(double price, int quantity, String item, int item_id, String author, String title, int year){
    this(price, quantity, item, item_id);
    setAuthor(author);
    setTitle(title);
    setYear(year);
  }

  @Override
  public int compareTo(Book other){
    return this.author.compareTo(other.author);
  }

  /**DISPLAY METHOD: Displays the shoe parameters entered by user or default if out of range*/
  @Override
  public String Display(){
    return "\n\nID: "+ getID()+"\nType: Book\nAuthor: " + getAuthor() + "\nTitle: " + getTitle() + "\nYear: " + getYear()  + "\nPrice: $" + getPrice() + " each\nQuantity: " + getQuantity()  + "\n";

  }

  /**PURCHASE METHOD: Decrements the quantity of item after purchase and displays what the user has purchased*/
  @Override
  public String Purchase(int num){
    this.quantity = quantity - num;
    return "\nThank you for purchasing " + num + " many books named " + getTitle() + " by " + getAuthor() + " published in " + getYear();
  }

  /**MUTATOR METHODS*/
  public String setAuthor(String author){
    if(isValidAuthor(author))
    {
      this.author = author;
    }
    return author;
  }

  public String setTitle(String title){
    if(isValidTitle(title))
      this.title = title;
    return title;
  }

  public int setYear(int year){
    if(isValidYear(year)){
      this.year = year;
    }
    return year;
  }

  /**ACCESSOR METHODS*/
  public String getAuthor(){
    return author;
  }

  public String getTitle(){
    return title;
  }

  public int getYear(){
    return year;
  }

/**HELPER METHODS:
   Determines if the title and author are valid and if year is isValid */
  private boolean isValidTitle(String title){
    return(title.isEmpty()?false:true);
  }

  private boolean isValidAuthor(String author){
    return(author.isEmpty()?false:true);
  }

  private boolean isValidYear(int year){
    return(year >= 1800 && year <= 2019);
  }

  public String toString(){
    return Display();
  }

}
