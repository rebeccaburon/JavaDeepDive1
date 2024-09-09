package app.Uge2.FridayExcercie_Uge2OG3;

import app.Uge2.FridayExcercie_Uge2OG3.DAO.LocationDAO;
import app.Uge2.FridayExcercie_Uge2OG3.DAO.PackageDAO;
import app.Uge2.FridayExcercie_Uge2OG3.DAO.ShipmentDAO;
import app.Uge2.FridayExcercie_Uge2OG3.entities.Location;
import app.Uge2.FridayExcercie_Uge2OG3.entities.Packages;
import app.Uge2.FridayExcercie_Uge2OG3.entities.Shipment;
import app.Uge2.FridayExcercie_Uge2OG3.persistence.HibernateConfig;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {
        PackageDAO packageDAO = new PackageDAO(HibernateConfig.getEntityManagerFactory());
        LocationDAO locationDAO = new LocationDAO(HibernateConfig.getEntityManagerFactory());
        ShipmentDAO shipmentDAO = new ShipmentDAO(HibernateConfig.getEntityManagerFactory());

        Location sourceLocation = locationDAO.createSourceLocation(
                Location.builder()
                        .address("Østerbrogade 113")
                        .latitude(55.78)
                        .longitude(12.456)
                        .build()
        );
        Location destionationLocation = locationDAO.createDestionationLocation(
                Location.builder()
                        .address("Estersvej 34")
                        .latitude(33.73)
                        .longitude(36.89)
                        .build()
        );


        Packages package1 = packageDAO.create(
                Packages.builder()
                        .trackingNumber("84595")
                        .deliveryStatus(Packages.DeliveryStatus.PENDING)
                        .senderName("Helle")
                        .reciverName("Oskar")
                        .lastUpdated(LocalDateTime.now())
                        .build()
        );

        Shipment shipment = shipmentDAO.createShipment(
                Shipment.builder()
                        .packages(package1)
                        .sourcesLocation(sourceLocation)
                        .destinationsLocation(destionationLocation)
                        .shipmentDateTime(LocalDateTime.now())
                        .build()
        );

        sourceLocation.addSourcesLocation(shipment);
        locationDAO.updateLocation(sourceLocation);

        destionationLocation.addDestinationLocation(shipment);
        locationDAO.updateLocation(destionationLocation);

        package1.addShipment(shipment);
        packageDAO.update(package1);


        /***  GLS Package Tracking System - Part 1
         * This main is connected to the Friday Assignment:  GLS Package Tracking System - Part 1
         * Scenario
         * GLS (Global Logistics Services) wants to develop a package tracking system to manage the delivery of packages.
         * As part of the initial phase, they need to create a basic system using Java, JPA, and JPQL to manage package information.
         * This exercise should provide a solid foundation for understanding JPA (ORM) and JPQL in the context of building a package tracking system.
         */
//        PackageDAO packageDAO = new PackageDAO(HibernateConfig.getEntityManagerFactory());

        //Creat new package info.
//        Packages creatingPackages= new Packages();
//        creatingPackages.setTrackingNumber("98654");
//        creatingPackages.setDeliveryStatus(Packages.DeliveryStatus.IN_TRANSIT);
//        creatingPackages.setSenderName("Tom");
//        creatingPackages.setReciverName("Jerry");
//        creatingPackages.setLastUpdated(LocalDateTime.now());
//        packageDAO.create(creatingPackages);
//        System.out.println(creatingPackages);

        //Create with the builder from the lombok in entity:
//        packageDAO.create(
//                Packages.builder()
//                        .trackingNumber("84595")
//                        .deliveryStatus(Packages.DeliveryStatus.PENDING)
//                        .senderName("Helle")
//                        .reciverName("Oskar")
//                        .lastUpdated(LocalDateTime.now())
//                        .build()
//        );

        //Read excisting package:
//        packageDAO.getAll().forEach(System.out::println);


        //update
//        Packages updateGLS = packageDAO.getById(4);
//        updateGLS.setSenderName("Peter");
//        packageDAO.update(updateGLS);
//        System.out.println(updateGLS);


        //delete
//        Packages deletingPackages= packageDAO.getById(3);
//        packageDAO.delete(deletingPackages);
    }
}
