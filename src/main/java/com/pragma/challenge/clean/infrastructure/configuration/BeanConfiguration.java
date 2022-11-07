package com.pragma.challenge.clean.infrastructure.configuration;

import com.pragma.challenge.clean.domain.api.IPersonServicePort;
import com.pragma.challenge.clean.domain.spi.IPersonPersistencePort;
import com.pragma.challenge.clean.domain.usecase.PersonUseCase;
import com.pragma.challenge.clean.infrastructure.output.jpa.adapter.PersonJpaAdapter;
import com.pragma.challenge.clean.infrastructure.output.jpa.mapper.PersonEntityMapper;
import com.pragma.challenge.clean.infrastructure.output.jpa.repository.IPersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@RequiredArgsConstructor
public class BeanConfiguration {

    private final IPersonRepository personRepository;
    private final PersonEntityMapper personEntityMapper;


    @Bean
    public IPersonPersistencePort personPersistencePort(){
        return new PersonJpaAdapter(personRepository, personEntityMapper);
    }

    @Bean
    public IPersonServicePort personServicePort(){
        return new PersonUseCase(personPersistencePort());
    }




}
