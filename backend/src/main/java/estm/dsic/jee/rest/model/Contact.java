package estm.dsic.jee.rest.model;
import lombok.Data;

import jakarta.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "contact")
@Data
public class Contact implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String nom;
    
    @Column
    private String tele;
    private String email;
    
    @Column
    private String adresse;

    @ManyToOne
    @JoinColumn(name = "userId", insertable = false, updatable = false)
    private User user;

    @Column(name = "userId")
    private int userId;
}