/**
 * Represents a User with a owner and followers
 */
public class User {

  private String owner;     // first owner of User
  private int followers;         // followers in years

  /** Constructor */
  public User(String owner, int followers) {
    this.owner = owner;
    this.followers = followers;
  }

  /** Accessor Method for owner */
  public String getOwner() {
    return owner;
  }
  
  /** Accessor Method for followers */
  public int getFollowers() {
    return followers;
  }
  
  /** toString Method override */
  public String toString() {
    return owner + " has this many followers: " + followers + " million";
  }
  
}