package com.api.socialmeli.service.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import com.api.socialmeli.dto.PostDto;
import com.api.socialmeli.entity.Post;
import com.api.socialmeli.entity.Seller;
import com.api.socialmeli.exception.BadRequestException;
import com.api.socialmeli.repository.IPostRepository;
import com.api.socialmeli.repository.ISellerRepository;
import com.api.socialmeli.service.IBuyerService;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.aot.DisabledInAotMode;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ContextConfiguration(classes = {PostServiceImpl.class})
@ExtendWith(SpringExtension.class)
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
@DisabledInAotMode
class PostServiceImplDiffblueTest {
  @MockBean
  private IBuyerService iBuyerService;

  @MockBean
  private IPostRepository iPostRepository;

  @MockBean
  private ISellerRepository iSellerRepository;

  @Autowired
  private PostServiceImpl postServiceImpl;

  /**
   * Method under test: {@link PostServiceImpl#publishPost(PostDto)}
   */
  @Test
  void testPublishPost() {
    // Arrange
    when(iSellerRepository.getAll()).thenReturn(new ArrayList<>());

    // Act and Assert
    assertThrows(BadRequestException.class, () -> postServiceImpl.publishPost(new PostDto()));
    verify(iSellerRepository).getAll();
  }

  /**
   * Method under test: {@link PostServiceImpl#publishPost(PostDto)}
   */
  @Test
  void testPublishPost2() {
    // Arrange
    when(iPostRepository.searchPostId()).thenReturn(1);
    doNothing().when(iPostRepository).savePost(Mockito.<Post>any());

    ArrayList<Seller> sellerList = new ArrayList<>();
    sellerList.add(new Seller());
    when(iSellerRepository.getAll()).thenReturn(sellerList);
    PostDto postDto = new PostDto();

    // Act
    PostDto actualPublishPostResult = postServiceImpl.publishPost(postDto);

    // Assert
    verify(iPostRepository).savePost(isA(Post.class));
    verify(iPostRepository).searchPostId();
    verify(iSellerRepository).getAll();
    assertEquals(1, actualPublishPostResult.getPost_id().intValue());
    assertSame(postDto, actualPublishPostResult);
  }

  /**
   * Method under test: {@link PostServiceImpl#publishPost(PostDto)}
   */
  @Test
  void testPublishPost3() {
    // Arrange
    ArrayList<Seller> sellerList = new ArrayList<>();
    sellerList.add(new Seller(1, "User name"));
    when(iSellerRepository.getAll()).thenReturn(sellerList);

    // Act and Assert
    assertThrows(BadRequestException.class, () -> postServiceImpl.publishPost(new PostDto()));
    verify(iSellerRepository).getAll();
  }
}
