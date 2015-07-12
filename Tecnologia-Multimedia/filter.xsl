<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <xsl:for-each select="sabores/sabor">
            <xsl:if test="nombre=$param">
                <article>
                    <div class="col-sm-6 col-md-2">
                        <div class="thumbnail">
                            <img src="" alt="">
                                <xsl:attribute name="src">
                                    <xsl:value-of select="img"/>
                                </xsl:attribute>
                            </img>
                            <div class="caption">
                                <header><h3 class="nombre-sabor"><xsl:value-of select="nombre"/></h3></header>
                                <p><span>Quiero </span><input type="number" name="quantity" min="0" max="7"/> bolas</p>
                                <!-- <p><a href="#" class="btn btn-primary" role="button">Button</a> <a href="#" class="btn btn-default" role="button">Button</a></p> -->
                            </div>
                        </div>
                    </div>
                </article>
            </xsl:if>
        </xsl:for-each>
    </xsl:template>
</xsl:stylesheet>

