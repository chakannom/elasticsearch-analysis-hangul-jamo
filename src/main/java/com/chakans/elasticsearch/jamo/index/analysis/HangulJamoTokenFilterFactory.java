package com.chakans.elasticsearch.jamo.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

import com.chakans.elasticsearch.jamo.index.analysis.parser.HangulJamoParserType;

/**
 * Created by chakannom on 17. 6. 30.
 * Modified by chakannom on 18. 8. 14.
 */
public class HangulJamoTokenFilterFactory extends AbstractTokenFilterFactory {
    private HangulJamoParserType parserType;

    public HangulJamoTokenFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    	super(indexSettings, name, settings);
        this.parserType = HangulJamoParserType.getParserTypeByString(HangulJamoParserType.JAMO.name());
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new HangulJamoTokenFilter(tokenStream, parserType);
    }
}
