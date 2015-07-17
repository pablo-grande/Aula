<?php

$path = $_GET['filename'];
$content = file_get_contents("php://input");

var_dump($path);

var_dump($content);

file_put_contents($path, $content);

?>