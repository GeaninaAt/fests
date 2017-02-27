package com.fests.ws.rest;

import com.fests.domain.Band;
import com.fests.domain.Festival;
import com.fests.repository.BandRepository;
import com.fests.repository.FestivalRepository;
import com.fests.service.BandService;
import com.fests.service.FestivalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

/**
 * Created by gatomulesei on 2/27/2017.
 */
@RestController
@RequestMapping("/rest/bands")
public class BandEndpoint {

    @Autowired
    BandRepository bandRepository;

    @Autowired
    BandService bandService;

    @Autowired
    FestivalService festivalService;

    @Autowired
    FestivalRepository festivalRepository;

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createBand(@RequestBody Band band, @RequestParam Long festivalId){
        Festival festival = festivalRepository.findOne(festivalId);
        band.setFestival(festival);
        Band bd = bandService.createBand(band);


        URI location = URI.create("/rest/bands" + bd.getId());
        return ResponseEntity.created(location).body(bd.getId());
    }

    @RequestMapping(method = RequestMethod.GET)
    public List<Band> retrieveAallBands(){
        return bandRepository.findAll();
    }

    @RequestMapping(value = "{bandId}", method = RequestMethod.GET)
    public Band retrieveBand(@PathVariable Long bandId){
        Band band = bandRepository.findOne(bandId);
        return band;
    }


}
