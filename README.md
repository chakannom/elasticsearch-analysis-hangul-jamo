# Elasticsearch Analyzer Hangul Jamo & Chosung

required elasticsearch v2.4.4

Setting Jamo Analyzer
```
curl -XPUT '127.0.0.1:9200/test_jamo' -d '{
  "settings": {
    "index": {
      "analysis": {
        "analyzer": {
          "hangul_jamo_analyzer": {
            "type": "custom",
            "filter": ["hangul_jamo_filter"],
            "tokenizer": "edge_ngram_tokenizer"
          }
        },
        "filter": {
          "hangul_jamo_filter": {
            "type": "hangul_jamo",
            "name": "jamo"
          }
        },
        "tokenizer": {
          "edge_ngram_tokenizer": {
            "type": "edgeNGram",
            "min_gram" : "1",
            "max_gram" : "30",
            "token_chars": [ "letter", "digit" ]
          }
        }
      }
    }
  }
}'

curl '127.0.0.1:9200/test_jamo/_analyze?pretty=1&analyzer=hangul_jamo_analyzer' -d '아버지가 방에 들어가신다.'
```
