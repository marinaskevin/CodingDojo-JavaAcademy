package com.marinaskevin.events.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.marinaskevin.events.models.Comment;
import com.marinaskevin.events.models.Event;
import com.marinaskevin.events.models.User;
import com.marinaskevin.events.repositories.CommentRepository;
import com.marinaskevin.events.repositories.EventRepository;
import com.marinaskevin.events.repositories.UserRepository;

@Service
public class EventService {
	private final UserRepository userRepository;
	private final EventRepository eventRepository;
	private final CommentRepository commentRepository;

	public EventService(UserRepository userRepository, EventRepository eventRepository,
			CommentRepository commentRepository) {
		this.userRepository = userRepository;
		this.eventRepository = eventRepository;
		this.commentRepository = commentRepository;
	}
	
	public User createUser(User user) {
		user.setPassword(BCrypt.hashpw(user.getPassword(),BCrypt.gensalt()));
		return userRepository.save(user);
	}
	
	public User findUserById(Long id) {
		Optional<User> user = userRepository.findById(id);
		if(user.isPresent()) {
			return user.get();
		} else {
			return null;
		}
	}
	
	public User findUserByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	public Event createEvent(Event event) {
		return eventRepository.save(event);
	}

	public Event updateEvent(Event event) {
		event.setAttendees(this.findEventById(event.getId()).getAttendees());
		return eventRepository.save(event);
	}

	public void deleteEvent(Long id) {
		Optional<Event> e = eventRepository.findById(id);
		if(e.isPresent()) {
			eventRepository.delete(e.get());
		}
	}

	public Event findEventById(Long id) {
		Optional<Event> e = eventRepository.findById(id);
		if(e.isPresent()) {
			return e.get();
		} else {
			return null;
		}
	}
	
	public List<Event> findEventsInState(String state) {
		return eventRepository.findEventsInState(state);
	}
	
	public List<Event> findEventsNotInState(String state) {
		return eventRepository.findEventsNotInState(state);
	}
	
	public Comment createComment(Comment comment) {
		return commentRepository.save(comment);
	}
	
    public boolean authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if(user == null) {
            return false;
        } else {
            if(BCrypt.checkpw(password, user.getPassword())) {
                return true;
            } else {
                return false;
            }
        }
    }	

    public boolean verifyPassword(String email,String password) {
    	User user = userRepository.findByEmail(email);
    	if(user == null) return false;
    	return BCrypt.checkpw(password, user.getPassword());
    }
}
