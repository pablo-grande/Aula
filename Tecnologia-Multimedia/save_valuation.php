<?php
/**
 * Created by PhpStorm.
 * User: pablo
 * Date: 19/05/15
 * Time: 18:36
 */

$message = $_POST['message'];
$rating = $_POST['rating'];

if ($message) $rating = $_POST['rating'].': '.$message;

$to = $_POST['to'];

$doc = new DOMDocument();
$doc->load( 'XML/heladeros.xml' );

$employees = $doc->getElementsByTagName( "heladero" );
foreach( $employees as $employee )
{
    $names = $employee->getElementsByTagName( "nombre" );
    $name = $names->item(0)->nodeValue;

    if ($name == $to){
        $employee->appendChild($doc->createElement('rating',$rating));
    }

}

echo $doc->save('XML/heladeros.xml');