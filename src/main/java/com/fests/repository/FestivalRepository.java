package com.fests.repository;

import com.fests.domain.Festival;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by gatomulesei on 2/27/2017.
 */
public interface FestivalRepository extends JpaRepository<Festival, Long>{
}
