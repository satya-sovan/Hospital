package com.hospital.javabeen;

import java.io.Serializable;
import java.sql.Date;

public class HospitalBO implements Serializable {
	/**
	 *   
	 */
	private static final long serialVersionUID = -1233102260292653556L;
	private String patName,docName;
	private long patPhNo;
	private Date apoDate,lvDate;
	private String symptoms,docId;
	private boolean insertFlag;
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
	public Date getApoDate() {
		return apoDate;
	}
	/**
	 * @param apoDate the apoDate to set
	 */
	public void setApoDate(Date apoDate) {
		this.apoDate = apoDate;
	}
	/**
	 * @return the lvDate
	 */
	public Date getLvDate() {
		return lvDate;
	}
	/**
	 * @param lvDate the lvDate to set
	 */
	public void setLvDate(Date lvDate) {
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
	 * @return the insertFlag
	 */
	public boolean isInsertFlag() {
		return insertFlag;
	}
	/**
	 * @param insertFlag the insertFlag to set
	 */
	public void setInsertFlag(boolean insertFlag) {
		this.insertFlag = insertFlag;
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
