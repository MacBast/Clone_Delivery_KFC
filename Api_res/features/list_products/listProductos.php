<?php

require_once(dirname(__DIR__)."../../db/db_config_product.php");
$db = new DBConfigPro();
$dbConnection = $db->connect();
$products= "";
$query = "SELECT * FROM product";
$products = $dbConnection->query($query)->fetchAll(PDO::FETCH_ASSOC);


header('Content-Type: application/json');
echo (json_encode($products)); 
?>
