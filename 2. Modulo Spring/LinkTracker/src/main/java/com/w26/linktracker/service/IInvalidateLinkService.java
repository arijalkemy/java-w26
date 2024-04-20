package com.w26.linktracker.service;

import com.w26.linktracker.dto.InvalidationLinkResult;

public interface IInvalidateLinkService {

   InvalidationLinkResult invalidateLinkById(Integer linkId);

}
