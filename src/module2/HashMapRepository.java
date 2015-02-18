package module2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashMapRepository<EntityType extends Entity> implements GenericRepository<EntityType> {

    private Map<Long, EntityType> storage = new HashMap<>();
    private long nextId;

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
