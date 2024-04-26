package com.be_java_hisp_w26_g13.be_java_hisp_w26_g13.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PostListDTO {

    List<PostDTO> postDTOList;
}
