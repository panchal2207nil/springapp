/**
 * @author Nil Panchal Mex IT May 28, 2022 11:18:48 PM UserRepository.java com.springdemo.repository
 *         SpringDemo
 */
package com.springdemo.repository;

import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.stereotype.Repository;
import com.springdemo.model.User;

/**
 * @author Nil Panchal Mex IT May 28, 2022 11:18:48 PM
 */
@Repository
@Transactional()
public interface UserRepository extends BaseRepository<User> {

  Optional<User> findByShortId(String shortId);

  Optional<User> findByEmail(String email);
}
