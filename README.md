# api-rest-employes
# aplicación desarrollada con el framework spring boot
# java versión 1.8
1. motor de base de datos Mysql-(para configurara la conexion hacial base de datos
ubique el archivo application.properties y proporcione su string de conexión, usuario y password).
2. el archivo de configuracion cuenta con el parametro spring.jpa.database-platform 
valide que el proporcionado coincida con la version del dialecto de su base de datos
con el fin de que la aplicación cree automaticamente el modelo de base de datos 
en caso de que no quiera que la aplicacion cree el modelo de base de datos modifique el parametro spring.jpa.hibernate.ddl-auto=create-drop 
spring.jpa.hibernate.ddl-auto=none  
