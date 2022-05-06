<?php

require_once(dirname(__DIR__)."../../db/db_config_product.php");
$db = new DBConfigPro();
$dbConnection = $db->connect();
$products= "";
if($_SERVER['REQUEST_METHOD'] == "POST"){
    $data = json_decode(file_get_contents('php://input'), true); 
    $search= $data['id_product'];
    $query = "SELECT * FROM product WHERE id_product='$search'";
    $products = $dbConnection->query($query)->fetchAll(PDO::FETCH_ASSOC);

}else{
    $query = "SELECT * FROM product" ;
    $products = $dbConnection->query($query)->fetchAll(PDO::FETCH_ASSOC);

}
header('Content-Type: application/json');
echo (json_encode($products[0])); 
?>
