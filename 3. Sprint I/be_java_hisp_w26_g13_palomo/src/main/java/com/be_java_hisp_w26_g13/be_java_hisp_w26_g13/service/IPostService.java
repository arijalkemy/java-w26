package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.CreatePostDTO;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.ExceptionDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;

public interface IPostService {

    ExceptionDto create(CreatePostDTO postDto);
    ExceptionDto createPromoPost(CreatePostDTO postDTO);
}
