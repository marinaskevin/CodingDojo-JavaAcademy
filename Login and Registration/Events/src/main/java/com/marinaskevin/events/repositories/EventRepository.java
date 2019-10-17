package com.marinaskevin.events.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.marinaskevin.events.models.Event;

@Repository
public interface EventRepository extends CrudRepository<Event, Long> {
	List<Event> findAll();

	@Query("SELECT e FROM Event e WHERE e.state = ?1")
	List<Event> findEventsInState(String state);

	@Query("SELECT e FROM Event e WHERE e.state != ?1")
	List<Event> findEventsNotInState(String state);

	@Query("update Event e set e.name = ?1 WHERE e.id = ?2")
	int setName(String name, Long id);

	@Query("update Event e set e.date = ?1 WHERE e.id = ?2")
	int setDate(Date date, Long id);

	@Query("update Event e set e.location = ?1 WHERE e.id = ?2")
	int setLocation(String location, Long id);

	@Query("update Event e set e.state = ?1 WHERE e.id = ?2")
	int setState(String state, Long id);
}
