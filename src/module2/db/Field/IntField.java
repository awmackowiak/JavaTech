package module2.db.Field;

import java.nio.ByteBuffer;

/**
 * Created by artur.mackowiak on 18/02/15.
 */

public class IntField implements Field<Integer> {

    private ByteBuffer byteBuffer = ByteBuffer.allocate(getSize());

    @Override
    public int getSize() {
        return Integer.BYTES;
    }

    @Override
    public byte[] toBytes(Integer value) {
        return byteBuffer.putInt(value).array();
    }

    @Override
    public Integer fromBytes(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getInt();
    }
}
