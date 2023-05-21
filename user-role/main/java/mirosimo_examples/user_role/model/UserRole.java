package mirosimo_examples.user_role.model;

import java.util.Date;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;





/*  
 * UserRole - Particular combination of User and Role - relation M:N
 *           - Contains primary key UserRoleId - composite key consist of Role and User
 *           - Represents connection entity -
 *    	
 *  Contains extra fields in connection entity 
 *  - this fields have sense just for one particular combination of User and Role
 *       - boolean active 		- Is role Active or Not 
 *       - int dateAdded  		- Date when was role added
 *       - int whoAssignRole 	- Who was assigned the role
 */ 

@Entity
@Table
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.user",
        joinColumns = @JoinColumn(name = "USER_ID")),
    @AssociationOverride(name = "primaryKey.role",
        joinColumns = @JoinColumn(name = "ROLE_ID")) })
public class UserRole {
	/*
	 *  Primary key - comosite key
	 *  
	 */
	private UserRoleId primaryKey = new UserRoleId();
		
	/*
	 *  Additional fields 
	 *  Have sense just for one particular combination of keys 
	 *  
	 */
	
	/*
	 * Is role active or not
	 */
	private boolean active;
	
	/* 
	 * Date when was role added
	 * 
	 */
	private Date dateAdded;
	
	/*
	 * Id - who was assigned the role
	 * 
	 */
	private long whoAssignRole;
	
	
    @EmbeddedId
    public UserRoleId getPrimaryKey() {
        return primaryKey;
    }
    
    public void setPrimaryKey(UserRoleId primaryKey) {
        this.primaryKey = primaryKey;
    }
 
    @Transient
    public User getUser() {
        return getPrimaryKey().getUser();
    }
 
    public void setUser(User user) {
        getPrimaryKey().setUser(user);
    }
 
    @Transient
    public Role getRole() {
        return getPrimaryKey().getRole();
    }
 
    public void setRole(Role role) {
        getPrimaryKey().setRole(role);
    }

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Date getDateAdded() {
		return dateAdded;
	}

	public void setDateAdded(Date dateAdded) {
		this.dateAdded = dateAdded;
	}

	public long getWhoAssignRole() {
		return whoAssignRole;
	}

	public void setWhoAssignRole(long whoAssignRole) {
		this.whoAssignRole = whoAssignRole;
	}


 
    
}
