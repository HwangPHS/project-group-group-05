package mcgill.ecse321.grocerystore.model;

import java.sql.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

/**
 * Implementation of the EmployeeSchedule Class for GroceryStoreApplication.
 * <p>
 * This class represents the assignment of a particular employee to a particular shift in
 * GroceryStoreApplication; it functions as an association class between the Employee Class and the
 * Shift Class. It facilitates the implementation of the following requirements:
 * <ul>
 * <li>RQ13 - Instances of the EmployeeSchedule class represents the assignment of a shift to a
 * store employee. The Owner can assign schedules to employees by assigning EmployeeSchedule
 * instances.</li>
 * </ul>
 * 
 * @author Harrison Wang
 */
@Entity
public class EmployeeSchedule {

  // EmployeeSchedule Attributes
  @Id
  @GeneratedValue
  private long id;
  private Date date;

  // EmployeeSchedule Associations
  @ManyToOne(optional = false)
  private Shift shift;

  // Getter Methods
  // --------------
  public long getId() {
    return id;
  }

  public Date getDate() {
    return date;
  }

  public Shift getShift() {
    return shift;
  }

  // Setter Methods
  // --------------
  /**
   * For mockito testing only. The id should never be set manually otherwise.
   * 
   * @param id
   */
  public void setId(long id) {
    this.id = id;
  }

  public void setDate(long date) {
    this.date = new Date(date);
  }

  public void setDate(String date) {
    this.date = Date.valueOf(date);
  }

  public void setDate(Date date) {
    this.date = date;
  }

  public void setShift(Shift shift) {
    this.shift = shift;
  }

  // Overrides
  // ---------

  /**
   * Comparisons based on the inherited hashCode() method are not useful for objects fetched from a
   * database. We are overriding the hashCode() method to use the auto-generated primary key as a
   * hash code instead.
   * 
   * If the primary key has not been generated yet (i.e. the object has not been added to the
   * database), we will substitute the hash code generated by the java Object class.
   * 
   * @return int - the primary key id of this EmployeeSchedule instance as an int.
   */
  @Override
  public int hashCode() {
    return id == 0L ? super.hashCode() : (int) id;
  }

  /**
   * Comparisons based on the inherited equals method are performed primarily on the hash code of
   * the object. Because we may be loading objects from the database, this is no longer useful.
   * Therefore, we will be overriding the equals method to evaluate equality based on the primary
   * key of this class.
   * <p>
   * The behavior of this method is as follows:
   * <ul>
   * <li>if this.getId() == 0 and o.getId() == 0 -> return o == this; If the id of both objects is
   * 0, neither of the two objects has interacted with the database yet. Therefore, the objects may
   * be evaluated identically to how super.equals() works. This is already done at the start of the
   * method.</li>
   * <li>if this.getId() != 0 xor o.getId() != 0 -> return false; If only one of the two objects has
   * been added to the database, the equality of both objects becomes unpredictable. They may be the
   * same object, but we cannot definitively assert that they are the same object. Therefore, return
   * false.</li>
   * <li>if this.getId() != 0 and o.getId() != 0 -> return this.getId() == o.getId(); If both
   * objects have been added to the database, we use their auto-generated primary keys to evaluate
   * equality.</li>
   * </ul>
   * 
   * @param o - the Object with which we are comparing this object to.
   * @return boolean - boolean indicating whether the objects are equal.
   */
  @Override
  public boolean equals(Object o) {
    // if o is this object, return true
    if (o == this)
      return true;
    // if o is not an instance of EmployeeSchedule, or is null, this code will not run
    if (o instanceof EmployeeSchedule) {
      long objectId = ((EmployeeSchedule) o).getId();
      return objectId != 0 && id == objectId;
    }
    return false;
  }

}
