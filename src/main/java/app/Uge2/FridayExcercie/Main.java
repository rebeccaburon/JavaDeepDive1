package app.Uge2.FridayExcercie;

import app.Uge2.FridayExcercie.DAO.PackageDAO;
import app.Uge2.FridayExcercie.entities.GLSPackages;

import java.time.LocalDateTime;

public class Main {
    public static void main(String[] args) {


        GLSPackages packages = new GLSPackages();
        PackageDAO packageDAO = new PackageDAO();

        //Creat new package info.
        packages.setTrackingNumber("342564");
        packages.setDeliveryStatus(GLSPackages.DeliveryStatus.PENDING);
        packages.setSenderName("Hans");
        packages.setReciverName("Henrik");
        packages.setLastUpdated(LocalDateTime.now());
        packageDAO.create(packages);
        System.out.println(packages);

        //Read excisting package:
        packageDAO.getAll().forEach(System.out::println);


        //update

        //delete
    }
}
