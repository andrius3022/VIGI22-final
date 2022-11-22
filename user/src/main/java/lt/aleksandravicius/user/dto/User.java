package lt.aleksandravicius.user.dto;



import org.hibernate.annotations.ColumnTransformer;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;


import javax.persistence.*;
import javax.validation.constraints.Email;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


@Entity
@Table (name ="users")
public class User {

    @Id //primary key
    @GeneratedValue(strategy = GenerationType.AUTO) //generates primary key AUTO nuo 0 ir IDENTITY toliau
    private Long id;

    @Column(name ="user_name")
    private String name;



    @Email (message = "Enter valid email")
    @ColumnTransformer(write = "LOWER(?)")
    private String email;
    private String country;
    private String server;

    @CreationTimestamp
     @Column(name ="creation_date", nullable = false, updatable = false)
     private Date createdAt;

    public User(){

    }

   public User( Long id,String name, String email, String country, String server, Date createdAt) {
       this.name = name;
       this.email = email;
       this.country = country;
       this.server = server;
       this.createdAt =createdAt;

   }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
