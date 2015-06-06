package br.com.ims.database.control;

import java.util.List;

import br.com.ims.database.dao.AudioDAO;
import br.com.ims.utils.entity.AudioEntity;


public class AudioControl {
	
	public List<AudioEntity> getAll(){
		AudioDAO dao = new AudioDAO();
		return dao.getAll();
	}

	public void delete(Long id) {
		AudioDAO dao = new AudioDAO();
		dao.delete(id);

	}

	public void insert(AudioEntity audio) {
		AudioDAO dao = new AudioDAO();
		dao.insert(audio);
	}

	public void update(AudioEntity audio) {
		AudioDAO dao = new AudioDAO();
		dao.update(audio);
	} 	
	
}
