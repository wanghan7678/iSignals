package com.igroup.signals.trial.HanWang.controler;

import com.igroup.signals.trial.HanWang.model.Signals;
import com.igroup.signals.trial.HanWang.service.SignalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/signals")
public class SignalsResource {

    @Autowired
    private final SignalService signalService;

    public SignalsResource(SignalService signalService) {
        this.signalService = signalService;
    }

    @GetMapping("/{tscode}")
    public ResponseEntity<List<Signals>> getLastSignalsByTsCode(@PathVariable("tscode") String tsCode) throws Exception
    {
        List<Signals> signals = signalService.findSignalsByCodeLastDay(tsCode);
        return new ResponseEntity<>(signals, HttpStatus.OK);
    }
}
