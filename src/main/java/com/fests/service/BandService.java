package com.fests.service;

import com.fests.domain.Band;
import com.fests.repository.BandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gatomulesei on 2/27/2017.
 */
@Transactional
@Service("bandService")
public class BandService {

    @Autowired
    private BandRepository bandRepository;

    public Band createBand(Band band){
        return bandRepository.save(band);
    }

}
