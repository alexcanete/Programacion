DROP PROCEDURE IF EXISTS `operacion_create`;
DELIMITER $$
CREATE PROCEDURE `operacion_create` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE iIdOperacionParam VARCHAR(255);
    DECLARE sTipoOperacionParam VARCHAR(255);
    	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO
				
                SET iIdOperacionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdOperacion')));
                SET sTipoOperacionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipoOperacion')));
                
                INSERT INTO OPERACION VALUES (`iIdOperacionParam`, `sTipoOperacionParam`);
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;
    
END $$
DELIMITER ;