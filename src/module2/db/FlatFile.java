package module2.db;

import java.io.File;

import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FlatFile {

    private RandomAccessFile dbFile;
    private Record record;
    private Map<Long, Long> recordsPositions = new HashMap<>();

    public FlatFile(String fileName, Record record) throws IOException {
        File file = new File(fileName);
        if (!file.exists()) {
            file.createNewFile();
        }
        dbFile = new RandomAccessFile(file, "rw");
        this.record = record;
    }

    public void getRecordsPositions() {
        try {
            dbFile.seek(0L);
            long position = dbFile.getFilePointer();
            while(true) {
                Long id = dbFile.readLong();
                recordsPositions.put(id, position);
                position += record.getSize();
                dbFile.seek(position);
            }
        } catch (IOException e) {
            Logger.getLogger(FlatFile.class.getName()).log(Level.WARNING, "EOF");
        }
        System.out.println(recordsPositions);
    }

    public void close() throws IOException {
        dbFile.close();
    }

    public void addRecord(Record record) throws IOException {
        dbFile.seek(dbFile.length());
        dbFile.write(record.toBytes());
    }

//    public Record getRecord(Long id) {
//        Long position = recordsPositions.get(id);
//        if(position != null ) {
//            try {
//                dbFile.seek(position);
//                byte[] result = new byte[record.getSize()];
//                dbFile.read(result);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }

}
