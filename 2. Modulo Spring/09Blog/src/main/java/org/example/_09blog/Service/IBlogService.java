package org.example._09blog.Service;

import org.example._09blog.DTO.GetBlogResponseDTO;
import org.example._09blog.DTO.NewBlogRequestDTO;
import org.example._09blog.DTO.NewBlogResponseDTO;

import java.util.List;

public interface IBlogService {

    public GetBlogResponseDTO retrieveBlog(int id);

    public NewBlogResponseDTO createBlog(NewBlogRequestDTO newBlogRequestDTO);

    public List<GetBlogResponseDTO> retrieveAllBlogs();
}
