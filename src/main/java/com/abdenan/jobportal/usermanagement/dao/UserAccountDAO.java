package com.abdenan.jobportal.usermanagement.dao;

import com.abdenan.jobportal.usermanagement.entities.UserAccount;
import org.springframework.data.repository.CrudRepository;

public interface UserAccountDAO extends CrudRepository<UserAccount, Long> {
}
