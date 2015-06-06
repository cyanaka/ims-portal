package br.com.ims.web.mb;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.primefaces.event.SelectEvent;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.ims.util.service.interfaces.IAudioService;
import br.com.ims.utils.entity.AudioEntity;
import br.com.ims.web.mb.util.ObjectParser;

@Scope(value=WebApplicationContext.SCOPE_SESSION)
@Named (value= "mbAudio")
public class MbAudioBean {
	
	private static final Logger logger = Logger.getLogger(MbAudioBean.class);
	@Inject
	private IAudioService audioService;
	private List<AudioEntity> audios;
	private Integer id;
	private AudioEntity selectedAudio;
	
	
	public MbAudioBean() {
		audios = new ArrayList<AudioEntity>();
	}
	
	public void onLoad(){
		this.audios = this.audioService.getAll();
	}

	public List<AudioEntity> getAudios() {
		return audios;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public AudioEntity getSelectedAudio() {
		return selectedAudio;
	}

	public void setSelectedAudio(AudioEntity selectedAudio) {
		this.selectedAudio = selectedAudio;
	}
	
	public void selectAudio(SelectEvent evt) {
		try {
			if (evt.getObject() != null) {
				this.selectedAudio = ObjectParser.JSON_MAPPER.convertValue(evt.getObject(), AudioEntity.class);
			} else {
				this.selectedAudio = null;
			}
		} catch (Exception e) {
			this.selectedAudio = null;

			logger.error(e.getMessage(), e);
		}
		
	}
	
	public void unselectAudio(){
		this.selectedAudio = null;
	}
	
	public void delete(){
		if(selectedAudio != null){
			this.audioService.delete(selectedAudio.getId());
		}
	}
	
	
	

}
