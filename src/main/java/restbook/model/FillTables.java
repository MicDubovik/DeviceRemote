package restbook.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import restbook.repository.DeviceRepo;
import restbook.repository.KeywordRepo;

@Component
public class FillTables implements CommandLineRunner {

    DeviceRepo deviceRepo;

    KeywordRepo keywordRepo;

    @Autowired
    public FillTables(DeviceRepo deviceRepo, KeywordRepo keywordRepo) {
        this.deviceRepo = deviceRepo;
        this.keywordRepo = keywordRepo;
    }

    @Override
    public void run(String... strings) throws Exception {

        Device device = new Device("bulb");
        Device device2 = new Device("burner");
        Device device3 = new Device("amplifer");
        Device device4 = new Device("toster");

        if (deviceRepo.findAll()==null){
            deviceRepo.saveAndFlush(device);
            deviceRepo.saveAndFlush(device2);
            deviceRepo.saveAndFlush(device3);
            deviceRepo.saveAndFlush(device4);

            keywordRepo.saveAndFlush(new Keyword("light",true, device));
            keywordRepo.saveAndFlush(new Keyword("dark",false, device));
            keywordRepo.saveAndFlush(new Keyword("light",true, device2));
            keywordRepo.saveAndFlush(new Keyword("dark",false, device2));
            keywordRepo.saveAndFlush(new Keyword("turn on",true, device3));
            keywordRepo.saveAndFlush(new Keyword("turn off",false, device3));
            keywordRepo.saveAndFlush(new Keyword("turn on",true, device4));
            keywordRepo.saveAndFlush(new Keyword("turn off",false, device4));
        }

    }
}
