package com.pragma.challenge.clean.application.mapper;

import com.pragma.challenge.clean.application.dto.PictureRequest;
import com.pragma.challenge.clean.application.dto.PictureResponse;
import com.pragma.challenge.clean.domain.model.Picture;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.ReportingPolicy;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper(componentModel = "spring",
        unmappedSourcePolicy = ReportingPolicy.IGNORE,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface IPictureMapper {


    Picture toPicture(PictureRequest pictureRequest);

    PictureResponse toPictureResponse(Picture picture);

    List<PictureResponse> toPictureResponseList(List<Picture> pictureList);

}
