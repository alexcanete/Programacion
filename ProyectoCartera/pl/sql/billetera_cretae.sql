DROP PROCEDURE IF EXISTS `billeterara_create`;
DELIMITER $$
CREATE PROCEDURE `billeterara_create` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sNombreBilleteraparam VARCHAR(255);
    DECLARE sSaldoActualParam VARCHAR(255);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET sNombreBilleteraparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreBilleteraparam')));
                SET sSaldoActualParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sSaldoActualParam')));
                
                INSERT INTO billetera VALUES (`sNombreBilleteraparam`, `sSaldoActualParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
    
    
END $$
DELIMITER ;