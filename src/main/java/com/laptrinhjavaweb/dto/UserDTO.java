package com.laptrinhjavaweb.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO extends AbstractDTO<UserDTO> {
	private String username;
	private String password;
	private String fullname;
}
