/*
 * You can use the following import statements
 * import org.springframework.beans.factory.annotation.Autowired;
 * import org.springframework.http.HttpStatus;
 * import org.springframework.stereotype.Service;
 * import org.springframework.web.server.ResponseStatusException;
 * import java.util.*;
 */

// Write your code here

package com.example.song.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.*;
import com.example.song.repository.*;
import com.example.song.model.*;

@Service
public class SongJpaService implements SongRepository{

    @Autowired
    private SongJpaRepository songjparepository;

    @Override 
    public ArrayList<Song> getSongs(){
        List<Song> songs=songjparepository.findAll();
        ArrayList<Song> allsongs=new ArrayList<>(songs);
        return allsongs;
    }

    @Override
    public Song addsong(Song song){
        try{
        songjparepository.save(song);
        return song;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song getsong(int id){
        try{
            Song song=songjparepository.findById(id).get();
            return song;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public Song updatesong(int id,Song song){
        try{
            Song newsong=songjparepository.findById(id).get();
            if(song.getSongName()!=null){
                newsong.setSongName(song.getSongName());
            }
            if(song.getLyricist()!=null){
                newsong.setLyricist(song.getLyricist());
            }
            if(song.getSinger()!=null){
                newsong.setSinger(song.getSinger());
            }
            if(song.getMusicDirector()!=null){
                newsong.setMusicDirector(song.getMusicDirector());
            }
            songjparepository.save(newsong);
            return newsong;
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @Override
    public void deletesong(int id){
        try{
        songjparepository.deleteById(id);
        }catch(Exception e){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}