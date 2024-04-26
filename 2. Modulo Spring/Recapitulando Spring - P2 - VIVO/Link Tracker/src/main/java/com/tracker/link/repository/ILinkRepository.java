package com.tracker.link.repository;

import com.tracker.link.entity.Link;

import java.util.HashMap;
import java.util.List;

public interface ILinkRepository {
    HashMap<Integer, Link> findAll();
    void addLink(int id, Link link);
    Link findLink(int id);
}
