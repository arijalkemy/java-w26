package org.example.be_java_hisp_w26_g07.service.interfaces;

import jakarta.validation.Valid;
import org.example.be_java_hisp_w26_g07.dto.PostDto;
import org.example.be_java_hisp_w26_g07.dto.PostRequestDto;
import org.example.be_java_hisp_w26_g07.dto.PromoPostReqDto;
import org.example.be_java_hisp_w26_g07.dto.SuccessResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IProductService {
    List<PostDto> findProductByFollow(Integer userID, String order);
    PostDto createPost(PostRequestDto postRequestDto);
    SuccessResponseDto createPromoPost(PromoPostReqDto postReqDto);
    SuccessResponseDto getPromoPostsBySellerId(Integer userId);
}
