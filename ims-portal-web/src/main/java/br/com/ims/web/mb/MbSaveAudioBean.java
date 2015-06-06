package br.com.ims.web.mb;

import javax.inject.Inject;
import javax.inject.Named;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;
import org.springframework.web.context.WebApplicationContext;

import br.com.ims.util.service.interfaces.IAudioService;
import br.com.ims.utils.entity.AudioEntity;
import br.com.ims.web.mb.util.BaseBean;


//ConfigurableBeanFactory.SCOPE_SINGLETON, ConfigurableBeanFactory.SCOPE_PROTOTYPE,
//WebApplicationContext.SCOPE_REQUEST, WebApplicationContext.SCOPE_SESSION
@Scope(value=WebApplicationContext.SCOPE_REQUEST)
@Named (value= "mbSaveAudio")
public class MbSaveAudioBean extends BaseBean {
	
	private static final long serialVersionUID = 2920522296856799398L;
	
	private static final Logger logger = Logger.getLogger(MbSaveAudioBean.class);
	
	@Inject
	private IAudioService audioService;
	
	@Inject
	private MbAudioBean mbAudioBean;
	
	private AudioEntity audio;
	
	private String title;
	
	public MbSaveAudioBean() {
		this.audio = new AudioEntity();
	}

	public AudioEntity getAudio() {
		return this.audio;
	}

	public void setAudio(AudioEntity audio) {
		this.audio = audio;
	}
	
	public void add() {
		this.title = "Add";
	}

	public void update() {
		this.audio = this.mbAudioBean.getSelectedAudio();
		this.title = "Update";
	}

	public void save() {
		if (this.audio != null) {
			if (this.audio.getId() == null) {
				// Add
				this.audioService.insert(this.audio);
			} else {
				// Update
				this.audioService.update(this.audio);
			}
		}
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}
	
	
	
	

}
