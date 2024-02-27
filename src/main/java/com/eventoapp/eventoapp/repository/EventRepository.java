package com.eventoapp.eventoapp.repository;

import com.eventoapp.eventoapp.models.Event;
import org.springframework.data.repository.CrudRepository;

public interface EventRepository extends CrudRepository<Event, String> {

}
