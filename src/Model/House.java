package Model;
// Generated Dec 18, 2017 2:07:07 PM by Hibernate Tools 4.3.1


import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * House generated by hbm2java
 */
@Entity
@Table(name="House"
    ,schema="dbo"
    ,catalog="HoDan"
)
public class House  implements java.io.Serializable {


     private String houseId;
     private Integer memberNumber;
     private String address;
     private Set personals = new HashSet(0);

    public House() {
    }

	
    public House(String houseId) {
        this.houseId = houseId;
    }
    public House(String houseId, Integer memberNumber, String address, Set personals) {
       this.houseId = houseId;
       this.memberNumber = memberNumber;
       this.address = address;
       this.personals = personals;
    }
   
     @Id 

    
    @Column(name="HouseId", unique=true, nullable=false, length=10)
    public String getHouseId() {
        return this.houseId;
    }
    
    public void setHouseId(String houseId) {
        this.houseId = houseId;
    }

    
    @Column(name="MemberNumber")
    public Integer getMemberNumber() {
        return this.memberNumber;
    }
    
    public void setMemberNumber(Integer memberNumber) {
        this.memberNumber = memberNumber;
    }

    
    @Column(name="Address", length=50)
    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }

@OneToMany(fetch=FetchType.LAZY, mappedBy="house")
    public Set getPersonals() {
        return this.personals;
    }
    
    public void setPersonals(Set personals) {
        this.personals = personals;
    }




}

