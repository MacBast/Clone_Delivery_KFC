<?php
class DBConfig{
    private $user = "root";
    private $password ="";
    private $dbname="product";
    private $host = "localhost";

    public function connect(){
        try{
            $dns= "mysql: host=$this->host; dbname=$this->dbname";
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