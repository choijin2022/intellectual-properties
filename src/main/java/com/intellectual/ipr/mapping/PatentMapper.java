package com.intellectual.ipr.mapping;

import com.intellectual.ipr.patent.dto.StorePatentDocument;
import com.intellectual.ipr.patent.entity.Patent;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PatentMapper {

    PatentMapper INSTANCE = Mappers.getMapper(PatentMapper.class);

    Patent toPatent(StorePatentDocument.Request storePatentDocument);
}
