package bootcamp.bendezujonathan.hql.model;

import java.time.LocalDate;
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
@Table(name = "episodes")
public class Episode {
    

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Long id;

    @CreationTimestamp
    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at")
    private LocalDateTime updatedAt;

    @Basic
    private String title;

    @Column(name = "release_date")
    private LocalDate releaseDate;

    @Basic
    private Integer number;

    @Basic
    private Double rating;

    @ManyToOne
    @JoinColumn(name = "season_id", referencedColumnName = "id")
    private Season season;

    @ManyToMany
    @JoinTable(name = "actor_episode",
    joinColumns = @JoinColumn(name = "episode_id", referencedColumnName = "id"),
    inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id"))
    private Set<Actor> actors;

    
}
