package com.example.eventsManagement.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.eventsManagement.entity.Event;
import com.example.eventsManagement.repository.EventRepository;
import com.example.eventsManagement.service.EventService;

@Service
public class EventServiceImpl implements EventService {
private EventRepository eventrepository; 
	
	
	public EventServiceImpl(EventRepository eventrepository) {
		super();
		this.eventrepository = eventrepository;
	}



	@Override
	public Event updateEvent(Event event) {
		// TODO Auto-generated method stub
		return eventrepository.save(event);
	}


	@Override
	public List<Event> getAllEvents() {
		// TODO Auto-generated method stub
		return eventrepository.findAll();
	}


	@Override
	public Event saveEvent(Event event) {
		// TODO Auto-generated method stub
		return eventrepository.save(event);
	}


	@Override
	public Event getEventById(Long Id) {
		// TODO Auto-generated method stub
		return eventrepository.findById(Id).get();
	}


	@Override
	public void deleteEventById(Long Id) {
		// TODO Auto-generated method stub
		eventrepository.deleteById(Id);
	}
	
}
