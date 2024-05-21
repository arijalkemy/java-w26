package bootcamp.bendezujonathan.hql.model;

import java.time.LocalDateTime;
import java.util.Set;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@Entity
@Table(name = "actors")
public class Actor {
    
    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private long id;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Basic
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "favorite_movie_id")
    private Movie favMovie;

    @ManyToMany
    @JoinTable(name = "actor_movie",
    joinColumns = @JoinColumn(name ="actor_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"))
    private Set<Movie> movies;

}
