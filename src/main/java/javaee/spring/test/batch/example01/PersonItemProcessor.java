package javaee.spring.test.batch.example01;

import javaee.spring.test.pojo.Person;

import org.springframework.batch.item.ItemProcessor;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {
	 
    public Person process(final Person person) throws Exception {
        final String firstName = person.getFirstName().toUpperCase();
        final String lastName = person.getLastName().toUpperCase();
        final Person transformedPerson = new Person(firstName, lastName);
        System.out.println("Converting (" + person + ") into ("
                + transformedPerson + ")");
        return transformedPerson;
    }
 
}