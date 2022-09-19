package com.candemirhan._321monoliticcoding.dto.request;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class FindByIdRequestDto {

    private Long oid;

    @JsonCreator
    public FindByIdRequestDto(Long oid)
    {
        this.oid = oid;
    }

}
