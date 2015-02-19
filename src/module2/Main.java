package module2;

import module2.db.Field.Field;
import module2.db.Field.IntField;
import module2.db.Field.LongField;
import module2.db.Field.TextField;
import module2.db.FlatFile;
import module2.db.Record;

import java.io.IOException;
import java.util.Date;

public class Main {

    public enum Columns {
        FIRSTNAME,
        LASTNAME
    }

    public static void main(String[] args) throws IOException {
//        GenericRepository<Participants> usersRepository = new HashMapRepository<>();
//        GenericRepository<Training> traningRepository = new SerializabelHashMapRepository<>("Training.txt");
//
//        TrainingManager trainingManager = new TrainingManager(traningRepository, usersRepository);
//        trainingManager.addParticipants(new Participants("Ziomeczek", "asdasd", "asdasd"));
//        trainingManager.addTraining(new Training("Ziomeczkowy", new Date(), new Date(), 1000));
//        trainingManager.assignUczestnikaToTraning(1L,1L);
//        trainingManager.printReport();
//
//        TrainingManager trainingManager2 = new TrainingManager(traningRepository, usersRepository);
//        trainingManager2.addParticipants(new Participants("Ziomeczek2", "asdasd", "asdasd"));
//        trainingManager2.addTraining(new Training("Ziomeczkowy2", new Date(), new Date(), 1000));
//        trainingManager2.assignUczestnikaToTraning(1L,1L);
//        trainingManager2.printReport();
//
//        trainingManager2.exportTrainingToXml(1L, "Training.xml");

        Record record = new Record();

        LongField longField = new LongField();
        TextField textField = new TextField();

        record.addColumn(Columns.FIRSTNAME.name(), textField);
        record.addColumn(Columns.LASTNAME.name(), textField);
        //------------------------------------

        record.setValue(Record.ID, longField.toBytes(1L));
        record.setValue(Columns.FIRSTNAME.name(), textField.toBytes("Artur"));
        record.setValue(Columns.LASTNAME.name(), textField.toBytes("Mackowiak"));

        FlatFile flatFile = new FlatFile("Database.db", record);

        flatFile.addRecord(record);
        flatFile.getRecordsPositions();

        flatFile.close();

    }
}
