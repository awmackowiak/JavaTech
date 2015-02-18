package module2.db.Field;

import java.util.Arrays;

/**
 * Created by artur.mackowiak on 18/02/15.
 */
public class TextField implements Field<String> {

    private static final int SIZE = 16 * 255;

    @Override
    public int getSize() {
        return SIZE;
    }

    @Override
    public byte[] toBytes(String value) {
        return Arrays.copyOf(value.getBytes(), SIZE);
    }

    @Override
    public String fromBytes(byte[] bytes) {
        return new String(bytes);
    }
}
