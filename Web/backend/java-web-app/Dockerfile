# Use the official Tomcat base image
FROM tomcat:latest

# Copy your web application war file to the webapps directory in Tomcat
COPY target/*.war /usr/local/tomcat/webapps/

# Expose port 8080 to the host
EXPOSE 8080

# Run Tomcat server
CMD ["catalina.sh", "run"]

