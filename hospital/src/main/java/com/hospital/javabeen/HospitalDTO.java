package com.hospital.javabeen;

import java.io.Serializable;

@SuppressWarnings("serial")
public class HospitalDTO implements Serializable {
	private String patName;
	private String docName;
	private long patPhNo;
	private String apoDate;
	private String lvDate;
	private String symptoms;
	private String docId;
	private String pat_id;
	/**
	 * @return the patName
	 */
	public String getPatName() {
		return patName;
	}
	/**
	 * @param patName the patName to set
	 */
	public void setPatName(String patName) {
		this.patName = patName;
	}
	/**
	 * @return the docName
	 */
	public String getDocName() {
		return docName;
	}
	/**
	 * @param docName the docName to set
	 */
	public void setDocName(String docName) {
		this.docName = docName;
	}
	/**
	 * @return the patPhNo
	 */
	public long getPatPhNo() {
		return patPhNo;
	}
	/**
	 * @param patPhNo the patPhNo to set
	 */
	public void setPatPhNo(long patPhNo) {
		this.patPhNo = patPhNo;
	}
	/**
	 * @return the docId
	 */
	public String getDocId() {
		return docId;
	}
	/**
	 * @param docId the docId to set
	 */
	public void setDocId(String docId) {
		this.docId = docId;
	}
	/**
	 * @return the apoDate
	 */
	public String getApoDate() {
		return apoDate;
	}
	/**
	 * @param apoDate the apoDate to set
	 */
	public void setApoDate(String apoDate) {
		this.apoDate = apoDate;
	}
	/**
	 * @return the lvDate
	 */
	public String getLvDate() {
		return lvDate;
	}
	/**
	 * @param lvDate the lvDate to set
	 */
	public void setLvDate(String lvDate) {
		this.lvDate = lvDate;
	}
	/**
	 * @return the symptoms
	 */
	public String getSymptoms() {
		return symptoms;
	}
	/**
	 * @param symptoms the symptoms to set
	 */
	public void setSymptoms(String symptoms) {
		this.symptoms = symptoms;
	}
	/**
	 * @return the pat_id
	 */
	public String getPat_id() {
		return pat_id;
	}
	/**
	 * @param pat_id the pat_id to set
	 */
	public void setPat_id(String pat_id) {
		this.pat_id = pat_id;
	}
}
