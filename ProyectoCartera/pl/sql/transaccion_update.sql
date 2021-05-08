DROP PROCEDURE IF EXISTS `transaccion_update`;
DELIMITER $$
CREATE PROCEDURE `transaccion_update` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sTipotransaccionparam VARCHAR(255);
    DECLARE sValortransaccionEUParam VARCHAR(255);   
    	
    SET vJsonIsValid = JSON_VALID(oObject);
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN
        
            WHILE vIndex < vItems DO
				
                SET sTipotransaccionparam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sTipotransaccion')));
                SET sValortransaccionEUParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sValortransaccionEU')));
                
                
                UPDATE transaccion SET Tipotransaccion = `sTipotransaccionParam`, ValortransaccionEU = `sValortransaccionEUParam`;
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;