package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.parser.KoreanJamoParserType;
import org.elasticsearch.index.settings.IndexSettingsService;

/**
 * Created by chakannom on 17. 6. 30.
 */
public class KoreanJamoTokenFilterFactory extends AbstractTokenFilterFactory {
    private KoreanJamoParserType parserType;

    public KoreanJamoTokenFilterFactory(Index index, IndexSettingsService indexSettingsService, @Assisted String name, @Assisted Settings settings) {
    	super(index, indexSettingsService.getSettings(), name, settings);
        this.parserType = KoreanJamoParserType.getParserTypeByString(KoreanJamoParserType.JAMO.name());
    }

    public TokenStream create(TokenStream tokenStream) {
        return new KoreanJamoTokenFilter(tokenStream, parserType);
    }
}
