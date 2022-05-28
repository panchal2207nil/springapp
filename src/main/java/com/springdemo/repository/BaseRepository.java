/**
 * @author Nil Panchal Mex IT May 28, 2022 11:20:01 PM BaseRepository.java com.springdemo.repository
 *         SpringDemo
 */
package com.springdemo.repository;

import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;
import com.springdemo.model.BaseEntity;

/**
 * @author Nil Panchal Mex IT May 28, 2022 11:20:01 PM
 */
@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity> extends JpaRepository<T, UUID> {

}
