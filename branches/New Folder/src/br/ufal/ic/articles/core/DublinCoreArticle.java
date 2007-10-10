package br.ufal.ic.articles.core;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.search.annotations.DocumentId;
import org.hibernate.search.annotations.Field;
import org.hibernate.search.annotations.Index;
import org.hibernate.search.annotations.Indexed;
import org.hibernate.search.annotations.Store;

@Indexed
@Entity
@Table(name = "articles")
public class DublinCoreArticle implements Serializable {

	private static final long serialVersionUID = 1217647980097502542L;

	@Id
	@DocumentId
	private String identifier;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "date_stamp")
	private Date dateStamp;
	
	@Column(name = "set_spec")
	private String setSpec;

	@Lob
	@Column(name = "dc_title")
	@Field(name = "title", index = Index.TOKENIZED, store = Store.YES)	
	private String dcTitle;
	
	@Lob
	@Column(name = "dc_creator")
	private String dcCreator;
	
	@Lob
	@Column(name = "dc_subject")
	@Field(name = "subject", index = Index.TOKENIZED, store = Store.YES)	
	private String dcSubject;
	
	@Lob
	@Column(name = "dc_description")
	@Field(name = "description", index = Index.TOKENIZED, store = Store.YES)	
	private String dcDescription;
	
	@Column(name = "dc_publisher")
	private String dcPublisher;
	
	@Column(name = "dc_contributor")
	private String dcContributor;	
	
	@Temporal(TemporalType.DATE)
	@Column(name = "dc_date")
	private Date dcDate;
	
	@Column(name = "dc_type")
	private String dcType;
	
	@Column(name = "dc_format")
	private String dcFormat;
	
	@Column(name = "dc_identifier")
	private String dcIdentifier;
	
	@Column(name = "dc_source")
	private String dcSource;
	
	@Column(name = "dc_language")
	private String dcLanguage;
	
	@Column(name = "dc_coverage")
	private String dcCoverage;
	
	@Column(name = "dc_rights")
	private String dcRights;
	
	public DublinCoreArticle() {
		super();
	}
	
	public DublinCoreArticle(String identifier) {
		super();
		this.identifier = identifier;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((identifier == null) ? 0 : identifier.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final DublinCoreArticle other = (DublinCoreArticle) obj;
		if (identifier == null) {
			if (other.identifier != null)
				return false;
		} else if (!identifier.equals(other.identifier))
			return false;
		return true;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the dateStamp
	 */
	public Date getDateStamp() {
		return dateStamp;
	}

	/**
	 * @param dateStamp the dateStamp to set
	 */
	public void setDateStamp(Date dateStamp) {
		this.dateStamp = dateStamp;
	}

	/**
	 * @return the setSpec
	 */
	public String getSetSpec() {
		return setSpec;
	}

	/**
	 * @param setSpec the setSpec to set
	 */
	public void setSetSpec(String setSpec) {
		this.setSpec = setSpec;
	}

	/**
	 * @return the dcTitle
	 */
	public String getDcTitle() {
		return dcTitle;
	}

	/**
	 * @param dcTitle the dcTitle to set
	 */
	public void setDcTitle(String dcTitle) {
		this.dcTitle = dcTitle;
	}

	/**
	 * @return the dcCreator
	 */
	public String getDcCreator() {
		return dcCreator;
	}

	/**
	 * @param dcCreator the dcCreator to set
	 */
	public void setDcCreator(String dcCreator) {
		this.dcCreator = dcCreator;
	}

	/**
	 * @return the dcSubject
	 */
	public String getDcSubject() {
		return dcSubject;
	}

	/**
	 * @param dcSubject the dcSubject to set
	 */
	public void setDcSubject(String dcSubject) {
		this.dcSubject = dcSubject;
	}

	/**
	 * @return the dcDescription
	 */
	public String getDcDescription() {
		return dcDescription;
	}

	/**
	 * @param dcDescription the dcDescription to set
	 */
	public void setDcDescription(String dcDescription) {
		this.dcDescription = dcDescription;
	}

	/**
	 * @return the dcPublisher
	 */
	public String getDcPublisher() {
		return dcPublisher;
	}

	/**
	 * @param dcPublisher the dcPublisher to set
	 */
	public void setDcPublisher(String dcPublisher) {
		this.dcPublisher = dcPublisher;
	}

	/**
	 * @return the dcContributor
	 */
	public String getDcContributor() {
		return dcContributor;
	}

	/**
	 * @param dcContributor the dcContributor to set
	 */
	public void setDcContributor(String dcContributor) {
		this.dcContributor = dcContributor;
	}

	/**
	 * @return the dcDate
	 */
	public Date getDcDate() {
		return dcDate;
	}

	/**
	 * @param dcDate the dcDate to set
	 */
	public void setDcDate(Date dcDate) {
		this.dcDate = dcDate;
	}

	/**
	 * @return the dcType
	 */
	public String getDcType() {
		return dcType;
	}

	/**
	 * @param dcType the dcType to set
	 */
	public void setDcType(String dcType) {
		this.dcType = dcType;
	}

	/**
	 * @return the dcFormat
	 */
	public String getDcFormat() {
		return dcFormat;
	}

	/**
	 * @param dcFormat the dcFormat to set
	 */
	public void setDcFormat(String dcFormat) {
		this.dcFormat = dcFormat;
	}

	/**
	 * @return the dcIdentifier
	 */
	public String getDcIdentifier() {
		return dcIdentifier;
	}

	/**
	 * @param dcIdentifier the dcIdentifier to set
	 */
	public void setDcIdentifier(String dcIdentifier) {
		this.dcIdentifier = dcIdentifier;
	}

	/**
	 * @return the dcSource
	 */
	public String getDcSource() {
		return dcSource;
	}

	/**
	 * @param dcSource the dcSource to set
	 */
	public void setDcSource(String dcSource) {
		this.dcSource = dcSource;
	}

	/**
	 * @return the dcLanguage
	 */
	public String getDcLanguage() {
		return dcLanguage;
	}

	/**
	 * @param dcLanguage the dcLanguage to set
	 */
	public void setDcLanguage(String dcLanguage) {
		this.dcLanguage = dcLanguage;
	}

	/**
	 * @return the dcCoverage
	 */
	public String getDcCoverage() {
		return dcCoverage;
	}

	/**
	 * @param dcCoverage the dcCoverage to set
	 */
	public void setDcCoverage(String dcCoverage) {
		this.dcCoverage = dcCoverage;
	}

	/**
	 * @return the dcRights
	 */
	public String getDcRights() {
		return dcRights;
	}

	/**
	 * @param dcRights the dcRights to set
	 */
	public void setDcRights(String dcRights) {
		this.dcRights = dcRights;
	}
	
}
