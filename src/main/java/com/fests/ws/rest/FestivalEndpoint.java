package com.fests.ws.rest;

import com.fests.domain.Festival;
import com.fests.repository.BandRepository;
import com.fests.repository.FestivalRepository;
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
@RequestMapping("/rest/festivals")
public class FestivalEndpoint {

    @Autowired
    private FestivalRepository festivalRepository;

    @Autowired
    private FestivalService festivalService;

    @Autowired
    private BandRepository bandRepository;

    //post festivals
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createFestival(@RequestBody Festival festival) {
        //Breach cBreach = breachRepository.findOne(breachId);
        //List<Breach> createdBreach = new ArrayList<>();
        //createdBreach.add(cBreach);
        //festivals.setBreaches(createdBreach);
        Festival createdFestival = festivalService.createFestival(festival);


        URI location = URI.create("/rest/festivals/" + createdFestival.getId());
        return ResponseEntity.created(location).body(createdFestival.getId());
    }


    //get festivals
    @RequestMapping(value = "{festivalId}", method = RequestMethod.GET)
    public Festival retrieveFestival(@PathVariable Long festivalId){
        Festival festival = festivalRepository.findOne(festivalId);
        return festival;
    }

    //delete festivals
    @RequestMapping(value = "{festivalId}", method = RequestMethod.DELETE)
    public ResponseEntity<?> deleteFestival(@PathVariable Long festivalId){
        Festival deletedFestival =  festivalRepository.findOne(festivalId);
        festivalRepository.delete(deletedFestival);

        return ResponseEntity.noContent().build();
    }
    //get all exclusions
    @RequestMapping(method = RequestMethod.GET)
    public List<Festival> retrieveAllFestivals(){
        return festivalRepository.findAll();
    }

    //update festivals
    @RequestMapping(value = "{festivalId}", method = RequestMethod.PUT)
    public ResponseEntity<?> updateFestival(@PathVariable Long festivalId, @RequestBody Festival festival){
        Festival existingFestival = festivalRepository.findOne(festivalId);
        existingFestival.setName(festival.getName());
        existingFestival.setLocation(festival.getLocation());

        festivalService.createFestival(existingFestival);
        URI location = URI.create("/rest/festivals/" + existingFestival.getId());
        return ResponseEntity.created(location).build();
    }
}

