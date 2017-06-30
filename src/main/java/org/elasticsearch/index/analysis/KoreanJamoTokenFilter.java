package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.TokenFilter;
import org.apache.lucene.analysis.TokenStream;
import org.apache.lucene.analysis.tokenattributes.CharTermAttribute;
import org.elasticsearch.index.analysis.parser.KoreanJamoParserType;
import org.elasticsearch.index.analysis.parser.IJamoParser;

import java.io.IOException;

/**
 * Created by chakannom on 17. 6. 30.
 */
public final class KoreanJamoTokenFilter extends TokenFilter {
    private final CharTermAttribute termAtt = addAttribute(CharTermAttribute.class);
    IJamoParser parser;

    public KoreanJamoTokenFilter(TokenStream input, KoreanJamoParserType parserType) {
        super(input);
        this.parser = parserType.getParser();
    }

    @Override
    public boolean incrementToken() throws IOException {
        if (input.incrementToken()) {
            CharSequence parserdData = this.parser.parse(termAtt.toString());
            termAtt.setEmpty().append(parserdData);
            return true;
        } else {
            return false;
        }
    }
}
