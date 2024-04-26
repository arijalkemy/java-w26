package org.example.be_java_hisp_w26_g07.service.interfaces;

import jakarta.validation.Valid;
import org.example.be_java_hisp_w26_g07.dto.*;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface IProductService {
    List<PostDto> findProductByFollow(Integer userID, String order);
    PostDto createPost(PostRequestDto postRequestDto);
    SuccessResponseDto createPromoPost(PromoPostReqDto postReqDto);
    PromoPostResDto getPromoPostsBySellerId(Integer userId);
    StatisticsDto getStatistics(Integer userId);
}
