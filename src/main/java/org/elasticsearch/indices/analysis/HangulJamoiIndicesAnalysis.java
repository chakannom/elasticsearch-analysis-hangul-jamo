package org.elasticsearch.indices.analysis;

import org.apache.lucene.analysis.TokenStream;
import org.elasticsearch.common.component.AbstractComponent;
import org.elasticsearch.common.inject.Inject;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.index.analysis.HangulJamoTokenFilter;
import org.elasticsearch.index.analysis.PreBuiltTokenFilterFactoryFactory;
import org.elasticsearch.index.analysis.TokenFilterFactory;
import org.elasticsearch.index.analysis.parser.HangulJamoParserType;

public class HangulJamoiIndicesAnalysis extends AbstractComponent {

	@Inject
	public HangulJamoiIndicesAnalysis(Settings settings, IndicesAnalysisService	indicesAnalysisService) {
		super(settings);

		indicesAnalysisService.tokenFilterFactories().put("hangul_jamo",
				new PreBuiltTokenFilterFactoryFactory(new TokenFilterFactory() {

					@Override
					public String name() {
						return "hangul_jamo";
					}
					
					@Override
					public TokenStream create(TokenStream tokenStream) {
						return new HangulJamoTokenFilter(tokenStream, HangulJamoParserType.getParserTypeByString(HangulJamoParserType.JAMO.name()));
					}
				}));
		
		indicesAnalysisService.tokenFilterFactories().put("hangul_chosung",
				new PreBuiltTokenFilterFactoryFactory(new TokenFilterFactory() {

					@Override
					public String name() {
						return "hangul_chosung";
					}
					
					@Override
					public TokenStream create(TokenStream tokenStream) {
						return new HangulJamoTokenFilter(tokenStream, HangulJamoParserType.getParserTypeByString(HangulJamoParserType.CHOSUNG.name()));
					}
				}));
	}

}
