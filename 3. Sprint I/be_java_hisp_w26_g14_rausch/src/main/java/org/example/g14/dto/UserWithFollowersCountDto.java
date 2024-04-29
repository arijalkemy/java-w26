package org.example.g14.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class UserWithFollowersCountDto extends UserDto{
    private int followers_count;

    public UserWithFollowersCountDto(int user_id, String user_name, int followers_count) {
        super(user_id, user_name);
        this.followers_count = followers_count;
    }
}
