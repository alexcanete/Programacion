DROP PROCEDURE IF EXISTS `moneda_search_by_pk`;
DELIMITER $$
CREATE PROCEDURE `moneda_search_by_pk` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sTipomonedaparam VARCHAR(255); 
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 			
            WHILE vIndex < vItems DO
                SET sTipomonedaparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipomoneda')));
                SELECT * FROM moneda WHERE sDni = `sTipomonedaparam`;
                SET vIndex = vIndex + 1;                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;