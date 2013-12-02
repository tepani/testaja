package com.test.maintenance

class Album {

	String name
	String desc
	String createdBy
	Date dateCreated
	String updatedBy = ""
	Date lastUpdated

	static constraints = {
		name(blank: false, maxSize: 100)
		desc(maxSize: 500)
		createdBy(blank: false, maxSize: 50)
		dateCreated(blank: false)
		updatedBy(maxSize: 50)
		lastUpdated()
	}
}
