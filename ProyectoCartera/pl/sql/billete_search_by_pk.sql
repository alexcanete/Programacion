DROP PROCEDURE IF EXISTS `billete_search_by_pk`;
DELIMITER $$
CREATE PROCEDURE `billete_search_by_pk` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sTipoBilleteparam VARCHAR(255); 
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET sTipoBilleteparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipoBillete')));
                SELECT * FROM BILLETE WHERE tipoBillete = `sTipoBilleteparam`;
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;