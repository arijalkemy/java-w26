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

import static org.example.be_java_hisp_w26_g04.util.scope.UtilScope.SCOPE;

@Repository
public class BuyerRepositoryImp implements IBuyersRepository {

    private Set<Buyer> buyers;
    private int idCount;

    @Override
    public int update(Buyer Object) {
        return 0;
    }

    @Override
    public void delete(Buyer Object) {}

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
    public int save(Buyer buyer) {
        idCount++;
        buyer.setUserId(idCount);
        buyers.add(buyer);
        return idCount;
    }

    private void populate() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        String resourcePath = "data/buyer.json";
        if ("test".equals(SCOPE)) {
            resourcePath = "test/" + resourcePath;
        }
        Resource resource = new ClassPathResource(resourcePath);
        buyers = objectMapper.readValue(resource.getInputStream(), new TypeReference<>() {
        });
    }
}
