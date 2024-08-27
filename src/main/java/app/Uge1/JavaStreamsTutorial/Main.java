package app.Uge1.JavaStreamsTutorial;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        List<Person> people = getPeople();

        /**  Imperative approach ❌
         * Definere hvert step, man gerne vil opnå
         */
//
//        List<Person> femalesList = new ArrayList<>();
//        for (Person person : people) {
//            if (person.getGender().equals(Gender.FEMALE)) {
//                femalesList.add(person);
//            }
//        }
//        femalesList.forEach(System.out::println);

        /** Declarative approach ✅
         * I Stream API er der blandt andet : Filter, Sort, All match, Any match, None match, Max, Min, Group:
         *
         */

        /** Filter
         *
         */
        List<Person> femalesList = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                //make a new list = Collect a list:
                .collect(Collectors.toList());
//        femalesList.forEach(System.out::println);

        /** Sort
         * It can be sorted reversed by adding .reversed() after getAge!
         * Man kan også ændre sammenligningen ved at tilføje .thenComparing(Person::get.Gender)
         */
        List<Person> sorted = people.stream()
                .sorted(Comparator.comparing(Person::getAge))
                .collect(Collectors.toList());
        //sorted.forEach(System.out::println);
/***
 * Det er også muligt at stille spørgsmål til kollektionen,
 * og det er her All match, Any match eller None match bliver brugt.
 */
        /** All match
         * "Finde ud af om alle i listen har en alder der er større end 5"
         * It will be either true or falses
         * Afhængig af hvilken condition det bliver smidt i parameteren.
         */
        boolean allMatch = people.stream()
                .allMatch(person -> person.getAge() > 8);
       // System.out.println(allMatch);

        /** Any match
         * It will be either true or false.
         * Ligesom i All match afhænger svaret af hvilken condition det bliver smidt i parameteren.
         */

        boolean anyMatch = people.stream()
                .anyMatch(person -> person.getAge() > 8);
        //System.out.println(anyMatch);

        /** None match
         * Det modsatte af Any match er None match
         * true eller false
         * Her kan man fx spørge om der er et navn eller lign i en liste, som ikke matcher
         */
        boolean noneMatch = people.stream()
                .noneMatch(person -> person.getName().equals("Rebecca"));
        //System.out.println(noneMatch);

        /** Max
         * Her kan man fx spørge om max værdien i kollektionen, fx Finde personen
         * som har Max alderen
         * Optional = det finder måske ikke max værdien i denne kollektion
         */
//        Optional <Person> max = people.stream()
//                .max(Comparator.comparing(Person::getAge));
//        System.out.println(max);

        /**
         *  Man kan også bruge ifPresent i stedet for optional:
         */

        people.stream()
                .max(Comparator.comparing(Person::getAge));
               // .ifPresent(System.out::println);

        /** Min
         * Man kan gøre det på samme måde med min:
         */
        people.stream()
                .min(Comparator.comparing(Person::getAge));
              //  .ifPresent(System.out::println);
        /** Group
         * Med Group kan man gruppere den kollektion man har
         * Et eksempel kunne være at man gerne ville gruppere udfra køn
         * Her skal der bruges et Map med et køn og en liste af hver køn
         * og så en liste for den person within each køn
         *
         * Det er en Map med typen Gender og hertil en liste med Personer
         */
        Map<Gender, List<Person>> groupByGender = people.stream()
                .collect(Collectors.groupingBy(Person::getGender));
//        groupByGender.forEach((gender, people1) -> {
//            System.out.println(gender);
//            people1.forEach(System.out::println);
//        });

        /** Chain Strams
         * Ved brugen af Streams har man mulighed for at "chain" dem sammen
         * "Find ud af hvad den ældeste female hedder og returne navnet"
         */
        Optional<String> nameForOldesFemale = people.stream()
                .filter(person -> person.getGender().equals(Gender.FEMALE))
                .max(Comparator.comparing(Person::getAge))
                .map(Person::getName);
        nameForOldesFemale.ifPresent(System.out::println);

    }

    private static List<Person> getPeople() {
        return List.of(
                new Person("Lukas Zeimer", 20, Gender.MALE),
                new Person("Alina Smith", 33, Gender.FEMALE),
                new Person("Helen White", 57, Gender.FEMALE),
                new Person("Alex Boz", 14, Gender.MALE),
                new Person("Rebecca", 99, Gender.FEMALE),
                new Person("Anna Cook", 7, Gender.FEMALE),
                new Person("Zelda Brown", 120, Gender.FEMALE)
        );
    }

}