package com.chakans.elasticsearch.jamo.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.env.Environment;
import org.elasticsearch.index.IndexSettings;
import org.elasticsearch.index.analysis.AbstractTokenFilterFactory;

import com.chakans.elasticsearch.jamo.index.analysis.parser.HangulJamoParserType;

/**
 * Created by chakannom on 17. 6. 30.
 */
public class HangulChosungFilterFactory extends AbstractTokenFilterFactory {
    private HangulJamoParserType parserType;

    public HangulChosungFilterFactory(IndexSettings indexSettings, Environment environment, String name, Settings settings) {
    	super(indexSettings, name, settings);
        this.parserType = HangulJamoParserType.getParserTypeByString(HangulJamoParserType.CHOSUNG.name());
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new HangulJamoTokenFilter(tokenStream, parserType);
    }
}
