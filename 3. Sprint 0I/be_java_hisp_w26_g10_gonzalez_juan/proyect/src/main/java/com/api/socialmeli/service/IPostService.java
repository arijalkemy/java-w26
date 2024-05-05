package com.api.socialmeli.service;

import com.api.socialmeli.dto.*;

public interface IPostService {

    PostsByFollowedDto getPostsByFollowed(Integer userId, String order);

    PostDto publishPost(PostDto postDto);

    /* US 0010 */
    PostPromoDto publishPostPromo(PostPromoDto postPromoDto);

    /* US 0011 */
    PostPromoCountDto getCountOfProductsPromosBySellerId(Integer seller_id);

    /* US 0012 */
    PostPromoListDto getPostPromosOfSellerById(Integer seller_id);
}
