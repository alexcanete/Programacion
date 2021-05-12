DROP PROCEDURE IF EXISTS `usuario_create`;
DELIMITER $$
CREATE PROCEDURE `usuario_create` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
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
				
                SET sNombreUsuarioParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreUsuario')));
                SET sCorreoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCorreo')));
                SET sContraseniaPanam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sContrasenia')));
                
                INSERT INTO USUARIO VALUES (`sNombreUsuarioParam`, `sCorreoParam`, `sContraseniaPanam`);
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;
    
END $$
DELIMITER ;