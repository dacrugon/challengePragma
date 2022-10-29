package com.pragma.challenge.clean.domain.usecase;

import com.pragma.challenge.clean.domain.api.IPictureServicePort;
import com.pragma.challenge.clean.domain.model.Picture;
import com.pragma.challenge.clean.domain.spi.IPicturePersistencePort;

import java.util.List;

public class PictureUserCase implements IPictureServicePort {

    private final IPicturePersistencePort picturePersistencePort;

    public PictureUserCase(IPicturePersistencePort picturePersistencePort) {
        this.picturePersistencePort = picturePersistencePort;
    }

    @Override
    public void savePicture(Picture picture) {
        picturePersistencePort.savePicture(picture);
    }

    @Override
    public List<Picture> getAllPictures() {
        return picturePersistencePort.getAllPictures();
    }

    @Override
    public Picture getPictureByIdentificationNumber(String in) {
        return picturePersistencePort.getPictureByIdentificationNumber(in);
    }

    @Override
    public void updatePicture(Picture picture) {
        picturePersistencePort.updatePicture(picture);
    }

    @Override
    public void deletePictureByIdentificationNumber(String in) {
        picturePersistencePort.deletePictureByIdentificationNumber(in);
    }
}
