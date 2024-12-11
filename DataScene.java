import org.code.theater.*;
import org.code.media.*;

public class DataScene extends Scene {

  /*
  *Declare an array to store User objects
  */ 
  
  private User[] users;      
  
  /*
  *Constructor for the DataScene class
  */ 
  
  public DataScene() {
    // Initialize the users array by creating users from data files
    users = createUsers();
  }

  /*
  *Method to create the array of User objects
  */
  
  public User[] createUsers() {
    // Read the owner names from the file "owner.txt" into a String array
    String[] ownerArray = FileReader.toStringArray("owner.txt");
    // Read the followers count from the file "followers.txt" into an int array
    int[] followersArray = FileReader.toIntArray("followers.txt");
    // Create an array to hold the User objects, with the same length as ownerArray
    User[] usersArray = new User[ownerArray.length];
    // Loop through each item and create a User object using the corresponding owner and followers
    for (int i = 0; i < usersArray.length; i++) {
      // Initialize each User object in the array
      usersArray[i] = new User(ownerArray[i], followersArray[i]);
    }
    // Return the array of User objects
    return usersArray;
  }

  /*
  *Method to draw the scene, calls the method to draw circles
  */
  
  public void drawScene() {
    drawCircle();
  }

  /*
  *Method to draw circles based on user data
  */
  
  public void drawCircle(){
    // Set the canvas scene to black for easier viewing
    clear("black");
    // Loop through all users in the users array
    for(int i = 0; i < users.length; i++){
      // Randomly pick a user from the array
      int randomIndex = (int) (Math.random() * users.length);
      User randomUser = users[randomIndex];
      // Get the number of followers and owner name for the randomly selected user
      int followers = randomUser.getFollowers();
      String owner = randomUser.getOwner();
      // Calculate the size of the circle based on the number of followers (square root scale)
      int circleSize = (int) Math.sqrt(followers) * 20;
      // Determine the category of the user based on the number of followers
      if(followers >= 0 && followers <= 99){
        // Set text style for small Insta users (red)
        setTextStyle(Font.SANS, FontStyle.BOLD); 
        setTextHeight(20);
        setTextColor("red");
        drawText("small Insta User", 0, 400);
        setFillColor("red");
      } else if (followers >= 100 && followers <= 149){
        // Set text style for mid-range Insta users (yellow)
        setTextStyle(Font.SANS, FontStyle.BOLD);
        setTextHeight(20);
        setTextColor("yellow");
        drawText("mid Insta User", 0, 400);
        setFillColor("yellow");
      } else {
        // Set text style for large Insta users (green)
        setTextStyle(Font.SANS, FontStyle.BOLD);
        setTextHeight(20);
        setTextColor("green");
        drawText("big Insta User", 0, 400);
        setFillColor("green");
      }
      // Draw the circle representing the user, size depends on followers
      drawEllipse(10, 10, circleSize, circleSize);
      // Reset the text style to the default
      textStyle();
      // Draw the owner's name and the follower count next to the circle
      drawText(owner, 0, 350);
      drawText("(" + followers + "M followers)", 0, 380);
      // Pause for a brief moment (1 second)
      pause(1);
      // Clear the canvas to prepare for the next frame
      clear("black");
    }
  }

  /*
  *Method to reset the text style to the default style
  */
  
  public void textStyle(){
    // Set default text style (sans serif, bold, and size 40)
    setTextStyle(Font.SANS, FontStyle.BOLD);
    setTextHeight(25);
  }
}
