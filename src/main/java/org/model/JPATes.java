package org.model;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="account_table")
public class JPATes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    String firstName = null;
    String lastName = null;
   
  
    public JPATes() {      }

    public JPATes(String firstName, String lastName) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
       
    }


}
