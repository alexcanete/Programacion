DROP PROCEDURE IF EXISTS `moneda_update`;
DELIMITER $$
CREATE PROCEDURE `moneda_update` (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    
    # Variables para parseo del objeto JSON
    DECLARE sTipomonedaparam VARCHAR(255);
    DECLARE sValormonedaEUParam VARCHAR(255);   
    	
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
                
                
                UPDATE moneda SET Tipomoneda = `sTipomonedaParam`, ValormonedaEU = `sValormonedaEUParam`, sFechaNacimiento = `sFehaNacimientoParam` WHERE sDni = `sDniParam`;
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
    END IF;    
END $$
DELIMITER ;