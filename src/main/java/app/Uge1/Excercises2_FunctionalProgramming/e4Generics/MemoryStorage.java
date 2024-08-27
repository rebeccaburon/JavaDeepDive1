package app.Uge1.Excercises2_FunctionalProgramming.e4Generics;

import java.util.ArrayList;
import java.util.List;

public class MemoryStorage<T> implements DataStorage <T>{

    private List<T> storageList = new ArrayList<T>();
    @Override
    public String store(T data) {
        storageList.add(data);
        //String.format, konvertere fra String til int, %d står for et tal
        // String.valueOf, kan også bruges: reurn String.valueOf(storageList.size() - 1);
        return String.format("%d",storageList.size() - 1);
    }

    @Override
    public T retrieve(String source) {

        int index = Integer.parseInt(source);
        return storageList.get(index);
    }
}
