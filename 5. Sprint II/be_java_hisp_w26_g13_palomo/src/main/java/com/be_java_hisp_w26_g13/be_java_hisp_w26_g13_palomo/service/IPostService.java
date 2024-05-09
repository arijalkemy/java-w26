package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.service;

import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.MessageDto;
import com.be_java_hisp_w26_g13.be_java_hisp_w26_g13_palomo.dto.PostDTO;

public interface IPostService {

    MessageDto create(PostDTO postDto);
}
