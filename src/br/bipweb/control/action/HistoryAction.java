package br.bipweb.control.action;

import java.util.Collection;

import br.bipweb.dao.DaoException;
import br.bipweb.dao.HistoryDao;
import br.bipweb.dao.ObjectNotFoundException;
import br.bipweb.model.History;

import com.opensymphony.xwork.ActionSupport;

public class HistoryAction extends ActionSupport {

	private static final long serialVersionUID = -4580059119769736353L;
	
	private History history;
	private Collection<History> histories;
	
	private String feedbackScore;
	
	private HistoryDao historyDao;
	
	public HistoryAction() {
		super();
	}
	
	public String doLoad()
			throws DaoException {
		
		histories = historyDao.listAll();
		
		return SUCCESS;
		
	}
	
	public String doQualify()
			throws DaoException, ObjectNotFoundException {
		
		history = historyDao.get(history.getId());
		
		history.setFeedbackScore(new Float(feedbackScore));
		
		historyDao.update(history);
		
		return SUCCESS;
		
	}
	
	public History getHistory() {
		return history;
	}
	
	public void setHistory(History history) {
		this.history = history;
	}
	
	public Collection<History> getHistories() {
		return histories;
	}
	
	public void setFeedbackScore(String feedbackScore) {
		this.feedbackScore = feedbackScore;
	}
	
	public void setHistoryDao(HistoryDao historyDao) {
		this.historyDao = historyDao;
	}
	
}