FROM jboss/wildfly:latest

ADD config /opt/jboss/wildfly/config/

COPY planer-webapp/target/planer-webapp.war /opt/jboss/wildfly/config/
COPY planer-inwigilator/target/planer-inwigilator.war /opt/jboss/wildfly/config/


CMD ["/opt/jboss/wildfly/config/execute.sh"]

RUN mkdir ~/tmp