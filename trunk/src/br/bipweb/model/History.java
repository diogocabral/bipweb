package br.bipweb.model;

public class History extends Document {
	
	private static final long serialVersionUID = 853378906342751473L;
	
	private float feedbackScore;
	
	public History() {
		super();
	}
	
	public float getFeedbackScore() {
		return feedbackScore;
	}
	
	public void setFeedbackScore(float feedbackScore) {
		this.feedbackScore = feedbackScore;
	}
	
}