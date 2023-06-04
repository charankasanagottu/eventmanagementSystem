package com.example.eventsManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.eventsManagement.entity.Event;

//@Repository as jpa inbuilt had it 
public interface EventRepository extends JpaRepository<Event,Long>{

}
