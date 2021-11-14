package com.aptech.springmvc.dao;

import com.aptech.springmvc.entity.Role;

public interface RoleDAO {
	public Role findRoleByName(String theRoleName);
}
