package br.com.FelipeBarboz.services;

import br.com.FelipeBarboz.data.dto.PersonDto;
import br.com.FelipeBarboz.exception.ResourceNotFoundException;
import static br.com.FelipeBarboz.mapper.ObjectMapper.parseListObjects;
import static br.com.FelipeBarboz.mapper.ObjectMapper.parseObject;
import br.com.FelipeBarboz.model.Person;
import br.com.FelipeBarboz.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
//import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Logger;

@Service
public class PersonService {

    //private final AtomicLong counter = new AtomicLong();
    private Logger logger = Logger.getLogger(PersonService.class.getName());

    @Autowired
    PersonRepository repository;

    public List<PersonDto> findAll() {

        logger.info("Finding all people!");

        return parseListObjects(repository.findAll(), PersonDto.class);
    }

    public PersonDto findById(Long id) {
        logger.info("Finding one person!");

        var entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        return parseObject(entity, PersonDto.class);
    }

    public PersonDto create(PersonDto person) {
        logger.info("Creating one person!");
        var entity = parseObject(person, Person.class);

        return parseObject(repository.save(entity), PersonDto.class);
    }

    public PersonDto update(PersonDto person) {

        logger.info("Updating one person!");

        Person entity = repository.findById(person.getId())
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));
        entity.setFirstName(person.getFirstName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());

        return parseObject(repository.save(entity), PersonDto.class);
    }

    public void delete(Long id) {

        logger.info("Deleting one person!");

        Person entity = repository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("No records found for this ID!"));

        repository.delete(entity);
    }
}
