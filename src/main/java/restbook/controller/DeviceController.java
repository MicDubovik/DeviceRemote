package restbook.controller;

import com.sun.deploy.net.HttpResponse;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import restbook.model.Device;
import restbook.model.Keyword;
import restbook.repository.DeviceRepo;
import restbook.repository.KeywordRepo;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "api/books")
public class DeviceController {

    DeviceRepo deviceRepo;

    KeywordRepo keywordRepo;

    @Autowired
    public DeviceController(DeviceRepo deviceRepo, KeywordRepo keywordRepo) {
        this.deviceRepo = deviceRepo;
        this.keywordRepo = keywordRepo;
    }

    @RequestMapping(value = "/set", method = RequestMethod.POST ,produces = "application/json")
    public List<String> setValue(@RequestBody String device )  {

        String value = null;

        List<String> stringList = new ArrayList<>();

        Device selectDevice = deviceRepo.findByName(device);

        if(selectDevice == null){
              value = "not found device ";
              stringList.add(value);
          return stringList;
        }

        List<Keyword> keywords = keywordRepo.findAllByDevice(selectDevice);

        for (Keyword keyword : keywords) {
            if (selectDevice.isconditions() == keyword.isOff()) {
                value = keyword.getName();
                break;

            }
        }

        deviceRepo.updateDevice(!selectDevice.isconditions(), selectDevice.getName());

        String resp = selectDevice.getName() + " is " + value;

        stringList.add(resp);

            return stringList;
    }


}