package org.example.be_java_hisp_w26_g04.repository.buyer;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.be_java_hisp_w26_g04.model.Buyer;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Repository;

import java.io.IOException;
import java.util.Optional;
import java.util.Set;

@Repository
public class BuyerRepositoryImp implements IBuyersRepository {

    private Set<Buyer> buyers;
    private int idCount;

    public BuyerRepositoryImp() throws IOException {
        populate();
    }


    @Override
    public Set<Buyer> findAll() {
        return buyers;
    }

    @Override
    public Optional<Buyer> findById(int id) {
        return buyers.stream().filter(b -> b.getUserId() == id).findFirst();
    }

    @Override
    public boolean save(Buyer buyer) {
        idCount++;
        buyer.setUserId(idCount);
        return buyers.add(buyer);
    }

    private void populate() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        Resource resource = new ClassPathResource("data/buyer.json");
        buyers = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
    }
}
