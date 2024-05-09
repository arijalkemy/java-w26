package org.example.g14.dto.response;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class UserFollowersCountResponseDto extends UserResponseDto {
    private int followers_count;

    public UserFollowersCountResponseDto(int user_id, String user_name, int followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }
}
