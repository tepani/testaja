grails.project.class.dir = "target/classes"
grails.project.test.class.dir = "target/test-classes"
grails.project.test.reports.dir = "target/test-reports"
//grails.project.war.file = "target/${appName}-${appVersion}.war"
grails.tomcat.jvmArgs = ["-server", "-Xms512m", "-Xmx512m", "-XX:PermSize=256m",
        "-XX:MaxPermSize=256m", "-XX:-UseGCOverheadLimit", "-XX:-PrintGCDetails", "-Djava.awt.headless=true", "-Dfile.encoding=UTF-8"]
grails.project.dependency.resolution = {
    // inherit Grails' default dependencies
    inherits("global") {
        // uncomment to disable ehcache
        // excludes 'ehcache'
        excludes 'slf4j-log4j12'
//Enabled when production war/ to prevent memory leak put the lib directly to container lib
        runtime 'net.sf.ehcache:ehcache-core:2.4.4'
        runtime 'net.sf.ehcache:ehcache-terracotta:2.4.4'
        runtime "org.terracotta:terracotta-toolkit-1.3-runtime:3.2.0"
    }
    log "warn" // log level of Ivy resolver, either 'error', 'warn', 'info', 'debug' or 'verbose'
    repositories {
        grailsPlugins()
        grailsHome()
        grailsCentral()
    }
    plugins {
    }
    dependencies {
    }
}
//Enabled when create production war
grails.war.resources = { stagingDir ->
    delete(file: "${stagingDir}/WEB-INF/lib/ehcache-core-1.7.1.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/slf4j-log4j12-1.5.8.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/logback-access-0.9.17.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/logback-classic-0.9.17.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/logback-core-0.9.17.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/log4j-1.2.16.jar")
    delete(file: "${stagingDir}/WEB-INF/classes/logback.xml")
    delete(file: "${stagingDir}/WEB-INF/lib/slf4j-api-1.6.1.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/mail-1.4.1.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/mail-1.4.3.jar")
    delete(file: "${stagingDir}/WEB-INF/lib/geronimo-javamail_1.4_spec-1.7.1.jar")
    delete(file: "${stagingDir}/WEB-INF/classes/logging.properties")
}

coverage {
    enabledByDefault = false
    xml = true
}

