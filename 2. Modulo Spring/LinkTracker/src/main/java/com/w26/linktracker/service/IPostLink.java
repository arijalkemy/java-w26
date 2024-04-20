package com.w26.linktracker.service;

import com.w26.linktracker.dto.LinkCreation;
import com.w26.linktracker.dto.LinkResultCreation;

public interface IPostLink {
    LinkResultCreation createLink(LinkCreation linkCreation, String password);
}
