package br.bipweb.model;

public class History extends Document {
	
	private float feedbackRelevance;
	
	public History() {
		super();
	}
	
	public float getFeedbackRelevance() {
		return feedbackRelevance;
	}
	
	public void setFeedbackRelevance(float feedbackRelevance) {
		this.feedbackRelevance = feedbackRelevance;
	}
	
}