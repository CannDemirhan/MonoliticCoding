package com.candemirhan._321monoliticcoding.repository.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class BaseObject {

    /**
     * 0 -> passive
     * 1 -> active
     * 2 -> deleted
     * 3 -> blocked
     */
    private int state;

    private String createdBy;
    private Long createdAt;
    private String updatedBy;
    private Long updatedAt;
}
