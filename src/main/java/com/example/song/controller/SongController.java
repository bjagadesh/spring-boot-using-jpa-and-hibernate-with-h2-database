/*
 * 
 * You can use the following import statements
 * 
 * import org.springframework.web.bind.annotation.*;
 * import java.util.*;
 *
 */

// Write your code here
package com.example.song.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;
import com.example.song.service.SongJpaService;
import com.example.song.model.*;

@RestController
public class SongController{

    @Autowired
    public SongJpaService songservice;

    @GetMapping("/songs")
    public ArrayList<Song> getsongs(){
        return songservice.getSongs();
    }

    @PostMapping("/songs")
    public Song addsong(@RequestBody Song song){
        return songservice.addsong(song);
    }

    @GetMapping("/songs/{songId}")
    public Song getsong(@PathVariable("songId") int songId){
        return songservice.getsong(songId);
    }

    @PutMapping("/songs/{songId}")
    public Song updatesong(@PathVariable("songId") int songId,@RequestBody Song song){
        return songservice.updatesong(songId, song);
    }

    @DeleteMapping("/songs/{songId}")
    public void deletesong(@PathVariable("songId") int songId){
        songservice.deletesong(songId);
    }
}