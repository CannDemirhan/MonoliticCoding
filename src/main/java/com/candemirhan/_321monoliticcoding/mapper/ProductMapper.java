package com.candemirhan._321monoliticcoding.mapper;

import com.candemirhan._321monoliticcoding.dto.request.ProductSaveRequestDto;
import com.candemirhan._321monoliticcoding.repository.entity.Product;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    Product toProduct(ProductSaveRequestDto dto);
    ProductSaveRequestDto fromProduct(Product product);
}
