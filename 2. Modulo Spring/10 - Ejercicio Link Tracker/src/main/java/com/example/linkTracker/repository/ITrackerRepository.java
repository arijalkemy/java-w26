package com.example.linkTracker.repository;

import com.example.linkTracker.model.Link;

import java.util.List;

public interface ITrackerRepository {

    List<Link> getAll();

    Link findById(String id);

    void save(Link link);
}
