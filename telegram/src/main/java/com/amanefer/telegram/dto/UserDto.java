package com.amanefer.telegram.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private long id;
    private String username;
    private Set<RoleDto> role = new HashSet<>();

    @Override
    public String toString() {
        return String.format("""
                        id: %d
                        username: %s
                        role: %s""",
                             id,
                             username,
                             role.stream().findFirst().get()
                                     .getName().replace("ROLE_", "").toLowerCase());
    }
}
