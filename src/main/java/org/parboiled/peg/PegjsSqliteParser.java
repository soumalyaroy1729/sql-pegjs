package org.parboiled.peg;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.parboiled.Node;
import org.parboiled.Rule;
import org.parboiled.annotations.BuildParseTree;
import org.parboiled.support.ParsingResult;
import org.parboiled.util.ParseUtils;

@BuildParseTree
public class PegjsSqliteParser extends BasePegjsParser {

	protected static Set<String> KEYWORDS = new HashSet<>();
	static {
	}

	private static Map<String, String> VERB_LABELS_MAP = new HashMap<>();
	static {
	}

	private static List<String> OBJECT_LABELS = new LinkedList<>();
	static {
		OBJECT_LABELS.add("table_name");
	}

	public static Map<String, String> getVerbLabels() {
		return Collections.unmodifiableMap(VERB_LABELS_MAP);
	}

	public static List<String> getObjectLabels() {
		return Collections.unmodifiableList(OBJECT_LABELS);
	}

	private static List<String> SKIP_LABELS = new LinkedList<>();
	static {
		
		SKIP_LABELS.add("crud_stmt");
		SKIP_LABELS.add("union_stmt");
		SKIP_LABELS.add("select_stmt");
		
		SKIP_LABELS.add("STAR");
	}

	private static List<String> SUPRESS_LABELS = new LinkedList<>();
	static {
		SUPRESS_LABELS.add("__");
		SUPRESS_LABELS.add("___");
		SUPRESS_LABELS.add("ident_start");
		SUPRESS_LABELS.add("ident_part");
		SUPRESS_LABELS.add("column_part");
		SUPRESS_LABELS.add("digit");
	}

	private static List<String> SUPRESS_SUB_LABELS = new LinkedList<>();
	static {

		SUPRESS_SUB_LABELS.add("literal_string");
		SUPRESS_SUB_LABELS.add("single_quoted_ident");
		SUPRESS_SUB_LABELS.add("backticks_quoted_ident");
		SUPRESS_SUB_LABELS.add("double_quoted_ident");
		SUPRESS_SUB_LABELS.add("table_name");
		SUPRESS_SUB_LABELS.add("column_name");
	}

	private static Rule startRule;

	@Override
	public Rule start() {
		if (startRule == null) {
			String pegjs = ParseUtils.read(PegjsSqliteParser.class.getClassLoader().getResource("sqlite.pegjs"));
			ParsingResult<?> result = ParseUtils.parse(pegjs, PegPegjsParser.class, false);
			startRule = start("start", result);
		}
		return startRule;
	}

	protected Rule parseRule(ParsingResult<?> result, Node<?> parent) {
		Rule rule = super.parseRule(result, parent);

		if (rule != null) {
			String value = result.inputBuffer.extract(parent.getStartIndex(), parent.getEndIndex());
			if (SUPRESS_LABELS.contains(value)) {
				rule.suppressNode();
			} else if (value.startsWith("\"") || value.startsWith("'") || SUPRESS_SUB_LABELS.contains(value)) {
				rule.suppressSubnodes();
			} else if (SKIP_LABELS.contains(value)) {
				rule.skipNode();
			}
		}

		return rule;
	}

	public static ParsingResult<?> parse(String script) throws Exception {
		System.out.println("script : " + script);
		ParsingResult<?> result = ParseUtils.parse(script, PegjsSqliteParser.class, false);
//		ParsingResult<?> result = ParseUtils.parse(script, PegjsSqliteParser.class, true);
		ParseUtils.printTree(result);
		return result;
	}

	public static void main(String[] args) throws Exception {

		parse("SELECT * FROM employee");

	}

}
