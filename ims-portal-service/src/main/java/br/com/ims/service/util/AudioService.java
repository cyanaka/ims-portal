package br.com.ims.service.util;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;

import org.codehaus.jackson.map.ObjectMapper;

import br.com.ims.database.control.AudioControl;
import br.com.ims.util.service.interfaces.IAudioService;
import br.com.ims.utils.entity.AudioEntity;


@Named
public class AudioService implements IAudioService {

	private static final ObjectMapper jsonMapper = new ObjectMapper();
	
	@Override
	public List<AudioEntity> getAll() {
		AudioControl control = new AudioControl();
		List<AudioEntity> lista = new ArrayList<AudioEntity>();
		lista= control.getAll();
		return lista;
	}

	@Override
	public void delete(Long id) {
		AudioControl control = new AudioControl();
		control.delete(id);
		
	}

	@Override
	public void insert(Object jsonEntityObject) {
		AudioControl control = new AudioControl();
		AudioEntity audio = jsonMapper.convertValue(jsonEntityObject, AudioEntity.class);
		control.insert(audio);
	}

	@Override
	public void update(Object jsonEntityObject) {
		AudioControl control = new AudioControl();
		AudioEntity audio = jsonMapper.convertValue(jsonEntityObject, AudioEntity.class);
		control.update(audio);
	}


}
