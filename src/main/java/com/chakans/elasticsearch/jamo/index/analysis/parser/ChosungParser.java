package com.chakans.elasticsearch.jamo.index.analysis.parser;

/**
 * Created by chakannom on 17. 6. 30.
 */
public class ChosungParser extends AbstractJamoParser {
    @Override
    protected void processWhenKorean(StringBuilder meaningfulChars, char chosung, char jungsung, char jongsung) {
        meaningfulChars.append(chosung);
    }

    @Override
    protected void processWhenNotKorean(StringBuilder meaningfulChars, char eachToken) {
        meaningfulChars.append(eachToken);
    }
}
