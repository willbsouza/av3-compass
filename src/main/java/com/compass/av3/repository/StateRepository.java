package com.compass.av3.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.compass.av3.entity.State;

@Repository
public interface StateRepository extends JpaRepository<State, Long>{
}
