package com.example.demo.repository.impl;

import com.example.demo.entity.Link;
import com.example.demo.repository.ILinkTackerRepository;
import lombok.Data;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class LinkTackerRepositoryImpl implements ILinkTackerRepository {

    private List<Link> links;

    public LinkTackerRepositoryImpl() {
        links = new ArrayList<>();
    }

    public List<Link> getLinks() {
        return links;
    }
}
