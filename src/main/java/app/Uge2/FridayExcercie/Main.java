package app.Uge2.FridayExcercie;

import app.Uge2.FridayExcercie.DAO.PackageDAO;
import app.Uge2.FridayExcercie.entities.GLSPackages;
import app.Uge2.FridayExcercie.persistence.HibernateConfig;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {



        PackageDAO packageDAO = new PackageDAO(HibernateConfig.getEntityManagerFactory());

        //Creat new package info.
        GLSPackages creatingPackages= new GLSPackages();
//        creatingPackages.setTrackingNumber("98654");
//        creatingPackages.setDeliveryStatus(GLSPackages.DeliveryStatus.IN_TRANSIT);
//        creatingPackages.setSenderName("Tom");
//        creatingPackages.setReciverName("Jerry");
//        creatingPackages.setLastUpdated(LocalDateTime.now());
//        packageDAO.create(creatingPackages);
//        System.out.println(creatingPackages);

        //Create with the builder from the lombok in entity:
//        packageDAO.create(
//                GLSPackages.builder()
//                        .trackingNumber("84595")
//                        .deliveryStatus(GLSPackages.DeliveryStatus.PENDING)
//                        .senderName("Helle")
//                        .reciverName("Oskar")
//                        .lastUpdated(LocalDateTime.now())
//                        .build()
//        );

        //Read excisting package:
//        packageDAO.getAll().forEach(System.out::println);


        //update
//        GLSPackages updateGLS = packageDAO.getById(4);
//        updateGLS.setSenderName("Peter");
//        packageDAO.update(updateGLS);
//        System.out.println(updateGLS);


        //delete
//        GLSPackages deletingPackages= packageDAO.getById(3);
//        packageDAO.delete(deletingPackages);
    }
}
