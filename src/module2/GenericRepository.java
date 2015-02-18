package module2; /**
 * Created by artur.mackowiak on 17/02/15.
 */
import java.util.List;

public interface GenericRepository<EntityType extends Entity> {

    EntityType add(EntityType entityType);
    EntityType getById(Long id);
    List<EntityType> getAll();

}