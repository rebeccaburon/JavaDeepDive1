package app.Uge3.Relations_Thomas_example;

import app.Uge3.Relations_Thomas_example.dao.DAOimpl;
import app.Uge3.Relations_Thomas_example.entities.Adress;
import app.Uge3.Relations_Thomas_example.entities.Emloyee;
import app.Uge3.Relations_Thomas_example.persistence.HibernateConfig;

public class Main {
    public static void main(String[] args) {
        DAOimpl dao = new DAOimpl(HibernateConfig.getEntityManagerFactory());
        Emloyee emloyee = Emloyee.builder()
                .name("Susanne")
                .build();

        Adress adrs = Adress.builder()
                .street("Østerbrogade")
                .build();
        adrs.addEmployee(emloyee);
        dao.create(emloyee);

        Emloyee found = dao.getById(1);
        found.setName("Sarah");
        dao.update(found);
    }
}
