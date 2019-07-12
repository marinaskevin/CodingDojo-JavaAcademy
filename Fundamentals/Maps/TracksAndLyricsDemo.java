import java.util.HashMap;
import java.util.Set;

public class TracksAndLyricsDemo {
	public static void main(String[] args) {

		TracksAndLyrics tal = new TracksAndLyrics();
		HashMap<String, String> trackList = tal.getTrackList();
		Set<String> tracks = trackList.keySet();

		System.out.println("Pull out one of the songs by its track title.");
		String trackTitle = "So";
		System.out.println("Song: "+trackTitle);
		System.out.println("Lyrics: "+trackList.get(trackTitle));

		System.out.println("Print out all the track names and lyrics in the format 'Track: Lyrics'");
		for(String track : tracks) {
			System.out.println(track+": "+trackList.get(track));
		}

	}
}
