package com.marinaskevin.lookify.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.marinaskevin.lookify.models.Song;
import com.marinaskevin.lookify.services.SongService;

@Controller
public class SongController {
	private final SongService songService;
	
	public SongController(SongService songService) {
		this.songService = songService;
	}

	@RequestMapping("/")
	public String index() {
		return "/songs/index.jsp";
	}
	
	@RequestMapping("/dashboard")
	public String dashboard(Model model) {
		List<Song> songs = songService.allSongs();
		model.addAttribute("songs", songs);
		return "/songs/dashboard.jsp";
	}
	
	@RequestMapping("/search/topTen")
	public String topTen(Model model) {
		List<Song> songs = songService.topTenSongs();
		model.addAttribute("songs", songs);
		return "/songs/top10.jsp";
	}
	
	@RequestMapping("/songs/{id}")
	public String song(@PathVariable("id") Long id, Model model) {
		Song song = songService.findSong(id);
		model.addAttribute("song", song);
		return "/songs/show.jsp";
	}
	
	@RequestMapping("/songs/new")
	public String newSong(@ModelAttribute("song") Song song) {
		return "/songs/new.jsp";
	}
	
	@RequestMapping(value="/songs", method=RequestMethod.POST)
	public String create(@Valid @ModelAttribute("song") Song song, BindingResult result) {
		if(result.hasErrors()) {
			return "/songs/new.jsp";
		} else {
			songService.createSong(song);
			return "redirect:/dashboard";
		}
	}
	
	@RequestMapping(value="/search", method=RequestMethod.POST)
	public String search(@RequestParam("artist") String artist){
		return "redirect:/search/"+artist;
	}
	
	@RequestMapping("/search/{artist}")
	public String results(@PathVariable("artist") String artist, Model model) {
		List<Song> songs = songService.songsByArtist(artist);
		model.addAttribute("artist", artist);
		model.addAttribute("songs", songs);
		return "/songs/search.jsp";
	}
	
	@RequestMapping(value="/songs/{id}", method=RequestMethod.DELETE)
	public String delete(@PathVariable("id") Long id) {
		songService.deleteSong(id);
		return "redirect:/dashboard";
	}

}
