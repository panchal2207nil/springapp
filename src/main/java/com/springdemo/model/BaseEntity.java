/**
 * @author Nil Panchal Mex IT May 28, 2022 10:23:40 PM BaseEntity.java com.springdemo.model
 *         SpringDemo
 */
package com.springdemo.model;

import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springdemo.constant.Constants;


/**
 * @author Nil Panchal Mex IT May 28, 2022 10:23:40 PM
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {""})
public abstract class BaseEntity implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 2728891103086813513L;

  public abstract String generatShortId();

  @Id
  @Type(type = "uuid-char")
  @GeneratedValue(generator = Constants.UUID_GENERATOR)
  @GenericGenerator(name = "UUID", strategy = Constants.UUID_GENERATOR_STRATEGY)
  @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(255)")
  private UUID id;

  @Column(name = "short_id", nullable = false, updatable = true, columnDefinition = "VARCHAR(255)")
  private String shortId;

  @CreatedDate
  @Column(nullable = false, updatable = false)
  private Instant createdAt;

  @LastModifiedDate
  @Column(nullable = false)
  private Instant updatedAt;

  @Column(name = "deleted", columnDefinition = "boolean default false")
  private boolean deleted;

  /**
   * @author Nil Panchal May 28, 2022 10:46:57 PM
   */
  public BaseEntity() {
    super();
    this.shortId = this.generatShortId();
  }

  public UUID getId() {
    return id;
  }

  public Instant getCreatedAt() {
    return createdAt;
  }

  public Instant getUpdatedAt() {
    return updatedAt;
  }

  public void setId(UUID id) {
    this.id = id;
  }


  public void setCreatedAt(Instant createdAt) {
    this.createdAt = createdAt;
  }

  public void setUpdatedAt(Instant updatedAt) {
    this.updatedAt = updatedAt;
  }

  public String getShortId() {
    return shortId;
  }

  public boolean isDeleted() {
    return deleted;
  }

  public void setShortId(String shortId) {
    this.shortId = shortId;
  }

  public void setDeleted(boolean deleted) {
    this.deleted = deleted;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((shortId == null) ? 0 : shortId.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) {
      return true;
    }
    if (!(obj instanceof BaseEntity)) {
      return false;
    }
    BaseEntity other = (BaseEntity) obj;
    if (shortId == null) {
      if (other.shortId != null) {
        return false;
      }
    } else if (!shortId.equals(other.shortId)) {
      return false;
    }
    return true;
  }
}
