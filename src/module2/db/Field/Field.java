package module2.db.Field;

/**
 * Created by artur.mackowiak on 18/02/15.
 */

public interface Field<Type> {

    int getSize();
    byte[] toBytes(Type value);
    Type fromBytes(byte[] bytes);

}
