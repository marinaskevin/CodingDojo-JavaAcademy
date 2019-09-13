package com.marinaskevin.lookify.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.marinaskevin.lookify.models.Song;
import com.marinaskevin.lookify.repositories.SongRepository;

@Service
public class SongService {
	private final SongRepository songRepository;

	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}
	
	public List<Song> allSongs() {
		return songRepository.findAll();
	}
	
	public Song createSong(Song s) {
		return songRepository.save(s);
	}
	
	public List<Song> songsByArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}
	
	public List<Song> topTenSongs() {
		return songRepository.findTop10ByOrderByRatingDesc();
	}
	
	public Song findSong(Long id) {
		Optional<Song> optionalSong = songRepository.findById(id);
		if(optionalSong.isPresent())
		{
			return optionalSong.get();
		} else {
			return null;
		}
	}
	
	public void deleteSong(Long id) {
		songRepository.deleteById(id);
	}
	
}
