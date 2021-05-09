DROP PROCEDURE IF EXISTS `cliente_update`;
DELIMITER $$
CREATE PROCEDURE `cliente_update` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sDniParam VARCHAR(255);
    DECLARE sNombreParam VARCHAR(255);
    DECLARE sApellidosParam VARCHAR(255);    
    DECLARE sFechaNacimientoParam VARCHAR(255);    
    	
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
                SET sFechaNacimientoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sFechaNacimiento')));
                
                
                UPDATE Cliente SET Nombre = `sNombreParam`, Apellidos = `sApellidosParam`, FechaNacimiento = `sFehaNacimientoParam` WHERE sDni = `sDniParam`;
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;