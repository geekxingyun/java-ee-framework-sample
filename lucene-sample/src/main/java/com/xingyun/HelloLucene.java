package com.xingyun;

import java.io.IOException;
import java.text.ParseException;

public class HelloLucene {

	public static void main(String[] args) throws IOException, ParseException {

		// 对于这个简单的例子，我们将从一些字符串中创建一个内存索引。
		// 0. Specify the analyzer for tokenizing text.
		// The same analyzer should be used for indexing and searching
//		StandardAnalyzer analyzer = new StandardAnalyzer(Version.LUCENE_7_1_0);
//
//		// 1. create the index
//		Directory index = new RAMDirectory();
//
//		IndexWriterConfig config = new IndexWriterConfig(Version.LUCENE_40, analyzer);
//
//		IndexWriter w = new IndexWriter(index, config);
//		addDoc(w, "Lucene in Action", "193398817");
//		addDoc(w, "Lucene for Dummies", "55320055Z");
//		addDoc(w, "Managing Gigabytes", "55063554A");
//		addDoc(w, "The Art of Computer Science", "9900333X");
//		w.close();
//
//		// 2. query
//		String querystr = args.length > 0 ? args[0] : "lucene";
//
//		// the "title" arg specifies the default field to use
//		// when no field is explicitly specified in the query.
//		Query q = null;
//		try {
//			q = new QueryParser(Version.LUCENE_40, "title", analyzer).parse(querystr);
//		} catch (org.apache.lucene.queryparser.classic.ParseException e) {
//			e.printStackTrace();
//		}
//
//		// 3. search
//		int hitsPerPage = 10;
//		IndexReader reader = DirectoryReader.open(index);
//		IndexSearcher searcher = new IndexSearcher(reader);
//		TopScoreDocCollector collector = TopScoreDocCollector.create(hitsPerPage, true);
//		searcher.search(q, collector);
//		ScoreDoc[] hits = collector.topDocs().scoreDocs;
//
//		// 4. display results
//		System.out.println("Found " + hits.length + " hits.");
//		for (int i = 0; i < hits.length; ++i) {
//			int docId = hits[i].doc;
//			Document d = searcher.doc(docId);
//			System.out.println((i + 1) + ". " + d.get("isbn") + "\t" + d.get("title"));
//		}
//
//		// reader can only be closed when there
//		// is no need to access the documents any more.
//		reader.close();
//	}
//
//	private static void addDoc(IndexWriter w, String title, String isbn) throws IOException {
//		Document doc = new Document();
//		doc.add(new TextField("title", title, Field.Store.YES));
//
//		// use a string field for isbn because we don't want it tokenized
//		doc.add(new StringField("isbn", isbn, Field.Store.YES));
//		w.addDocument(doc);
//	}
	}
}
