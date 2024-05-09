package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.MessageDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto.PostDTO;

public interface IPostService {

    MessageDto create(PostDTO postDto);
}
