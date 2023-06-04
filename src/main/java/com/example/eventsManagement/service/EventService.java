package com.example.eventsManagement.service;

import java.util.List;

import com.example.eventsManagement.entity.Event;


public interface EventService {
	List<Event> getAllEvents();
	Event saveEvent(Event event);
	Event getEventById(Long Id);
	void deleteEventById(Long Id);
	Event updateEvent(Event event);
}
