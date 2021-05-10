DROP PROCEDURE IF EXISTS `transaccion_create`;
DELIMITER $$
CREATE PROCEDURE `transaccion_create` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE iIdTransaccionParam VARCHAR(255);
    DECLARE sFechaParam VARCHAR(255);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET iIdTransaccionParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].iIdTransaccionParam')));
                SET sFechaParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sFecha')));
                
                INSERT INTO transaccion VALUES (`iIdTransaccionParam`, `sFechaParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
    
    
END $$
DELIMITER ;