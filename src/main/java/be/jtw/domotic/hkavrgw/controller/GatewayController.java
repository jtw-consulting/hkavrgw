package be.jtw.domotic.hkavrgw.controller;

import be.jtw.domotic.hkavrgw.request.Harman;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by julien on 31/03/2018.
 */
@RestController
public class GatewayController {


    //TODO implement keep-alive to avoid sleep
    //TODO implement REST client with 2-sec timeout

    @RequestMapping(method = RequestMethod.GET, path = "/command", produces = MediaType.APPLICATION_XML_VALUE)
    public ResponseEntity command(@RequestParam(value = "name", defaultValue = "radio") String name) {
        Harman harman = new Harman();
        Harman.Avr avr = new Harman.Avr();
        Harman.Common common = new Harman.Common();
        Harman.Control control = new Harman.Control();

        common.setControl(control);
        avr.setCommon(common);
        harman.setAvr(avr);

        control.setZone("Main zone");
        control.setName("source-selection");
        control.setPara("audio");

        return new ResponseEntity(harman,HttpStatus.OK);
    }
}
