package org.elasticsearch.index.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.inject.assistedinject.Assisted;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.Index;
import org.elasticsearch.index.analysis.parser.HangulJamoParserType;
import org.elasticsearch.index.settings.IndexSettingsService;

/**
 * Created by chakannom on 17. 6. 30.
 */
public class HangulJamoTokenFilterFactory extends AbstractTokenFilterFactory {
    private HangulJamoParserType parserType;

    @Inject
    public HangulJamoTokenFilterFactory(Index index, IndexSettingsService indexSettingsService, @Assisted String name, @Assisted Settings settings) {
    	super(index, indexSettingsService.getSettings(), name, settings);
        this.parserType = HangulJamoParserType.getParserTypeByString(HangulJamoParserType.JAMO.name());
    }

    @Override
    public TokenStream create(TokenStream tokenStream) {
        return new HangulJamoTokenFilter(tokenStream, parserType);
    }
}
