<?php
/**
 * Created by PhpStorm.
 * User: pablo
 * Date: 26/05/15
 * Time: 11:45
 */

$sabor = $_GET['sabor'];

$xsl_filename = "filter.xsl";	/* nom arxiu xsl */
$xml_filename = "XML/sabores.xml";	/* nom arxiu xml */

$doc = new DOMDocument();
$xsl = new XSLTProcessor();

$doc->load($xsl_filename);

$xsl->importStyleSheet($doc);

/* pasam par?metre al xsl */
$xsl->setParameter('', 'param',$sabor);

$doc->load($xml_filename);


echo $xsl->transformToXML($doc);
?>