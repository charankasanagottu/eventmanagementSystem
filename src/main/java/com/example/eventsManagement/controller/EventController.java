package com.example.eventsManagement.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.eventsManagement.entity.Event;
import com.example.eventsManagement.service.EventService;


@Controller
public class EventController {
	private EventService service;

	public EventController(EventService service) {
		super();
		this.service = service;
	}
	
//	handler method to handle list students request and return mode and view 
	@GetMapping("/")
	public String listEvents(Model model) {
		model.addAttribute("events",service.getAllEvents());
		return "events";
	}
	
	@GetMapping("/events/new")
	public String createStudentForm(Model model) {
		
		Event event = new Event();
		model.addAttribute("event",event);
		return "create_event";
	}
	
	@PostMapping("/")
	public String saveEvent(@ModelAttribute("event") Event event)
	{
		service.saveEvent(event);
		
		return "redirect:/";
	}
	@GetMapping("/events/edit/{id}")
	public String editStudentform(@PathVariable Long id,Model model) {
		model.addAttribute("event",service.getEventById(id));
		return "edit_event";
	}
	
	@PostMapping("/events/{id}")
	public String updateEventform(@PathVariable Long id,@ModelAttribute("event") Event event,Model model) {
//		get Student from databse for id 
		Event existingEvent= service.getEventById(id);
		existingEvent.setId(id);
		existingEvent.setEventName(event.getEventName());
		existingEvent.setOrganizerMail(event.getOrganizerMail());
		existingEvent.setLocation(event.getLocation());
		
//		Svae updated student object 
		service.updateEvent(existingEvent);
		return "redirect:/";
	}
	
//	handler method to handle Delete Student Request 
	@GetMapping("/events/{id}")
	public String deleteEvent(@PathVariable Long id) {
		service.deleteEventById(id);
		return "redirect:/";
	}
}
