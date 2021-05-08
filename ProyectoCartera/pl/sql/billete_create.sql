DROP PROCEDURE IF EXISTS `billete_create`;
DELIMITER $$
CREATE PROCEDURE `billete_create` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sTipoBilleteparam VARCHAR(255);
    DECLARE sValorBilleteEUParam VARCHAR(255);
    DECLARE vValido INT;
	
    SET vValido = 0;
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET sTipoBilleteparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipoBillete')));
                SET sValorBilleteEUParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sValorBilleteEU')));
                
                INSERT INTO BILLETE VALUES (`sTipoBilleteParam`, `sValorBilleteEUParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
            SET vValido = 1;
        END IF;	
    END IF;
    
    SELECT vValido;
    
END $$
DELIMITER ;