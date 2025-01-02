USE customerMan;
DELIMITER //
DROP PROCEDURE IF EXISTS delete_province;

CREATE PROCEDURE delete_province(IN p_province_id BIGINT)
BEGIN
    -- Update customers to set province_id to null
    UPDATE customers 
    SET province_id = NULL 
    WHERE province_id = p_province_id;
    
    -- Delete the province
    DELETE FROM province 
    WHERE province_id = p_province_id;
END //
DELIMITER ;