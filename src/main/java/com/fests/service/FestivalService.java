package com.fests.service;

import com.fests.domain.Festival;
import com.fests.repository.FestivalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by gatomulesei on 2/27/2017.
 */
@Transactional
@Service("festivalService")
public class FestivalService {

    @Autowired
    private FestivalRepository festivalRepository;

    public Festival createFestival(Festival festival) {
        return festivalRepository.save(festival);
    }

}