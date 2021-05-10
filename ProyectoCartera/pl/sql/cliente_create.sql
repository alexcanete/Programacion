DROP PROCEDURE IF EXISTS `cliente_create`;
DELIMITER $$
CREATE PROCEDURE `cliente_create` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sDniParam VARCHAR(255);
    DECLARE sNombreParam VARCHAR(255);
    DECLARE sApellidosParam VARCHAR(255);    
    DECLARE sFechaNacimiento VARCHAR(255);  
    DECLARE sNombreUsuarioParam VARCHAR(255);
    DECLARE sCorreoParam VARCHAR(255);
    DECLARE sContraseniaPanam VARCHAR(255);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET sDniParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sDni')));
                SET sNombreParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombre')));
                SET sApellidosParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sApellidos')));
                SET sFechaNacimiento = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sFechaNacimiento')));
                SET sNombreUsuarioParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].uUsuario.sNombreUsuario')));
                SET sCorreoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].uUsuario.sCorreo')));
                SET sContraseniaPanam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].uUsuario.sContrasenia')));
                                
                CALL usuario_create(JSON_ARRAY(JSON_OBJECT("sNombreUsuario",`sNombreUsuarioParam`,"sCorreo", `sCorreoParam`, "sContrasenia", `sContraseniaPanam`)));
                
                INSERT INTO CLIENTE VALUES (`sDniParam`, `sNombreParam`, `sApellidosParam`, `sFechaNacimiento`,`sNombreUsuarioParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
    
    
END $$
DELIMITER ;

CALL cliente_create('[{"uUsuario":{"sNombreUsuario":"aurelio","sCorreo":"aurelio@lopez.com","sContrasenia":"1234567"},"sDni":"12345678A","sNombre":"Aurelio","sApellidos":"Lopez","sFechaNacimiento":""}]');