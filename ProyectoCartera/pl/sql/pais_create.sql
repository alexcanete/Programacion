DROP PROCEDURE IF EXISTS `pais_create`;
DELIMITER $$
CREATE PROCEDURE `pais_create` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sNombrePaisParam VARCHAR(250);
    
    	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO
				
                SET sNombrePaisParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombrePais')));
                
                INSERT INTO pais(sNombrePais) VALUES (`sNombrePaisParam`);
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;