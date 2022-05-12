<?php 

require_once(dirname(__DIR__)."../../db/db_config_product.php");
if( $_SERVER['REQUEST_METHOD'] == "POST"){
$products= "";
$data = json_decode(file_get_contents('php://input'), true);  

    $id= $data['id_product'];
    $name= $data['name'];
    $price= $data['price'];

    $image= $data['image'];

    $descripcion= $data['descripcion'];


$db = new DBConfigPro();
$dbConnection = $db->connect();
$query = "INSERT INTO compra (id_product,name,descripcion,price,image)
values ('$id','$name','$descripcion','$price','$image')";

$products = $dbConnection->query($query);

header('Content-Type: application/json');
echo (json_encode("compra exitosa"));
    }else{

    echo (json_encode("Error"));
} 

?>