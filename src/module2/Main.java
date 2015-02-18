package module2;

import java.util.Date;

public class Main {

    public static void main(String[] args) {
        GenericRepository<Participants> usersRepository = new HashMapRepository<>();
        GenericRepository<Training> traningRepository = new SerializabelHashMapRepository<>("Training.txt");

        TrainingManager trainingManager = new TrainingManager(traningRepository, usersRepository);
        trainingManager.addParticipants(new Participants("Ziomeczek", "asdasd", "asdasd"));
        trainingManager.addTraining(new Training("Ziomeczkowy", new Date(), new Date(), 1000));
        trainingManager.assignUczestnikaToTraning(1L,1L);
        trainingManager.printReport();

        TrainingManager trainingManager2 = new TrainingManager(traningRepository, usersRepository);
        trainingManager2.addParticipants(new Participants("Ziomeczek2", "asdasd", "asdasd"));
        trainingManager2.addTraining(new Training("Ziomeczkowy2", new Date(), new Date(), 1000));
        trainingManager2.assignUczestnikaToTraning(1L,1L);
        trainingManager2.printReport();

        trainingManager2.exportTrainingToXml(1L, "Training.xml");

    }
}
