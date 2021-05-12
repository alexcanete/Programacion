DROP PROCEDURE IF EXISTS `billete_delete`;
DELIMITER $$
CREATE PROCEDURE `billete_delete` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sNombreBilleteraparam VARCHAR(255);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET sNombreBilleteraparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreBilletera')));                
                DELETE FROM BILLETE WHERE NombreBilletera = `sNombreBilleteraparam`;
                SET vIndex = vIndex + 1;
            END WHILE;            
        END IF;	
    END IF;
    
END
DELIMITER ;