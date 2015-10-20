package org.model;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="account_table")
@XmlRootElement
public class JPATes {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    private   String firstName = null;
    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Date getCreated() {
		return created;
	}

	public void setCreated(Date created) {
		this.created = created;
	}

	private    String lastName = null;
	 private Date created = new Date();
  
    public JPATes() {      }

    public JPATes(String firstName, String lastName,Date created) {
        super();
        this.firstName = firstName;
        this.lastName = lastName;
        this.created=created;
    }


}
