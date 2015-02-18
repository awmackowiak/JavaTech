package module2.db;

import module2.db.Field.Field;
import module2.db.Field.LongField;

import java.util.*;

/**
 * Created by artur.mackowiak on 18/02/15.
 */

public class Record {

    public static final String ID = "id";
    private Map<String, Field> columns = new LinkedHashMap<>();
    private Map<String, byte[]> values = new LinkedHashMap<>();

    private boolean deleted;
    private List<Field> fields = new ArrayList<>();
//    private int size = 1;

    public Record() {
        columns.put(ID, new LongField());
    }

    public void addColumn(String name, Field field) {
        if(!ID.equals(name)) {
            columns.put(name, field);
        }
    }

    public void setValue(String name, byte[] value) {
        if(!columns.containsKey(name)) {
            throw new IllegalArgumentException();
        }
        values.put(name, value);
    }


    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }

    public byte[] toBytes() {
        byte[] result = new byte[getSize()];
        int index = 0;
        for (Map.Entry<String, Field> entry : columns.entrySet()) {
            byte[] fieldBytes = values.get(entry.getKey());
            Field curentField = entry.getValue();
            System.arraycopy(fieldBytes, 0, result, index, curentField.getSize());
            index += curentField.getSize();
        }
        return result;
    }

    public int getSize() {
        int size = 0;
        for(Field field : columns.values()) {
            size += field.getSize();
        }
        return size;
    }

}
