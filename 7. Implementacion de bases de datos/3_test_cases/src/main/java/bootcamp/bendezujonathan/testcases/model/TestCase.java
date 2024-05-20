package bootcamp.bendezujonathan.testcases.model;

import java.time.LocalDate;
import java.util.Objects;

import org.hibernate.annotations.UpdateTimestamp;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@Entity
@Table(name = "test_cases")
public class TestCase {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_case")
    private Long id;

    @Basic
    private String description;
    
    @Basic
    private Boolean tested;
    
    @Basic
    private Boolean passed;
    
    @Column(name = "number_of_tries")
    private Integer numberOfTries;

    @Column(name = "last_update")
    @UpdateTimestamp
    private LocalDate lastUpdate;


    public void update(TestCase updatedData) {
        description = (!Objects.isNull(updatedData.description)) ? updatedData.description : description;
        tested = (!Objects.isNull(updatedData.tested)) ? updatedData.tested : tested;
        passed = (!Objects.isNull(updatedData.passed)) ? updatedData.passed : passed;
        numberOfTries = (!Objects.isNull(updatedData.numberOfTries)) ? updatedData.numberOfTries : numberOfTries;
    }

}
