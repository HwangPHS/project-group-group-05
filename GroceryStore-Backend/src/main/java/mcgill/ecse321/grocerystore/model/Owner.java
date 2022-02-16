package mcgill.ecse321.grocerystore.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Owner {

  private String username;
  private String password;
  private String email;
  
  @Id
  public String getUserName() {
  return this.username;
     }

  public void setUserName(String value) {
    this.username = value;
       }
  
  public void setPassword(String value) {
  this.password = value;
     }

  public String getPassword() {
  return this.password;
     }

  public void setEmail(String value) {
  this.email = value;
     }

  public String getEmail() {
  return this.email;
     }
}
