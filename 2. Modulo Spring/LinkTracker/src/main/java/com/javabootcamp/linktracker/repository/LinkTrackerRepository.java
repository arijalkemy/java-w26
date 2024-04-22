package com.javabootcamp.linktracker.repository;

import com.javabootcamp.linktracker.model.Link;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Repository
public class LinkTrackerRepository {

    Map<Integer, Link> linkList = new HashMap<>();

    public void setLinkList(Map<Integer, Link> linkList) {
        this.linkList = linkList;
    }

    public Map<Integer, Link> getLinkList() {
        return linkList;
    }

    public void addLink(Link link) {
        linkList.put(link.getLinkId(), link);
    }

    public void deleteLink(int id) {
        linkList.remove(id);
    }

    public void updateLink(Link link) {
        linkList.put(link.getLinkId(), link);
    }

    public boolean findLink(int id) {
        if(linkList.containsKey(id)){
            return true;
        }
        else{
            return false;
        }
    }

    public Link getLink(int id) {
        return linkList.get(id);
    }

    public void increaseRedirectionCounter(int linkId) {
        linkList.get(linkId).setRedirectionCounter(linkList.get(linkId).getRedirectionCounter() + 1);
    }

}
