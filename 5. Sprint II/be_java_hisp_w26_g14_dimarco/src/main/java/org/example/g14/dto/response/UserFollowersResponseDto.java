package org.example.g14.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserFollowersResponseDto extends UserResponseDto {
    private List<UserResponseDto> followers;

    public UserFollowersResponseDto(int user_id, String user_name, List<UserResponseDto> followers) {
        super(user_id, user_name);
        this.followers = followers;
    }
}
