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
    DECLARE sTipomonedaparam VARCHAR(255);
    DECLARE sValormonedaEUParam VARCHAR(255);
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

                SET sTipomonedaparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipomoneda')));
                SET sValormonedaEUParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sValormonedaEU')));
                
                INSERT INTO moneda VALUES (`sTipomonedaParam`, `sValormonedaEUParam`);
                  
                SET vIndex = vIndex + 1;
            END WHILE;
            
            SET vValido = 1;
        END IF;	
    END IF;
    
    SELECT vValido;
    
END $$
DELIMITER ;