package module2.db.Field;

import java.nio.ByteBuffer;

/**
 * Created by artur.mackowiak on 18/02/15.
 */
public class LongField implements Field<Long> {


    private ByteBuffer byteBuffer = ByteBuffer.allocate(getSize());

    @Override
    public int getSize() {
        return Long.BYTES;
    }

    @Override
    public byte[] toBytes(Long value) {
        return byteBuffer.putLong(value).array();
    }

    @Override
    public Long fromBytes(byte[] bytes) {
        return ByteBuffer.wrap(bytes).getLong();
    }
}
