package com.example.dto_y_response_entityp2.repository;

import com.example.dto_y_response_entityp2.entity.SymptomPerson;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SympotmsPersonRepository {
    List<SymptomPerson> relation;

    public SympotmsPersonRepository() {
        this.relation = new ArrayList<>();
        relation.add(new SymptomPerson(1L,1L));
        relation.add(new SymptomPerson(2L,3L));
        relation.add(new SymptomPerson(3L,5L));
        relation.add(new SymptomPerson(1L,3L));
    }
    public List<SymptomPerson> getAll(){
        return relation;
    }
}
