dataSource { pooled = true }
hibernate {
	cache.use_second_level_cache = true
	cache.use_query_cache = true
	cache.provider_class = 'net.sf.ehcache.hibernate.EhCacheProvider'
	jdbc.batch_size = 100
}

// environment specific settings
environments {
	development {
		dataSource {
			driverClassName = "com.mysql.jdbc.Driver"
			username = "root"
			password = "root"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			url = "jdbc:mysql://localhost:3306/testaja"
			properties {
				maxActive = 50
				maxIdle = 25
				minIdle = 5
				initialSize = 5
				minEvictableIdleTimeMillis = 60000
				timeBetweenEvictionRunsMillis = 60000
				maxWait = 10000
				validationQuery = "/* ping */"
			}
		}
	}
	production {
		dataSource {
			// remark this line if deploy without JNDI
			jndiName = "java:comp/env/jdbc/NetbankDS"
			dbCreate = "update" // one of 'create', 'create-drop','update'
			dialect = "org.hibernate.dialect.MySQL5InnoDBDialect"
		}
	}
}