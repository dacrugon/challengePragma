package com.pragma.challenge.clean.infrastructure.configuration;

import com.pragma.challenge.clean.domain.api.IPersonServicePort;
import com.pragma.challenge.clean.domain.api.IPictureServicePort;
import com.pragma.challenge.clean.domain.spi.IPersonPersistencePort;
import com.pragma.challenge.clean.domain.spi.IPicturePersistencePort;
import com.pragma.challenge.clean.domain.usecase.PersonUseCase;
import com.pragma.challenge.clean.domain.usecase.PictureUseCase;
import com.pragma.challenge.clean.infrastructure.output.jpa.adapter.PersonJpaAdapter;
import com.pragma.challenge.clean.infrastructure.output.jpa.mapper.IPersonEntityMapper;
import com.pragma.challenge.clean.infrastructure.output.jpa.repository.IPersonRepository;
import com.pragma.challenge.clean.infrastructure.output.mongodb.adapter.PictureMongodbAdapter;
import com.pragma.challenge.clean.infrastructure.output.mongodb.mapper.IPictureEntityMapper;
import com.pragma.challenge.clean.infrastructure.output.mongodb.repository.IPictureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPersonRepository personRepository;
    private final IPersonEntityMapper IPersonEntityMapper;

    private final IPictureRepository pictureRepository;
    private final IPictureEntityMapper IPictureEntityMapper;


    @Bean
    public IPersonPersistencePort personPersistencePort(){
        return new PersonJpaAdapter(personRepository, IPersonEntityMapper);
    }

    @Bean
    public IPersonServicePort personServicePort(){
        return new PersonUseCase(personPersistencePort());
    }

    @Bean
    public IPicturePersistencePort picturePersistencePort(){
        return new PictureMongodbAdapter(pictureRepository, IPictureEntityMapper);
    }

    @Bean
    public IPictureServicePort pictureServicePort(){
        return new PictureUseCase(picturePersistencePort());
    }


}
