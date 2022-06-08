<?php
class DBConfig{
    
    private $user = "admin";
    private $password ="Col2028..";
    private $dbname="products";
    private $host = "database-1.csvoeg1cxn8s.us-east-1.rds.amazonaws.com";

    public function connect(){
        try{
            $dns= "mysql:host=$this->host;dbname=$this->dbname";
            $connection = new PDO($dns, $this->user, $this->password);
            $connection->setAttribute(PDO::ATTR_ERRMODE, PDO::ERRMODE_EXCEPTION);
            return $connection;
            echo "conexion exitosa";
        }catch(PDOException $exception){
            echo "Fallo de conexion " .$exception->getMessage();
        }
    }
}

?>