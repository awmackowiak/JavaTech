package module2;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class SerializabelHashMapRepository<EntityType extends Entity> implements GenericRepository<EntityType> {

    private Map<Long, EntityType> storage;
    private long nextId;

    public SerializabelHashMapRepository(final String fileName){
        try(
                FileInputStream fileInputStream = new FileInputStream(fileName);
                ObjectInputStream objectInput = new ObjectInputStream(fileInputStream)
        ) {
            storage = (Map<Long, EntityType>) objectInput.readObject();
        } catch (FileNotFoundException e) {
                storage  = new HashMap<>();
        } catch (IOException | ClassNotFoundException e) {
            Logger.getLogger(SerializabelHashMapRepository.class.getName())
                    .log(Level.SEVERE, "Blad odczytu: " + fileName);
        }

        Runtime.getRuntime().addShutdownHook(new Thread() {
            //Tutaj robimy myk ze przy zamkniecu programu on zapisze do pliku wszystkie dane
            //Dokladnie zrobi to maszyna wirtualna
            @Override
            public void run() {
                try(FileOutputStream fos = new FileOutputStream(fileName);
                ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                    oos.writeObject(storage);
                } catch (IOException e) {
                    Logger.getLogger(SerializabelHashMapRepository.class.getName())
                            .log(Level.SEVERE, "Blad zapisu: " + fileName);
                }
            }
        });

    }

    @Override
    public EntityType add(EntityType entityType) {
        nextId++;
        entityType.setId(nextId);
        storage.put(nextId, entityType);
        return entityType;
    }

    @Override
    public EntityType getById(Long id) {
        return storage.get(id);
    }

    @Override
    public List<EntityType> getAll() {
        return new ArrayList<>(storage.values());
    }


}
