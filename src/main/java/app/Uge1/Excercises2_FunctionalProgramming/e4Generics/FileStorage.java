package app.Uge1.Excercises2_FunctionalProgramming.e4Generics;

import java.io.*;

public class FileStorage<T> implements DataStorage<T> {

    @Override
    public String store(T data) {
        //  A unique filename is generated using the current time in milliseconds.
        String EmployeeStorage = "data_storage_" + System.currentTimeMillis() + ".dat";

        // The object is serialized using ObjectOutputStream and saved to the generated filename.
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(EmployeeStorage))) {
            if (data instanceof Employee) {
                //Serialize the object (using SerializableEmployee wrapper for Employee)
                SerializableEmployee serializableEmployee = new SerializableEmployee((Employee) data);
                oos.writeObject(serializableEmployee);
            } else {
                oos.writeObject(data);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        // The method returns the filename where the object is stored.
        return EmployeeStorage;
    }

    @Override
    public T retrieve(String source) {
        T data = null;
        // The object is deserialized using ObjectInputStream from the file with the given filename.
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(source))) {
            Object object = ois.readObject();
            // Deserialize the object
            if (object instanceof SerializableEmployee) {
                data = (T) ((SerializableEmployee) object).getEmployee();
            }else {
                data = (T) object;
            }
        } catch (ClassNotFoundException | IOException e) {
            e.printStackTrace();
        }
        // returns the deserialized object.
        return data;
    }
}
