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
    DECLARE vValido INT;
    
    # Variables para parseo del objeto JSON
    DECLARE sNombrePaisParam VARCHAR(255);
    	
    SET vJsonIsValid = JSON_VALID(oObject);
    SET vValido = 0;
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO
				
                SET sNombrePaisParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombrePais')));
                
                INSERT INTO PAis VALUES (`sNombrePaisParam`);
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
        SET vValido = 1;
    END IF;
    
    SELECT vValido;
END $$
DELIMITER ;