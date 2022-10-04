package com.example.repository;

import com.example.dto.IFacilityDto;
import com.example.model.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public interface IFacilityRepository extends JpaRepository<Facility, Integer> {

    Facility findById(int id);

    @Query(value = "select * from facility where `name` like %:key% and is_delete = 0 ", nativeQuery = true)
    Page<Facility>  findAllByQuery(@Param("key") String name, Pageable pageable);

//    @Query(value = "select * from facility where name like %:nameSearch% and is_delete = false",
//            nativeQuery = true)
//    Page<Facility> searchFacility(@Param("nameSearch") String nameSearch, Pageable pageable);

    @Modifying
    @Query(value = "update facility set is_delete = 1 where id = :idDelete", nativeQuery = true)
    void deleteLogical(@Param("idDelete") int id);

    @Query(value = "select id as idDto ,name as nameDto from facility where is_delete = 0",nativeQuery = true)
    List<IFacilityDto> findIdNameDto();
}
