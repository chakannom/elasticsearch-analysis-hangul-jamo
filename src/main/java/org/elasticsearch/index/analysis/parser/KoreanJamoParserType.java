package org.elasticsearch.index.analysis.parser;

import java.util.HashMap;
import java.util.Map;

public enum KoreanJamoParserType {
    JAMO {
        @Override
        public IJamoParser getParser() {
            return new JamoParser();
        }
    },
    CHOSUNG {
        @Override
        public IJamoParser getParser() {
            return new ChosungParser();
        }
    };

    private static Map<String, KoreanJamoParserType> stringToEumMap = new HashMap<>(KoreanJamoParserType.values().length);

    static {
        for (KoreanJamoParserType type : KoreanJamoParserType.values()) {
            stringToEumMap.put(type.toString(), type);
        }
    }

    public static KoreanJamoParserType getParserTypeByString(String parserType) {
        if (stringToEumMap.containsKey(parserType)) {
            return stringToEumMap.get(parserType);
        }

        throw new IllegalArgumentException("parserType(" +parserType+") is not found");
    }

    public abstract IJamoParser getParser();
}
