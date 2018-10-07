package com.example.demo.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.example.demo.Entity.Voice;
import com.example.demo.repository.voiceRepository;

@Service
public class VoiceService {
	@Autowired
	voiceRepository repository;
	/**
	 * searchメソッド ID指定検索
	 * @param 検索するID
	 * @return 音声データ1レコード
	 */
	public Voice search(Integer id) {
		Voice voice = repository.findOne(id);
		return voice;
	}
	public List<Voice> findAll()
	{
		List<Voice> list = repository.findAll();
		return list;
	}
	public Voice FindOne(int id){
		Voice data = repository.findOne(id);
		return data;
	}

	public void Delete(int id){
		repository.delete(id);
	}

	public void AllDelete(){
		repository.deleteAll();
	}

    public Voice create(Voice voice) {
        return repository.save(voice);
    }
	
}
