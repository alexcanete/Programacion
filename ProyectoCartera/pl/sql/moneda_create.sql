DROP PROCEDURE IF EXISTS `moneda_create`;
DELIMITER $$
CREATE PROCEDURE `moneda_create` (
	IN oObject JSON
)
BEGIN
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sTipoMonedaparam VARCHAR(255);
    DECLARE sValorMonedaEUParam VARCHAR(255);
	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO

                SET sTipoMonedaparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipoMoneda')));
                SET sValorMonedaEUParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sValorMonedaEU')));
                
                INSERT INTO BILLETE VALUES (`sTipoMonedaParam`, `sValorMonedaEUParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
        END IF;	
    END IF;
    
    
END $$
DELIMITER ;