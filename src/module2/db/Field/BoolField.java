package module2.db.Field;

import java.util.Arrays;

/**
 * Created by artur.mackowiak on 18/02/15.
 */
public class BoolField implements Field<Boolean> {

    private static int SIZE = 1;

    private static byte[] TRUE_VALUE = {1};
    private static byte[] FALSE_VALUE = {0};

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public byte[] toBytes(Boolean value) {
        return value ? TRUE_VALUE : FALSE_VALUE;
    }

    @Override
    public Boolean fromBytes(byte[] bytes) {
        return Arrays.equals(bytes, TRUE_VALUE);
    }
}
