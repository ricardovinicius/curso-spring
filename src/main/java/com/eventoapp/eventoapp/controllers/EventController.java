package com.eventoapp.eventoapp.controllers;

import com.eventoapp.eventoapp.models.Event;
import com.eventoapp.eventoapp.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @RequestMapping(value = "cadastrarEvento", method = RequestMethod.GET)
    public String form() {
        return "event/formEvent";
    }

    @RequestMapping(value = "cadastrarEvento", method = RequestMethod.POST)
    public String form(Event event) {
        eventRepository.save(event);

        return "redirect:/cadastrarEvento";
    }

    @RequestMapping(value = "eventos")
    public ModelAndView listaEventos() {
        ModelAndView modelAndView = new ModelAndView("index");
        Iterable<Event> events = eventRepository.findAll();
        modelAndView.addObject("events", events);

        return modelAndView;
    }
}
