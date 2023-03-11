// Write your code here
package com.example.song.repository;

import java.util.*;
import com.example.song.model.Song;

public interface SongRepository{
    ArrayList<Song> getSongs();
    Song addsong(Song song);
    Song getsong(int id);
    Song updatesong(int id,Song song);
    void deletesong(int id);
}