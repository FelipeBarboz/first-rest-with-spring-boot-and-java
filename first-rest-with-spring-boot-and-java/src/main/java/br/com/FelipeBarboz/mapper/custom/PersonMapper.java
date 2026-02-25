package br.com.FelipeBarboz.mapper.custom;

import br.com.FelipeBarboz.data.dto.v2.PersonDtoV2;
import br.com.FelipeBarboz.model.Person;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonMapper {

    public PersonDtoV2 convertEntityToDto(Person person){
        PersonDtoV2 dto = new PersonDtoV2();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        dto.setBirthday(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return dto;
    }

    public Person convertDtoToEntity(PersonDtoV2 person){
        Person dto = new Person();

        dto.setId(person.getId());
        dto.setFirstName(person.getFirstName());
        dto.setLastName(person.getLastName());
        // dto.setBirthday(new Date());
        dto.setAddress(person.getAddress());
        dto.setGender(person.getGender());

        return dto;
    }
}
