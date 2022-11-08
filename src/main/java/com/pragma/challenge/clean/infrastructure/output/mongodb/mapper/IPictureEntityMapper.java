package com.pragma.challenge.clean.infrastructure.output.mongodb.mapper;

import com.pragma.challenge.clean.domain.model.Picture;
import com.pragma.challenge.clean.infrastructure.output.mongodb.entity.PictureEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface IPictureEntityMapper {

    PictureEntity toEntity(Picture picture);

    Picture toPicture(PictureEntity pictureEntity);

    List<Picture> toPictureList(List<PictureEntity> pictureEntityList);
}
