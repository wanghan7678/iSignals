package com.igroup.signals.trial.HanWang.controler;

import com.igroup.signals.trial.HanWang.model.Prediction;
import com.igroup.signals.trial.HanWang.model.Signals;
import com.igroup.signals.trial.HanWang.service.PredictionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/predictions")
public class PredictionResource
{
    @Autowired
    private final PredictionService predictionService;


    public PredictionResource(PredictionService predictionService) {
        this.predictionService = predictionService;
    }

    @GetMapping("/{tscode}")
    public ResponseEntity<List<Prediction>> getPredictionByDate(@PathVariable("tscode") String tsCode) throws Exception
    {
        LocalDate today = LocalDate.now();
        List<Prediction> predictions = predictionService.getPredictionByDate(tsCode, today);
        return new ResponseEntity<>(predictions, HttpStatus.OK);
    }
}
