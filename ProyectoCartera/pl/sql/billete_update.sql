DROP PROCEDURE IF EXISTS `billete_update`;
DELIMITER $$
CREATE PROCEDURE `billete_update` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sTipoBilleteParam VARCHAR(255);
    DECLARE sValorBilleteEUParam VARCHAR(255);   
    	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN
        
            WHILE vIndex < vItems DO
				
                SET sTipoBilleteParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipoBillete')));
                SET sValorBilleteEUParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sValorBilleteEU')));
                
                
                UPDATE BILLETE SET TipoBillete = `sTipoBilleteParam`, ValorBilleteEU = `sValorBilleteEUParam`;
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;