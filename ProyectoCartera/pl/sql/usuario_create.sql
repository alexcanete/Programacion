CREATE PROCEDURE usuario_create (
	IN oObject JSON
)
BEGIN
	# Excepciones
	DECLARE vJsonIsValid INT;
    DECLARE vItems INT;
    DECLARE vIndex BIGINT UNSIGNED DEFAULT 0;
    DECLARE vValido INT;
    
    # Variables para parseo del objeto JSON
    DECLARE SNombreUsuarioParam VARCHAR(250);
    DECLARE sCorreoParam VARCHAR(250);
    DECLARE sContraseniaPanam VARCHAR(12);
    
	
    SET vJsonIsValid = JSON_VALID(oObject);
    SET vValido = 0;
    
	IF vJsonIsValid = 0 THEN
		SELECT "JSON suministrado no es válido";     
	ELSE
		# Nos traemos el numero de columnas del Json
        SET vItems = JSON_LENGTH(oObject);

        IF vItems > 0 THEN 
			
            WHILE vIndex < vItems DO
				
                SET SNombreUsuarioParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sNombreUsuario')));
                SET sCorreoParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sCorreo')));
                SET sPasswordParam = JSON_UNQUOTE(JSON_EXTRACT(oObject, CONCAT('$[', vIndex, '].sContrasenia')));
                
                INSERT INTO Usuario VALUES ('sNombreUsuarioParam', 'sCorreoParam', 'sContraseniaParam');
                SET vIndex = vIndex + 1;    
                
            END WHILE;            
        END IF;	
        SET vValido = 1;
    END IF;
    
    SELECT vValido;
    
END usuario_create;