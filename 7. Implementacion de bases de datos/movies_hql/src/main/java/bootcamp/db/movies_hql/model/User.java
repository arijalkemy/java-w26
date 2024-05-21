package bootcamp.db.movies_hql.model;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter @Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String email;
    @Column(name = "created_at")
    private Timestamp createdAt;
    private String name;
    private String password;
    @Column(name = "remember_token")
    private String rememberToken;
    @Column(name = "updated_at")
    private Timestamp updatedAt;
}
