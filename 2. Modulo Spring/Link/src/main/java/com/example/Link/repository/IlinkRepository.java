package com.example.Link.repository;
import com.example.Link.entity.Link;
public interface IlinkRepository {
    Link save(Link link);
    Link findById(Integer id);
    void invalidate(Integer id);
}
