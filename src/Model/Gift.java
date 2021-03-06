package Model;
// Generated Dec 19, 2017 6:21:36 PM by Hibernate Tools 4.3.1


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Gift generated by hbm2java
 */
@Entity
@Table(name="Gift"
    ,schema="dbo"
    ,catalog="HoDan"
)
public class Gift  implements java.io.Serializable {


     private long quaId;
     private String qua;
     private Integer dien;
     private Integer sluong;
     private String event;

    public Gift() {
    }

	
    public Gift(long quaId, String qua) {
        this.quaId = quaId;
        this.qua = qua;
    }
    public Gift(long quaId, String qua, Integer dien, Integer sluong, String event) {
       this.quaId = quaId;
       this.qua = qua;
       this.dien = dien;
       this.sluong = sluong;
       this.event = event;
    }
   
     @Id 

    
    @Column(name="QuaId", unique=true, nullable=false)
    public long getQuaId() {
        return this.quaId;
    }
    
    public void setQuaId(long quaId) {
        this.quaId = quaId;
    }

    
    @Column(name="Qua", nullable=false, length=50)
    public String getQua() {
        return this.qua;
    }
    
    public void setQua(String qua) {
        this.qua = qua;
    }

    
    @Column(name="Dien")
    public Integer getDien() {
        return this.dien;
    }
    
    public void setDien(Integer dien) {
        this.dien = dien;
    }

    
    @Column(name="SLuong")
    public Integer getSluong() {
        return this.sluong;
    }
    
    public void setSluong(Integer sluong) {
        this.sluong = sluong;
    }

    
    @Column(name="Event", length=50)
    public String getEvent() {
        return this.event;
    }
    
    public void setEvent(String event) {
        this.event = event;
    }




}


