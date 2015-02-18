package module2;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by artur.mackowiak on 17/02/15.
 */
public class TrainingManager {

    private GenericRepository<Training> trainingsRepository;
    private GenericRepository<Participants> uczestnikRepository;

    public TrainingManager(GenericRepository<Training> trainingsRepository,
                           GenericRepository<Participants> uczestnikRepository) {
        this.trainingsRepository = trainingsRepository;
        this.uczestnikRepository = uczestnikRepository;
    }

    public void addTraining(Training training) {
        trainingsRepository.add(training);
    }

    public void addParticipants(Participants participants) {
        uczestnikRepository.add(participants);
    }

    public void assignUczestnikaToTraning(Long uczestnikId, Long traningId) {
//        Uczestnik uczestnik = uczestnikRepository.getById(uczestnikId);
//        Traning traning = trainingsRepository.getById(uczestnikId);
//        traning.addParticipants(uczestnik);
        Participants participants = uczestnikRepository.getById(uczestnikId);
        trainingsRepository.getById(traningId).addParticipants(participants);


    }

    public List<Training> getAllTrainings() {
        return trainingsRepository.getAll();
    }

    public List<Participants> getAllUczestnik() {
        return uczestnikRepository.getAll();
    }

    public void printReport() {
        List<Training> tranings = trainingsRepository.getAll();
        for(Training traning : tranings) {
            System.out.println(traning.toString());
        }
    }

    public void exportTrainingToXml(Long trainingId, String fileName) {
        Training training = trainingsRepository.getById(trainingId);
        if(training != null) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Training.class);
                Marshaller marshaller = jaxbContext.createMarshaller();
                marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
                marshaller.marshal(training, new File(fileName));
            } catch (JAXBException e) {
                Logger.getLogger(TrainingManager.class.getName())
                        .log(Level.SEVERE, "Blad exportu pliku xml: " + fileName);
//                e.printStackTrace();
            }
        }
    }


}
